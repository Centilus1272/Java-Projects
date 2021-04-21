public class Hourly extends Employee
{
    private float rate;
    private int hours;

    public Hourly(String fname, String lname, int hoursWorked, float hourlyWage)
    {
        super.setFirstName(fname);
        super.setLastName(lname);
        this.rate = hourlyWage;
        this.hours = hoursWorked;
    }

    public float calculateGross() {
       if (hours <= 40) {
           return hours * rate;
       } else {
           int over = hours - 40;
           return (float) (over * (1.5 * rate) + (40 * rate));
       }
    }

    @Override protected void displayEmployee() {
        super.displayEmployee();
        System.out.println("Hours: " + hours);
        System.out.println("Rate: " + rate);
    }


}
