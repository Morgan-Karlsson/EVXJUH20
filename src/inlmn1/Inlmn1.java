package inlmn1;

import java.util.Scanner;

public class Inlmn1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variable initialising. 
		String password = "password";
		String compare;
		Scanner input = new Scanner(System.in);
		int counter = 3;
		boolean checkPassword = false;
		
		
	do {	
		
		//User input
		System.out.println("Input password: ");
		compare = input.next();
		
		//Compares the already initialised string to the string containing the user input.
		//Changes the boolean value from false to true to exit the loop
		if(password.equals(compare)) {
			System.out.println("Correct password");
			checkPassword = true;

		//Decreases the counter value and prints it so the user know how many tries that are left.	
		} else {
			counter--;
			System.out.println("Wrong password, try again. " + counter + " tries remaining");
			
		} 
	} while(checkPassword==false && counter>0);
	
	//Check the value of the counter. If the value is zero then it assumes that the user used to many
	//tries 
	if (counter==0) {
		System.out.println("Too many tries");
	}
		
		
		input.close();
		
		

	}

}
