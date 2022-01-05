
package javaapplication15;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;


public class JavaApplication15 {

    public final static int SERVICE_PORT = 32000;
    public static void main(String[] args) throws IOException{
        
         try{
      /* Instantiate client socket. 
      No need to bind to a specific port */
      DatagramSocket clientSocket = new DatagramSocket();
      String host = "192.168.254.19";
      // Get the IP address of the server
      InetAddress IPAddress = InetAddress.getByName(host);
      
      // Creating corresponding buffers
      byte[] sendingDataBuffer = new byte[1024];
      byte[] receivingDataBuffer = new byte[1024];
      
      /* Converting data to bytes and 
      storing them in the sending buffer */
       System.out.print("csil-machine2>");
       System.out.println("client " + host + " " +SERVICE_PORT);
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter text: ");
      String sentence = sc.next();
        
      sendingDataBuffer = sentence.getBytes();
      
      // Creating a UDP packet 
      DatagramPacket sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,IPAddress, SERVICE_PORT);
      
      // sending UDP packet to the server
      clientSocket.send(sendingPacket);
      
      // Get the server response .i.e. capitalized sentence
      DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
      clientSocket.receive(receivingPacket);
      
      // Printing the received data
      String receivedData = new String(receivingPacket.getData());
      //System.out.println("Sent from the server: "+receivedData);
      System.out.println("Response from server : " +receivedData);
      
      // Closing the socket connection with the server
      clientSocket.close();
    }
    catch(SocketException e) {
      e.printStackTrace();
    }
    }
    
}
