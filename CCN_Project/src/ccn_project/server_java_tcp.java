//GROUP MEMBERS: Saba Fatima And Mahum Fatima Khan

package ccn_project;
import java.net.*;
import java.io.*;

public class server_java_tcp {

   private DataInputStream input=null;
   private static int port=5000;
   private Socket socket=null;
   private ServerSocket server=null;
   
   
public server_java_tcp(int port){
    try { 
			server = new ServerSocket(port);

			System.out.println("csil-machine1> Server "+ port);
			System.out.println("csil-machine1> Waiting for client Connection.. ");
			socket = server.accept();
			System.out.println("csil-machine1> Connection Established");
			DataOutputStream dout=new DataOutputStream(socket.getOutputStream()); 
			input=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			String text="";
			
                        
			if(text.length()<80){
                            text=input.readUTF();
                            String s=ReverseCapitalize(text);
			    dout.writeUTF(s);
                            dout.flush();
                            
                        }
                        
			System.out.println("csil-machine1> Closing Connection ");
			socket.close();
			server.close();
			input.close();
}
		catch(IOException i) {
			
		}
}
public static String ReverseCapitalize(String text) {
	
	char[] charArray = text.toCharArray();
        String ans="";
        char s;
    //process chars one by one
    for(int i=0; i < charArray.length; i++){
        
        //if char is uppercase, make it lower case
        if( Character.isUpperCase(charArray[i]) ){
            
            charArray[i] = Character.toLowerCase( charArray[i] );
            
        }else if(Character.isLowerCase(charArray[i]) ){
            
            charArray[i] = Character.toUpperCase( charArray[i] );
        }
        text = new String(charArray);
    }
    charArray = text.toCharArray();
        
        for (int i = charArray.length - 1; i >= 0; i--){
            ans+=charArray[i];
           
        }

        return ans;
}
	

	public static void main(String[] args) {
		
            server_java_tcp server= new server_java_tcp(port);
	}

}
