/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymethods2;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
 

 
//
public class MyMethods2
{
// public static void main(String args[])       
//{

    /**
     *
     * @throws IOException
     */
    
    public void product() throws IOException
    {
    int input;// = 1;
        int temp = 1;
//        int index;
//        String s;
 
        System.out.println("");
        System.out.println("");
        System.out.println("Enter string of numbers followed by \"0\" to exit."); // system.out.println( Displays Message for the user to input.
        System.out.println("Decimals are acceptable");
        System.out.println("Negative #'s are ignored");
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //buffer reader allows user to type input//
        String line = br.readLine(); // reads(read) user input and assigns to line(Line)
 
        StringTokenizer st = new StringTokenizer(line);
        
 
    
     while (st.hasMoreTokens())//st=string tokenizer goes through each varibale and count 
     {
        input = Integer.parseInt(st.nextToken());// seperates each variable input from tokenizer
        temp = (input * temp);   //goes through each input then reassigns to temp then multiplies by input then reassigns answer to temp variable    
     }
     if(temp==0)
         System.out.print("You have entered zero");
        // System.exit(1);
         else
             System.out.println("The product is " + temp);// product of all tokens
    }

 
     
    public void  findTwelves()
    {
        
        Scanner reader = new Scanner(System.in);
        String input;
        int firstIndex = 0;
        int lastIndex = 0;
        int tokenCount = 0;

        // Get your input
        System.out.println("Enter in a collection of numbers:");
        input = reader.nextLine();
        
        // Tokenize your string
        StringTokenizer tokens = new StringTokenizer(input, ",");
        
        // Loop through each token until there are no more tokens
        while (tokens.hasMoreTokens())
        {
            // Get your next value by converting the string token to an int value
            int tokenValue = Integer.parseInt(tokens.nextToken());
            tokenCount += 1;          // Increment the token count
            
            // Check whether the current token matches the value we are searching for
            if (tokenValue == 12)
            {
                // If the firstIndex has not been set yet, then set it
                if (firstIndex == 0)
                    firstIndex = tokenCount;      // set the first index to the current count
                
                lastIndex = tokenCount;                  // set the last index to the current count
            }
        }
        
        // Print out first index (will cover where number not found
        // since it was initialized to 0).
        System.out.println( "The first index"+firstIndex);
        
        
        // If the number 12 was found, then print the last index
        if (firstIndex != 0)
            System.out.println("The Last index"+lastIndex);

    }
      
            
            
            
            
    
public void minMaxAvg() throws IOException
{ 

      
        System.out.println("Please enter your numbers.");  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
        int count = 0;  
        int min = Integer.MAX_VALUE;  
        int max = Integer.MIN_VALUE;  
        int total = 0;  
           
        while (st.hasMoreTokens()) { //Added while loop here  
            int Num = Integer.parseInt(st.nextToken());  
            if (Num > max) {  
                max = Num;  
                // min = Integer.parseInt(st.nextToken());  
            }  
            if (Num < min) {  
                min = Num;  
                // max = Integer.parseInt(st.nextToken());  
            }  
            // System.out.println("Min : " + min + " Max : " + max);  
   
            count++; // increment counter  
            total += Num; // accumulate the sum  
        }  
   
        float average = (float) total / count;  
        System.out.println("The Average value is: " + average);  
        System.out.println("Maximum: " + max);  
        System.out.println("Minimum: " + min);  
    }  

    


    public void myGrader() 
    {
            int input, sumA, sumB, sumC, sumD, sumF;
             sumA=sumB=sumC=sumD=sumF=0;

Scanner sc = new Scanner(System.in);

System.out.println("Enter a grade or -99 to exit");
input = sc.nextInt();

if(input==-99) 
{
System.exit(1);
}

while(input != -99)
{

if(input>=90)
{
sumA++;
System.out.println(input + " A");
}
else if(input >= 70)
{
sumB++;
System.out.println(input + " B");
}
else if(input >= 50)
{
sumC++;
System.out.println(input + " C");
}
else if(input >= 35)
{
sumD++;
System.out.println(input + " D");
}
else
{
sumF++;
System.out.println(input + " F");
}

System.out.println("Enter another grade -99 to quit: ");
input = sc.nextInt();
}

System.out.println("The total number of A's is " + sumA );
System.out.println("The total number of B's is " + sumB );
System.out.println("The total number of C's is " + sumC );
System.out.println("The total number of D's is " + sumD );
System.out.println("The total number of F's is " + sumF );
         
    }

    void exit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}