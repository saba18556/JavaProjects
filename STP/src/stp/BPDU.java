
package stp;

class BPDU {
    
    int root_ID;
    int cost;
    int B_ID;
    
    BPDU(int ID){
        this.root_ID = ID;
        this.cost = 0;
        this.B_ID = ID;
    }
    
    public String toString(){
        return(root_ID + "." + cost + "." + B_ID);
    }
    
    
    
}
