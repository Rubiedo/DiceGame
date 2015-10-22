import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.util.*;
/*
Name: Stephen Wu
Class: CMSC 255-002, Spring 2013
Programming Project 1
Due: Tuesday, February 19, 2013
*/

/*
	This is the driver class which will be used to run your project. Do not
	forget to fill in the header comments above with the correct information.
	
	NOTE: CHANGE XYZ TO YOUR INITIALS FOR ALL OF THE CLASSES AND REFERENCES TO
	THESE CLASSES! Test your program to make sure it works properly before you
	hand it in!
	
	Please note that you can have multiple classes within the same source file.
	The other classes must not have a public keyword. This makes it easier to
	work on a multi-class project without having to open multiple files.
*/
public class DiceGameSDW
{
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args)
	{
		// Instantiate an object of type StudentXYZ, passing in your name and
		// section.
		
		// Using the setMyProjectTitle() method, set the title of the StudentXYZ's
		// project to "Programming Project 1"
		
		// Print out the StudentXYZ isntance.
		
		// Call the startGame() method
		
		StudentSDW student = new StudentSDW("Stephen Wu", 002);
		student.setMyProjectNum("Programming Project 1");
		System.out.println(student.toString());
		System.out.println("");
		startGame();
	}
	
	public static void startGame()
	{
		// Instantiate 3 PlayerXYZ objects and ask the user for each player's
		// name. Then set the player objects' names using the user's input. 2 of
		// the PlayerXYZ objects should be the players, one should be the bar.
		
		// Loop until the current player types "quit" (without the quotes). If
		// this condition is met, the program should end.

		// Otherwise, the program should loop, set the new current bar, then allow
		// Player 1 and Player 2 a chance to get as close to the bar as possible.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("First Player's name: ");
		PlayerSDW player1 = new PlayerSDW();
		player1.PlayerSDW(scan.nextLine());
		System.out.print("Second Player's name: ");
		PlayerSDW player2 = new PlayerSDW();
		player2.PlayerSDW(scan.nextLine());
		System.out.println("The Bar's name will be 'Bar'");
		PlayerSDW bar = new PlayerSDW();
		bar.PlayerSDW("bar");
		
		// Do not forget to program the loop exit conditional! DO NOT REPLACE
		// true in the while statement below. The exit conditional must happen
		// in the body of the while loop.
		while(true)
		{
			// In this loop, players will take turns rolling dice and attempting
			// to get as close to the bar as possible.
			
			// If a player's roll is closest to the bar, the player's score is
			// increased by 1.

			// If a player rolls a score that equals the bar, that player's score
			// is increased by 2.

			// If both player's scores equals the bar, neither wins.
			
			// Do not forget to set the current bar. (See game rules in the
			// assignment for more information).
			
			// Use the getPlayerInput() method for user input. The only options
			// are roll (to roll their dice) or quit (to quit the game).
		bar.rollDice();
		player2.rollDice();
		System.out.println("The bar rolled " + bar.showDice() + ". The total is: " + bar.diceTotal());		
		System.out.println("");
		
				System.out.print(player1.getMyName() + ", do you want to play? ");
				String currentInput = getPlayerInput();

				if (currentInput.equals("roll"))
				{
					player1.rollDice();
					System.out.println(player1.getMyName() + " rolled: " + player1.showDice() + " The total is: " + player1.diceTotal());
					player1.toString();
				}
				else
				{
					System.out.println(player1.getMyName() + "'s score: " + player1.getMyScore());
					System.out.println(player2.getMyName() + "'s score: " + player2.getMyScore());
					if (player1.getMyScore() > player2.getMyScore())
						System.out.println(player1.getMyName() + " wins!");
					else if (player2.getMyScore() > player1.getMyScore())
						System.out.println(player2.getMyName() + " wins!");
					else
						System.out.println("Neither Wins!");
					System.exit(0); 					
				}				
				
				System.out.println("");
				System.out.print(player2.getMyName() + ", do you want to play? ");
				currentInput = getPlayerInput();

				if (currentInput.equals("roll"))
				{
					player2.rollDice();
					System.out.println(player2.getMyName() + " rolled: " + player2.showDice() + ". The total is: " + player2.diceTotal());
					player2.toString();
				}
				else
				{
					System.out.println(player1.getMyName() + "'s score: " + player1.getMyScore());
					System.out.println(player2.getMyName() + "'s score: " + player2.getMyScore());
					if (player1.getMyScore() > player2.getMyScore())
						System.out.println(player1.getMyName() + " WINS!");
					else if (player2.getMyScore() > player1.getMyScore())
						System.out.println(player2.getMyName() + " WINS!");
					else
						System.out.println("Tie Game!");
					System.exit(0); 					
				}
				if ((Math.abs(bar.diceTotal() - player1.diceTotal()) < Math.abs(bar.diceTotal() - player2.diceTotal())) && (player1.diceTotal() != bar.diceTotal()))
				{
					player1.setMyScore(player1.getMyScore()+1);
					System.out.println(player1.getMyName() + " gets 1 point.");
					System.out.println("");
				}
				
				if ((Math.abs(bar.diceTotal() - player2.diceTotal()) < Math.abs(bar.diceTotal() - player1.diceTotal())) && (player2.diceTotal() != bar.diceTotal()))
				{
					player2.setMyScore(player2.getMyScore()+1);
					System.out.println(player2.getMyName() + " gets 1 point.");
					System.out.println("");
				}
				
				if (player2.diceTotal() != player1.diceTotal())
				{
					if (player2.diceTotal() == bar.diceTotal())
					{
						player2.setMyScore(player2.getMyScore()+2);
						System.out.println(player2.getMyName() + " gets 2 points.");
						System.out.println("");
					}
					else if(player1.diceTotal() == bar.diceTotal())
					{
						player1.setMyScore(player1.getMyScore()+2);
						System.out.println(player1.getMyName() + " gets 2 points.");
						System.out.println("");
					}
				}else
				{
					System.out.println("No one wins. It's a tie.");
					System.out.println("");
				}	
				
				System.out.println("Scores: " + player1.toString() + ", " + player2.toString());
				System.out.println("");
		}
	}

	// Write a method named getPlayerInput() that checks for player input. It
	// should loop until you receive a roll, or quit result. Return the result
	// of the user input as a String. Use a while loop.
		public static String getPlayerInput()
	{
		String input;
		
		while(true)
		{
			System.out.print("Would you like to roll or quit? ");
			input = scan.next();
			if (input.equals("roll"))
			{
				return input;
			}
			else if (input.equals("quit"))
			{
				return input;
			}
			
		}
	}
}

/*
	This is the StudentXYZ class that will print out your information at the
	beginning of the program run.
*/
class StudentSDW
{
	// declare the remaining required instance variables here.
	private String myName;
	private String myProject;
	private String myProjectNum;
	private int mySec;
	
	public StudentSDW(String myName, int mySec)
	{
		this.myName = myName;
		this.mySec = mySec;	
	}
	
	// Write getters and setters for all the instance variables
	// String result = new String();
	// Format the output necessary to properly print out your class info
	// and return the formatted text.
	
	public String getName()
	
	{
		return myName;
	}
	
	public void setName(String myName)
	{
		this.myName = myName;
	}
	
	public int getSec()
	{
		return mySec;
	}	
		
	public void setSec(int mySec)
	{
		this.mySec = mySec;
	}
	
	public void setMyProjectNum(String myProjectNum)
	{
		this.myProjectNum = myProjectNum;
	}
	
	public String getMyProjectNum()
	{
		return myProjectNum;
	}
	
	public void setMyProject(String myProject)
	{	
		this.myProject = myProject;
	}
	
	public String getMyProject()
	{	
		return myProject;
	}
	public String toString()
	{
		String result = myName + " -- Section: " + mySec + " -- Project Number: " + myProjectNum;			
		
		return result;
	}
}

/*
	This class is identical to the one used in the book. I have rewritten here
	without the comments the book provides. The source code can be found on page
	165, Listing 4.2 in your book.
	
	We will be modifying the code to handle the following 4 tasks. Document
	your changes.
	Task 1: Provide a new instance variable called MIN and set it to 1.
	Task 2: Ensure that setFaceValue can never set a value higher than MAX
	Task 3: Ensure that setFaceValue can never set a value lower than MIN.
	Task 4: Allow a user to access the MAX and MIN variables from outside
			the Die class.
	Task 5: Reimplement roll() to use java.util.Random instead of Math.random().
			Do not use the fully-qualified name for the class, instead, import
			the java.util.Random class for use in the DieXYZ class (import
			statements are always at the top of a source file).
*/
class DieSDW
{
	final int MAX = 6;
	final int MIN = 1;
	private int faceValue;
	
	public DieSDW()
	{
		faceValue = 1;
	}

	public int roll()
	{
		Random rand = new Random();
		faceValue = (int)(rand.nextInt(MAX-1))+1 ;
		return faceValue;
	}
	
	public void setFaceValue(int value)
	{
		if (value >=1 && value <= 6)
		faceValue = value;
	}

	public int getFaceValue()
	{
		return faceValue;
	}

	public String toString()
	{
		String result = Integer.toString(faceValue);
		
		return result;
	}
}

/*
	This class will represent a player of the game. It will need to hold the
	player's name (String), score (int) and 3 Die objects that the player will
	need to roll for the game.
*/
class PlayerSDW
{
	// Declare your instance variables here of the appropriate types: myName,
	// myDie1, myDie2, myDie3, and myScore
	
	private String myName;
	private DieSDW myDie1, myDie2, myDie3;
	private int myScore;
	
	// Write the PlayerXYZ constructor that takes a single String as it's only
	// parameter. This parameter must be stored in the instance variable myName.
	// You will also need to instantiate the 3 Die objects and set the player's
	// score to 0.
	
	public void PlayerSDW(String myName)
	{
		this.myName = myName;
		myDie1 = new DieSDW();
		myDie2 = new DieSDW();
		myDie3 = new DieSDW();
		this.myScore = 0;
	}	
	
	// Write the rollDice() method. This should use the rollDie() method of each
	// of the Die objects to produce a faceValue for each die. This method
	// returns nothing.
	
	public void rollDice()
	{
		myDie1.roll();
		myDie2.roll();
		myDie3.roll();
	}
	
	// Provide a getDieValue() method that accepts an int which represents one
	// of the 3 dice (1 - 3) the player has rolled. Return the appropriate face
	// value for the die requested.

	public int getDieValue(int diceNum)
	{
		if (diceNum == 1)
			return myDie1.getFaceValue();
		else if (diceNum == 2)
			return myDie2.getFaceValue();
		else if (diceNum == 3)
			return myDie3.getFaceValue();
		else
			return 0;
	}
	
	// Write the getter and setter methods for each of the instance variables. Do
	// not use these methods to add score to the standing or current scores, only
	// to set them.
	
		public void setMyName(String myName)
	{
		this.myName = myName;
	}
	
	public String getMyName()
	{
		return myName;
	}
	
	public void setMyDie1(DieSDW myDie1)
	{
		this.myDie1 = myDie1;
	}

	public DieSDW getMyDie1()
	{
		return myDie1;
	}
	
	public void setMyDie2(DieSDW myDie2)
	{
			this.myDie2 = myDie2;
	}

	public DieSDW getMyDie2()
	{
		return myDie2;
	}
	
	public void setMyDie3(DieSDW myDie3)
	{
		this.myDie3 = myDie3;
	}

	public DieSDW getMyDie3()
	{
		return myDie3;
	}
	
	public void setMyScore(int myScore)
	{
		this.myScore = myScore;
	}
	
	public int getMyScore()
	{
		return myScore;
	}
	
	// Create the showDice() method which prints out the current player's current
	// dice roll.
	
	public String showDice()
	{
		String dice = myDie1.getFaceValue() + ", " + myDie2.getFaceValue() + ", " + myDie3.getFaceValue();
		return dice;
	}
	
	// Create the diceTotal() method that reaturns the sum of the faces of the
	// current player's dice.
	
	public int diceTotal()
	{
		int total = myDie1.getFaceValue()+myDie2.getFaceValue()+myDie3.getFaceValue();
		return total;
	}
	
	// Finish the toString() method which prints out the Player's name and his
	// score in parenthesis following his name. Use the getDieValue() method to
	// get the faceValue of any dice.
	public String toString()
	{
		String result = new String();

		// write your code here
		String resul = myName + "(" + myScore + ")";
		return resul;
	}
}