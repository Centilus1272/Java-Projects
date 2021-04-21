import java.util.Scanner;

public class Salary extends Employee
{
    private float salary;

    public Salary(String fname, String lname, float salary)
    {
        super.setFirstName(fname);
        super.setLastName(lname);
        this.salary = salary;
    }

    public float  calculateGross()
    {
        return this.salary;
    }


    @Override protected void displayEmployee() {
        super.displayEmployee();
        System.out.println("Salary: " + salary);
    }

}
