import java.io.*;
import java.io.Serializable;
import java.util.*;

public class Employee implements Serializable
{
    /*********************
	     Attributes
	*********************/
    public String FirstName;
    public String LastName;
    public int Hours;
    public float Rate;
    public float Gross;
        
//	float rate=30.0f;
	float taxrate=0.2f;
//	int hours=45;
//	float gross=0.0f;
	float tax=0.0f;
	float net=0.0f;
	float net_percent=0.0f;

	//End Attributes
        
        /********************
	     Constructors
	********************/
        
        public void SaveEmployee()
        {
                
        try{ 
            try (FileOutputstream fos = new FileOutputStream("EmployeeFile.out")){
            ObjectOutputstream oos =new ObjectOutputstream(fos);
            
            oos.writeObject(emp));
            
            fos.flush();
            oos.flush();
            fos.close();
            oos.close();
            }
        } catch (IOException e)
        {
            System.err.Println(e);
        }
        System.out.println("Accounts have been Saved")
}

    public void ReadEmployee ()
{ 
try
{
FileInputStream fileln =new FileInputStream ("EmployeeFile.out")
ObjectInputStream in = new ObjectInputStream(fileln);
emp=(Employee[]) in.readObject();
in.close();
fileIn.close();
}
 catch (IOExxcepion | Null ExceptionPointer i)
{
in.printStackTrace();

}

        
                 
        }   
       public Employee()
       
        {
        
      Employee employee = null;  
        
    try
      {
     
      java.io.File employee2 = new java.io.File("C:/Temp/mployee2.ser");
		  
          try (FileInputStream fis = new FileInputStream(employee2); ObjectInputStream ois = new ObjectInputStream(fis)) {
              employee = (Employee) ois.readObject();
          }
      }catch(IOException | ClassNotFoundException e)
      {
         e.printStackTrace();
         return;
      }
     
      FirstName=employee.FirstName;
      LastName=employee.LastName;
      Hours=employee.Hours;
      Rate=employee.Rate;
      Gross=employee.Gross;       
          
    
       
        }
        	
	/********************
	     Methods
	********************/
        public void menu()
        {
        
        Scanner in = new Scanner(System.in);

            String select;

            boolean goodby =  false;


            do {
                
                  System.out.println("\ni. Calculate Gross Pay");

                  System.out.println("ii. Calculate Tax");

                  System.out.println("iii. Calculate Net Pay");
                  
                  System.out.println("iv. Calculate Net Percent");
                  
                   System.out.println("v. DisplayEmployee");

                  System.out.print("Your choice, 0 to quit: ");

                  select = in.next();

                  switch (select) {

                  case "i":
                  
                  computeGross();

                        break;

                  case "ii":
                  
                  computeTax();

                        break;

                  case "iii":
                  
                   computeNet();
                   
                   break;
                   
                   case "iv":
                   
                   computeNetperc();

                        break;
                        
                      case "v":
                   
                   displayEmployee();

                        break;

                  case "0":

                        goodby = true;

                        break;

                  default:

                        System.out.println("Incorrect selection.");

                        break;

                  }

                  System.out.println();

            } while (!goodby);

            System.out.println("goodbye!");

            
        }
         
	protected void computeGross()
        	{ 
        	
   Gross=Rate*Hours;
		
	}

	protected void computeTax() 
{ 
		tax=Gross*taxrate;
	}

	protected void computeNet()
 { 
		net=Gross-tax;
	}

	protected void computeNetperc() 
{ 
		net_percent=(net/Gross)*100;
	}
	
	protected void displayEmployee() 
{

   if(Rate>0) { 
   if(Hours>0) { 
   
		System.out.println("Hours: " + new Integer(Hours));
		System.out.println("Rate: " + new Float(Rate));
		
		}
		}
		
		System.out.println("Gross: " + new Float(Gross));
		System.out.println("Net: " + new Float(net));
		System.out.println("Net%: " + new Float(net_percent) + "%");
		
		try {
		
		FileWriter fw=new	FileWriter("Payroll.txt" + FirstName + "_" + LastName + ".txt",false);
		
				BufferedWriter bw=new BufferedWriter(fw);
				
			bw.write("FirstName: " +  FirstName + "\n");
			
			bw.write("LastName: " + LastName + "\n");
			
			bw.write("Hours: " +  Hours + "\n");
			
			bw.write("Rate: " + Rate + "\n");

			bw.write("Gross: " + Gross + "\n");
			
			bw.write("Net: " + net + "\n");
			
			bw.write("Net%: " + net_percent + "\n");
			
								bw.flush();
						bw.close(); 
	       
        }
        
       catch (Exception e) {
       
			e.printStackTrace();
			
		}  
		
		
	}
} 	










