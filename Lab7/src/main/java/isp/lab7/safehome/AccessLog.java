package isp.lab7.safehome;

import java.time.LocalDateTime;

public class AccessLog
{
    private String tenantName;
    private LocalDateTime  dateTime;
    private String operation;
    private DoorStatus doorStatus;
    private String errorMessage;
    AccessLog(String name,LocalDateTime date,String op,DoorStatus door,String error)
    {
        tenantName=name;
        dateTime=date;
        operation=op;
        doorStatus=door;
        errorMessage=error;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String toString()
    {
        return "LOG:"+tenantName+" "+dateTime+" "+operation+" "+doorStatus+" "+errorMessage;
    }
}
