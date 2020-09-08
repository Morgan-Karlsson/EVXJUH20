package inlmn3;

import java.util.Scanner;

public class gameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String choice = new String();
		Scanner input = new Scanner(System.in);
		Counter count = new Counter();
		WordToGuess word = new WordToGuess();
		
		/*
		 * Loop while score of the remaining guesses is more then 0
		 */
		while(count.getRemainingGuesses() > 0) {
			gameMenu();
			System.out.println("Enter choice: (1-3)");
			choice = input.next();
			menuLogic(choice, count, word);
		}
		
		input.close();

	}
	
	/*
	 * Just prints of the menu choices
	 */
	public static void gameMenu() {
		
		System.out.println("Game Meny");
		System.out.println("1: Game Stats (Show number of guesses");
		System.out.println("2: Guess a letter");
		System.out.println("3: Guess the word");
		
	}
	
	/*
	 * Logic for the menu choices, converts the String to an int and bases the choices
	 * in the switch case on that. 
	 */
	public static void menuLogic(String choice, Counter count, WordToGuess word) {
		
		int countNumber = 0;
		
		try {
			countNumber = Integer.parseInt(choice);
		} catch (Exception e) {
			countNumber = 0;
		}
		
		switch (countNumber) {
		case 1:
			System.out.println("You have " + count.getRemainingGuesses() + " guesses left");
			break;
		case 2:
			guessLetter(count, word);
			break;
		case 3:
			guessWholeWord(count, word);
			break;
		default:
			System.out.println("Not a valid choice");
			break;
		}
		
	}
	
	/*
	 * Function for guessing one letter of the word.
	 */
	public static void guessLetter(Counter count, WordToGuess word) {
		
		Scanner inputLetter = new Scanner(System.in);
		char letter;
		
		System.out.println("Input the letter to check: ");
		letter = inputLetter.next().charAt(0);
		
		/*
		 * Function call to check the user input letter.
		 */
		checkLetter(letter, count, word);
		
		inputLetter.reset();
		
	}
	
	/*
	 * Checking the user input letter if it's in the original word
	 */
	public static void checkLetter(char letter, Counter count, WordToGuess word) {
		
		/*
		 * Call to the function in the word class that checks if the letter is in the word.
		 */
		boolean b = word.isLetterInWord(letter);
		
		/*
		 * Checks to see if it's true that the letter occurs in the word and that the array that
		 * contains the correct guesses already doesn't have that letter. Inserts the letter in that array
		 * and prints it. If the array already contains that letter it adds to the number of wrong guesses.
		 */
		if (b && !word.arrayContains(letter)) {
			System.out.println("Letter is in the word!");
			word.insertLetter(letter);
			word.printGuessingArray();
		} else if (word.arrayContains(letter)) {
			System.out.println("You already guessed that letter, counts as a wrong guess");
			count.increaseCounter();
		}
		else {
			System.out.println("You guessed wrong!");
			word.addGuessedLetter(letter);
			count.increaseCounter();
			HangmanPrint.printHangman(count);
		
		}
	}
	
	/*
	 * Function for guessing the whole word. If the user guesses correct the game is over, otherwise it's 
	 * added to the number of guesses.
	 */
	public static void guessWholeWord(Counter count, WordToGuess word) {
		
		Scanner inputWord = new Scanner(System.in);
		String guessWord = new String();
		
		System.out.println("Ok, guess the word:");
		guessWord = inputWord.next();
		
		if(word.getWordGuess().equals(guessWord)) {
			System.out.println("Congratulations! You won!");
			count.gameOver();
		} else {
			System.out.println("Wrong!");
			count.increaseCounter();
			HangmanPrint.printHangman(count);
		}
		
		inputWord.reset();
			
	}

}
