/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signaturersa;

/**
 *
 * @author Saba Fatima
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;
public class SignatureRSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

 //Initializing the key pair generator
 keyPairGen.initialize(2048);

 //Generate the pair of keys
 KeyPair pair = keyPairGen.generateKeyPair();

 //Getting the private key from the key pair
 PrivateKey privKey = pair.getPrivate();

//Creating a Signature object
 Signature sign = Signature.getInstance("SHA256withRSA");

 //Initialize the signature
 sign.initSign(privKey);
 
 String msg = "Saba Fatima";

 byte[] bytes = "Saba Fatima".getBytes();
 
 sign.update(bytes);

 //Calculating the signature
 byte[] signature = sign.sign();

 //Printing the signature
 System.out.println("Digital signature for given text: "+DatatypeConverter.printHexBinary(signature));
    }
    
}
