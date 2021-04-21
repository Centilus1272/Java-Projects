public class Commission extends Employee
{
    private float price;
    private int amountSold;
    private float salary;
    private float commissionRate = 0.5f;


    public Commission(String fname, String lname, float price, int widget)
    {
        super.setFirstName(fname);
        super.setLastName(lname);
        this.price = price;
        this.amountSold = widget;

        this.salary = (price * widget) * commissionRate;
    }

    public float calculateGross()
    {
        return this.salary;
    }

    @Override protected void displayEmployee() {
        super.displayEmployee();
        System.out.println("Widgets sold: " + this.amountSold);
        System.out.println("Price sold for: " + this.price);
        System.out.println("Gross sales: " + this.amountSold * this.price);
        System.out.println("Salary: " + this.salary);
    }
}
