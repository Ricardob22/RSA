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

public class keyGen {

   //RSA Key Generation function
   public static void generateKey() {
      
      SecureRandom rand = new SecureRandom();
      BigInteger p, q, N, phi, d, e;
      int bit;
      Scanner in = new Scanner(System.in);
      
      do {
         System.out.print("Enter bit length (up to 32 bits): ");
         bit = in.nextInt();
      }while (bit > 32 || bit < 1);
      
      do{
			p = new BigInteger(bit, rand); //generate a random number and that would be p.
		}
		while(!p.isProbablePrime(1)); //ensuring that the randon p is a prime number
      
      System.out.println("p generated as: " + p);
      
      do{
			q = new BigInteger(bit, rand); //generate a random number and that would be q.
		}
		while(!q.isProbablePrime(1)); //ensuring that the random q is a prime number
      
      System.out.println("q generated as: " + q);
      
      N = p.multiply(q); //generate N = p * q
      
      System.out.println("N generated as: " + N);
      
      //generate phi = (p-1) * (q-1)
      phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)); 
      
      //generate e
      e = generateE(phi);
      
      System.out.println("e generated as: " + e);
      
      //compute d where ed = 1 mod phi. d = e^-1 mod phi
      d = e.modInverse(phi);
     
      System.out.println("d generated as: " + d);
      
      System.out.println("\nWriting to file"); //writing the values to the files
      try {
           
           FileWriter pk = new FileWriter(new File("Task1SourceCode/pk.txt"));
           FileWriter sk = new FileWriter(new File("Task1SourceCode/sk.txt"));
           
           pk.write("N: " + "\n" + N + "\n" + " e: " + "\n" + e + "\n"); //public key (N,e)
           pk.close();
           System.out.println("N and e written to pk.txt");
           
           sk.write("N: " + "\n" + N + "\n" + " p: " + "\n" + p + "\n" + " q: " + "\n" + q + "\n" + " d: " + "\n" + d + "\n"); //private key (N,p,q,d)
           sk.close();  
           System.out.println("N, p, q, d written to sk.txt");
           
      } catch (Exception e1) {
      
            e1.printStackTrace();
      }
   
   }
   //function to compute e
   public static BigInteger generateE(BigInteger phi) {
      
       BigInteger e;
       Boolean flag = false;
       
       do {
         e = new BigInteger(phi.bitLength(), new SecureRandom()); //generate a random value for e that has same bitlength as the phi value
         if(e.gcd(phi).equals(BigInteger.ONE) && (e.compareTo(phi) == -1) && (e.compareTo(BigInteger.ONE) == 1)) //ensuring that gcd(e,phi) = 1 and the value is between 0 and phi value.
         {
            flag = true;
         }
       } while (flag == false);
       
       return e;
   
   }

}
