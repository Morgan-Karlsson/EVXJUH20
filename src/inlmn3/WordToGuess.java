package inlmn3;

import java.util.ArrayList;

/*
 * Class that handles the three different type of arrays. One with the word to guess, another ArrayList that contains all the wrong letters guessed
 * and a char array that contains the correct guesses.
 */

public class WordToGuess {
	
	private final String WORD = "asdf";
	private ArrayList<String> letters = new ArrayList<String>();
	char[] wordGuess = new char[WORD.length()];
	
	/*
	 * Fills up the char array with * for each letter that is in the original word.
	 */
	public WordToGuess() {
		for(int i=0; i<WORD.length(); i++) {
			wordGuess[i] = '*';
		}
	}
	
	public String getWordGuess() {
		return WORD;
	}
	
	/*
	 * Checks if the letter is in the word. Returns true of false. 
	 */
	public boolean isLetterInWord (char c) {
		
		return WORD.contains(Character.toString(c));
	}
	
	public int getSizeofWord() {
		return WORD.length();
	}
	
	/*
	 * Letters that are wrong are added into this ArrayList.
	 */
	public void addGuessedLetter(char c) {
		
		this.letters.add(Character.toString(c));
	}
	
	/*
	 * Insert the letter in the correct spot in the char array based on the index in the original word.
	 * Replaces the * symbol with the letter.
	 */
	public void insertLetter(char c) {
		int pos = positionInWord(c);
		wordGuess[pos] = c;
	}
	
	/*
	 * Checks in what index position the guessed letter is in the original word.
	 */
	private int positionInWord(char c) {
		return WORD.indexOf(c);
	}
	
	/*
	 * Prints the char array with the guessed letters in the correct place.
	 */
	public void printGuessingArray() {
		for(int i=0; i<WORD.length(); i++) {
			System.out.print(wordGuess[i]);
		}
		System.out.println();
	}
	
	/*
	 * Duplicate check for the char array that contains guessed letters.
	 */
	public boolean arrayContains(char c) {
		
		boolean checkChar = false;
		
		for(int i=0; i<wordGuess.length; i++) {
			if(wordGuess[i] == c) {
				checkChar = true;
			}
		}
		
		return checkChar;
	}
}
