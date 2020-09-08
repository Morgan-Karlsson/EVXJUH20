package inlmn3;

/*
 * Class to keep track of the number of guesses.
 */

public class Counter {
	
	public int guessCounter = 0;
	private final int MAX_GUESSES = 12;
	
	
	public int getGuessCounter() {
		return guessCounter;
	}
	
	public int getMaxGuess() {
		return MAX_GUESSES;
	}
	
	/*
	 * Subtracts the max number of guesses with the guesses made so far.
	 */
	public int getRemainingGuesses() {
		return MAX_GUESSES - guessCounter;
	}
	
	/*
	 * Adds one the number of guesses made.
	 */
	public void increaseCounter() {
		this.guessCounter++;
		
	}
	
	/*
	 * Function to quickly end the game
	 */
	public void gameOver() {
		this.guessCounter = 12;
	}

	
	
}
