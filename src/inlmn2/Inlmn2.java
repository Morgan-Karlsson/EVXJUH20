package inlmn2;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Inlmn2 {
	
	public enum Weapon {ROCK, PAPER, SCISSOR}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String player1 = "Player 1";
		String player2 = "Player 2";
		String choicePlayer1 = new String();
		String choicePlayer2 = new String();
		
		
		choicePlayer1 = playerInput(player1);
		choicePlayer2 = playerInput(player2);
		
		
		
		determineWinner(choicePlayer1, choicePlayer2);
		
		
		
	}
	
	public static String playerInput(String playerNo) {
		
		String gameChoices[] = {"Rock", "Paper", "Scissor"};
		String[] lol = new String[3];
		Scanner input = new Scanner(System.in);
		boolean inputLoop = false;
		String playerChoice = "";
		
		
		
		while(!inputLoop)  {
			System.out.println(playerNo +" choose: " + gameChoices[0] + "(1) , " + gameChoices[1] + "(2) , " + gameChoices[2] + "(3)");
			playerChoice = input.nextLine();
			//playerChoice = checkInput(playerChoice);
			inputLoop = checkInput(playerChoice);
			
			/*if (!playerChoice.equals("wrong")) {
				inputLoop = false;
			}*/
		
		}
		
		//input.close();
		
		return fixInput(playerChoice);
		
	}
	
	
	
	public static boolean checkInput(String s) {
		
		boolean trueNameValue = false;
		
		
		String inputNormalized = s.toLowerCase();	
		
		
		if (inputNormalized.equals("rock")  || inputNormalized.equals("paper")  || inputNormalized.equals("scissor")  ) {
			trueNameValue = true;
		} else if (inputNormalized.equals("1")  || inputNormalized.equals("2")  || inputNormalized.equals("3")) {
			trueNameValue = true;
			//s = fixInput(s);
		} else {
			//System.out.println("Wrong input, try again!");
			trueNameValue = false;
		}
		
		
		/*if (trueNameValue) {
			return s;
		} else {
			s = "wrong";
			return s;
		}*/
		
		return trueNameValue;
		
		
	}
	
	public static String fixInput(String choice) {
		
		if (choice.equals("1")) {
			choice = "rock";
		} else if (choice.equals("2") ) {
			choice = "paper";
		} else if (choice.equals("3")) {
			choice = "scissor";
		} else {
			choice = choice.toLowerCase();
		}
		
		return choice;
			
	}
	
	public static void determineWinner(String s1, String s2) {
		
		int winner = 0;
		
		if (s1.equals(s2) ) {
			winner = 3;
		} else if (s1.equals("rock") ) {
			if (s2.equals("paper")) {
				winner = 2;
			} else if (s2.equals("scissor")) {
				winner = 1;
			}			
		} else if (s1.equals("paper")) {
			if (s2.equals("rock"))  {
				winner = 1;
			} else if (s2.equals("scissor")) {
				winner = 2;
			}
		} else if (s1.equals("scissor")) {
			if (s2.equals("rock")) {
				winner = 2;
			} else if (s2.equals("paper")) {
				winner = 1;
			}
		}
		
		winnerOutput(winner);
		
	}
	
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
	
	
	
	

}