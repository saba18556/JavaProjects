
package stp;

public class ports {
   
    final int cost = 19;
    Switch sw = null;
    String type;
    BPDU incoming_packet;
    
    ports(){
        
    }
    
    public void set_label(String type){
        this.type = type;
    }
    
    public void set_connection(Switch sw){
        this.sw = sw;
    }
    public boolean is_connection(){
        return this.sw != null;
    }

    
    
}
