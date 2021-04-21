import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Payroll
{
    ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String args [])
        {
            Payroll payroll = new Payroll();
            payroll.menu();
        }

    public void menu()
    {
        Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.println("0) load employee data from file");
            System.out.println("1) populate employee");
            System.out.println("2) select employee");
            System.out.println("3) save employee");
            System.out.println("4) exit");
            input = sc.nextInt();
            if (input == 0) {
                loadEmployee();
            }
            if (input == 1) {
                populateEmployee();
            }
            if (input == 2) {
                selectEmployee();
            }
            if (input == 3) {
                saveEmployee();
            }
        }
        while(input != 4);

    }

    public void populateEmployee()
    {
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("Please choose what type of employee to populate");
        System.out.println("1) Hourly employee");
        System.out.println("2) Salary employee");
        System.out.println("3) Commission employee");
        System.out.println("4) Cancel");
        input = sc.nextInt();

        if (input == 1) {
            System.out.println("Enter first name");
            String fname = sc.next();

            System.out.println("Enter last name");
            String lname = sc.next();

            System.out.println("How many hours did you work this week? ");
            int hours = sc.nextInt();

            System.out.println("How much is your hourly wage? ");
            float wage = sc.nextFloat();

            Hourly hemployee = new Hourly(fname, lname, hours, wage);
            employees.add(hemployee);
        }
        if (input == 2) {
            System.out.println("Enter first name");
            String fname = sc.next();

            System.out.println("Enter last name");
            String lname = sc.next();

            System.out.println("Press 0 for Staff or 1 for Executive" );

            float salary = 0;

            input = sc.nextInt();
            if (input == 0)
            {
                salary = 50000;
            }
            if (input == 1)
            {
                salary = 100000;
            }

            Salary semployee = new Salary(fname, lname, salary);
            employees.add(semployee);
        }
        if (input == 3) {
            System.out.println("Enter first name");
            String fname = sc.next();

            System.out.println("Enter last name");
            String lname = sc.next();

            System.out.println("How many widgets did you sell? ");
            int widget = sc.nextInt();

            System.out.println("How much is one widget? ");
            float price = sc.nextFloat();

            Commission cemployee = new Commission(fname, lname, price, widget);
            employees.add(cemployee);
        }
    }

    public void selectEmployee()
    {
        if (employees.size() <= 0) {
            System.out.println("No employees on record");
        } else {
            System.out.println("Select an employee to view");
            for (int i = 0; i < employees.size(); i++) {
                System.out.println(i + ") " + employees.get(i).getName());
            }
            Scanner sc = new Scanner(System.in);
            int input;
            input = sc.nextInt();

            if (input >= 0 && input < employees.size()) {
                Employee selectedEmployee = employees.get(input);

                do {
                    System.out.println("\n" + selectedEmployee.getName());
                    System.out.println("0) Calculate gross pay");
                    System.out.println("1) Calculate tax");
                    System.out.println("2) Calculate net pay");
                    System.out.println("3) Calculate net percent");
                    System.out.println("4) Display employee");
                    System.out.println("5) Exit");

                    input = sc.nextInt();
                    if (input == 0) {
                        System.out.println("Gross pay: " + selectedEmployee.calculateGross());
                    }
                    if (input == 1) {
                        System.out.println("Tax: " + selectedEmployee.computeTax(selectedEmployee.calculateGross()));
                    }
                    if (input == 2) {
                        System.out.println("Net pay " + selectedEmployee.computeNet(selectedEmployee.calculateGross()));
                    }
                    if (input == 3) {
                        System.out.println("Net percentage: " + selectedEmployee.computeNetperc(selectedEmployee.calculateGross(), selectedEmployee.computeNet(selectedEmployee.calculateGross())));
                    }
                    if (input == 4) {
                        selectedEmployee.displayEmployee();
                    }
                } while(input != 5);

            } else {
                System.out.println("Invalid input, returning to main menu");
            }
        }
    }

    public void saveEmployee()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("PayrollData.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(employees);
            oos.flush();
            fos.close();
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        //Save employees Array List to the File
    }

    public void loadEmployee()
    {
        try
        {
            FileInputStream fis = new FileInputStream("PayrollData.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            employees = ((ArrayList<Employee>)ois.readObject());
            fis.close();
            for(int i = 0; i < employees.size(); i++)
            {
                employees.get(i).getName();
            }
        }
        catch (IOException e)
        {
            System.err.println("An error was encounter please try again.");
            menu();
        }
        catch( ClassNotFoundException cnfe)
        {
            System.err.println("File to load accounts was not found.");
            menu();
        }
        //Load employees from the File
    }

    public void WriteFile()
    {
        try
        {
        File file = new File("EmployeeData.txt");

        if(!file.exists())
        {
            file.createNewFile();
        }

        PrintWriter pw = new PrintWriter(file);
        pw.println("this is my file content");
        pw.close();
            System.out.println("Done");

        }catch (IOException e)
        {
            e.printStackTrace();
        }





    }

    /*public void WriteFile() throws IOException {
            File file = new File("c:/newfile.txt");
            String content = "This is the text content";

            try(FileOutputStream fop = new FileOutputStream(file))
            {
                if (!file.exists())
                {
                    file.createNewFile();
                }

                byte[] contentInBytes = content.getBytes();

                fop.write(contentInBytes);
                fop.flush();
                fop.close();

                System.out.println("Done");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
    }*/




}

