/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_phase1_v2;

public class GPR {
    private short[] GPR = new short[16];
    
    public GPR()
    {
        
    }
    
    @Override
    
    //Printing the values in each Register
    public String toString() {
        String str = "\nGeneral Purpose Registers:\n";
        String[] names = {"R0", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "R12", "R13", "R14", "R15"};
        for (int i = 0; i < GPR.length; i++)
        {
            str += names[i] + ": " + GPR[i] + "\n";
        }
        return str;
    }
    
    //Returning the GPR Array
    public short[] getGPR() {
        return GPR;
    }
    
}
