/********************************************************
 * This class is the courseMajors class of courseDecision
 * that contains methods to display a message dialog GUI box
 * that displays what major the AI has chosen and then ends
 * the program.
 * 
 * @author - Kyle Siler 
 * @version 1.0 - 4/23/2013
 ********************************************************/
/*******************************************************
 *	References and Acknowledgments: I received no outside help with this
 *	programming assignment
 ********************************************************/

package courseDecision;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class courseMajorsDatabase {
	
	//creates a new courseDriver object that runs the GUI part of the program to interact with AI decisions
	static courseDriver courseMain = new courseDriver();

	/* This method is of void type and does not return anything
	 * This method will display a picture and description of the CSCI major that is chosen using a GUI
	 * message Dialog box.  When the user clicks "OK" to close the dialog box, the default web browser
	 * of the computer will open a web page that will take the user to a website with information on their
	 * selected major and then cease running the program.
	 * @param:  None
	 */
	public static void csciResult() throws URISyntaxException
	{
		//GUI message dialog box that displays picture and description of the CSCI major the AI has chosen
		JOptionPane.showMessageDialog(null,
				"Based on your responses to the questions I have asked you, I think you should major in:  \n"
						+ "                                           COMPUTER SCIENCE (CSCI)\n"
						+ "Upon clicking 'OK' the program will close and a browser window will open and take\n"
						+ "you to a site that will show information pertaining to your major match.",
						"****Computer Science Major****",
						JOptionPane.INFORMATION_MESSAGE,
						courseDriver.csciIcon);
		courseDriver.aiRunning = false;   							//switch flag to stop the program

		//open default desktop browser to display web page with information on major career path AI has selected
		URI url = new URI("http://www.bls.gov/ooh/computer-and-information-technology/computer-programmers.htm");
		try {
			Desktop.getDesktop().browse(url);
		} catch (IOException e) {
			// catch block
			e.printStackTrace();
		}
	}

	/* This method is of void type and does not return anything
	 * This method will display a picture and description of the ISM major that is chosen using a GUI
	 * message Dialog box. When the user clicks "OK" to close the dialog box, the default web browser
	 * of the computer will open a web page that will take the user to a website with information on their
	 * selected major and then cease running the program.
	 * @param:  None
	 */
	public static void cisResult() throws URISyntaxException
	{
		//GUI message dialog box that displays picture and description of the ISM major the AI has chosen
		JOptionPane.showMessageDialog(null,
				"Based on your responses to the questions I have asked you, I think you should major in:  \n"
						+ "Information Systems Management (ISM)/Computer Information Systems (CIS)\n"
						+ "Upon clicking 'OK' the program will close and a browser window will open and take\n"
						+ "you to a site that will show information pertaining to your major match.",
						"****Information Systems Major****",
						JOptionPane.INFORMATION_MESSAGE,
						courseDriver.cisIcon);	
		courseDriver.aiRunning = false;   							//switch flag to stop the program

		//open default desktop browser to display web page with information on major career path AI has selected
		URI url = new URI("http://www.bls.gov/ooh/computer-and-information-technology/network-and-computer-systems-administrators.htm");
		try {
			Desktop.getDesktop().browse(url);
		} catch (IOException e) {
			// catch block
			e.printStackTrace();
		}
	}

	/* This method is of void type and does not return anything
	 * This method will display a picture and description of the Painting/Drawing major that is chosen using a GUI
	 * message Dialog box. When the user clicks "OK" to close the dialog box, the default web browser
	 * of the computer will open a web page that will take the user to a website with information on their
	 * selected major and then cease running the program.
	 * @param:  None
	 */
	public static void paintDrawResult() throws URISyntaxException
	{
		//GUI message dialog box that displays picture and description of the Painting/Drawing major the AI has chosen
		JOptionPane.showMessageDialog(null,
				"Based on your responses to the questions I have asked you, I think you should major in:  \n"
						+ "Painting or Drawing.  You said you like to work with tools such as pens and paint to \n" 
						+ "represent your ideas and the world as you see it on paper.  I think this major would be a perfect fit for you!\n"
						+ "Upon clicking 'OK' the program will close and a browser window will open and take\n"
						+ "you to a site that will show information pertaining to your major match.",
						"****Painting/Drawing Major****",
						JOptionPane.INFORMATION_MESSAGE,
						courseDriver.paintDrawIcon);	
		courseDriver.aiRunning = false;   							//switch flag to stop the program

		//open default desktop browser to display web page with information on major career path AI has selected
		URI url = new URI("http://www.bls.gov/ooh/arts-and-design/craft-and-fine-artists.htm");
		try {
			Desktop.getDesktop().browse(url);
		} catch (IOException e) {
			// catch block
			e.printStackTrace();
		}
	}

	/* This method is of void type and does not return anything
	 * This method will display a picture and description of the Graphic Design major that is chosen using a GUI
	 * message Dialog box.  When the user clicks "OK" to close the dialog box, the default web browser
	 * of the computer will open a web page that will take the user to a website with information on their
	 * selected major and then cease running the program.
	 * @param:  None
	 */
	public static void graphicDesignResult() throws URISyntaxException
	{
		//GUI message dialog box that displays picture and description of the Graphic Design major the AI has chosen
		JOptionPane.showMessageDialog(null,
				"Based on your responses to the questions I have asked you, I think you should major in:  \n"
						+ "Graphic Design!  You said you like to work with the computer to transform you art into visual \n" 
						+ "presentations and representations for the whole world to see.  You may also not want to paint or draw with hand tools \n"
						+ "and want to use the computer instead.  I think using art and computers is the best fit for you.\n"
						+ "Upon clicking 'OK' the program will close and a browser window will open and take\n"
						+ "you to a site that will show information pertaining to your major match.",
						"****Graphic Design Major****",
						JOptionPane.INFORMATION_MESSAGE,
						courseDriver.graphicDesignIcon);	
		courseDriver.aiRunning = false;   							//switch flag to stop the program

		//open default desktop browser to display web page with information on major career path AI has selected
		URI url = new URI("http://www.bls.gov/ooh/arts-and-design/graphic-designers.htm");
		try {
			Desktop.getDesktop().browse(url);
		} catch (IOException e) {
			// catch block
			e.printStackTrace();
		}
	}

	/* This method is of void type and does not return anything
	 * This method will display a picture and description of the Art Education major that is chosen using a GUI
	 * message Dialog box.  When the user clicks "OK" to close the dialog box, the default web browser
	 * of the computer will open a web page that will take the user to a website with information on their
	 * selected major and then cease running the program.
	 * @param:  None
	 */
	public static void teachArtResult() throws URISyntaxException
	{
		//GUI message dialog box that displays picture and description of the Art Education major the AI has chosen
		JOptionPane.showMessageDialog(null,
				"Based on your responses to the questions I have asked you, I think you should major in:  \n"
						+ "Teaching Art!  You said you like to teach art rather than always make your own art even though you may have to \n" 
						+ "create your own works at times.  Your artistic talent shines more in teaching people how to bring out their artistic talent \n"
						+ "rather than putting you ideas on paper or using the computer for graphic design.\n"
						+ "I think teaching art is the best fit for you.\n"
						+ "Upon clicking 'OK' the program will close and a browser window will open and take\n"
						+ "you to a site that will show information pertaining to your major match.",
						"****Art Education Major****",
						JOptionPane.INFORMATION_MESSAGE,
						courseDriver.teachArtIcon);	
		courseDriver.aiRunning = false;   							//switch flag to stop the program

		//open default desktop browser to display web page with information on major career path AI has selected
		URI url = new URI("http://www.payscale.com/career-news/2007/07/name-kelly-tm-k");
		try {
			Desktop.getDesktop().browse(url);
		} catch (IOException e) {
			// catch block
			e.printStackTrace();
		}
	}

	/* This method is of void type and does not return anything
	 * This method will display a picture and description of the Photography major that is chosen using a GUI
	 * message Dialog box.  When the user clicks "OK" to close the dialog box, the default web browser
	 * of the computer will open a web page that will take the user to a website with information on their
	 * selected major and then cease running the program.
	 * @param:  None
	 */
	public static void photographyResult() throws URISyntaxException
	{
		//GUI message dialog box that displays picture and description of the Photography major the AI has chosen
		JOptionPane.showMessageDialog(null,
				"Based on your responses to the questions I have asked you, I think you should major in:  \n"
						+ "Photography!  You said you like to take professionally looking pictures of the world you see and publish them in an \n" 
						+ "art studio or art show rather than drawing or painting art.  You will use the computer but only to edit the pictures you \n"
						+ "take and not to create art and visual presentations.\n"
						+ "I think photography is the best fit for you.\n"
						+ "Upon clicking 'OK' the program will close and a browser window will open and take\n"
						+ "you to a site that will show information pertaining to your major match.",
						"****Photography Major****",
						JOptionPane.INFORMATION_MESSAGE,
						courseDriver.photographyIcon);	
		courseDriver.aiRunning = false;   							//switch flag to stop the program

		//open default desktop browser to display web page with information on major career path AI has selected
		URI url = new URI("http://www.bls.gov/ooh/media-and-communication/photographers.htm");
		try {
			Desktop.getDesktop().browse(url);
		} catch (IOException e) {
			// catch block
			e.printStackTrace();
		}
	}
	
	/* This method is of void type and does not return anything
	 * This method will display a picture and description of the Psychology major that is chosen using a GUI
	 * message Dialog box.  When the user clicks "OK" to close the dialog box, the default web browser
	 * of the computer will open a web page that will take the user to a website with information on their
	 * selected major and then cease running the program.
	 * @param:  None
	 */
	public static void psychResult() throws URISyntaxException
	{
		//GUI message dialog box that displays picture and description of the Psychology major the AI has chosen
		JOptionPane.showMessageDialog(null,
				"Based on your responses to the questions I have asked you, I think you should major in:  \n"
						+ "Psychology!  You said you like to study how the human mind works and would be intrested in researching and advancing\n" 
						+ "treatements for mental disorders such as Schizophrenia.  While you are fascinated and have a passion for learning how human interaction works,\n"
						+ "you are more conerned with studying the individual rather than a group of people and how interactions with different cultures differ.\n"
						+ "Therefore, I think a major in psychology is the best fit for you.\n"
						+ "Upon clicking 'OK' the program will close and a browser window will open and take\n"
						+ "you to a site that will show information pertaining to your major match.",
						"****Psychology Major****",
						JOptionPane.INFORMATION_MESSAGE,
						courseDriver.psychologyIcon);	
		courseDriver.aiRunning = false;   							//switch flag to stop the program

		//open default desktop browser to display web page with information on major career path AI has selected
		URI url = new URI("http://www.bls.gov/ooh/life-physical-and-social-science/psychologists.htm#tab-1");
		try {
			Desktop.getDesktop().browse(url);
		} catch (IOException e) {
			// catch block
			e.printStackTrace();
		}
	}
	
	/* This method is of void type and does not return anything
	 * This method will display a picture and description of the Sociology major that is chosen using a GUI
	 * message Dialog box.  When the user clicks "OK" to close the dialog box, the default web browser
	 * of the computer will open a web page that will take the user to a website with information on their
	 * selected major and then cease running the program.
	 * @param:  None
	 */
	public static void socResult() throws URISyntaxException
	{
		//GUI message dialog box that displays picture and description of the Sociology major the AI has chosen
		JOptionPane.showMessageDialog(null,
				"Based on your responses to the questions I have asked you, I think you should major in:  \n"
						+ "Sociology!  You said you like to study how people interact in groups, the connections people establish in groups,\n" 
						+ "how different cultures interact with each other, and how the social world is organized and structured.\n"
						+ "You are more conerned with studying a group of people rather than an individual and how interactions with different cultures differ.\n"
						+ "Therefore, I think a major in sociology is the best fit for you.\n"
						+ "Upon clicking 'OK' the program will close and a browser window will open and take\n"
						+ "you to a site that will show information pertaining to your major match.",
						"****Sociology Major****",
						JOptionPane.INFORMATION_MESSAGE,
						courseDriver.sociologyIcon);	
		courseDriver.aiRunning = false;   							//switch flag to stop the program

		//open default desktop browser to display web page with information on major career path AI has selected
		URI url = new URI("http://www.bls.gov/ooh/life-physical-and-social-science/sociologists.htm");
		try {
			Desktop.getDesktop().browse(url);
		} catch (IOException e) {
			// catch block
			e.printStackTrace();
		}
	}
	
	/* This method is of void type and does not return anything
	 * This method will display a picture and description of the Business major that is chosen using a GUI
	 * message Dialog box.  When the user clicks "OK" to close the dialog box, the default web browser
	 * of the computer will open a web page that will take the user to a website with information on their
	 * selected major and then cease running the program.
	 * @param:  None
	 */
	public static void businessResult() throws URISyntaxException
	{
		//GUI message dialog box that displays picture and description of the Business major the AI has chosen
		JOptionPane.showMessageDialog(null,
				"Based on your responses to the questions I have asked you, I think you should major in:  \n"
						+ "Business Management!  You said you like to control, organize, plan, and even direct the functions\n"
						+ "of an organization and would enjoy working behind a desk, or among a small team of people or even in human resources.\n"
						+ "Analyzing money stocks and controlling the flow of money in an organization is just not for you.  You would rather work on how the organization functions.\n"
						+ "Therefore, I think a major in Business Management is the best fit for you.\n"
						+ "Upon clicking 'OK' the program will close and a browser window will open and take\n"
						+ "you to a site that will show information pertaining to your major match.",
						"****Business Management Major****",
						JOptionPane.INFORMATION_MESSAGE,
						courseDriver.businessIcon);	
		courseDriver.aiRunning = false;  							//switch flag to stop the program

		//open default desktop browser to display web page with information on major career path AI has selected
		URI url = new URI("http://www.bls.gov/oes/2008/may/oes111021.htm#ind");
		try {
			Desktop.getDesktop().browse(url);
		} catch (IOException e) {
			// catch block
			e.printStackTrace();
		}
	}
	
	/* This method is of void type and does not return anything
	 * This method will display a picture and description of the Economics major that is chosen using a GUI
	 * message Dialog box.  When the user clicks "OK" to close the dialog box, the default web browser
	 * of the computer will open a web page that will take the user to a website with information on their
	 * selected major and then cease running the program.
	 * @param:  None
	 */
	public static void economicsResult() throws URISyntaxException
	{
		//GUI message dialog box that displays picture and description of the Economics major the AI has chosen
		JOptionPane.showMessageDialog(null,
				"Based on your responses to the questions I have asked you, I think you should major in:  \n"
						+ "Economics!  You said you would enjoy understanding how money flows through an economy\n"
						+ "and how society is consuming and using natural resources to predict future economic conditions.\n"
						+ "Analyzing money stocks and doing an extensive research on how the economy functions is for you rather than managing a business or handling money.\n"
						+ "Therefore, I think a major in Economics is the best fit for you.\n"
						+ "Upon clicking 'OK' the program will close and a browser window will open and take\n"
						+ "you to a site that will show information pertaining to your major match.",
						"****Economics Major****",
						JOptionPane.INFORMATION_MESSAGE,
						courseDriver.economicsIcon);	
		courseDriver.aiRunning = false;   							//switch flag to stop the program

		//open default desktop browser to display web page with information on major career path AI has selected
		URI url = new URI("http://www.bls.gov/ooh/life-physical-and-social-science/economists.htm");
		try {
			Desktop.getDesktop().browse(url);
		} catch (IOException e) {
			// catch block
			e.printStackTrace();
		}
	}
	
	/* This method is of void type and does not return anything
	 * This method will display a picture and description of the Accounting major that is chosen using a GUI
	 * message Dialog box.  When the user clicks "OK" to close the dialog box, the default web browser
	 * of the computer will open a web page that will take the user to a website with information on their
	 * selected major and then cease running the program.
	 * @param:  None
	 */
	public static void accountingResult() throws URISyntaxException
	{
		//GUI message dialog box that displays picture and description of the Accounting major the AI has chosen
		JOptionPane.showMessageDialog(null,
				"Based on your responses to the questions I have asked you, I think you should major in:  \n"
						+ "Accounting!  You said you would enjoy handling money while following concepts of effective\n"
						+ "budget control and resource management.  You are okay with filing taxes for a business as well as\n"
						+ "preparing and analyzing financial reports instead of managing a business or analzying the economy as a whole.\n"
						+ "Therefore, I think a major in Accounting is the best fit for you.\n"
						+ "Upon clicking 'OK' the program will close and a browser window will open and take\n"
						+ "you to a site that will show information pertaining to your major match.",
						"****Accounting Major****",
						JOptionPane.INFORMATION_MESSAGE,
						courseDriver.accountingIcon);	
		courseDriver.aiRunning = false;   							//switch flag to stop the program

		//open default desktop browser to display web page with information on major career path AI has selected
		URI url = new URI("http://www.bls.gov/ooh/business-and-financial/accountants-and-auditors.htm");
		try {
			Desktop.getDesktop().browse(url);
		} catch (IOException e) {
			// catch block
			e.printStackTrace();
		}
	}
}