/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_phase1_v2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Memory {
    private byte[] byteMemory = new byte[65536];
    private int codeCounter;
    
    //Reads the File and stores each value into a byte Array i.e. byteMemory
    public Memory() throws FileNotFoundException
    {
        Scanner s = new Scanner(new File("p1.txt"));
        codeCounter = 0;
        
        while (s.hasNext())
        {
            byteMemory[codeCounter] = (byte) s.nextInt();
            codeCounter++;
        }
        printMemory();
    }
    
    //Printing Decimal and HexaDecimal values of the byteMemory Array
    public void printMemory()
    {
        System.out.println("Decimal Byte Values:");
        for (int i = 0; i < 13; i++) {
            System.out.println(Byte.toUnsignedInt(byteMemory[i]));
        }
        System.out.println("\nHexa String Values:");
        for (int i = 0; i < 13; i++) {
            System.out.println(SPR.decimalToHex(Byte.toUnsignedInt(byteMemory[i])));
        }
        System.out.println("");
    }
    
    //Getting the instruction program counter is pointing at
    public byte getByte(int programCounter)
    {
        return byteMemory[programCounter];
    }
    public int getCodeCounter()
    {
        return codeCounter;
    }
    
    //updating the values in byteMemory array
    public void updateByte(int index, byte num)
    {
        byteMemory[index] = num;
    }
}
