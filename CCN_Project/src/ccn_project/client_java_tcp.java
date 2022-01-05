//GROUP MEMBERS: Saba Fatima And Mahum Fatima Khan

package ccn_project;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class client_java_tcp  {
    private Socket socket=null;
    
    public client_java_tcp(String ip,int port) throws UnknownHostException,IOException{
        
        System.out.println("csil-machine2> client "+ ip + " " + port);
        socket = new Socket(ip,port);
        DataInputStream input=new DataInputStream(socket.getInputStream());  
        DataOutputStream output=new DataOutputStream(socket.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        
        String str="";

        // sends output to the socket
        output = new DataOutputStream(socket.getOutputStream());
        String text = "";
        System.out.print("csil-machine2>> Enter message to be sent: ");
        
         if (text.length()<80) {
               text=br.readLine();   
               output.writeUTF(text);  
               output.flush();  
               str=input.readUTF();
               System.out.println("Response from Server: "+ str);
           
         }
   
         // close the connection
       
             input.close();
             output.close();
             socket.close();
             System.exit(0);
    }

    public static void main(String args[]) throws UnknownHostException
    {
    	Scanner in = new Scanner(System.in);
    	System.out.print("Enter ip: ");
    	String ip = in.nextLine();
        
    	int port = (int)(Math.random()*10000);
        
        try {
            client_java_tcp client = new client_java_tcp(ip,5000);
        } catch (IOException ex) {
            Logger.getLogger(client_java_tcp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
