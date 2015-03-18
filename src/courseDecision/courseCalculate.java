/********************************************************
 * This class is the courseCalculate class of courseDecision that
 * contains the majority of the AI functions that take in the 
 * the user's responses as parameters and asks a few more questions
 * based off of user's responses to make a final decision on best
 * suited major.
 * 
 * @author - Kyle Siler 
 * @version 1.0 - 4/23/2013
 ********************************************************/
/*******************************************************
 *	References and Acknowledgments: I received no outside help with this
 *	programming assignment
 ********************************************************/

package courseDecision;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class courseCalculate {
	
	//creates a new courseDriver object that runs the GUI part of the program to interact with AI decisions
	static courseDriver courseMain = new courseDriver();
	//creates a new courseMajorsDatabase object that contains all of the possible majors the AI can recommend to the user
	static courseMajorsDatabase majorData = new courseMajorsDatabase();
	
	//Boolean flags used to indicate if user is unsatisfied with the major the AI has recommened and if re-evaluation is needed.  True if satisifed with decision.
	static boolean newCSCIDecision = false;							
	static boolean newCISDecision = false;
	static boolean newPaintDrawDecision = false;
	static boolean newPhotographyDecision = false;
	static boolean newTeachArtDecision = false;
	static boolean newGraphicDesignDecision = false;
	static boolean newBusDecision = false;
	static boolean newEconDecision = false;
	static boolean newAccountingDecision = false;
	static boolean newEconomicsIcon = false;

	/* This method is of void type and does not return anything
	 * This method will consider what choice the user has made in the GUI in regards to their interest in computers and whether
	 * they should do hardware in ISM or software in CIS
	 * @param:  int of the decision the user has made, string of the user's name
	 */
	public static void calculateTechnical(int decision, String name) throws URISyntaxException
	{
		newCSCIDecision = false;									//flag used to indicate user does not want to do CSCI major and re-evaluation is needed
		newCISDecision = false;										//flag used to indicate user does not want to do CIS major and re-evaluation is needed
		
		//check to see if the user has decided they want to do stuff with software
		if (decision == 1)
		{
			//GUI confirm dialog box that asks the user if they are willing to do what the computer science field requires to see if it is a good match for them
			int confirmDialog = JOptionPane.showConfirmDialog(
				    null,
				    "                                 You are doing great " + name + "!\n"
				    + "                               Let me ask you one more thing.\n"
				    + "               Could you sit and write code for a long period of time,\n " 
				    + "debug code for a long period of time, write logic and solve algorithms\n " 
				    + "and problems while being able to transfter them to the computer?",
				    "Making a decision.....",
				    JOptionPane.YES_NO_OPTION);
			
			//check to see if the user chose "yes" and is happy with CSCI and wants to pursue that field of study
			if (confirmDialog == 0)
				courseMajorsDatabase.csciResult();
			
			//user is unsatisfied with CSCI and wants to switch major
			else
			{
				newCSCIDecision = true;								//switch flag to indicate that user wants a new major 
				courseDriver.techPrompt(name);						//switch back to main driver and call the techPrompt method to ask the user if they want to do CIS instead
			}
		}
		
		
		//check to see if the user has decided they want to do stuff with hardware
		else if (decision == 2)
		{
			//GUI confirm dialog box that asks the user if they are willing to do what the computer info systems field requires to see if it is a good match for them
			int confirmDialog = JOptionPane.showConfirmDialog(
				    null,
				    "                                 You are doing great " + name + "!\n"
				    + "                               Let me ask you one more thing.\n"
				    + "               Could you work with hardware such as servers, computers and networks,\n " 
				    + "while also working in a business environment interacting with customers and team members\n " 
				    + "to maintain business computer systems and troubleshoot/repair them when something goes wrong?",
				    "Making a decision.....",
				    JOptionPane.YES_NO_OPTION);
			
			//check to see if the user chose "yes" and is happy with CIS and wants to pursue that field of study
			if (confirmDialog == 0)
				courseMajorsDatabase.cisResult();					//method call to recommend CIS as major program best suited to user based on their choices
			
			//user is unsatisfied with CIS and wants to switch major
			else
			{
				newCISDecision = true;								//switch flag to indicate that user wants a new major
				courseDriver.techPrompt(name);						//switch back to main driver and call the techPrompt method to ask the user if they want to do CSCI instead
			}
		}
	}
	
	/* This method is of void type and does not return anything
	 * This method will consider what choice the user has made in the GUI in regards to their interest in art and whether
	 * they should do Painting/Drawing, Photography, Art Education, or Graphic Design
	 * @param:  int of the decision the user has made, string of the user's name
	 */
	public static void calculateArt(int decision, String name) throws URISyntaxException
	{
		newPaintDrawDecision = false;								//flag used to indicate user does not want to do Painting/Drawing major and re-evaluation is needed
		newPhotographyDecision = false;								//flag used to indicate user does not want to do Photography major and re-evaluation is needed
		newTeachArtDecision = false;								//flag used to indicate user does not want to do Art Education major and re-evaluation is needed
		newGraphicDesignDecision = false;							//flag used to indicate user does not want to do Graphic Design major and re-evaluation is needed
	
		//check to see if the user wants to do Painting/Drawing
		if (decision == 1)
		{
			//GUI confirm dialog box that asks the user if they are willing to do what the Painting/Drawing field requires to see if it is a good match for them
			int confirmDialog = JOptionPane.showConfirmDialog(
				    null,
				    "                                                                         You are doing great " + name + "!\n"
				    + "                                                             Let me ask you a few more things.\n"
				    + "                    Could you work with a series of colors and choose the right colors to represent your scene\n" 
				    + " and understand how each color affects your scene " 
				    + "while also being able to sit for as long as it takes to draw your scene\n"
				    + "                          and capture the moment down on paper with a variety of tools including pens and paint\n " 
				    + "               even if you were soley tasked with making a still life of objects or portraits of people.",
				    "Making a decision.....",
				    JOptionPane.YES_NO_OPTION);
			
			//check to see if the user chose "yes" and is happy with Painting/Drawing and wants to pursue that field of study
			if (confirmDialog == 0)
				courseMajorsDatabase.paintDrawResult();				//method call to recommend CIS as major program best suited to user based on their choices
			
			//the user wants a different major than Painting/Drawing
			else
			{
				newPaintDrawDecision = true;						//switch flag to indicate that user wants a new major
				courseDriver.artPrompt(name);						//switch back to main driver and call the artPrompt method to ask the user if they want to do Graphic Design, Photography, or Art Education instead
			}
		}
	
		//check to see if the user wants to do Photography
		else if (decision == 2)
		{
			//GUI confirm dialog box that asks the user if they are willing to do what the Photography field requires to see if it is a good match for them
			int confirmDialog = JOptionPane.showConfirmDialog(
				    null,
				    "                                                                         You are doing great " + name + "!\n"
				    + "                                                             Let me ask you a few more things.\n"
				    + "                    Could you work with high tech cameras to take stunning pictures while also considering \n " 
				    + "factors that can affect the quality of your picture such as setting, lighting, shadows, blur, and etc. \n " 
				    + "in addition to using software such as Adobe Photoshop to edit your pictures and correct issues such as those mentioned above?",
				    "Making a decision.....",
				    JOptionPane.YES_NO_OPTION);
			
			//check to see if the user chose "yes" and is happy with Photography and wants to pursue that field of study
			if (confirmDialog == 0)
				courseMajorsDatabase.photographyResult();			//method call to recommend Photography as major program best suited to user based on their choices
			
			//the user wants a different major than Photography
			else
			{
				newPhotographyDecision = true;						//switch flag to indicate that user wants a new major
				courseDriver.artPrompt(name);						//switch back to main driver and call the artPrompt method to ask the user if they want to do Graphic Design, Photography, or Art Education instead
			}
		}
		
		//check to see if the user wants to do Art Education
		else if (decision == 3)
		{
			//GUI confirm dialog box that asks the user if they are willing to do what the Art Education field requires to see if it is a good match for them
			int confirmDialog = JOptionPane.showConfirmDialog(
				    null,
				    "                                                                         You are doing great " + name + "!\n"
				    + "                                                             Let me ask you a few more things.\n"
				    + "                    It seems that you would rather teach art then be on the frontlines and create art yourself.  So are you a\n " 
				    + "self-directed individual who wants to create their own art-related courses of study and are willing to pursue a master's degree \n " 
				    + "in education with a background in art to instruct individuals with artistic talent how to turn their talent into a profession?",
				    "Making a decision.....",
				    JOptionPane.YES_NO_OPTION);
			
			//check to see if the user chose "yes" and is happy with Art Education and wants to pursue that field of study
			if (confirmDialog == 0)
				courseMajorsDatabase.teachArtResult();				//method call to recommend Art Education as major program best suited to user based on their choices
			
			//the user wants a different major than Art Education
			else
			{
				newTeachArtDecision = true;							//switch flag to indicate that user wants a new major
				courseDriver.artPrompt(name);						//switch back to main driver and call the artPrompt method to ask the user if they want to do Graphic Design, Painting/Drawing, or Art Education instead
			}
		}
		
		//check to see if the user wants to do Graphic Design
		else if (decision == 4)
		{
			//GUI confirm dialog box that asks the user if they are willing to do what the Graphic Design field requires to see if it is a good match for them
			int confirmDialog = JOptionPane.showConfirmDialog(
				    null,
				    "                                                                         You are doing great " + name + "!\n"
				    + "                                                             Let me ask you a few more things.\n"
				    + "                                             Could you create visual representations for clients that require\n " 
				    + "your design services, in addition to using the computer to create art that portray the client's message visually that can be included\n " 
				    + "in magazines, books, packaging, public announcements, and etc.?",
				    "Making a decision.....",
				    JOptionPane.YES_NO_OPTION);
			
			//check to see if the user chose "yes" and is happy with Graphic Design and wants to pursue that field of study
			if (confirmDialog == 0)
				courseMajorsDatabase.graphicDesignResult();			//method call to recommend Graphic Design as major program best suited to user based on their choices
			
			//the user wants a different major than Graphic Design
			else
			{
				newGraphicDesignDecision = true;					//switch flag to indicate that user wants a new major
				courseDriver.artPrompt(name);						//switch back to main driver and call the artPrompt method to ask the user if they want to do Photography, Painting/Drawing, or Art Education instead
			}
		}
	}

	/* This method is of void type and does not return anything
	 * This method will consider what choice the user has made in the GUI in regards to their interest in business and whether
	 * they should do Painting/Drawing, Photography, Art Education, or Graphic Design
	 * @param:  int of the decision the user has made, string of the user's name
	 */
	public static void calculateBusiness(int decision, String name) throws URISyntaxException
	{
		newBusDecision = false;										//flag used to indicate user does not want to do Business Management major and re-evaluation is needed
		newEconDecision = false;									//flag used to indicate user does not want to do Economics major and re-evaluation is needed
		newAccountingDecision = false;								//flag used to indicate user does not want to do Accounting major and re-evaluation is needed
		newGraphicDesignDecision = false;							//flag used to indicate user does not want to do Graphic Design major and re-evaluation is needed
	
		//check to see if the user wants to do Business Management
		if (decision == 1)
		{
			//GUI confirm dialog box that asks the user if they are willing to do what the Business Management field requires to see if it is a good match for them
			int confirmDialog = JOptionPane.showConfirmDialog(
				    null,
				    "                                                                         You are doing great " + name + "!\n"
				    + "                                                             Let me ask you a few more things.\n"
				    + "                    Could you work in an organization to plan, organize, direct, and control the functions and processes\n" 
				    + " of the organization with the potential of working in human resources to hire new people, working in marketing to further\n"
				    + " advertise for the company you are working for, and being able to sit at a desk or head a team of small people?\n",
				    "Making a decision.....",
				    JOptionPane.YES_NO_OPTION);
			
			//check to see if the user chose "yes" and is happy with Business Management and wants to pursue that field of study
			if (confirmDialog == 0)
				courseMajorsDatabase.businessResult();				//method call to recommend Business Management as major program best suited to user based on their choices
			
			//the user wants a different major than Business Management
			else
			{
				newBusDecision = true;								//switch flag to indicate that user wants a new major
				courseDriver.businessPrompt(name);					//switch back to main driver and call the artPrompt method to ask the user if they want to do Accounting or Economics instead
			}
		}
	
		//check to see if the user wants to do Economics
		else if (decision == 2)
		{
			//GUI confirm dialog box that asks the user if they are willing to do what the Economics field requires to see if it is a good match for them
			int confirmDialog = JOptionPane.showConfirmDialog(
				    null,
				    "                                                                         You are doing great " + name + "!\n"
				    + "                                                             Let me ask you a few more things.\n"
				    + "                    Could you study how society uses resources to produce goods and services, analyze the costs and benefits of\n " 
				    + "consuming goods and resources, and predict future economic conditions such as predicting stocks or economic depressions  as well as \n " 
				    + "evaluate and create new economic policies that can aid the economy in money usage and production?",
				    "Making a decision.....",
				    JOptionPane.YES_NO_OPTION);
			
			//check to see if the user chose "yes" and is happy with Economics and wants to pursue that field of study
			if (confirmDialog == 0)
				courseMajorsDatabase.economicsResult();				//method call to recommend Economics as major program best suited to user based on their choices
			
			//the user wants a different major than Economics
			else
			{
				newEconDecision = true;								//switch flag to indicate that user wants a new major
				courseDriver.businessPrompt(name);					//switch back to main driver and call the businessPrompt method to ask the user if they want to do Business Management or Accounting instead
			}
		}
		
		//check to see if the user wants to do Accounting
		else if (decision == 3)
		{
			//GUI confirm dialog box that asks the user if they are willing to do what the Accounting field requires to see if it is a good match for them
			int confirmDialog = JOptionPane.showConfirmDialog(
				    null,
				    "                                                                         You are doing great " + name + "!\n"
				    + "                                                             Let me ask you a few more things.\n"
				    + "                    It seems that you enjoy handling money and could manage money effectively and efficiently.  People that handle money\n " 
				    + "for a business will also need to process the taxes of a business and plan and consult financial accounts of business for effective budget control\n " 
				    + "as well as prepare and analyze financial records.  Do this sound of interest to you?",
				    "Making a decision.....",
				    JOptionPane.YES_NO_OPTION);
			
			//check to see if the user chose "yes" and is happy with Accounting and wants to pursue that field of study
			if (confirmDialog == 0)
				courseMajorsDatabase.accountingResult();			//method call to recommend Accounting as major program best suited to user based on their choices
			
			//the user wants a different major than Accounting
			else
			{
				newAccountingDecision = true;						//switch flag to indicate that user wants a new major
				courseDriver.businessPrompt(name);					//switch back to main driver and call the businessPrompt method to ask the user if they want to do Business Management or Accounting instead
			}
		}
	}
}