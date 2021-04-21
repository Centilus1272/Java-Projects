
 
package mymethods2;
import java.util.Scanner;
//import java.util.StringTokenizer;
import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;



 //
public class RunMyMethods2 
{
   


 


    public static void main(String args[]) throws IOException
    {
        MyMethods2 vm = new MyMethods2();
        int input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
         
        do
        {
            System.out.println("1) Product");
            System.out.println("2) Find Twelves");
            System.out.println("3) Min Max Average");
            System.out.println("4) Grades");
            System.out.println("5) Exit");
             
//            String s = br.readLine();
//            input = Integer.parseInt(br.readLine());
            input = sc.nextInt();
             
            switch (input) {
                case 1:
                    vm.product();
                    break;
                case 2:
                    vm.findTwelves();
                    break;
                case 3:
                    vm.minMaxAvg();
                    break;
                case 4:
                    vm.myGrader();
                    break;
                case 5:
                    vm.exit();
                    break;
                default:
                    break;
            }
        }while(input != 5);
         
    }
}


    
