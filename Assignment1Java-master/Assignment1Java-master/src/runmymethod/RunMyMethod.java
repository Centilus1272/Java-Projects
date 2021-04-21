/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runmymethod;

//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author My Computer
 */
public class RunMyMethod {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
  public static void main(String[] args) throws IOException
    {
   
        MyMethods mm = new MyMethods();
        int input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
      do{
         System.out.println(   "1] Product");
         System.out.println(   "2] Find Twelve");
         System.out.println(   "3] Min Max Average");
         System.out.println(   "4] Grades");
         System.out.println(   "5] Exit");
         
         input = Integer.parseInt(br.readLine());
         
         if(input == 1)
         {
             mm.product();
         }
         else if(input ==2)
            {
                mm.findTwelves();
            }
            else if(input ==3)
            {
                mm.calcMinMaxAvg();
            }
            else if(input == 4)
            {
                mm.calcGrades();
            }
            else if(input == 5)
            {
                mm.Exit();
            }
        
      }
      while(input != 5);
    }
}

         
         
         
         
      
      
      
      
      
      
   
    

