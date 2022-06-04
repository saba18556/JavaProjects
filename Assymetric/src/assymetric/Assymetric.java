/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assymetric;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Saba Fatima
 */
public class Assymetric {
    
    private static final String RSA
        = "RSA";
 
    // Generating public and private keys
    // using RSA algorithm.
    public static KeyPair generateRSAKkeyPair()
        throws Exception
    {
        SecureRandom secureRandom
            = new SecureRandom();
 
        KeyPairGenerator keyPairGenerator
            = KeyPairGenerator.getInstance(RSA);
 
        keyPairGenerator.initialize(
            2048, secureRandom);
 
        return keyPairGenerator
            .generateKeyPair();
    }
    
    public static byte[] do_RSAEncryption(
        String plainText,
        PrivateKey privateKey)
        throws Exception
    {
        Cipher cipher
            = Cipher.getInstance(RSA);
 
        cipher.init(
            Cipher.ENCRYPT_MODE, privateKey);
 
        return cipher.doFinal(
            plainText.getBytes());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        
        KeyPair keypair
            = generateRSAKkeyPair();
 
        String plainText = "Saba Fatima";
 
        byte[] cipherText
            = do_RSAEncryption(
                plainText,
                keypair.getPrivate());
        System.out.println(
            "Public Key is: "
            + Base64.getEncoder().encodeToString(keypair.getPublic().getEncoded()));
 
        System.out.println(
            "Private Key is: "
            + Base64.getEncoder().encodeToString(keypair.getPrivate().getEncoded()));
        System.out.print("The Encrypted Text is: ");
 
        System.out.println(
            DatatypeConverter.printHexBinary(
                cipherText));
    }
    
}
