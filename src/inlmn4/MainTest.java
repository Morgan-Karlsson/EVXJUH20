package inlmn4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {

public static String COMMA_DELIMITER = ",";
	

	public static void main(String[] args) {

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
			
		}
		
		
		

	}

	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		
		int count = 0;
		
		for(int i=0; i<values.size(); i++) {
			
			
			if(values.get(1).contains("a") || values.get(2).contains("a")) 
				count++;
		}
		 
		System.out.println(count-2);
		
		
		return values;
	}
}
