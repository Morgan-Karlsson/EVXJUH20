package inlmn3;

public class HangmanPrint {
	
	public static void printHangman(Counter c) {
		
		switch (c.guessCounter) {
			case 1: System.out.println("_");
					break;
			case 2: System.out.println("|_");
					break;
			case 3: System.out.println("|" + "\n" + "|_");
					break;
			case 4: System.out.println("|" + "\n" + "|" + "\n" + "|_");
					break;
			case 5: System.out.println("|" + "\n" + "|" + "\n" + "|" + "\n" + "|_");
					break;
			case 6: System.out.println("|--|" + "\n" + "|" + "\n" + "|" + "\n" + "|_");
					break;
			case 7: System.out.println("|--|" + "\n" + "|  O" + "\n" + "|" + "\n" + "|_");
					break;
			case 8: System.out.println("|--|" + "\n" + "|  O" + "\n" + "|  |" + "\n" + "|_");
					break;
			case 9: System.out.println("|--|" + "\n" + "|  O" + "\n" + "|  |-" + "\n" + "|_");
					break;
			case 10: System.out.println("|--|" + "\n" + "|  O" + "\n" + "| -|-" + "\n" + "|_");
					break;
			case 11: System.out.println("|--|" + "\n" + "|  O" + "\n" + "| -|-" + "\n" + "|_ 2/");
					break;
			case 12: System.out.println("|--|" + "\n" + "|  O" + "\n" + "| -|-" + "\n" + "|_ /\\");
					break;
			default:
					System.out.println("Game Over!");
					c.gameOver();
		}
	}

}
