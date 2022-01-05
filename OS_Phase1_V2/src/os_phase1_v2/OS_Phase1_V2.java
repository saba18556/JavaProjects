/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_phase1_v2;

import java.io.FileNotFoundException;

/**
 *
 * @author rhs-9
 */
public class OS_Phase1_V2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        //SPR spr = new SPR();
        Memory mem = new Memory();
        GPR gpr = new GPR();
        SPR spr = new SPR(mem, gpr);
        
        System.out.println(gpr);
    }
}
