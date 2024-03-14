package isp.lab7.safehome;

public class Tenant
{
    private String name;

    Tenant(String name)
    {
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
