package isp.lab7.safehome;
import java.time.LocalDateTime;
import java.util.*;

public class DoorLockController implements ControllerInterface
{
    private Map<Tenant,AccessKey> validAccess;

    private Door door;

    static int tries;

    private List<AccessLog> logs;

    static int log_nr;

    public LocalDateTime time;

    DoorLockController()
    {
        validAccess=new HashMap<Tenant,AccessKey>();
        door=new Door();
        tries=0;
        log_nr=0;
        logs=new ArrayList<AccessLog>();
        time=LocalDateTime.now();
    }

    public DoorStatus enterPin(String pin) throws TooManyAttemptsException,InvalidPinException
    {
        Door door=this.door;
        int check = 0;
        AccessKey x=new AccessKey(pin);
        String name=new String();
        for (Tenant i : validAccess.keySet()) {
            if (validAccess.get(i).equals(x))
            {
                check = 1;
                if(door.getStatus()==DoorStatus.OPEN)
                    door.lockDoor();
                else
                    door.unlockDoor();
                name=i.getName();
                break;
            }
        }
        if(pin.equals(ControllerInterface.MASTER_KEY))
        { tries=0;
            check = 1;
            if(door.getStatus()==DoorStatus.OPEN)
                door.lockDoor();
            else
                door.unlockDoor();}
        if(check==0)
            tries++;
        if(tries>=3 || (tries>=3 && check==1))
        {
            AccessLog test=new AccessLog(name,time,"Input Key",door.getStatus(),"TooManyAttempts");
            logs.add(test);
            throw new TooManyAttemptsException();
        }
        else
        if(check==0)
        {
            AccessLog test=new AccessLog(name,time,"Input Key",door.getStatus(),"InvalidPin");
            logs.add(test);
            throw new InvalidPinException();
        }
        AccessLog test=new AccessLog(name,time,"Input Key",door.getStatus(),"NoError");
        logs.add(test);
        return door.getStatus();
    }

    public void addTenant(String pin,String user) throws TenantAlreadyExistsException
    {
        int ok=1;
        for(Tenant i:validAccess.keySet())
        {
            if(i.getName().equals(user))
            {
                ok=0;
                AccessLog test=new AccessLog("Tenant",time,"Add Tenant",door.getStatus(),"ExistingUser");
                logs.add(test);
                throw new TenantAlreadyExistsException();
            }
        }
        Tenant new1=new Tenant(user);
        AccessKey new2=new AccessKey(pin);
        if(ok==1)
        {
            validAccess.put(new1,new2);
        }
        AccessLog test=new AccessLog("Tenant",time,"Add Tenant",door.getStatus(),"NoError");
        logs.add(test);
        System.out.println("Siccesfully Added!");
    }

    public void removeTenant(String name) throws TenantNotFoundException
    {
        int ok=1;
        int ct=0;
        Tenant removal=new Tenant(name);
        for(Tenant i:validAccess.keySet())
        {
            if(i.getName().equals(name))
            {
                ok=0;
                validAccess.remove(i);
                AccessLog test=new AccessLog("Tenant",time,"Remove Tenant",door.getStatus(),"NoError");
                logs.add(test);
                break;
            }
            ct++;
        }
        if(ok==1) {
            AccessLog test=new AccessLog("Tenant",time,"Remove Tenant",door.getStatus(),"TenantNotFound");
            logs.add(test);
            throw new TenantNotFoundException();
        }
        System.out.println("Succesfully removed!");
    }

    public void displayAccessLog()
    {
        System.out.println(logs.toString());
    }

    public String doorStatusi()
    {
        return "Door is:"+door.getStatus();
    }

}
