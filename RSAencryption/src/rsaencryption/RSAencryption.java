
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saba Fatima
 */
public class RSAencryption {

    /**
     * @param args the command line arguments
     */
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
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        KeyPair keypair
            = generateRSAKkeyPair();
 
        String plainText = "MIIBCgKCAQEAyq4JMh49jp+NHeR3HEk/EU9wxT+sTzTimbEDW4SpBXKizdZgshGv\n" +
"oPS1K1pFB7hBS5CIG6narAVoTJaGGCUHR4jUm3pWpJqwWckwRPu47Ee6ZfRQAdWU\n" +
"pziBbM5fiqiEJVkTsqGNbSEBNFiqPVX3/rhe8eym5JIcwD8AydETJsHv2kio5Q0m\n" +
"ohbmkEQwVguMYMYBOnyWA2D51sSFV7tJWSxME6zQZzvYOTgZYMUO+15hq62gpmkS\n" +
"evwdVoHC/7i4HPwdTAGiUh+AX6D70Zv9kqN/PuGn5e+Vst9VyK3So0Fv4UQeRJJ+\n" +
"pONOpKDTd7F4PJO+gSMxy6nana6OF5sI0QIDAQAB";
 
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
    }
    
}
