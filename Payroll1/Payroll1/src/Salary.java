import java.util.*;
import java.io.*;




 public class Salary extends Employee { 
 
 public Salary() {
 
 
 Employee employee = null;
   
    try
      {
		  
     	 java.io.File employee2 = new java.io.File("C:/Temp/employee.ser");
	
     try (FileInputStream fis = new FileInputStream(employee2); ObjectInputStream ois = new ObjectInputStream(fis)) {
         employee = (Employee) ois.readObject();
     }
      }catch(IOException | ClassNotFoundException e)
      {
         return;
      }
    
     
       }
 
 	public void displayEmployee()
 { 
 
 System.out.println("Gross: " + Gross);
		System.out.println("Net: " + net);
		System.out.println("Net%: " + net_percent + "%");

 
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 }
