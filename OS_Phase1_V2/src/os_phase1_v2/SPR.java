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
public class SPR {
    private short[] SPR = new short[16];
    Memory mem;
    GPR gpr;
    short[] Gregister;
    short flag = 0;
    
    //Entering values of CC, PC and IR into the SPR Array
    public SPR(Memory mem, GPR gpr) throws FileNotFoundException
    {
        this.mem = mem;
        this.gpr = gpr;
        Gregister = this.gpr.getGPR();
        
        SPR[2] = (short) mem.getCodeCounter(); //CodeCounter
        SPR[9] = SPR[0];                       //ProgramCounter
        SPR[10] = (short) Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(SPR[9])));  //InstructionRegister
        Execute();
        printSPR();
    }
    
    //Execution of corresponding methods of each instruction
    //The Terminating conditions are: If PC(SPR[9])>CC(SPR[2]) or F3 is pressed
    public void Execute()
    {
        boolean terminate = false;
        
        while (SPR[9] < SPR[2])
        {
            String code = decimalToHex(SPR[10]);
            SPR[9]++;
            
            switch (code)
            {
                case "16":
                    MOV();
                    break;
                case "17":
                    ADD();
                    break;
                case "18":
                    SUB();
                    break;
                case "19":
                    MUL();
                    break;
                case "1A":
                    DIV();
                    break;
                case "1B":
                    AND();
                    break;
                case "1C":
                    OR();
                    break;
                case "30":
                    MOVI();
                    break;
                case "31":
                    ADDI();
                    break;
                case "32":
                    SUBI();
                    break;
                case "33":
                    MULI();
                    break;
                case "34":
                    DIVI();
                    break;
                case "35":
                    ANDI();
                    break;
                case "36":
                    ORI();
                    break;
                case "37":
                    BZ();
                    break;
                case "38":
                    BNZ();
                    break;
                case "39":
                    BC();
                    break;
                case "3A":
                    BS();
                    break;
                case "3B":
                    JMP();
                    break;
                case "3C":
                    //CALL();
                    break;
                case "3D":
                    //ACT();
                    break;
                case "51":
                    MOVL();
                    break;
                case "52":
                    MOVS();
                    break;
                case "71":
                    SHL();
                    break;
                case "72":
                    SHR();
                    break;
                case "73":
                    RTL();
                    break;
                case "74":
                    RTR();
                    break;
                case "75":
                    INC();
                    break;
                case "76":
                    DEC();
                    break;
                case "77":
                    //PUSH();
                    break;
                case "78":
                    //POP();
                    break;
                case "F1":
                    //RETURN();
                    break;
                case "F2":
                    NOOP();
                    break;
                case "F3":
                    terminate = true;
                    break;
            }
            if (code.equals("F3"))
                break;
            SPR[10] = (short) Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(SPR[9])));
        }
        if (terminate)
            System.out.println("Process Ended because F3 was read");
        else
            System.out.println("Process Ended Because Instructions Ran Out");
    }
    
    //Copying the register contents
    //of reg2 to reg1
    public void MOV()
    {
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = Gregister[mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))];
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        
        SPR[9] += 2;
    }
    
    //Adding the value of Reg1 that PC is pointing at to Reg2 which is the next Register
    //Saving the added value into Reg1 
    //After execution, PC is incremented by 2
    public void ADD()
    {
        int reg1 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        int reg2 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))]);
        int res = reg1 + reg2;
        updateFlag(res);
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) res;
        SPR[9] += 2;
    }
    
    //Subtracting the value Reg2 which is the next Register from Reg1 that PC is pointing at  
    //Saving the subtracted value into Reg1 
    //After execution, PC is incremented by 2
    public void SUB()
    {
        int reg1 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        int reg2 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))]);
        int res = reg1 - reg2;
        updateFlag(res);
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) res;
        SPR[9] += 2;
    }
    
    //Multiplying the values of Reg1 that PC is pointing at to Reg2 which is the next Register
    //Saving the multiplied value into Reg1 
    //After execution, PC is incremented by 2
    public void MUL()
    {
        int reg1 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        int reg2 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))]);
        int res = reg1 * reg2;
        updateFlag(res);
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) res;
        SPR[9] += 2;
    }
    
    //Dividing the values of Reg1 that PC is pointing at from Reg2 which is the next Register 
    //If the values of Reg2 is not 0 then only the dividing operation can be performed
    //Saving the dividend value into Reg1 
    //After execution, PC is incremented by 2
    public void DIV()
    {
        int reg1 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        int reg2 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))]);
        int res = reg1;
        if (reg2 != 0)
            res = reg1 / reg2;
        updateFlag(res);
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) res;
        SPR[9] += 2;
    }
    
    //Logically AND the values of Reg1 that PC is pointing at and Reg2 which is the next Register
    //Saving the value into Reg1 
    //After execution, PC is incremented by 2
    public void AND()
    {
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) (Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] & Gregister[mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))]);
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        
        SPR[9] += 2;
    }
    
    //Logically OR the values of Reg1 that PC is pointing at and Reg2 which is the next Register
    //Saving the value into Reg1 
    //After execution, PC is incremented by 2
    public void OR()
    {
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) (Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] | Gregister[mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))]);
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        
        SPR[9] += 2;
    }
    
    /*
    given immediate data is moved into R1 
    After execution, PC is incremented by 3
    */
    public void MOVI()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt((short) (SPR[9]+1)))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+2))))));
        String concat = byte1 + byte2;
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short)Integer.parseInt(concat, 16);
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        
        SPR[9] += 3;
    }
    
    //Concatinating the two hexadecimal values-Concat
    //Changing the new value from Hexa to Int -Reg2
    //Adding the values in 'Reg2' to the value in Reg1 that PC is pointing at
    //Saving the added value into Res 
    //After execution, PC is incremented by 3
    public void ADDI()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+2))))));
        String concat = byte1 + byte2;
        
        int reg1 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        int reg2 = Integer.parseInt(concat, 16);
        int res = reg1 + reg2;
        updateFlag(res);
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) res;
        SPR[9] += 3;
    }
    
    //Concatinating the two hexadecimal values -Concat
    //Changing the new value from Hexa to Int-Concat -Reg2
    //Subtracting the value in 'Reg2' from the value in Reg1 that PC is pointing at
    //Saving the added value into Res
    //After execution, PC is incremented by 3
    public void SUBI()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+2))))));
        String concat = byte1 + byte2;
        
        int reg1 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        int reg2 = Integer.parseInt(concat, 16);
        int res = reg1 - reg2;
        updateFlag(res);
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) res;
        SPR[9] += 3;
    }
    
    //Concatinating the two hexadecimal values -Concat
    //Changing the new value from Hexa to Int-Concat -Reg2
    //Multiplying the value in 'Reg2' to the value in Reg1 that PC is pointing at
    //Saving the multiplied value into Res 
    //Updtating the flag with new value Res
    //After execution, PC is incremented by 3
    public void MULI()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+2))))));
        String concat = byte1 + byte2;
        
        int reg1 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        int reg2 = Integer.parseInt(concat, 16);
        int res = reg1 * reg2;
        updateFlag(res);
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) res;
        SPR[9] += 3;
    }
    
    //Concatinating the two hexadecimal values -Concat
    //Changing the new value from Hexa to Int-Concat -Reg2
    //Dividing the value in 'Reg2' from the value in Reg1 that PC is pointing at
    //Saving the dividend value into Res 
    //Updtating the flag with new value Res
    //After execution, PC is incremented by 3
    public void DIVI()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+2))))));
        String concat = byte1 + byte2;
        
        int reg1 = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        int reg2 = Integer.parseInt(concat, 16);
        int res = reg1;
        if (reg2 != 0)
            res = reg1 / reg2;
        updateFlag(res);
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) res;
        SPR[9] += 3;
    }
    
    //Concatinating the two hexadecimal values -Concat
    //Changing the new value from Hexa to Int 
    //AND the int value of concat  to the value in Register that PC is pointing at
    //Updtating the flag with new value Res
    //After execution, PC is incremented by 3
    public void ANDI()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+2))))));
        String concat = byte1 + byte2;
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) (Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] & Integer.parseInt(concat, 16));
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        
        SPR[9] += 3;
    }
    
    /*
    Bitiwise OR the given immediate data to R1
    After execution, PC is incremented by 3
    */
    public void ORI()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+2))))));
        String concat = byte1 + byte2;
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) (Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] | Integer.parseInt(concat, 16));
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        
        SPR[9] += 3;
    }
    
    /*
    It jumps to offset if Zero flag is on
    After execution, PC is incremented by 2
    */
    public void BZ()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((SPR[9]))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String concat = byte1 + byte2;
        
        int check = flag & 2;
        if (check == 2)
            SPR[9] = (short) ((short) Integer.parseInt(concat, 16) + SPR[0]);
        else
            SPR[9] += 2;
    }
    public void BNZ()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((SPR[9]))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String concat = byte1 + byte2;
        
        int check = flag & 2;
        if (check == 0)
            SPR[9] = (short) ((short) Integer.parseInt(concat, 16) + SPR[0]);
        else
            SPR[9] += 2;
    }
    public void BC()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((SPR[9]))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String concat = byte1 + byte2;
        
        int check = flag & 1;
        if (check == 1)
            SPR[9] = (short) ((short) Integer.parseInt(concat, 16) + SPR[0]);
        else
            SPR[9] += 2;
    }
    public void BS()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((SPR[9]))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String concat = byte1 + byte2;
        
        int check = flag & 4;
        if (check == 4)
            SPR[9] = (short) ((short) Integer.parseInt(concat, 16) + SPR[0]);
        else
            SPR[9] += 2;
    }
    public void JMP()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((SPR[9]))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String concat = byte1 + byte2;
        
        SPR[9] = (short) ((short) Integer.parseInt(concat, 16) + SPR[0]);
    }
    
    /*
    Load into register the bytes saved at location offset
    */
    public void MOVL()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+2))))));
        String concat = byte1 + byte2;
        int loc = Integer.parseInt(concat, 16) + SPR[0];
        
        String resByte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(loc)));
        String resByte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(loc+1)));
        String concat2 = resByte1 + resByte2;
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) Integer.parseInt(concat2, 16);
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        SPR[9] += 3;
    }
    
    /*
    Save at the location of offset the data of regidter
    */
    public void MOVS()
    {
        String byte1 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+1))))));
        String byte2 = decimalToHex(Byte.toUnsignedInt(mem.getByte(Short.toUnsignedInt(((short) (SPR[9]+2))))));
        String concat = byte1 + byte2;
        int loc = Integer.parseInt(concat, 16) + SPR[0];
        
        byte firstEight = (byte) (Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] >> 8);
        byte lastEight = (byte) Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))];
        
        mem.updateByte(loc, firstEight);
        mem.updateByte(loc+1, lastEight);
        SPR[9] += 3;
    }
    public void SHL()
    {
        int check1 = 32768 & Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        if (check1 == 32768)
            flag = (short) (flag | 1);
        else
            flag = (short) (flag & 14);
        
        int Shift = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) (Shift << 1);
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        SPR[9]++;
    }
    public void SHR()
    {
        int check1 = 32768 & Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        if (check1 == 32768)
            flag = (short) (flag | 1);
        else
            flag = (short) (flag & 14);
        
        int Shift = Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) (Shift >> 1);
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        SPR[9]++;
    }
    public void RTL()
    {
        int check1 = 32768 & Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        if (check1 == 32768)
            flag = (short) (flag | 1);
        else
            flag = (short) (flag & 14);
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) Integer.rotateLeft(Short.toUnsignedInt(mem.getByte(Short.toUnsignedInt(SPR[9]))), 1);
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        SPR[9]++;
    }
    public void RTR()
    {
        int check1 = 32768 & Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]);
        if (check1 == 32768)
            flag = (short) (flag | 1);
        else
            flag = (short) (flag & 14);
        
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))] = (short) Integer.rotateRight(Short.toUnsignedInt(mem.getByte(Short.toUnsignedInt(SPR[9]))), 1);
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        SPR[9]++;
    }
    public void INC()
    {
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]++;
        
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        SPR[9]++;
    }
    public void DEC()
    {
        Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]--;
        
        updateFlag(Short.toUnsignedInt(Gregister[mem.getByte(Short.toUnsignedInt(SPR[9]))]));
        SPR[9]++;
    }
    public void NOOP()
    {
        
    }
    public void updateFlag(int num)
    {
        if (num == 0)
            flag = (short) (flag | 2);
        else
            flag = (short) (flag & 13);
        
        if (num > 32767 && num < 65536)
            flag = (short) (flag | 4);
        else
            flag = (short) (flag & 11);
        
        if (num > 65535)
            flag = (short) (flag | 8);
        else
            flag = (short) (flag & 7);
    }
    public void printSPR()
    {
        String[] names = {"CodeBase", "CodeLimit", "CodeCounter", "DataBase", "DataLimit", "DataCounter", "StackBase", "StackCounter", "StackLimit", "ProgramCounter", "InstructionRegister"};
        System.out.println("\nInitial SPR Values:");
        for (int i = 0; i < 11; i++)
            System.out.println(names[i] + ": " + SPR[i]);
        
        String str = "\nFlag Register: \n";
        int carry, zero, sign, overflow;
        carry = flag & 1;
        zero = flag & 2;
        sign = flag & 4;
        overflow = flag & 8;
        if (carry == 1)
            str += "Carry bit = 1\n";
        else
            str += "Carry bit = 0\n";
        if (zero == 2)
            str += "Zero bit = 1\n";
        else
            str += "Zero bit = 0\n";
        if (sign == 4)
            str += "Sign bit = 1\n";
        else
            str += "Sign bit = 0\n";
        if (overflow == 8)
            str += "Overflow bit = 1";
        else
            str += "Overflow bit = 0";
        
        System.out.println(str);
    }
    public static String decimalToHex(int decimal)
    {
        int remainder;
        String hex = "";
        char[] hexChar = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        if (decimal == 0)
            return hex = "00";
        while (decimal > 0)
        {
            remainder = decimal % 16;
            if (decimal/16 == 0 && hex.equals(""))
                hex = "0" + hexChar[remainder] + hex;
            else
                hex = hexChar[remainder] + hex;
            decimal = decimal / 16;
        }
        return hex;
    }
}
