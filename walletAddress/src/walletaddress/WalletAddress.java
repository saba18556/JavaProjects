/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package walletAddress;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.xml.bind.DatatypeConverter;
import java.util.Base64;

/**
 *
 * @author Saba Fatima
 */
public class WalletAddress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        KeyPair kp = keyGen.generateKeyPair();
        PublicKey pub = kp.getPublic();
        PrivateKey pvt = kp.getPrivate();
        String kpub = pub.toString();
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] s1 = sha.digest(kpub.getBytes("UTF-8"));
        System.out.println("  sha: " + DatatypeConverter.printHexBinary(s1).toUpperCase());
        String rmd = "9dead49313d7dd122c5a5c9f8450b54d15f71bb2";
        byte[] r1 = rmd.getBytes();
        byte[] r2 = new byte[r1.length + 1];
        r2[0] = 0;
        for (int i = 0 ; i < r1.length ; i++) r2[i+1] = r1[i];
        System.out.println("  rmd: " + DatatypeConverter.printHexBinary(r2).toUpperCase());
        byte[] s2 = sha.digest(r2);
        System.out.println("  sha: " + DatatypeConverter.printHexBinary(s2).toUpperCase());
        byte[] s3 = sha.digest(s2);
        System.out.println("  sha: " + DatatypeConverter.printHexBinary(s3).toUpperCase());
        byte[] a1 = new byte[50];
        for (int i = 0 ; i < r2.length ; i++) a1[i] = r2[i];
        for (int i = 0 ; i < 5 ; i++) a1[20 + i] = s3[i];
        System.out.println("  adr: " + Base64.getEncoder().encodeToString(a1));
        
    }
    
}
