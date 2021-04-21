import java.util.*;
import java.io.*;
import java.lang.*;




public class Payroll
{
    
    ArrayList<String> alEmployee = new ArrayList<>();
    String EmployeeInfo=""; 
    
          	int Hours=0;
         			float Rate=0.0f;
         	 String StaffOrExecutive  = "";
         	 int NumberOfItemsSold=0;
         	 int UnitPriceOfItemSold=0;
         	 float Gross=0.0f;
         	 
    
	public static void main(String[] args)
	{
      

         		     		
         		Payroll Payroll = new Payroll();
         		
         		Payroll.Menu();
                       
                            
	}
      
        public void Menu() {
        
        
         	      
         		int index =-1;
         		String EmployeeInfo="";
         		
         		 Scanner in = new Scanner(System.in);

            String select;

            boolean quit =  false;
            
            System.out.println("** Payroll System **");
            
            System.out.println("");
            
           System.out.println("i. Add Employee(s):");

           System.out.println("ii. Load & Search for Employee(s):");     
                  
          System.out.println("iii. Exit:");         
              
           System.out.print("Enter your selection:");

                  select = in.nextLine ();

                  switch (select) {

                  case "i":
                  
                  
                  do  {
         		       		
         		index++;       		
            
            Scanner scannerFirstName = new Scanner(System.in);
		System.out.print("Enter Employee First Name or type quit: ");
		String FirstName = scannerFirstName.next();
		
		if(FirstName.equals("quit")){
  
    Menu();                 
   		break;
		
		}
            
                Scanner scannerLastName = new Scanner(System.in);
		System.out.print("Enter Employee Last Name:");
		String LastName = scannerLastName.nextLine();
                
                Scanner scannerPayrollType = new Scanner(System.in);
                System.out.print("Enter Payroll Type(Hourly, Salary, Commission):");
		String PayrollType = scannerPayrollType.next();
		
		 if(!PayrollType.equals("Hourly") && !PayrollType.equals("Salary") && !PayrollType.equals("Commission")) {     
       do {     
         
        System.out.println(PayrollType + " is incorrect. Enter Hourly or Salary or Commission:"); 
        
       PayrollType   = scannerPayrollType.next();
        
      } while(!PayrollType.equals("Hourly") && !PayrollType.equals("Salary") && !PayrollType.equals("Commission"));
          
          }       
	            
                if(PayrollType.equals("Hourly")) {
                  
                  Scanner scannerHours = new Scanner(System.in);
                  System.out.print("Enter Hours:");
                  
        Hours  = scannerHours.nextInt();
                
                         
                  Scanner scannerRate = new Scanner(System.in);
                  System.out.print("Enter Rate:");
                   Rate = scannerRate.nextFloat();
                    
                }
                
               
                   if(PayrollType.equals("Salary")) {
                       
                  Scanner scannerStaffOrExecutive = new Scanner(System.in);
                  System.out.print("Enter Staff or Executive:");
                  StaffOrExecutive  = scannerStaffOrExecutive.next();
                  
         if(!StaffOrExecutive.equals("Staff") && !StaffOrExecutive.equals("Executive")) {
         
    do {     
         
        System.out.println(StaffOrExecutive + " is incorrect. Enter Staff or Executive:"); StaffOrExecutive  = scannerStaffOrExecutive.next();
        
      } while(!StaffOrExecutive.equals("Staff") && !StaffOrExecutive.equals("Executive"));
      
         
         }
                        
                  if(StaffOrExecutive.equals("Staff")) {
                      
                      Gross = 50000;
                      
                  }
                  
                   if(StaffOrExecutive.equals("Executive")) {
                      
                      Gross = 100000;
                      
                  }
                  
                  }
                   
                   if(PayrollType.equals("Commission")) {
                             
           float SalePrice=50.0f;
                       
                   Scanner scannerNumberOfItemsSold = new Scanner(System.in);
                   System.out.print("Enter number of items sold:");
                 NumberOfItemsSold  = scannerNumberOfItemsSold.nextInt();  
                   
                   Scanner scannerUnitPriceOfItemSold = new Scanner(System.in);
                   System.out.print("Enter unit price of item sold:");
                 UnitPriceOfItemSold  = scannerUnitPriceOfItemSold.nextInt();
                 
           Gross= SalePrice*NumberOfItemsSold*.50f;
                       
                   }     
                   
			
			EmployeeInfo = index + "," + FirstName + "," + LastName + "," + PayrollType + "," +  Hours + "," + Rate + "," + StaffOrExecutive + "," + NumberOfItemsSold + "," + UnitPriceOfItemSold;                                           
			PopulateEmployees(index, EmployeeInfo);
			
			    
	                   
             
                   } while (true);                  	
                        break;

                  case "ii":
                  
                  SelectEmployee(Hours,Rate,Gross);

                        break;
                        
                       case "iii":

                        break;

                  default:

                        System.out.println("Incorrect selection.");
                 Menu();
                 break;
                 
                 
                        
                        }                     
                        
                     }
        
             
        public void PopulateEmployees(int index, String EmployeeInfo) {    
                        
        alEmployee.add(EmployeeInfo);
        
      SaveEmployee(alEmployee);
      
      
        }
        
        public void SelectEmployee(int Hours, float Rate, float Gross) {
        
        Scanner scannerFirstName = new Scanner(System.in);
		System.out.print("Enter Employee First Name to search: ");
		String FirstName = scannerFirstName.nextLine();    
		
		Scanner scannerLastName = new Scanner(System.in);
		System.out.print("Enter Employee Last Name to search: ");
		String LastName = scannerLastName.nextLine();   
		
		
		java.io.File employee2 = new java.io.File("C:/Temp/employee2.ser");
		
		LoadEmployee();
		

		
		for(int i=0;i<alEmployee.size();i++) {   
		
		String[] alEmployeeSplit= alEmployee.get(i).toString().split(",");
		        
        if(alEmployeeSplit[1].equals(FirstName)) {
        if(alEmployeeSplit[2].equals(LastName)) {
    
       
        Employee Employee= new Employee();
        
        Employee.FirstName=FirstName;
        Employee.LastName=LastName;
        Employee.Hours=Hours;
        Employee.Rate=Rate;
        
        		
        
         if(alEmployeeSplit[3].equals("Hourly")) {
        
     
      if(alEmployeeSplit[3].equals("Hourly")) {
 
      
        Hourly Hourly = new Hourly();
        
        Hourly.FirstName=FirstName;
        Hourly.LastName=LastName;
        
        if(Hours>0) {
        if(Rate>0) {
        
        if(Hours>40) {
        
        float Overtime=0.0f;
        Gross=40*Rate;
              Overtime=(Hours-40)*(Rate*1.5f);
        Gross=Gross+Overtime;
               
        }
        
         if(Hours<=40) {
        
        Gross=Hours*Rate;
        
        }
        
        }
        }
              
        Hourly.Rate=Rate;               
        Hourly.Hours=Hours;
        Hourly.Gross=Gross;
        
       
     
        
        
          FileOutputStream fos = null; 
        ObjectOutputStream oss = null;
         try { 
         
         fos = new FileOutputStream("C:/Desktop/employee2.ser"); 
         oss = new ObjectOutputStream(fos);
         oss.writeObject(Hourly); 
         
         oss.close();
         
          } 
          catch(IOException ex) {
          
           ex.printStackTrace(); 
           
           }
        
        
        Hourly.menu();  
           
        }        
      
      }  
 
 if(alEmployeeSplit[3].equals("Salary")) {
 
      
        Salary Salary = new Salary();
        
        Salary.FirstName=FirstName;
        Salary.LastName=LastName;
                            
        Salary.Gross=Gross;
        
        try
      {
        
         FileOutputStream fos =
         new FileOutputStream(employee2);		 	
		 
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(Salary);
         oos.close();
         fos.close();
         
      }catch(Exception e)
      {
      
          e.printStackTrace();
      }
 
        Salary.menu();  
           
        }  
       
        if(alEmployeeSplit[3].equals("Commission")) {
 
      
        Commission Commission = new Commission();
        
        Commission.FirstName=FirstName;
        Commission.LastName=LastName;
                            
        Commission.Gross=Gross;
        
        try
      {
        
         FileOutputStream fos =
         new FileOutputStream(employee2);		 
		 
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(Commission);
         oos.close();
         fos.close();
         
      }catch(Exception e)
      {
      
     
          e.printStackTrace();
      }
 
        Commission.menu();  
           
        }  
       
      }
       
      }
      
        
         if(!alEmployeeSplit[1].equals(FirstName) |
          !alEmployeeSplit[2].equals(LastName)) {
        
          System.out.printf("The above information is not stored");
          
          SelectEmployee(Hours,Rate,Gross);
        
        
        }    
        }     
        
        }
        
         protected void SaveEmployee(ArrayList<String> alEmployee) {
        
        FileOutputStream fos = null; 
        ObjectOutputStream oss = null;
         try { 
         
         fos = new FileOutputStream("C:/Temp/employee.ser"); 
         oss = new ObjectOutputStream(fos);
         oss.writeObject(alEmployee); 
         
         oss.close();
         
          } 
          catch(IOException ex) {
          
           ex.printStackTrace(); 
           
           }
       
            
        }
         
         ArrayList<String> LoadEmployee() {
         
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		ArrayList<String> alEmployee = null;

		try {
	
			fis = new FileInputStream("C:/Temp/employee.ser");

			ois = new ObjectInputStream(fis);
			
			alEmployee = (ArrayList<String>) ois.readObject();
			
			
		} 
		
		catch (Exception e) {
		
			e.printStackTrace();
			
		}   
            return alEmployee;
        }
         
         
}
