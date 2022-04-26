/*
Phi Phan
Homework 4
C

*/
import java.util.Scanner;

public class VirtualPet
{
	public static void main(String[] args)
	{
		petCreate();// method for Creating the pet
		//Do-while loop to initiate commands until the pet runaways
		do{
		System.out.println();
		System.out.println("******BIRTHDAY!******");
		petAge();// method to increase the age of pet and day to make it difficult to manage
		petInteract();// declaring method to let the player interact with the pet
		petFeeling();// declaring method to let the player know how the pet is currently feeling
		}while(ranAway() == false);//until the pet runaway, the methods are looped
		System.out.println();
		System.out.println("******STATS******");
		result();//prints the result of how the player did for taking care of the pet
	}

		static String petName;//declared variable to store pet's name
		static int age; //decalred variable to store pet's age
		static int days;//declared variable to store the amount of days
		//declaring attributes
		static int currentHunger;// declared variable to store how hungry the pet is
		static int hungerRate;//declared variable to store the rate in which how hungry the pet is
		static int currentBoredom;//declared variable to stor how bored the pet is at
		static int boredomRate;// declared variable to store the rate in which how bored the pet is
		static int currentDirtiness;// declared varible to store how dirty the pet is
		static int dirtyRate;//declared variable to store the rate in which how the pet is clean 
		 

		final static int LOW_STAT_THRESHOLD = 5;//constant varible for threshhold point to determine the pet is doing good
		final static int MED_STAT_THRESHOLD = 10;//constant varible for threshhold point to determine the pet is doing okay
		final static int HIGH_STAT_THRESHOLD = 15;//constant varible for threshhold point to determine the pet is doing bad
		final static int RUNAWAY_STAT_THRESHOLD = 20;//constant varible for threshhold point to determine the pet ranaway or not

	//Create a pet to give to the player
	public static void petCreate()
	{
		//create a scanner to take player's input for their name
		Scanner input = new Scanner(System.in);
		age = 0;// initialize a variable to store the start off age for the pet
		System.out.println("A mysterious egg hateches before you!");
		System.out.println("What will you name this creature?");// notify the player to name the pet
		petName = input.nextLine();// gets user's input for their pet name

		hungerRate = 1; //initialize the hunger rate
		dirtyRate = 1;//initialize the dirty rate
		boredomRate = 1;//initialize the bored rate
		currentHunger = 10;//initializing the start off of how hungry the pet is 
		currentBoredom = 10;//initializing the start off of how bored the pet is 
		currentDirtiness = 10;//initializing the start off of how dirty the pet is 


	}// end petCreate method

	//Create a method to increase the age of the pet
	public static void petAge()
	{	
		days += 1;// increments the day for each round as the pet gets older
		age += 1; // increments the age to store how old the pet is

		System.out.println(petName + " is now " + age + " days old!");// prints out for the user to see

		//changes the attributes base on certain days

		if(age % 2 == 0)//if the age of the pet is divisible by 2 increase the hungerrate, 
				{
				hungerRate++;// increments the hunger rate
				System.out.println(petName + " gets hungrier faster!");// notifies that the pet is getting hungrier

			}else if (age % 3 == 0)// if the age of the pet is divisible by 3 increase the dirty rate 
				{
				dirtyRate++;// increments the dirty rate
				System.out.println(petName + " gets dirtier faster!");// notify the player the the pet is getting dirtier

			}else if(age % 5 == 0)
				{
					boredomRate++;// increments the boredom rate
					System.out.println(petName +  " gets bored faster!");// notifies that the pet is getting bored
				}else{

					System.out.println(petName + " is still in good care!");// notifies that the pet is in good care 
				}


		}// end of petAge method

	//Create a method that let the player decide how to interact witht the pet
	// the interaction will be based on the attributes that is declared for the class
	public static void petInteract()
	{	
		//use a new scanner to take a new scanner input
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.) Feed the pet\n2.) Clean the pet\n3.) Play with the pet");//displaying the options for the players
		System.out.println("What do you want to do with your pet?");//prompt the user to decide which action to do 
		int userInput = scanner.nextInt();// gets player's decision on what they want to do with the pet

		//if the user inputs 1, the player feeds the pet
		if(userInput == 1){
			feeding();
		//if the user inputs 2, the player cleans the pet
		}else if(userInput == 2){
			cleaning();
		//if the user inputs 3, the player plays with the pet
		}else if(userInput == 3){
			playing();
		//if the user input something else other than 1,2, or 3, they done nothing for the pet
		}else{
			didNothing();
		}


	}//end of interaction method

	//create a submethod to feed the pet
	public static void feeding()
	{	
		currentHunger = currentHunger - hungerRate;// decrease the current hunger with the hunger rate because the player feed the pet
		currentDirtiness = currentDirtiness + dirtyRate;//increase the current dirtiness with the dirty rate because the player feed the pet

		System.out.println("You fed " + petName + " but it makes a mess...");//note that the user that they fed the pet, but not it get dirtier

	}//end of feeding sub method

	//create a submethod to clean the pet
	public static void cleaning()
	{
		currentDirtiness = currentDirtiness - dirtyRate;// decrease the current dirtyiness with the dirty rate because the player cleaned the pet
		currentBoredom = currentBoredom + boredomRate;// increase the current boredness with the bordness rate because the player pet is getting bored from cleaning

		System.out.println("You cleaned " + petName + " but now its bored..." );// prompt the user  that the pet is cleaned but not is getting bored

	} //end of cleaning sub method

	//create a submethod to play with the pet
	public static void playing()
	{
		currentBoredom = currentBoredom - boredomRate;// decrease the current boredness with the bordness rate because the player is playing with the pet
		currentHunger = currentHunger + hungerRate;// increase the current hunger with the hunger rate because the pet is getting  hungry from playing

		System.out.println("You played with " + petName + " but now its hungry..");// prompt the user that the pet isn't as bored but is now getting hungrier

	}//end of playing sub method

	//create a sub method when the player press anything beside 1,2 or 3
	public static void didNothing()
	{
		//decrease the currentHunger, currentDirtiness, and current boredom, bececause the owner refused to do anything
		currentHunger = currentHunger - hungerRate;
		currentDirtiness = currentDirtiness - dirtyRate;
		currentBoredom = currentBoredom - boredomRate;

		//prompt the user that they did nothing
		System.out.println("You chose to do nothing with " + petName + " today, you have failed a simple job");

	}

	//create a method to let the player know how the pet is currently feeling
	public static void petFeeling()
	{
		//create string variable and assign it based on the attributes using a submethod to display the message
		String hungerDescrip = "Hunger Level: ";
		System.out.println(hungerDescrip + description(currentHunger));

		String dirtDescrip = "Cleanliness Level: ";
		System.out.println(dirtDescrip + description(currentDirtiness));

		String boredDescrip = "Boredom Level: ";
		System.out.println(boredDescrip + description(currentBoredom));

	}// end of talking about pet's feeling

	//create a submethod that give a description how the pet is doing
	public static String description(int x)
	{
		//create a string variable to store the message
		String message;
		//if the value within the method is less than the LOW_STAT_THRESHHOLD
		if (x <  LOW_STAT_THRESHOLD)
		{
			//promp user this
			 message = "You are going to be a great pet owner!";
		//if the value within the method is less than the MED_STAT_THRESHHOLD
		}else if (x < MED_STAT_THRESHOLD) 
		{
			//prompt user this
			message = "Doing well, but could be better";

		//if the value within the method is less than the HIGH_STAT_THRESHHOLD
		}else if(x < HIGH_STAT_THRESHOLD)
		{
			//prompt user this
			message = "WARNING! DO SOMETHING! You are about to lose your pet";
		}else
		{//if the value within the method is about to cause the pet to runaway
			message = "Welp, say goodbye to your pet soon";
		}

		return message;
	}//end of sub method decription

	//create a method to see if the pet ranaway
	public static boolean ranAway()
	{
		//If the method returns true, the pet run away, if it returns false, the pet didn't run away.
		//If the currentHunger status is greater than the RUNAWAY_STAT_THRESHOLD
		if(currentHunger > RUNAWAY_STAT_THRESHOLD)
		{
			//return true and prompt the user this
			System.out.println("Your pet ran away because it was too hungry... YOU MONSTER T-T");
			return true;

		//If the currentDirtiness status is greater than the RUNAWAY_STAT_THRESHOLD
		}else if(currentDirtiness > RUNAWAY_STAT_THRESHOLD)
		{
			//return true and prompt the user this
			System.out.println("Your pet ran away because it was too dirty.. you had one job.. one job..");
			return true;
		//If the currentBoredom status is greater than the RUNAWAY_STAT_THRESHOLD
		}else if (currentBoredom > RUNAWAY_STAT_THRESHOLD)
		{
			//return true and prompt the user this
			System.out.println("Your pet ran away because it was too bored.. didn't have time for it huh? You heartless soul you..");
			return true;
		}else{
		
		return false;
	}

	}//end of runawaying from a useless owner method

	//method that let the player know how they did after the pet run away
	public static void result()
	{
		//prompt the user how many days they took care of the pet
		System.out.println("You took care of " + days + " days!");
		
		//if the user took care of the pet for less than 5 days 
		if( days <= 5 )
		{
			//if the user took care of the pet for less than 5 days prompt them encouragement
			System.out.println("Do better next time you monster!");

		//if the user took care of the pet for more than 6 days, but less than 15 days prompt them a congratulations
		}else if((days  >= 6)  && (days <= 15))
		{
			System.out.println("Congratulations! You're pet is happy and you are an actual human being!"); 

		//if the user took care of the pet for more than 16 days, but less than 25 days prompt them a exuberant
		}else if ((days >= 16) && (days <= 25))
		{
			System.out.println("You are the best, people want to be with you.. people want to be you!");

		}else if (days > 25)
		{//if the user took care of the pet for more than 25 days, prompt them they are ready for a real pet.
			System.out.println("You sir or mam is ready for a real life pet!!");
		}
	}// end of result method.



}//end class



