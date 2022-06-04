/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash256;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author Saba Fatima
 */
public class Hash256 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
        //Reading data from user
Scanner sc = new Scanner(System.in);
System.out.println("Enter the message");
String message = sc.nextLine();

 //same code will be used for sha-256
 MessageDigest md = MessageDigest.getInstance("SHA-512");

 //Passing data to the created MessageDigest Object
 md.update(message.getBytes());

 //Compute the message digest
 byte[] digest = md.digest();

 System.out.println(digest);

 //Converting the byte array in to HexString format
 StringBuffer hexString = new StringBuffer();
 for (int i=0;i<digest.length;i++) {
 hexString.append(Integer.toHexString(0xFF & digest[i]));
 }
 System.out.println("Hex format : " + hexString.toString());
 

    }
    
}
