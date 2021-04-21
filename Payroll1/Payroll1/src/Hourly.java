import java.io.*;


 public class Hourly extends Employee { 
 
 public Hourly() {
 
 
 Employee employee = null;
   
    try
      {
	
	 java.io.File employee2 = new java.io.File("C:/Temp/employee2.ser");
	 
	
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
 
public void computeGross()
        	{ 
        	
        	
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
