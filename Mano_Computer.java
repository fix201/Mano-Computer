//Olufisayo Joseph Ayodele
//Mano Computer Main function and constructor
/*
 * */

package manoComputer;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Mano_Computer
{	
	//Mano computer constructor	
	Mano_Computer()
	{
		//Declaration and initialization of variables
		int[] first_value = new int[10];
		String DR = new String(); 
		String[] M_AR = new String[4096];
		String[] Hex = new String[4096];
		String AC = new String();
		String PC = new String();
		String IR = new String();
		String newIR = new String();
		String NewAR = new String();
		String[] AR = new String[4096];
		int rand = 0, S = 0, E = 0;
		
		//Class Instructions
		Instructions instruction = new Instructions();
		
		//Call the random memory
		instruction.Random_Memory(Hex);
		
		//Display
		System.out.println("Register Transfer Statement" + " AC    " + "   DR   " + "   PC   " + "   AR   " + "   M[AR]   " + "   IR  "  + "   E");
		System.out.print("Initial Values are:     ");
		
		//Initializing rand function from instructions class
		rand = instruction.setRand(Hex, rand);
		
		//Initializing AC function from instructions class
		AC = instruction.setAC(Hex, AC);
		System.out.print("   " + AC);
		
		//Initializing DR and PC function from instructions class
		DR = instruction.setDR(Hex, DR);
		PC = instruction.setPC(PC);
		System.out.print("     " + PC);
		
		//Calling AR function from instructions class
		instruction.setAR(AR, M_AR, rand);
		//Calling M_AR function from instructions class
		instruction.setM_AR(Hex, M_AR, rand);
		
		//Initializing IR function from instructions class
		IR =  instruction.setIR(Hex, IR);
		System.out.print("      " + IR);
		
		//Initializing E function from instructions class
		E = instruction.setE(E);
		
		//Calling T0 function from instructions class
		instruction.tZero(AR, M_AR, PC, rand);
		
		//Calling and Initializing T1 and T2 functions from instructions class
		newIR = instruction.tOne(IR, M_AR, PC, newIR, rand);
		NewAR = instruction.tTwo(Hex, M_AR, IR, AR, NewAR, rand);
		
		//Calling the Sololution which has the T3-T6 functions from instructions class
		instruction.Solution(DR, M_AR, AC, PC, AR, IR, newIR, NewAR, rand, S, E);	
		
		//After Instruction
		//System.out.println("After Instruction          " + AC + "     " + DR + "     " + PC + "     " + AR + "     " + "Mar" + "     " + IR + "    " + E);
	}	

	public static void main(String[] args)
	{
		//Main
		Mano_Computer manoComputer = new Mano_Computer();		
	}
}





















