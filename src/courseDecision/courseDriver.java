/********************************************************
 * This class is the Driver class of courseDecision that
 * controls the majority of the GUI that aids the AI in
 * determining which major program best fits the user based
 * on their responses.
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

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class courseDriver {

	//creates a new courseCalculate object to handle AI decisions in picking user's best matching course
	static courseCalculate courseAnalyze = new courseCalculate();
	//creates a new courseMajorsDatabase object that contains all of the possible majors the AI can recommend to the user
	static courseMajorsDatabase majorData = new courseMajorsDatabase();

	//File paths used to access pictures for each major return result to distinguish and provide visual representation of which major was chosen.
	final static java.net.URL csciURL = courseDriver.class.getResource("/computer_science.jpg");			
	final static ImageIcon csciIcon = new ImageIcon(csciURL);												//CSCI
	
	final static java.net.URL cisURL = courseDriver.class.getResource("/computer_systems.jpg");
	final static ImageIcon cisIcon = new ImageIcon(cisURL);													//ISM
	
	final static java.net.URL paintDrawURL = courseDriver.class.getResource("/painting-and-drawing-md.png");
	final static ImageIcon paintDrawIcon = new ImageIcon(paintDrawURL);										//Painting/Drawing
	
	final static java.net.URL graphicDesignURL = courseDriver.class.getResource("/graphicDesign.jpg");
	final static ImageIcon graphicDesignIcon = new ImageIcon(graphicDesignURL);								//Graphic Design
	
	final static java.net.URL teachArtURL = courseDriver.class.getResource("/teachArt.jpg");
	final static ImageIcon teachArtIcon = new ImageIcon(teachArtURL);										//Art Education
	
	final static java.net.URL photographyURL = courseDriver.class.getResource("/photography.jpg");
	final static ImageIcon photographyIcon = new ImageIcon(photographyURL);									//Photography
	
	final static java.net.URL psychologyURL = courseDriver.class.getResource("/psychology.jpg");
	final static ImageIcon psychologyIcon = new ImageIcon(psychologyURL);									//Psychology
	
	final static java.net.URL sociologyURL = courseDriver.class.getResource("/sociology.jpg");
	final static ImageIcon sociologyIcon = new ImageIcon(sociologyURL);										//Sociology
	
	final static java.net.URL businessURL = courseDriver.class.getResource("/business.jpg");
	final static ImageIcon businessIcon = new ImageIcon(businessURL);										//Business
	
	final static java.net.URL economicsURL = courseDriver.class.getResource("/economics.jpg");
	final static ImageIcon economicsIcon = new ImageIcon(economicsURL);										//Economics
	
	final static java.net.URL accountingURL = courseDriver.class.getResource("/accounting.jpg");
	final static ImageIcon accountingIcon = new ImageIcon(accountingURL);									//Accounting

	static String name;												//string container of the user's name
	static String initialSelection;									//string container of what interest the user has chosen
	static boolean retryDecision = false;							//boolean flag used to indicate if user was unsatisfied with AI decision making path and wanted to select a differet major
	static boolean nameError = true;								//boolean flag to indicate whether or not the user has entered a valid name.  Default value is an invalid name.
	static boolean aiRunning = true;								

	//main method to run program
	public static void main(String[] args) throws URISyntaxException {

		while(aiRunning == true){

			//check to see if the user is unsatisfied with the decision path the AI made and wants to select another major
			if (retryDecision == false)
			{
				//GUI welcome message dialog
				JOptionPane.showMessageDialog(null, "                                                       "
						+ "Hi my name is Jack!\n  I am a course decision" 
						+ " program that can help you find a field you may wish to study or major/minor in\n"
						+ "                         "
						+ "I know you may not know what you want to do after college, but that is okay!\n" 
						+ "                                                "
						+ "That is what I am here for!  Let's get started!", "Welcome!", JOptionPane.INFORMATION_MESSAGE);

				//only accept a valid name that requires the user to enter something in the input dialog
				while (nameError == true)
				{
					//GUI input dialog to prompt user what their name is
					name = JOptionPane.showInputDialog("First, what is your name?");

					//check to see if the user has entered nothing for their name
					if ((name == null) || (name.equals("")))
					{
						JOptionPane.showMessageDialog(null, "Please enter a name."); 
					}

					//user entered valid name
					else
					{
						nameError = false;
					}
				}
			}
			
			//GUI multiple selection dialog box to prompt user what they are interested in to suggest potential course match
			Object[] intrests = {"Computers", "Art", "The Human Mind", "Society and Interaction of People", "Business and Money"};
			initialSelection = (String)JOptionPane.showInputDialog(null,
					"OK " + name + "!  " + "What kind of things are you intrested in?\n",
					"Getting to Know You.....",
					JOptionPane.QUESTION_MESSAGE,
					null, intrests,
					"computers");

			//check to see if the user has specified what interests them
			if (initialSelection != null)
			{
				//case switch block to determine what path to take based on what interest the user specified
				switch(initialSelection){
				case "Computers":									//user is interested in computers									
					techPrompt(name);								//method call to ask user more questions about the Tech field they are interested in to see if it is a right match
					break;

				case "Art":											//user in interested in Art
					artPrompt(name);								//method call to ask user more questions about the Art field they are interested in to see if it is a right match
					break;

				case "The Human Mind":								//user is interested in the human mind (Psychology)
					physchologyPrompt(name);						//method call to ask user more questions about the Psychology field they are interested in to see if it is a right match
					break;

				case "Society and Interaction of People":			//user is interested in society and its people (Sociology)
					sociologyPrompt(name);							//method call to ask user more questions about the Sociology field they are interested in to see if it is a right match
					break;

				case "Business and Money":							//user is interested in Business
					businessPrompt(name);							//method call to ask user more questions about the Business field they are interested in to see if it is a right match
					break;

				default:											//by default, unless the user specifies, choose the computer fields as area of interest
					techPrompt(name);
				}
			}

			//the user has hit the cancel button and doesn't want to be consulted anymore
			else
				aiRunning = false;									//switch exit flag to stop program
		}
	}

	/* This method is of void type and does not return anything
	 * This method will ask the user more questions about the Computer field they are interested in and determine what they want to do in that field
	 * to see if it is the perfect major program for them to pursue.
	 * @param:  string of the user's name
	 */
	public static void techPrompt(String name) throws URISyntaxException
	{
		int userTechDec = 0;										//int container to store whether the user has chose hardware or software

		//check to see if the user is not satisfied with the AI decision making for CSCI and wants to switch to another major
		if (courseCalculate.newCSCIDecision == true)
		{
			//GUI dialog to ask the user if they would be interested in doing CIS rather than CSCI since they were not not happy with CSCI
			int cisConfirmDialog = JOptionPane.showConfirmDialog(
					null,
					"Since you don't seem to be intrested in programming but still want to do "
							+ "something with computers I recommend working with computer hardware.\n" +
							"Is this something you would be intrested in doing?",
							"Trying really hard to find the best match for you.....",
							JOptionPane.YES_NO_OPTION);

			//check to see if the user has chosen hardware
			if (cisConfirmDialog == 0)
			{
				courseMajorsDatabase.cisResult();					//method call to return CIS recommended course major
				//aiRunning = false;
			}
				
			//the user did not choose hardware and doesn't want to work with software either
			else
			{
				retryDecision = true;								//return user back to initial selection so they may re-pick their interests since they are not interested in computers
				main(null);											//re-run main to find new interests of users
			}
		}

		//check to see if the user was not satisfied with the AI decision making for CIS and wants to switch to another major
		if (courseCalculate.newCISDecision == true)
		{
			//GUI dialog to ask the user if they would be interested in doing CSCI rather than CIS since they were not happy with CIS
			int csciConfirmDialog = JOptionPane.showConfirmDialog(
					null,
					"Since you don't seem to be intrested in hardware but still want to do "
							+ "something with computers I recommend working with computer software.\n" +
							"Is this something you would be intrested in doing?",
							"Trying really hard to find the best match for you.....",
							JOptionPane.YES_NO_OPTION);

			//check to see if the user has chosen software
			if (csciConfirmDialog == 0)
				courseMajorsDatabase.csciResult();					//method call to return CSCI recommended major

			//the user did not choose software and doesn't want to work with hardware either
			else
			{
				retryDecision = true;								//return user back to initial selections so they may re-pick their interests since they are not interested in computers
				main(null);
			}
		}

		//only run while the AI is still running and hasn't given user a major
		while (aiRunning == true)
		{
			//String container used to inform user of what CSCI entails to see if they are interested in major
			String software = "work with software and learn about making software such as Microsoft Word or a board game";

			//String container used to inform user of what CIS entails to see if they are interested in major
			String hardware = "work with hardware like networks, servers, computers, laptops, and etc.";

			//GUI multiple selection dialog box that will restate what the user is interested in and ask the user another question to see if they want to work with software or hardware of computers
			Object[] techFields = {software, hardware};
			String techSelection = (String)JOptionPane.showInputDialog(null,
					"OK " + name + "!  " + "So it looks like you like " + initialSelection + "!" +
							"\n Now tell me, would you perfer to....",
							"Getting to Know You.....",
							JOptionPane.QUESTION_MESSAGE,
							null, techFields,
							software);

			//check to see if the user has made a selection between software and hardware
			if (techSelection != null)
			{
				//the user has chosen software
				if(techSelection.equals(software))
					userTechDec = 1;									//update major chosen flag

				//the user has chosen hardware
				else
					userTechDec = 2;									//update major chosen flag

				courseCalculate.calculateTechnical(userTechDec, name);	//method call to evaluate what major the user should study in their field of interest
			}

			//the user has hit cancel and does not want to be counseled anymore
			else
				aiRunning = false;   						//switch set exit flag to stop program
		}
	}

	/* This method is of void type and does not return anything
	 * This method will ask the user more questions about the Art field they are interested in and determine what they want to do in that field
	 * to see if it is the perfect major program for them to pursue.
	 * @param:  string of the user's name
	 */
	public static void artPrompt(String name) throws URISyntaxException
	{
		int userArtDec = 0;											//int container to store whether the user has chose Art Education, Photography, Painting/Drawing, or Graphic Design

		//check to see if the user was not satisfied with the AI decision making for Painting/Drawing and wants to switch to another major
		if (courseCalculate.newPaintDrawDecision == true)
		{
			//GUI dialog to ask the user if they would be interested in doing Graphic Design rather than Painting/Drawing since they were not not happy with Painting/Drawing
			int graphicDesignConfirmDialog = JOptionPane.showConfirmDialog(
					null,
					"Since you don't seem to be intrested in painting or drawing but still want to do "
							+ "something with painting and drawing I recommend working with graphic design.\n"
							+ "It is similar to what you want to do but doesn't always involve making portraits of people or object stills.\n"
							+ "Graphic design allows you to use the computer to create logos, visual presentations, and use the computer to do your art rather than actual colors and tools you use with your hands.\n"
							+ "Is this something you would be intrested in doing?",
							"Trying really hard to find the best match for you.....",
							JOptionPane.YES_NO_OPTION);

			//check to see if the user has selected "yes" that they are happy with Graphic Design and it sounds of interest to them
			if (graphicDesignConfirmDialog == 0)
				courseMajorsDatabase.graphicDesignResult();

			//the user did not like Graphic Design either, so ask the user if they would like to teach art instead or if they just don't want to do art now
			else
			{
				//GUI confirm dialog box with custom options for yes, no to see if the user wants to teach art or if art just isn't for them
				Object[] options = {"Teach Art", "Art isn't for me"};
				int retryArt = JOptionPane.showOptionDialog(null,
						"So since you don't want to draw/paint OR do graphic design but still want to do something in art," 
								+ " the only other thing I can recommend for you to do is teach drawing/painting or is art just not for you?",
								"Trying really hard to find the best for you.....",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,     							//do not use a custom Icon
								options,  							//the titles of buttons
								options[0]); 						//default button title

				//check to see if the user wants to teach art
				if (retryArt == 0)
					courseMajorsDatabase.teachArtResult();			//method call to recommend Art Education as major program best suited for user based on their choices

				//the user doesn't want to do anything with art suited to their interests so let them pick a new interest
				else
				{
					retryDecision = true;							//return user back to initial selections so they may re-pick their interests since they are not interested in art
					main(null);
				}
			}
		}

		//check to see if the user was not satisfied with the AI decision making for Photography and wants to switch to another major
		if(courseCalculate.newPhotographyDecision == true)
		{
			//GUI dialog to ask the user if they would be interested in doing Graphic Design rather than Photography since they were not not happy with Photography
			int graphicDesignConfirmDialog = JOptionPane.showConfirmDialog(
					null,
					"Since you don't seem to be intrested in photography but still want to do "
							+ "something with images I recommend working with graphic design.\n"
							+ "It is similar to what you want to do but instead uses the computer to process images that others may have taken or\n"
							+ "photos you may already have without having to actually take photo shots.  Graphic design allows you to use the computer to create logos, \n" 
							+ "visual presentations, and use the computer to process and render your art.\n"
							+ "Is this something you would be intrested in doing?",
							"Trying really hard to find the best match for you.....",
							JOptionPane.YES_NO_OPTION);

			//check to see if the user has selected "yes" that they are happy with Graphic Design and it sounds of interest to them
			if (graphicDesignConfirmDialog == 0)
				courseMajorsDatabase.graphicDesignResult();			//method call to recommend Graphic Design as best suited major for user based on their choices

			//the user did not like Graphic Design either, so ask the user if they would like to teach art instead or if they just don't want to do art now
			else
			{
				//GUI confirm dialog box with custom options for yes, no to see if the user wants to teach art or if art just isn't for them
				Object[] options = {"Teach Art", "Art isn't for me"};
				int retryArt = JOptionPane.showOptionDialog(null,
						"So since you don't want to do photography OR do graphic design but still want to do something in art,\n" 
								+ " the only other thing I can recommend for you to do is to teach photography and learn about it rather than actually doing it or is art just not for you?",
								"Trying really hard to find the best for you.....",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,     //do not use a custom Icon
								options,  //the titles of buttons
								options[0]); //default button title

				//check to see if the user wants to teach art
				if (retryArt == 0)
					courseMajorsDatabase.teachArtResult();			//method call to recommend Art Education as best suited major for user based on their choices

				//the user doesn't want to do anything with art suited to their interests so let them pick a new interest
				else
				{
					retryDecision = true;							//return user back to initial selections so they may re-pick their interests since they are not interested in art
					main(null);
				}
			}
		}

		//check to see if the user was not satisfied with the AI decision making for Art Education and wants to switch to another major
		if(courseCalculate.newTeachArtDecision == true)
		{
			//GUI confirm dialog box with custom options for yes, no to see if the user wants to do Painting/Drawing, Graphic Design, or if art just isn't for them
			Object[] options = {"Painting/Drawing", "Graphic Design","Art isn't for me"};
			int retryArt = JOptionPane.showOptionDialog(null,
					"Since you don't seem to be intrested in teaching art but still want to do "
							+ "something with art I recommend working with either painting/drawing or graphic design.\n"
							+ "Both fields are similar to what you want to do but instead of teaching students how to make fascinating art, you are the one making the art\n"
							+ "In art education, you teach students how to paint and draw primarly, elements that are present in graphic design and painting/drawing.\n"
							+ "Painting/Drawing using colors and tools such as paint brushes, pencils, and pens to create stills of objects and people\n"
							+ "while Graphic Design uses the computer to create visual presentations and make art digitally where all of the tools are on the computer \n"
							+ "or is art just simply not for you?",
							name, JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,     //do not use a custom Icon
							options,  //the titles of buttons
							options[0]); //default button title

			//check to see if the user wants to do Painting/Drawing
			if (retryArt == 0)
				courseMajorsDatabase.paintDrawResult();				//method call to recommend Painting/Drawing as best suited major based on their choices

			//check to see if the user wants to do Graphic Design
			else if (retryArt == 1)
				courseMajorsDatabase.graphicDesignResult();			//method call to recommend Graphic Design as best suited major based on their choices

			//art isn't for the user based on their responses so let them pick a new interest
			else
			{
				retryDecision = true;								//return user back to initial selections so they may re-pick their interests since they are not interested in art
				main(null);
			}
		}

		//check to see if the user was not satisfied with the AI decision making for Graphic Design and wants to switch to another major
		if(courseCalculate.newGraphicDesignDecision == true)
		{
			//GUI dialog to ask the user if they would be interested in doing Painting/Drawing rather than Graphic Design since they were not not happy with Graphic Design
			int paintingDrawingConfirmDialog = JOptionPane.showConfirmDialog(
					null,
					"Since you don't seem to be intrested in Graphic Design but still want to do "
							+ "something with art similar to Graphic Design I recommend painting/drawing.\n"
							+ "It is similar to Graphic Design, but instead of using the computer to draw and paint your work of art\n"
							+ "you will use your hand to transform your ideas and the world as you see it onto paper with its own distinctive art quality.\n"
							+ "Is this something you would be intrested in doing?",
							"Trying really hard to find the best match for you.....",
							JOptionPane.YES_NO_OPTION);

			//check to see if the user has selected "yes" that they are happy with Painting/Drawing and it sounds of interest to them
			if (paintingDrawingConfirmDialog == 0)
				courseMajorsDatabase.paintDrawResult();				//method call to recommend Painting/Drawing as best suited major based on their choices

			//the user did not want to Graphic Design or Painting/Drawing, so ask them if they would like to teach art instead
			else
			{
				//GUI confirm dialog box that asks the user if they would like to teach art using "yes" or "no"
				int retryArt = JOptionPane.showConfirmDialog(
						null,
						"Since you don't seem to be intrested in Graphic Design OR painting/drawing but still want to do "
								+ "something with art similar to Graphic Design, how about majoring in teaching art?\n"
								+ "Rather than actually designing visual representations or drawing and painting the world and its people\n"
								+ "and objects, you will teach artisticly talented student turn their talents into a passion and profession\n"
								+ "by showing them the elements and concepts of arts and what it takes to make a truly magnificent masterpiece.\n"
								+ "Is this something you would be intrested in doing?",
								"Trying really hard to find the best match for you.....",
								JOptionPane.YES_NO_OPTION);

				//check to see if the user wants to teach art
				if (retryArt == 0)
					courseMajorsDatabase.teachArtResult();			//method call to recommend Art Education as best suited major based on their choices

				//art isn't for the user based on their choices so let them pick a new interest
				else
				{
					retryDecision = true;							//return user back to initial selections so they may re-pick their interests since they are not interested in art
					main(null);
				}
			}
		}

		//only run while the AI is still running and hasn't given user a major
		while (aiRunning == true)
		{
			//String container used to inform user of what Painting and Drawing entails to see if they are interested in major
			String paintDraw = "represent your ideas, emotions, and the world you see on paper with tools such as pens, pencils, pastel, and etc.";

			//String container used to inform user of what Photography entails to see if they are interested in major
			String photography = "tell the events and stories of your life and others through stunning photographs and display your photos in studios for everyone to see.";

			//String container used to inform user of what Art Education entails to see if they are interested in major
			String teachingArt = "to teach people with immense artistic talent how to turn their talent and passion into a career while ocassionally producing your own art as well.";

			//String container used to inform user of what Graphic Design entails to see if they are interested in major
			String graphicDesign = "work with computer software to design visual representations of visual presentations as well as artwork that are all digitally created.";

			//GUI multiple selection dialog box to prompt user what area of art they are interested in to suggest a potential art major
			Object[] artFields = {paintDraw, photography, teachingArt, graphicDesign};
			String artSelection = (String)JOptionPane.showInputDialog(null,
					"OK " + name + "!  " + "So it looks like you like " + initialSelection + "!" +
							"\n Now tell me, would you perfer to....",
							"Getting to Know You.....",
							JOptionPane.QUESTION_MESSAGE,
							null, artFields,
							paintDraw);

			//check to see if the user has made a selection between Painting/Drawing, Photography, Art Education, or Graphic Design
			if (artSelection != null)
			{
				//check to see if the user has chosen Painting/Drawing
				if(artSelection.equals(paintDraw))
					userArtDec = 1;										//update art major chosen flag

				//check to see if the user has chosen Photography
				else if (artSelection.equals(photography))
					userArtDec = 2;										//update art major chosen flag

				//check to see if the user has chosen Art Education
				else if (artSelection.equals(teachingArt))
					userArtDec = 3;										//update art major chosen flag

				//check to see if the user has chosen Graphic Design
				else
					userArtDec = 4;										//update art major chosen flag

				courseCalculate.calculateArt(userArtDec, name);			//method call to evaluate what major the user should study in their field of interest
			}

			//the user does not want to be counseled anymore
			else
				aiRunning = false;   									//switch set exit flag to stop program
		}
	}

	/* This method is of void type and does not return anything
	 * This method will ask the user more questions about the Psychology field they are interested in and determine what they want to do in that field
	 * to see if it is the perfect major program for them to pursue.
	 * @param:  string of the user's name
	 */
	public static void physchologyPrompt(String name) throws URISyntaxException
	{
		//GUI dialog to ask the user if they would be interested in doing everything the Psychology field entails
		int psychConfirmDialog = JOptionPane.showConfirmDialog(
				null,
				"Are you intrested in scientifically studying the human mind and its behavior, the physical\n "
						+ "and environmental conditions that affect human behavior, and \n"
						+ "researching treatments for mental problems and disorders such as anxiety, stress, and Schizophrenia?\n",
						"Getting to know you.....",
						JOptionPane.YES_NO_OPTION);

		//check to see if the user chose "yes" and is happy with Psychology and wants to pursue that field
		if (psychConfirmDialog == 0)
			courseMajorsDatabase.psychResult();						//method call to recommend Psychology as major program best suited for user based on their choices

		//the user did not like Psychology so ask the user if they would like Sociology instead
		else
		{
			//GUI dialog to ask the user if they would be interested in doing everything the Sociology field entails
			int socConfirmDialog = JOptionPane.showConfirmDialog(
					null,
					"Since you are not intrested in physchology but still want to study human behavior, would you like to study how\n"
							+ "people live together in groups, understand why people think and act the way they do,\n"
							+ "learn about the connections people make in life and how they maintain such connections, and study how cultures differ?\n",
							"Trying really hard to find the best match for you.....",
							JOptionPane.YES_NO_OPTION);

			//check to see if the user chose "yes" and is happy with Sociology and wants to pursue that field
			if (socConfirmDialog == 0)
				courseMajorsDatabase.socResult();					//method call to recommend Sociology as best suited major based on their choices

			//Sociology or Psychology just isn't for the user based on their choices so let them pick a new interest
			else
			{
				retryDecision = true;								//return user back to initial selections so they may re-pick their interests since they are not interested in Sociology or Psychology
				main(null);
			}
		}
	}

	/* This method is of void type and does not return anything
	 * This method will ask the user more questions about the Psychology field they are interested in and determine what they want to do in that field
	 * to see if it is the perfect major program for them to pursue.
	 * @param:  string of the user's name
	 */
	public static void sociologyPrompt(String name) throws URISyntaxException
	{
		//GUI dialog to ask the user if they would be interested in doing everything the Sociology field entails
		int SocConfirmDialog = JOptionPane.showConfirmDialog(
				null,
				"Would you like to study how people live together in groups, understand why people think and act the way they do,\n"
						+ "learn about the connections people make in life and how they maintain such connections, and study how cultures differ?\n",
						"Getting to know you.....",
						JOptionPane.YES_NO_OPTION);

		//check to see if the user chose "yes" and is happy with Sociology and wants to pursue that field
		if (SocConfirmDialog == 0)
			courseMajorsDatabase.socResult();						//method call to recommend Sociology as best suited major based on their choices

		//the user did not like Sociology so ask the user if they would like Psychology instead
		else
		{
			//GUI dialog to ask the user if they would be interested in doing everything the Psychology field entails
			int psychConfirmDialog = JOptionPane.showConfirmDialog(
					null,
					"Since you are not intrested in sociology but still want to study human behavior, would you like to study how the human mind \n"
							+ "works and its behavior in additon to the environmental conditions that affect human behavior, and \n"
							+ "research treatments for menatal problems and disorders such as anxiety, stress, and Schizophrenia?\n",
							"Trying really hard to find the best match for you.....",
							JOptionPane.YES_NO_OPTION);

			//check to see if the user chose "yes" and is happy with Psychology and wants to pursue that field
			if (psychConfirmDialog == 0)
				courseMajorsDatabase.psychResult();					//method call to recommend Psychology as best suited major for the user based on their choices

			//Psychology or Sociology isn't for the user based on their choices so let them pick a new interest
			else
			{
				retryDecision = true;								//return user back to initial selections so they may re-pick their interests since they are not interested in Sociology or Psychology
				main(null);
			}
		}
	}

	/* This method is of void type and does not return anything
	 * This method will ask the user more questions about the Business field they are interested in and determine what they want to do in that field
	 * to see if it is the perfect major program for them to pursue.
	 * @param:  string of the user's name
	 */
	public static void businessPrompt(String name) throws URISyntaxException
	{
		int userBusDec = 0;											//int container to store whether the user has chose Business, Economics, or Accounting

		//check to see if the user was not satisfied with the AI decision making for Business Management and wants to switch to another major
		if (courseCalculate.newBusDecision == true)
		{
			//GUI dialog to ask the user if they would be interested in doing Accounting rather than Business Management since they were not not happy with Business Management
			int accountingConfirmDialog = JOptionPane.showConfirmDialog(
					null,
					"Since you don't seem to be intrested in business management but still want to do "
							+ "something with business I recommend working with money as an accountant.\n"
							+ "Accounting shares the same concepts and knowledge as business management does but is more money focused.\n"
							+ "Rather than being the head of a tem or working in a team, you work on your own behind a desk and process taxes and analyze and create financial reports.\n"
							+ "Is this something you would be intrested in doing?",
							"Trying really hard to find the best match for you.....",
							JOptionPane.YES_NO_OPTION);

			//check to see if the user chose "yes" and is happy with Accounting and wants to pursue that field
			if (accountingConfirmDialog == 0)
				courseMajorsDatabase.accountingResult();			//method call to recommend Accounting as best suited major based on their choices

			//the user did not like Accounting so ask the user if they would like Economics instead
			else
			{
				//GUI confirm dialog box with custom options for yes, no to see if the user wants to do Economics instead or if business just isn't for them
				Object[] options = {"Study Economics", "Business isn't for me"};
				int retryBusiness = JOptionPane.showOptionDialog(null,
						"So since you don't want to manage a business and head a team OR work with money," 
								+ " the only other thing I can recommend for you to do is to study economics since it deals with managing resources and money\n"
								+ "as well as controlling how money is spent and transferred through an organization.  It is a combination of different things you want to do or is business just not for you?",
								"Trying really hard to find the best for you.....",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,     //do not use a custom Icon
								options,  //the titles of buttons
								options[0]); //default button title

				//check to see if the user chose "yes" and is happy with Economics and wants to pursue that field
				if (retryBusiness == 0)
					courseMajorsDatabase.economicsResult();			//method call to recommend Economics as best suited major for the user based on their choices

				//Business isn't for the user based on their choices so let them pick a new interest
				else
				{
					retryDecision = true;							//return user back to initial selections so they may re-pick their interests since they are not interested in business
					main(null);
				}
			}
		}

		//check to see if the user was not satisfied with the AI decision making for Economics and wants to switch to another major
		if(courseCalculate.newEconDecision == true)
		{
			//GUI dialog to ask the user if they would be interested in doing Business Management rather than Economics since they were not not happy with Economics
			int businessConfirmDialog = JOptionPane.showConfirmDialog(
					null,
					"Since you don't seem to be intrested in economics but still want to do "
							+ "something with business, I recommend specializing in Business Management.\n"
							+ "It is similar to what you want to do but instead focuses less on the money and resources avaialble to an economy\n"
							+ "and studying trends for econimc predictions.  Instead, Business Management deals with managing and planning the dtions \n" 
							+ "of an organization and can even include postions such as human resources for future recruitment. \n"
							+ "Is this something you would be intrested in doing?",
							"Trying really hard to find the best match for you.....",
							JOptionPane.YES_NO_OPTION);

			//check to see if the user chose "yes" and is happy with Business Management and wants to pursue that field
			if (businessConfirmDialog == 0)
				courseMajorsDatabase.businessResult();				//method call to recommend Business as best suited major for the user based on their choices

			//the user did not like Economics or Business Management so ask the user if they would like Accounting instead
			else
			{
				//GUI confirm dialog box with custom options for yes, no to see if the user wants to do Accounting instead or if business just isn't for them
				Object[] options = {"Accounting", "Business isn't for me"};
				int retryBusiness = JOptionPane.showOptionDialog(null,
						"So since you don't want to do Economics OR Business Management but still want to do something in business,\n" 
								+ " the only other thing I can recommend for you to do is to handle money and budgets by working in accounting.\n"
								+ " In accounting, you will still control money and how it is spent as a Business Manager would, but you will also analyze and create financial reports as an economists would.\n"
								+ "Is this something you would be intrested in doing?",
								"Trying really hard to find the best for you.....",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,     							//do not use a custom Icon
								options,  							//the titles of buttons
								options[0]); 						//default button title

				//check to see if the user chose "yes" and is happy with Accounting and wants to pursue that field
				if (retryBusiness == 0)
					courseMajorsDatabase.accountingResult();		//method call to recommend Accounting as best suited major for the user based on their choices

				//Business isn't for the user based on their choices so let them pick a new interest
				else
				{
					retryDecision = true;							//return user back to initial selections so they may re-pick their interests since they are not interested in business
					main(null);
				}
			}
		}

		//check to see if the user was not satisfied with the AI decision making for Accounting and wants to switch to another major
		if(courseCalculate.newAccountingDecision == true)
		{
			//GUI dialog to ask the user if they would be interested in doing Business Management rather than Accounting since they were not not happy with Accounting
			int businessConfirmDialog = JOptionPane.showConfirmDialog(
					null,
					"Since you don't seem to be intrested in accounting but still want to do "
							+ "something with business, I recommend specializing in Business Management.\n"
							+ "It is similar to what you want to do but instead focuses less on the money and resources avaialble to an economy\n"
							+ "and studying trends for econimc predictions.  Instead, Business Management deals with managing and planning the functions \n" 
							+ "of an organization and can even include postions such as human resources for future recruitment. \n"
							+ "Is this something you would be intrested in doing?",
							"Trying really hard to find the best match for you.....",
							JOptionPane.YES_NO_OPTION);

			//check to see if the user chose "yes" and is happy with Business Management and wants to pursue that field
			if (businessConfirmDialog == 0)
				courseMajorsDatabase.businessResult();				//method call to recommend Business Management as best suited major for the user based on their choices

			//the user did not like Accounting or Business Management so ask the user if they would like Economics instead
			else
			{
				//GUI confirm dialog box with custom options for yes, no to see if the user wants to do Economics instead or if business just isn't for them
				Object[] options = {"Economics", "Business isn't for me"};
				int retryBusiness = JOptionPane.showOptionDialog(null,
						"So since you don't want to do Accounting OR Business Management but still want to do something in business,\n" 
								+ "the only other thing I can recommend for you to do is to study economics since it deals with managing resources and money\n"
								+ "as well as controlling how money is spent and transferred through an organization.  It is a combination of different things you want to do or is business just not for you?",
								"Trying really hard to find the best for you.....",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,     //do not use a custom Icon
								options,  //the titles of buttons
								options[0]); //default button title

				//check to see if the user chose "yes" and is happy with Economics and wants to pursue that field
				if (retryBusiness == 0)
					courseMajorsDatabase.accountingResult();

				//Business isn't for the user based on their choices so let them pick a new interest
				else
				{
					retryDecision = true;							//return user back to initial selections so they may re-pick their interests since they are not interested in business
					main(null);
				}
			}
		}

		//only run while the AI is still running and hasn't given user a major
		while (aiRunning == true)
		{
			//String container used to inform user of what Business Management entails to see if they are interested in major
			String business = "work behind a desk and control how an organizations functions and be part of a team or even head a team that makes everything function in an entire organization.";

			//String container used to inform user of what Economics entails to see if they are interested in major
			String economics = "work with statistics and economic trends and patterns to shape the economic outcomes of a business while effectively using public policies to increase economic performance.";

			//String container used to inform user of what Accounting entails to see if they are interested in major
			String accounting = "handle money while performing business related functions such as budget control in addition to handling and processing the taxes of a business.";

			//GUI multiple selection dialog box to prompt user what area of business they are interested in to suggest a potential art major
			Object[] bussFields = {business, economics, accounting};
			String bussSelection = (String)JOptionPane.showInputDialog(null,
					"OK " + name + "!  " + "So it looks like you like " + initialSelection + "!" +
							"\n Now tell me, would you perfer to....",
							"Getting to Know You.....",
							JOptionPane.QUESTION_MESSAGE,
							null, bussFields,
							business);

			//check to see if the user has made a selection between Business Management, Economics, or Accounting
			if (bussSelection != null)
			{
				if(bussSelection.equals(business))
					userBusDec = 1;
				else if (bussSelection.equals(economics))
					userBusDec = 2;
				else
					userBusDec = 3;

				courseCalculate.calculateBusiness(userBusDec, name);	//method call to evaluate what major the user should study in their field of interest
			}

			//The user does not want to be counseled anymore
			else
				aiRunning = false;   									//switch set exit flag to stop program
		}
	}
}