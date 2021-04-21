import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Account {

    public static void main(String[] args) throws IOException {
        // 一个size 1000 的 Account array
        Account[] acctArray = new Account[3];

        for (int i = 0; i < acctArray.length; i ++){
            acctArray[i] = new Account();
        }

        // 一个用来store 总用户量的variable
        int numOfAcc = 0;


        Scanner sc= new Scanner(System.in);
        int input = 0;

        do{
            System.out.println("\n\tWhat would you like to do?");
            System.out.println("1)Create an account");
            System.out.println("2)Load accounts from file (Load to initiate, do not load twice)");
            System.out.println("3)Select an account");
            System.out.println("4)Save account data. (Remember to save data before exiting)");
            System.out.println("5)Display all accounts infos");
            System.out.println("6)Display single account info");
            System.out.println("7)Exit");


            try{
                input= sc.nextInt();
            }
            catch (InputMismatchException IME){
                System.out.println("Please enter a number from 1 to 5.\n");

            }

            if(input ==1){
                addAcc(acctArray);
            }
            else if(input==2){

                try {
                    FileInputStream fileIn = new FileInputStream("lol.dat");
                    ObjectInputStream is = new ObjectInputStream(fileIn);

                    // 如果没读到，eof ＝ true，结束 loop
                    // 读到，object array从零开始，在file里读取一个， numOfAcc ＋1，loop 到下一个element position
                    while(true) {
                        acctArray[numOfAcc] = (Account) is.readObject();
                        numOfAcc += 1;
                    }
                } catch (FileNotFoundException FNF) {
                    System.out.println("ERROR! File not found");
                } catch (EOFException EOF) {
                    System.out.println("Account data successfully loaded\n");
                } catch (IOException IOE) {
                    System.out.println("yes" +IOE.getMessage());
                } catch (ClassNotFoundException cNFE) {
                    System.out.println("no"+ cNFE.getMessage());
                }
            }
            else if(input==3){
                selectAccts(acctArray);
            }
            else if(input==4){
                try {
                    saveAccount(acctArray);
                }
                catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
            else if (input == 5){
                displayAll(acctArray);
            }
            else if (input == 6){
                displayOne(acctArray);
            }
            else if (input == 7){
                return;
            }
            else
                System.out.println("Please enter a valid choice from 1 through 7.\n");

        }while(input !=7);
    }



    // save Account 把size 1000的array当个argument。

    public static void saveAccount(Account array[]) throws IOException, FileNotFoundException
    {
        try{
            FileOutputStream outStream = new FileOutputStream("lol.dat");
            ObjectOutputStream os = new ObjectOutputStream(outStream);

            // loop 整个array，把 account number 不是 0 的 写进file里
            for(int i = 0; i < 3; i ++ ) {
                if(array[i].accNum != 0) {
                    os.writeObject(array[i]);
                }
            }
            os.flush();
            os.close();
        }
        catch (FileNotFoundException FNF) {
            System.out.println(FNF.getMessage());
        }
        catch (IOException ioe){
            System.out.println(ioe);
        }
    }







    public static void selectAccts(Account array[]) throws IOException {
        // 从 0 到 现有的acct数量里 loop
        // 用户输入账号
        // loop 现有用户， match  账号， display 菜单
        System.out.println("Please enter your account number");
        Scanner sc1 = new Scanner(System.in);
        int input1 = sc1.nextInt();
        int found = 0;

        for (int i = 0; i < 3; i++) {
            if (input1 == array[i].accNum) {
                found = 1;
                int input = 0;
                while (input!=4) {
                    System.out.println("\tHi \"" + getAcctName(array[i]) + "\" What would you like to do?");
                    System.out.println("1)Deposit");
                    System.out.println("2)withdrawal");
                    System.out.println("3)check balance");
                    System.out.println("4)Exit");
                    Scanner sc = new Scanner(System.in);
                    input = sc.nextInt();
                    if (input == 1) {
                        array[i].getDate1();
                        array[i].getDate2();
                        array[i].calcInterest(array[i]);
                        array[i].deposit(array[i]);
                    } else if (input == 2) {
                        array[i].getDate1();
                        array[i].getDate2();
                        array[i].calcInterest(array[i]);
                        array[i].withdraw(array[i]);
                    } else if (input == 3) {
                        array[i].getDate1();
                        array[i].getDate2();
                        array[i].calcInterest(array[i]);
                        array[i].checkBalance(array[i]);
                    }
                }
                break;
            }
        }
        if (found != 1){
            System.out.println("ERROR! The account number entered does not exist.\n");
        }
    }

    public static void addAcc(Account array[]) throws NullPointerException {
        try {
            Scanner sNew = new Scanner(System.in);

            for (int i = 0; i < 3; i++) {
                int repeat = 0;
                if (array[i].accNum == 0) {
                    System.out.println("What's the name of the account");
                    String tempID = sNew.next();
                    System.out.println("What do you want your account ID to be (Please enter an integer)");
                    int accnum = sNew.nextInt();

                    // 检验看看account number 有没有重复，有的话break
                    for(int j = 0; j < 3; j ++){
                        if (array[j].accNum == accnum){
                            repeat = 1;
                        }
                    }
                    if(repeat == 1){
                        System.out.println("Sorry, Account number already in use.\n");
                        break;
                    }

                    System.out.println("What is the initial deposit you are making:");
                    double intDeposit = sNew.nextDouble();
                    array[i].setAccNum(accnum);
                    array[i].setAcctName(tempID);
                    array[i].setAccBalance(intDeposit);
                    System.out.println("Account successfully created! Please remember your account number: "+array[i].accNum+ "\n");
                    break;
                }
            }
        }
        catch (NullPointerException NPE){
            System.out.println(NPE.getMessage());
        }
    }

    public static void displayOne(Account array[]){
        int found = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your account number?");
        int accnum = sc.nextInt();
        for (int i = 0; i < 3; i++){
            if(array[i].accNum == accnum) {
                found = 1;
                System.out.println("===============================");
                System.out.println("Name: " + array[i].getAcctName(array[i]));
                System.out.println("Account ID: " + array[i].accNum);
                System.out.println("Account balance: " + array[i].balance);
                System.out.println("===============================\n");
                break;
            }
        }
        if(found!= 1){
            System.out.println("Please enter the correct account number\n");
        }
    }

    // 把所有的account info display出来
    public static void displayAll(Account array[]){
        int found = 0;
        for (int i = 0; i < 3; i++){

            if(array[i].accNum!=0) {
                found = 1;
                System.out.println("===============================");
                System.out.println("Name: " + array[i].getAcctName(array[i]));
                System.out.println("Account ID: " + array[i].accNum);
                System.out.println("Account balance: " + array[i].balance);
                System.out.println("===============================\n");
            }
        }
        if(found!= 1){
            System.out.println("There are no accounts in the system\n");
        }
    }

}
