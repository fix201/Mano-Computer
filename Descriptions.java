//Olufisayo Joseph Ayodele
//Mano Computer Description Class
/**
 * This class holds the functions for the descriptions 
 * To work the T3-T6, you need these instructions, they would be later sorted in the Instructions class
 * 
 */

package manoComputer;

import java.awt.*;
import javax.swing.*;

public class Descriptions 
{	
	//AND: And memory word to AC
	public void AND(String DR, String[] M_AR, String AC, int rand)
	{
	    //AR gets M[AR](0-11)
		DR = M_AR[rand];  //runs in T4 
		
		//Converts to an integer so it would be easy to add
		int ac = Integer.parseInt(AC, 16);
		int dr = Integer.parseInt(DR, 16);
	    ac = ac + dr;       //runs in T5
	    
	    //later convert the added integer back to hexadecimal to be displayed
	    String newAC = Integer.toHexString(ac);
	    
	    //If the new string is an overflow, remove overflow
	    if(newAC.length() > 4)
	    {
	    	String overflow = newAC.substring(1);
		    //print it out
			System.out.println("T4 DR<-M[AR]                        " + DR);
			System.out.println("T5 AC<-AC + DR             " + overflow);
	    }
		else
		{
			//print it out
			System.out.println("T4 DR<-M[AR]                        " + DR);
			System.out.println("T5 AC<-AC + DR             " + newAC);
		}
	}
	
	//ADD: Add memory to AC
	public void ADD(String DR, String[] M_AR, String AC, int rand)
	{
		//DR gets M[AR]
		DR = M_AR[rand];    //runs in T4
		
		//Converts to an integer so it would be easy to add
		int ac = Integer.parseInt(AC, 16);
		int dr = Integer.parseInt(DR, 16);
	    ac = ac + dr;       //runs in T5
	    
	    //later convert the added integer back to hexadecimal to be displayed
	    String newAC = Integer.toHexString(ac);
	    
	    //If the new string is an overflow, remove overflow
	    if(newAC.length() > 4)
	    {
	    	String overflow = newAC.substring(1);
		    //print it out
			System.out.println("T4 DR<-M[AR]                        " + DR);
			System.out.println("T5 AC<-AC + DR             " + overflow);
	    }
		else
		{
			//print it out
			System.out.println("T4 DR<-M[AR]                        " + DR);
			System.out.println("T5 AC<-AC + DR             " + newAC);
		}
	}
	
	//LDA: Load memory word to AC
	public void LDA(String DR, String[] M_AR, String AC, int rand)
	{
		//DR gets M[AR]
		DR = M_AR[rand];	// runs in T4
		AC = DR;    		// runs in T5
		
		//I make a new string because Strings in Java are typically immutable
	    String newAC = DR;
	    
	    //print it out
		System.out.println("T4 DR<-M[AR]                        " + DR);
		System.out.println("T5 AC<-DR                  " + newAC);
	}
	
	//STA: Store content of AC in memory
	public void STA(String[] M_AR, String AC, int rand)
	{
		//M[AR] gets AC
		M_AR[rand] = AC;  // runs in T4
		
		//Print it out
		System.out.println("T4 M[AR]<-AC                                                 " + AC);
	}
	
	//BUN: Branch Unconditionally
	public void BUN(String PC, String[] AR, String NewAR, int rand)
	{
		//I make a new string because Strings in Java are typically immutable
		String newPC = AR[rand];    //runs in T4
		
		//Print it out
		System.out.println("T4 PC<-AR                                    " + NewAR);
	}
	
	//BSA: Branch and save return address
	public void BSA(String[] M_AR, String PC, String[] AR, String NewAR, int rand)
	{
		//M[AR] gets PC
		M_AR[rand] = PC;
		
		//Create a new integer so addition is easy
		int ar = Integer.parseInt(NewAR, 16);
		ar = ar + 1;       //runs in T5
		
		//I make a new string because Strings in Java are typically immutable
	    String newAR = Integer.toHexString(ar);

	    //Create a new integer so addition is easy
		int pc = Integer.parseInt(PC, 16);
	    pc = pc + 1;       //runs in T5
	    
	    //I make a new string because Strings in Java are typically immutable
	    String newPC = Integer.toHexString(pc);
	    
	    if(newPC.length() < 4)
	    {
	    	//Print it out
			System.out.println("T4 M[AR]<-PC                                                 0" + newPC);
	    }
	    else
	    {
	    	//Print it out
			System.out.println("T4 M[AR]<-PC                                                  " + newPC);
	    }
	    
	    //Print it out
		System.out.println("   AR<-AR + 1                                        " + newAR);
		System.out.println("T5 PC<-AR                                    " + newAR);
	}
	
	//ISZ: Increment and skip if zero
	public void ISZ(String DR, String[] M_AR, int rand)
	{
		//Stuff
		String newDR = M_AR[rand];    //runs in T4
		System.out.println("T4 DR<-M[AR]                        " + newDR);
		
		//Converts to an integer so it would be easy to add
		int dr = Integer.parseInt(newDR, 16);
	    dr = dr + 1;       //runs in T5
	    
	    //you know the drill
	    String newDR2 = Integer.toHexString(dr);	    
	   
	    //If the new string is an overflow, remove overflow
	    if(newDR2.length() > 4)
	    {
	    	String overflow = newDR2.substring(1);
		    //print it out
			System.out.println("T5 DR<-DR + 1                     " + overflow);
	    }
		else
		{
			//print it out
			System.out.println("T5 DR<-DR + 1                     " + newDR2);
		}

	}
	   
	//CLA: Clear AC
	public void CLA(String AC)
	{
		//AC is cleared
		AC = "0000";	
		
		//Print it out
		System.out.println("T4 AC<-0   " + AC);
	}
	
	//CLE: Clear E
	public void CLE(int E)
	{
		//E is cleared
		E = 0;
		
		//Print it out
		System.out.println("T4 E<-0                        " + E);
	}
	
	//CMS: or CMA, Compliment AC
	public void CMS(String AC)
	{
		//AC compliment
		int ac = Integer.parseInt(AC, 16);
	    ac = ac - 1;       //runs in T5
	    String newAC = Integer.toHexString(ac);
	    
	    //Print it out
	 	System.out.println("T4 AC<-AC'                " + newAC);
	}
	
	//CME: Compliment E
	public void CME(int E)
	{
		//Easiest way to find the E's compliment
		if(E == 0){
	       E = 1;
		}
		else if(E == 1){
			E = 0;
		}
		
		//Print it out
		System.out.println("T4 E<-E'                        " + E);
	}
	
	//CIR: Circulate right AC and E
	public void CIR(String AC, int E)
	{
		//Print it out
		System.out.println("T4 AC<-0   0000");
	}
	
	//CIL: Circulate left AC and E
	public void CIL(String AC, int E)
	{
		//Print it out
		System.out.println("T4 E<-0                                                           0");
	}
	
	//INC: Increment AC
	public void INC(String AC)
	{
		//Convert AC to an integer first
		int ac = Integer.parseInt(AC, 16);
		//Increment it
	    ac = ac + 1;       //runs in T5
	    //And convert it back to a HexString
	    String newAC = Integer.toHexString(ac);
	    
	    //If the new string is an overflow, remove overflow
	    if(newAC.length() > 4)
	    {
	    	String overflow = newAC.substring(1);
	    	//Print it out
			System.out.println("T4 AC<-AC + 1     " + overflow);
	    }
		else
		{
			//Print it out
			System.out.println("T4 AC<-AC + 1     " + newAC);
		}
	    
	    
	}
	
	//SPA: Skip next instruction if AC is positive
	public void SPA(String AC, String PC)
	{
		//Convert AC to an integer first
		int pc = Integer.parseInt(PC, 16);
		String newPC = new String();
		
		//AC(15)
		if(AC.charAt(0) == '0')
		{
			//Increment it
		    pc = pc + 2;       //runs in T5
		    //And convert it back to a HexString
		    newPC = Integer.toHexString(pc);
		}
		
		//If the new string is an overflow, remove overflow
	    if(newPC.length() > 4)
	    {
	    	String overflow = newPC.substring(1);
	    	//print out PC gets PC + 1
		    System.out.println("T5 PC<-PC + 1                                " + overflow);
	    }
		else
		{
			//print out PC gets PC + 1
		    System.out.println("T5 PC<-PC + 1                                " + newPC);
		}
		
			
	}
		
	//SNA: Skip the next instruction if AC is negative
	public void SNA(String AC, String PC)
	{
		//Convert AC to an integer first
		int pc = Integer.parseInt(PC, 16);
		String newPC = new String();
		
		//AC(15)
		if(AC.charAt(0) == '1')
		{
			//Increment it
		    pc = pc + 2;       //runs in T5
		    //And convert it back to a HexString
		    newPC = Integer.toHexString(pc);
		}
		
		///If the new string is an overflow, remove overflow
	    if(newPC.length() > 4)
	    {
	    	String overflow = newPC.substring(1);
	    	//print out PC gets PC + 1
		    System.out.println("T5 PC<-PC + 1                                " + overflow);
	    }
		else
		{
			//print out PC gets PC + 1
		    System.out.println("T5 PC<-PC + 1                                " + newPC);
		}
	}

	//SZA: Skip the next instruction if AC is zero
	public void SZA(String AC, String PC)
	{
		//Convert AC to an integer first
		int pc = Integer.parseInt(PC, 16);
		String newPC = new String();
		
		//Convert to an Integer then
		if(Integer.parseInt(AC) == 0)
		{
			//Increment it
		    pc = pc + 2;       //runs in T5
		    //And convert it back to a HexString
		    newPC = Integer.toHexString(pc);
		}
		
		//If the new string is an overflow, remove overflow
	    if(newPC.length() > 4)
	    {
	    	String overflow = newPC.substring(1);
	    	//print out PC gets PC + 1
		    System.out.println("T5 PC<-PC + 1                                " + overflow);
	    }
		else
		{
			//print out PC gets PC + 1
		    System.out.println("T5 PC<-PC + 1                                " + newPC);
		}
	}
	
	//SZE: Skip the next instruction if E is 0
	public void SZE(int E, String PC)
	{
		//Convert AC to an integer first
		int pc = Integer.parseInt(PC, 16);
		String newPC = new String();
		
		if(E == 0)
		{
			//Increment it
		    pc = pc + 2;       //runs in T5
		    //And convert it back to a HexString
		    newPC = Integer.toHexString(pc);
		}
		
		//If the new string is an overflow, remove overflow
	    if(newPC.length() > 4)
	    {
	    	String overflow = newPC.substring(1);
	    	//print out PC gets PC + 1
		    System.out.println("T5 PC<-PC + 1                                " + overflow);
	    }
		else
		{
			//print out PC gets PC + 1
		    System.out.println("T5 PC<-PC + 1                                " + newPC);
		}
	}
	
	//Halt Computer
	public void HLT(int S)
	{
		S = 0;
	}

}
