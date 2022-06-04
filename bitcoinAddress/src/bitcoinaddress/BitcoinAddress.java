/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitcoinaddress;

/**
 *
 * @author Saba Fatima
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import javax.xml.bind.DatatypeConverter;


public class BitcoinAddress {
    

    /**
     * @param args the command line arguments
     */
    static public String adjustTo64(String s) {
    switch(s.length()) {
    case 62: return "00" + s;
    case 63: return "0" + s;
    case 64: return s;
    default:
        throw new IllegalArgumentException("not a valid key: " + s);
    }
    }
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1");
        keyGen.initialize(ecSpec);
        KeyPair kp = keyGen.generateKeyPair();
        PublicKey pub = kp.getPublic();
        PrivateKey pvt = kp.getPrivate();
        ECPrivateKey epvt = (ECPrivateKey)pvt;
        
String sepvt = adjustTo64(epvt.getS().toString(16)).toUpperCase();
System.out.println("s[" + sepvt.length() + "]: " + sepvt);
ECPublicKey epub = (ECPublicKey)pub;
ECPoint pt = epub.getW();
String sx = adjustTo64(pt.getAffineX().toString(16)).toUpperCase();
String sy = adjustTo64(pt.getAffineY().toString(16)).toUpperCase();
String bcPub = "04" + sx + sy;
System.out.println("bcPub: " + bcPub);
MessageDigest sha = MessageDigest.getInstance("SHA-256");
byte[] s1 = sha.digest(bcPub.getBytes("UTF-8"));
System.out.println("  sha: " + DatatypeConverter.printHexBinary(s1).toUpperCase());
MessageDigest rmd = MessageDigest.getInstance("RipeMD160","BC");
byte[] r1 = rmd.digest(s1);



    }
    
    
}
