/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain.key;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.Base64;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Saba Fatima
 */
public class BlockchainKey {

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
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        KeyPair keypair
            = generateRSAKkeyPair();
 
        System.out.println(
            "Public Key is: "
            + Base64.getEncoder().encodeToString(keypair.getPublic().getEncoded()));
 
        System.out.println(
            "Private Key is: "
            + Base64.getEncoder().encodeToString(keypair.getPrivate().getEncoded()));
    }
    
}
