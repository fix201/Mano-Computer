//Olufisayo Joseph Ayodele
//Mano Computer Instruction Class
//Here we have all the instructions that goes from T0 through T6, the DR, AC, IR, TR, PC,  M_AR, AR, E and the random functions

package manoComputer;

import java.util.Random;

public class Instructions
{
	//Creating variables for the registers
	private String DR, AC, IR, TR, PC;
	private String[] M_AR, Hex, AR;
	private int E, rand;
	
	
	//Finds random values to fill the memory
	public void Random_Memory(String[] Hex)
	{
		//Creating random numbers to fill the 4096 locations of the library
		int memory[] = new int[4096];
		int memoryRand, memoryrand, MemoryRand;
		String HexRand, hexRand, Hexrand;
		Random rand = new Random();
		String[] hex = new String[4096];
		final int[] MEMORY = new int[]{2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
	
		//This loop takes care of what random memory the PC has
		for(int i = 0; i < 4096; i++)
		{
			//First random value
			memory[i] = rand.nextInt(15);
		
			//Changes the random integer memory to hexadecimal
			Hex[i] = Integer.toHexString(memory[i]);
			
			//Random hex that comes after 7
			int rnd = new Random().nextInt(MEMORY.length);
			hex[i] = Integer.toHexString(MEMORY[rnd]);
			
			
			//Random hex that comes after 7
			if (memory[i] == 7)
			{
				if(MEMORY[rnd] == 2048 || MEMORY[rnd] == 1024 || MEMORY[rnd] == 512 || MEMORY[rnd] == 256)
				{
	            	Hex[i] = 7 + hex[i];
				}
				else if(MEMORY[rnd] == 128 || MEMORY[rnd] == 64 || MEMORY[rnd] == 32 || MEMORY[rnd] == 16)
				{
					Hex[i] = 70 + hex[i];
				}
				else if(MEMORY[rnd] == 8 || MEMORY[rnd] == 4 || MEMORY[rnd] == 2 || MEMORY[rnd] == 1)
				{
					Hex[i] = 700 + hex[i];
				}
				
			}
			else
			{
				//Other three random values
				memoryRand = rand.nextInt(16);	
				memoryrand = rand.nextInt(16);
				MemoryRand = rand.nextInt(16);
				//Changes the random integer memory to hexadecimal
				HexRand = Integer.toHexString(memoryRand);
				hexRand = Integer.toHexString(memoryrand);
				Hexrand = Integer.toHexString(MemoryRand);
				
				Hex[i] = Hex[i] + HexRand + hexRand + Hexrand;
				
			}
		}
		
	}
	
	//Sets the Random number
	public int setRand(String[] Hex, int rand)
	{
		rand = new Random().nextInt(Hex.length);
		
		return rand;		
	}

	//Setters
	//Sets the memory of Address Register
	public void setM_AR(String[] Hex, String[] M_AR, int rand)
	{
		//Fill up the M[AR]
		M_AR[rand] = Hex[rand];
		int newRand = new Random().nextInt(Hex.length);
		
		System.out.print("     "+ Hex[newRand]);
	}
	
	//Sets the Data Register
	public String setDR(String[] Hex, String DR)
	{
		//Fill up the DR
		int rand = new Random().nextInt(Hex.length);
		this.DR = DR;
		DR = Hex[rand];
		System.out.print("     " + DR);
		
		return DR;
	}
	
	//Sets the Accumulator Register
	public String setAC(String[] Hex, String AC)
	{
		//Fill up the AC
		int rand = new Random().nextInt(Hex.length);
		this.AC = AC;
		AC = Hex[rand];
		
		return AC;
	}
	
	//Sets the Iinstruction Register
	public String setIR(String[] Hex, String IR)
	{
		//Fill up the IR
		int rand = new Random().nextInt(Hex.length);
		this.IR = IR;
		IR = Hex[rand];
		
		return IR;
	}
	
	//Sets the E
	public int setE(int E)
	{
		this.E = E;
		E = new Random().nextInt(2);
		System.out.print("    " + E);
		
		return E;
	}
	
	//Sets the Program Counter
	public String setPC(String PC)
	{
		//Variable declaration
		int memoryRand, memoryrand, MemoryRand;
		String HexRand, hexRand, Hexrand;
		Random rand = new Random();
		
		//Other three random values
		memoryRand = rand.nextInt(16);	
		memoryrand = rand.nextInt(16);
		MemoryRand = rand.nextInt(16);
		
		//Changes the random integer memory to hexadecimal
		HexRand = Integer.toHexString(memoryRand);
		hexRand = Integer.toHexString(memoryrand);
		Hexrand = Integer.toHexString(MemoryRand);
		
		//this.PC = PC;
		PC = HexRand + hexRand + Hexrand;
		
		
		return PC;
	}
	
	//Sets the Address Register
	public void setAR(String[] AR, String[] M_AR,  int rand)
	{
		//Variable declaration
		int i;
		
		for (i = 0; i < 4096; i++)
		{
			AR[i] = Integer.toHexString(i);
		}		
		
		//When converting to integer and back 
		if(AR[rand].length() < 3)
			System.out.print("     0" + AR[rand]);
		else
			System.out.print("     " + AR[rand]);
	}

	//Instruction for t0
	public void tZero(String []AR, String[] M_AR, String PC, int rand)
	{
		//AR gets PC
        String newAR = PC;
        String newM_AR = M_AR[rand];
        
        //Prints
        System.out.println("\nT0 AR<-PC                                            " + PC + "     " + newM_AR);
    }
    
	//Instruction for t1
    public String tOne(String IR, String[] M_AR, String PC, String newIR, int rand)
    {
        //IR gets M[AR]
        IR = M_AR[rand];
        
        //PC gets incremented
        int pc = Integer.parseInt(PC, 16);
	    pc = pc + 1;       //runs in T5
	    String newPC = Integer.toHexString(pc);
	    //prints
	    System.out.println("T1 IR<-M[AR]                                                           " + IR);
        
        //When converting to integer and back 
        if(newPC.length() < 3)
        	System.out.println("   PC<-PC + 1                                0" + newPC);
        else
        	System.out.println("   PC<-PC + 1                                " + newPC);
        
        //Saves IR in a new variable and then returns it
        newIR = IR;
        return newIR;
    }
    
    //Instruction for t2
    public String tTwo(String[] Hex, String[] M_AR,String IR, String[] AR, String NewAR, int rand)
    {
    	NewAR = M_AR[rand].substring(1);
    	System.out.println("T2 AR<-IR(0-11)                                      " + NewAR);
    	
    	return NewAR;
    }
    
    //Instruction for T3 if the first digit is indirect
    //For the in direct
    public void tThree(String[] AR, String[] M_AR, int rand)
    {
    	//AR gets M[AR]
    	AR[rand] = M_AR[rand];
    	System.out.println("T3 AR<-M[AR]                                         " + AR[rand].substring(1));
    }
    
    //Instructions for the Indirect memory
    //If the first digit is indirect, runs the following functions
    public void Indirect(String DR, String[] M_AR, String AC, String PC, String[] AR, String IR, String newIR, String NewAR, int rand)
    {
    	//Class Descriprion
    	Descriptions description = new Descriptions();
    	
    	//Calls tThree because it is indirect
    	tThree(AR, M_AR, rand);
    	
    	//runs the following instructions if the first digit of the M_AR is between 8 and E
    	switch(newIR.charAt(0))
    	{
    		case '8':
    			description.AND(DR, M_AR, AC, rand);
    			break;
    		case '9':
    			description.ADD(DR, M_AR, AC, rand);
    			break;
    		case 'a':
    			description.LDA(DR, M_AR, AC, rand);
    			break;
    		case 'b':
    			description.STA(M_AR, AC, rand);
    			break;
    		case 'c':
    			description.BUN(PC, AR, NewAR, rand);
    			break;
    		case 'd':
    			description.BSA(M_AR, PC, AR, NewAR, rand);
    			break;
    		case 'e':
    			description.ISZ(DR, M_AR, rand);
    			break;
    	}
    }
    
    //Instructions for indirect memory
    //If the first direct runs the following functions
    public void Direct(String DR, String[] M_AR, String AC, String PC, String[] AR, String IR, String newIR, String NewAR, int rand)
    {
    	//Class Description
    	Descriptions description = new Descriptions();
    	
    	//runs the following instructions if the first digit of the M_AR is between 0 and 6
    	switch(newIR.charAt(0))
    	{
    		case '0':
    			description.AND(DR, M_AR, AC, rand);    			
    			break;
    		case '1':
    			description.ADD(DR, M_AR, AC, rand);    			
    			break;
    		case '2':
    			description.LDA(DR, M_AR, AC, rand);
    			break;
    		case '3':
    			description.STA(M_AR, AC, rand);
    			break;
    		case '4':
    			description.BUN(PC, AR, NewAR, rand);
    			break;
    		case '5':
    			description.BSA(M_AR, PC, AR, NewAR, rand);
    			break;
    		case '6':
    			description.ISZ(DR, M_AR, rand);
    			break;
    	}
    }
    
    //Instructions for registrers that start with seven  
    //If the first digit is a 7, it runs the following instructions
    public void Sevens(String DR, String[] M_AR, String AC, String PC, String[] AR, int rand, int S, int E)
    {
    	//Class Description
    	Descriptions description = new Descriptions();
    	
    	//Calls tThree 
    	tThree(AR, M_AR, rand);
    	
    	switch(M_AR[rand])
    	{
    		case "7800":
    			description.CLA(AC);
    			break;
    		case "7400":
    			description.CLE(E);
    			break;
    		case "7200":
    			description.CMS(AC);
    			break;
    		case "7100":
    			description.CME(E);
    			break;
    		case "7080":
    			description.CIR(AC, E);
    			break;
    		case "7040":
    			description.CIL(AC, E);
    			break;
    		case "7020":
    			description.INC(AC);
    			break;
    		case "7010":
    			description.SPA(AC, PC);
    			break;
    		case "7008":
    			description.SNA(AC, PC);
    			break;
    		case "7004":
    			description.SZA(AC, PC);
    			break;
    		case "7002":
    			description.SZE(E, PC);
    			break;
    		case "7001":
    			description.HLT(S);
    			break;
    	}
    }
    
    //A function that solves T3 through T6
    public void Solution(String DR, String[] M_AR, String AC, String PC, String[] AR, String IR, String newIR, String NewAR, int rand, int S, int E)
    {   	
    	//Determines the instruction to run, whether direct or indirect based on the first digit
    	//If the first character is a number from 0 to 6, it means direct so the direct function is called
    	if(newIR.charAt(0) >= '0' && newIR.charAt(0) <= '6')
    	{
    		Direct(DR, M_AR, AC, PC, AR, IR, newIR, NewAR, rand);
    	}
    	//If the first character starts with 7, the seven function is called
    	else if(newIR.charAt(0) == '7')
    	{
    		Sevens(DR, M_AR, AC, PC, AR, rand, S, E);
    	}
    	//If the first character is from 8 to e, it means indirect so the indirect function is called
    	else
    	{
    		Indirect(DR, M_AR, AC, PC, AR, IR, newIR, NewAR, rand);
    	}
    }

}

























