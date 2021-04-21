import java.io.Serializable;
public abstract class Employee implements Serializable
{
    //float rate=30.0f;
    float taxrate=0.2f;
    //int hours=45;
    //float gross=0.0f;
    float tax=0.0f;
    float net=0.0f;
    float net_percent=0.0f;
    private String firstName;
    private String lastName;

     Employee()
    {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
         return this.firstName + " " + this.lastName;
    }

    public abstract float calculateGross();


    protected float computeTax(float gross)
    {
        tax=gross*taxrate;
        return this.tax;
    }

    protected float computeNet(float gross)
    {

        net=gross-tax;
        return this.net;
    }

    protected float computeNetperc(float gross, float net)
    {
        net_percent=(net/gross)*100;
        return this.net_percent;
    }

    protected void displayEmployee()
    {

        System.out.println(this.firstName + " " + this.lastName);

        /*
        System.out.println("Hours: " + new Integer(hours));
        System.out.println("Rate: " + new Float(rate));
        System.out.println("Gross: " + new Float(gross));
        System.out.println("Net: " + new Float(net));
        System.out.println("Net%: " + new Float(net_percent) + "%");
        */
    }
}


