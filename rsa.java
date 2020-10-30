/*
  UOW ID: 5987520
  Student Name: Ricardo Budidharma
  Programming Language: Java
*/

package Task1SourceCode;

import java.util.*;

public class rsa {

   public static void main(String[] args) {
   
      Scanner in = new Scanner(System.in);
      
      //option to choose function
      while (true) {
        System.out.println("\nPlease Choose One");
        System.out.println("1. Generate Keys");
        System.out.println("2. Create Signature");
        System.out.println("3. Verify Signature");
        System.out.println("4. Exit");
        System.out.print("Enter Choice: ");
        int choice = in.nextInt();
        System.out.println("");
        switch(choice){
        
           case 1: keyGen.generateKey(); //function to generate key
                   break;
                   
           case 2: signature.sign(); //function to create signature
                   break;
           
           case 3: signature.verify(); //function to verify signature
                   break;
                   
           case 4: System.out.println("Thank you for using the program.");
		   System.exit(0);
                   break;
                   
           default: System.out.println("Invalid Choice");
        
        }
        
      }
   
   }
}
