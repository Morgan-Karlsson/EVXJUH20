package inlmn4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {

public static String COMMA_DELIMITER = ",";
	

	public static void main(String[] args) {
		
		int count = 0;

		List<List<String>> records = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("sample.csv"));) {
			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(List<String> b:records){ 
			System.out.println(b);
			count += countLetters("a", b);
			
		}
		
		
		System.out.println("Det finns " + count + " personer med bokstaven a i sitt namn");
		
		sameTime(records);

	}

	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		
		
		return values;
	}
	
	/*
	 * Check columns with the names except the column that contains the word "group".
	 * Returns an int that represents the number of the letter.
	 */
	private static int countLetters(String letter, List<String> values) {
		
		int count = 0;
		
		if(!values.get(1).contains("group")) {
			
			/*
			 * 1st check is checking both columns for the letter "a" and adds 2 to the counter.
			 * 2nd check is if just column 1 is containing "a".
			 * And 3rd check for column 2.
			 */
			if(values.get(1).toLowerCase().contains(letter) && values.get(2).toLowerCase().contains(letter)) {
				count = count+2;
			} else if (values.get(1).toLowerCase().contains(letter)) {
				count++;
			} else if (values.get(2).toLowerCase().contains(letter)){
				count++;
			}
		}
		
		return count;
	}
	
	private static void sameTime(List<List<String>> l) {
		
		String names = new String();
		
		/*
		 * Loops through all the rows in the outer loop and the rows backwards in the inner loop. The inner loop goes through each row except the one that
		 * the outer loop is on. 
		 * Then checks in the Timestamp column if the value matches any other value in that column. Builds a string that it then prints with the names corresponding
		 * to the timestamp.
		 */
		for(int i=0; i<l.size(); i++) {
			for(int j=l.size()-1; j>i; j--) {
				if (l.get(i).get(0).equals(l.get(j).get(0)) && !l.get(i).get(0).equals(""))  {
					names = l.get(i).get(1) + " " + l.get(i).get(2) + " & " + l.get(j).get(1) + " " + l.get(j).get(2);
					System.out.println(names);	
				}
				
			}
			
		}
		
	}
}
