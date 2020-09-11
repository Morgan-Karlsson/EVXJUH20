package inlmn2;

import java.util.Random;
import java.util.Scanner;

public class Inlmn2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Variable declaration */
		String player1 = "Player 1";
		String player2 = "Player 2";
		String choicePlayer1 = new String();
		String choicePlayer2 = new String();
		String[] fixedGameNames = {"Rock", "Paper", "Scissor"};
		String[] gameNames = new String[3];
		Scanner inputNumberOfPlayers = new Scanner(System.in);
		int numberOfPlayers = 0;
		
		/*
		 * Loop through an array with fixed names (Rock, Paper, Scissor) and give the user 
		 * an input to name them something else.
		 */
		for(int i=0; i<gameNames.length; i++) {
			
			System.out.println("Choose a name for " + fixedGameNames[i] + " :");
			gameNames[i] = new Scanner(System.in).nextLine();
		}
		
		System.out.println("How many players? 1 (vs AI) or 2 (player vs player)");
		
		/*
		 * Check to see that an integer was the correct input.
		 */
		try {
			numberOfPlayers = inputNumberOfPlayers.nextInt();
		} catch (Exception e){
			System.out.println("Only numbers between 1 and 2 are permitted.");
		}
		
		
		/*
		 * Check to see how many players. If two players then the input method is called twice otherwise it calls
		 * the AI function. 
		 */
		if (numberOfPlayers == 2) {
		
			choicePlayer1 = playerInput(player1, gameNames);
			choicePlayer2 = playerInput(player2, gameNames);
			determineWinner(choicePlayer1, choicePlayer2, gameNames);
		} else if (numberOfPlayers == 1) {
			choicePlayer1 = playerInput(player1, gameNames);
			choicePlayer2 = aiChoice(player2, gameNames);
			determineWinner(choicePlayer1, choicePlayer2, gameNames);
		}	
		
		
		inputNumberOfPlayers.close();
		
	}
	
	/* 
	 * Method to take input from the user and call other methods to check for correct inputs.
	 * Takes a String and a String array as parameters. Returns a String.
	 */
	public static String playerInput(String playerNo, String[] names) {
		
		Scanner input = new Scanner(System.in);
		boolean inputLoop = false;
		String playerChoice = "";
		
		
		/* Loop while inputLoop is false, prints to Screen from a String array with three choices. Takes a string as input from the user.
		 * The boolean is then "checked" against a method that takes the user input as a parameter.
		 */
		while(!inputLoop)  {
			System.out.println(playerNo +" choose: " + names[0] + "(1) , " + names[1] + "(2) , " + names[2] + "(3)");
			playerChoice = input.nextLine();
			inputLoop = checkInput(playerChoice, names);
		}
		
		input.reset(); 
	
		/* Send the input stream to a formatting method*/
		return fixInput(playerChoice, names);
		
	}
	
	
	/* Method that checks a String for correct input */
	public static boolean checkInput(String s, String[] names) {
		
		boolean trueNameValue = false;
		
		/* Set the string to all lowercase letters to make it easier to check */
		String inputNormalized = s.toLowerCase();	
		
		/*
		 * Check if the string is equal to the right letter options or numbers, if it's not it prints an error message
		 * and sets the boolean to false.
		 */
		if (inputNormalized.equals(names[0])  || inputNormalized.equals(names[1])  || inputNormalized.equals(names[2])  ) {
			trueNameValue = true;
		} else if (inputNormalized.equals("1")  || inputNormalized.equals("2")  || inputNormalized.equals("3")) {
			trueNameValue = true;
		} else {
			System.out.println("Wrong input, try again!");
			trueNameValue = false;
		}
		
		
		return trueNameValue;
		

	}
	
	/* Method to "fix" the String if the user has input numbers instead of the word choice.
	 */
	public static String fixInput(String choice, String[] names) {
		
		/* Matches the number value to the correct choice 
		 * 
		 */
		if (choice.equals("1")) {
			choice = names[0];
		} else if (choice.equals("2") ) {
			choice = names[1];
		} else if (choice.equals("3")) {
			choice = names[2];
		} else {
			choice = choice.toLowerCase();
		}
		
		return choice;
			
	}
	
	/*
	 * Method to determine the winner. Compares two Strings to each other.
	 */
	public static void determineWinner(String s1, String s2, String[] names) {
		
		int winner = 0;
		
		/*
		 * Check if the two Strings are the same.
		 */
		if (s1.equals(s2) ) {
			winner = 3;
		/*
		 * Check if the first String is rock and then compare it to the other String with both of the remaining value it can have.
		 */
		} else if (s1.equals(names[0]) ) {
			if (s2.equals(names[1])) {
				winner = 2;
			} else if (s2.equals(names[2])) {
				winner = 1;
			}
		/*
		 * Check if the first String is paper and then compare it to the other String with both of the remaining value it can have.
		 */
		} else if (s1.equals(names[1])) {
			if (s2.equals(names[0]))  {
				winner = 1;
			} else if (s2.equals(names[2])) {
				winner = 2;
			}
		/*
		 * Check if the first String is paper and then compare it to the other String with both of the remaining value it can have.
		 */
		} else if (s1.equals(names[2])) {
			if (s2.equals(names[0])) {
				winner = 2;
			} else if (s2.equals(names[1])) {
				winner = 1;
			}
		}
		
		winnerOutput(winner);
		
	}
	
	/* 
	 * Method to interpret the winner and print it out on screen.
	 * Takes an int as parameter.
	 */
	public static void winnerOutput(int winner) {
		
		switch (winner) {
		case 1:
			System.out.println("Player 1 wins!");
			break;
		case 2: 
			System.out.println("Player 2 wins");
			break;
		case 3:
			System.out.println("It's a tie!");
			break;
		}
	}
	
	/*
	 * Method that takes a String as parameter and randomises a number between 1 and 3 and returns that number
	 * as a String.
	 */
	public static String aiChoice(String s, String[] names) {
		
		Random rand = new Random();
		Integer randomNumber;
		
		randomNumber = rand.nextInt(2)+1;
		s = randomNumber.toString();

		return fixInput(s, names);
	}
	

}