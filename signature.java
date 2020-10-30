/*
  UOW ID:5987520
  Student Name: Ricardo Budidharma
  Programming Language: Java
*/

package Task1SourceCode;

import java.util.*;
import java.math.*;
import java.security.*;
import java.io.*;

public class signature {
  
   private static BigInteger p, q, e, N, d, M, sig;
   
   //function to create RSA signature
   public static void sign() {
      
      try { //reading secret key file secret key (N,p,q,d)
         Scanner sc = new Scanner(new File("Task1SourceCode/sk.txt"));
         String read;
         if (sc.hasNextLine()) {
         
           read = sc.nextLine();
           read = sc.nextLine();
           N = new BigInteger(read); //N
         }
         if (sc.hasNextLine()) {
         
            read = sc.nextLine();
            read = sc.nextLine();
            p = new BigInteger(read); //p
         }
         if (sc.hasNextLine()) {
    
            read = sc.nextLine();
            read = sc.nextLine();
            q = new BigInteger(read); //q
         }
         if (sc.hasNextLine()) {
         
            read = sc.nextLine();
            read = sc.nextLine();
            d = new BigInteger(read); //d
         }
         sc.close();
      } catch (FileNotFoundException e1) {
         System.out.println("Unable to locate secret key file. Exiting program.");
         System.exit(1);
        }  
      
      try { //reading value from message file
         Scanner sc = new Scanner(new File("Task1SourceCode/mssg.txt"));
         String read;
         if (sc.hasNextLine()) {
         
           read = sc.nextLine();
           M = new BigInteger(read); //M
         }
         sc.close();
      } catch (FileNotFoundException e1) {
         System.out.println("Unable to locate message file. Exiting program.");
         System.exit(1);
        }  
        
        //compute signature S = M^d mod N
        sig = M.modPow(d, N); 
        
        System.out.println("Message: " + M);
        System.out.println("Signature: " + sig);
        
        System.out.println("\nWriting to file");
        try { //writing the signature value into file
           
           FileWriter s = new FileWriter(new File("Task1SourceCode/sig.txt"));
           
           s.write(sig + "\n");
           s.close();
           System.out.println("Signature written to sig.txt");
        } catch (Exception e1) {
      
           e1.printStackTrace();
         }  
   }
   
   //function to verify RSA signature
   public static void verify() {
   
      try { //Read in public key file
      
         Scanner sc = new Scanner(new File("Task1SourceCode/pk.txt"));
         String read;
         if (sc.hasNextLine()) {
         
           read = sc.nextLine();
           read = sc.nextLine();
           N = new BigInteger(read); //N
         }
         if (sc.hasNextLine()) {
 
           read = sc.nextLine();
           read = sc.nextLine();
           e = new BigInteger(read); //e
         }
         sc.close();
      }catch (FileNotFoundException e1) {
         System.out.println("Unable to locate public key file. Exiting program.");
         System.exit(1);
        } 
        
      try { //Read in signature file
         
       Scanner sc = new Scanner(new File("Task1SourceCode/sig.txt"));
       String read;
       if (sc.hasNextLine()) {
         
         read = sc.nextLine();
         sig = new BigInteger(read); //S
       }
       sc.close();
      }catch (FileNotFoundException e1) {
      
         System.out.println("Unable to locate signature file. Exiting program.");
         System.exit(1);         
        } 
        
      try { //Read in message file
         Scanner sc = new Scanner(new File("Task1SourceCode/mssg.txt"));
         String read;
         if (sc.hasNextLine()) {
         
           read = sc.nextLine();
           M = new BigInteger(read); //M
         }
         sc.close();
      } catch (FileNotFoundException e1) {
         System.out.println("Unable to locate message file. Exiting program.");
         System.exit(1);
        }  
        
      //compute M' = S^e mod N
      BigInteger check = sig.modPow(e, N); 
      
      System.out.println("Signed Message: " + sig);

      //check if M = M'
      if (check.equals(M))
         System.out.println("Signature Verification: True");
      else {
         System.out.println("Signature Verification: False");
      }
      
      System.out.println("Decrypted Message: " + check);
   
   }

}
