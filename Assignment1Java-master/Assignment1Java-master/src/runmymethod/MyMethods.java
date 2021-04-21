/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runmymethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author My Computer
 */
public class MyMethods 
{

public void product() throws IOException
{
    float input = 0;
        float temp = 1;
        int index;
        String s;
       
        System.out.println("");
        System.out.println("");
        System.out.println("Enter string of numbers followed by \\\"0\\\" to exit.");
        System.out.println("Decimals are acceptable");
        System.out.println("Negative #'s are ignored");
        
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String line = br.readLine();
        
        StringTokenizer st = new StringTokenizer(line);
   input = Float.parseFloat(st.nextToken());

if(input==0)
    { 
 
         System.out.print("END");
         System.exit(1);
         
    }
 
         while(input != 0)
         {
 
             if(input<0)
             {
                System.out.println(input + " ignored.");
         }
             else if(input>0)
             {
                
                temp = input * temp;
                 
             }
              
             input = Float.parseFloat(st.nextToken());
         }
         
        s =     Float.toString(temp);
        
        index=s.indexOf(".");
 
        int i = index+5;
        int j = s.length();
    
        if(j > i)
        {
              System.out.println("The product of all positive inputs is " + s.substring(0,i));
        }
        else
        {
           System.out.println("The Product of all positive inputs is " + s);
        }
        System.out.println("END");
    }
     public void findTwelves() throws IOException
     {
      
         int input, first, last,count,num; 
    input=first=last=count=num=0;
        System.out.println("");
        System.out.println("");
        System.out.println("Enter #");
        System.out.println("How many # \"12\".");
        System.out.println("1st and last \"12\".");
         
        BufferedReader br;
        br = new BufferedReader( new InputStreamReader( System.in ) );
        String line = br.readLine();
 
        StringTokenizer st = new StringTokenizer( line );
 
            while(st.hasMoreTokens() )
            {
 
                input = Integer.parseInt(st.nextToken());
 
                count++;
 
                if(first==0)
                {
                    if(input == 12)
                    {
                        first = count;
                        last = count;
                        num++;
                        
                    }
                }
                else
                {
                    if(input==12)
            {
                        num++;   
                        last=count;
                    }
                }
        }
        System.out.println("The first # 12 is located at" + first);
 
        if(first !=0)
        {
        System.out.println("Entry " + num + " \"12's\"");
        System.out.println("Last instance of # 12 is at" + last);
        System.out.println("Ending");
        }
    
     }
     public void calcMinMaxAvg()throws IOException
     {
      System.out.println("Enter #'s");
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(br.readLine());
     int count = 0;
     int min = 0;
     int max = 0;
     int temp = 0;
     int avg = 0;
   
        if(st.hasMoreTokens())
        { 
            min = Integer.parseInt(st.nextToken()); 
        } 
        if(st.hasMoreTokens())
        { 
            max = Integer.parseInt(st.nextToken()); 
        } 
        if(st.hasMoreTokens())
        { 
            temp = Integer.parseInt(st.nextToken()); 
        } 
        if(st.hasMoreTokens())
        {
        int Num= Integer.parseInt(st.nextToken()); 
      
        float Avg= Num+Num/count++;
  
    System.out.println("AVG: "+Num);
    System.out.println("MAX: " + max); 
    System.out.println("MIN: " + min);
        }   
     }
     public void calcGrades()throws IOException
     {
         int  input = 0, sumA, sumB, sumC, sumD, sumF;
    sumA=sumB=sumC=sumD=sumF=0;
        System.out.println("Enter a series of numbers:");
        Scanner sc = new Scanner(System.in);
         String line = sc.nextLine();
        StringTokenizer mytokenizer = new StringTokenizer(line);
         
        while(mytokenizer.hasMoreTokens())
        {
            input = Integer.parseInt(mytokenizer.nextToken());
          //   if(mytokenizer.nextToken() >= 90)
             
                 if(input >= 90){
                     sumA++;
                     System.out.println(new Integer (input) + "      A");
                 }
                 else if (input >= 70)
                 {
                 sumB++;
                 System.out.println(input + "      B");
                 }
                 else if(input >= 50){
                     sumC++;
                     System.out.println(input + "      C");
                 }
                 else if(input >= 35){
                     sumD++;
                     System.out.println(input + "      D");
                 }
                 
                 else{
                     sumF++;
                     System.out.println(input + "      F");
                 }
                 
             }
 
            
        
        
         
        System.out.println("The total number of A's is " + sumA);
        System.out.println("The total number of B's is " + sumB);
        System.out.println("The total number of C's is " + sumC);
        System.out.println("The total number of D's is " + sumD);
        System.out.println("The total number of F's is " + sumF);
     }
     public void Exit(){
         
     }
     


}



   


