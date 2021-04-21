import java.util.*;
import java.io.*;




 public class Commission extends Employee { 
 
 public Commission() {
 
 
 Employee employee = null;
   
    try
      {
		  
        	 java.io.File employee2 = new java.io.File( "Payroll.txt");
	
         FileInputStream fis = new FileInputStream(employee2);
         
         ObjectInputStream ois = new ObjectInputStream(fis);
         employee = (Employee) ois.readObject();
         ois.close();
         fis.close();
      }catch(Exception e)
      {
         e.printStackTrace();
         return;
      }
    
     
       }
 
 	public void displayEmployee()
 {   
 
 System.out.println("Gross: " + new Float(Gross));
		System.out.println("Net: " + new Float(net));
		System.out.println("Net%: " + new Float(net_percent) + "%");

 
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 }
