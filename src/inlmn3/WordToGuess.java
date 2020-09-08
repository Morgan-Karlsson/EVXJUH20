package inlmn3;

public class WordToGuess {
	
	private char[] wordGuess = {'a', 's', 'd', 'f'};

	public char[] getWordGuess() {
		return wordGuess;
	}
	
	public char[] getLetter(int i) {
		
		return wordGuess;
	}
	
	public boolean isLetterInWord (char c) {
		
		boolean check = false;
		
		for (int i = 0; i<wordGuess.length; i++) {
			if(c == wordGuess[i]) {
				check = true;
			}
		}
		
		return check;
	}
	
}
