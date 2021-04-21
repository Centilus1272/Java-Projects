import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Account implements Serializable{

    protected double balance;
    protected int firstDate;
    protected int secondDate;
    protected Calendar cal1 = new GregorianCalendar();
    protected Calendar cal2 = new GregorianCalendar();
    protected boolean dateFlag = false;
    protected double rate = 0.05;
    protected String acctName;
    protected int accNum;



    static Scanner sc = new Scanner(System.in);

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public int getAccNum() {
        return accNum;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public void setAccBalance(double balance) {
        this.balance = balance;
    }

    // constructor，把accNum 全部设置为0 代表这是个无人使用的账户，balance 是 100；
    public Account(){
        this.accNum = 0;
        this.balance = 100;
    }

    public Account(String name, double initDeposit, int accnum) {
        this.acctName = name;
        this.balance = initDeposit;
        this.accNum = accnum;
    }


    // argument是一个Account object，更替它的balance
    public void deposit(Account a){
        System.out.println("please enter amount to deposit:");
        Scanner sc = new Scanner(System.in);
        double depotAmount = sc.nextDouble();
        a.setAccBalance(a.balance + depotAmount);
        System.out.printf("Your new account balance is $%.2f\n\n",a.balance);
    }

    public void withdraw(Account a){

        System.out.println("please enter the amount to withdraw:");
        double withdAmount = sc.nextDouble();
        a.setAccBalance(a.balance - withdAmount);
        System.out.printf("Your new account balance is $%.2f\n\n", a.balance);
    }

    public void checkBalance(Account a){
        System.out.printf("your balance is: $%.2f\n\n", a.balance);

    }

    public void calcInterest(Account a){
        double rate_Day = rate/365;
        int dateDiff = (secondDate- firstDate);
        double rateTime = Math.pow(1+rate_Day,dateDiff);
        double interest = a.balance * rateTime;
        balance =+ interest;
        firstDate = secondDate;
    }


    public static String getAcctName(Account a) {
        return a.acctName;
    }

    public void getDate1( ){
        if (dateFlag==false)
        {
            Date date = new Date();
            cal1.setTime(date);
            firstDate= cal1.get(Calendar.DAY_OF_YEAR);
            dateFlag = true;
        }

    }

    public void getDate2() throws IOException
    {
        System.out.print("Enter todays date(mm/dd/yyyy): ");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        String inputText = br.readLine();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date date= new Date();
        date = formatter.parse(inputText, pos);

        cal2.setTime(date);
        secondDate = cal2.get(Calendar.DAY_OF_YEAR);
        if (firstDate > secondDate) {
            System.out.println("You must enter a future date.");
            getDate2();
        }
    }



}
