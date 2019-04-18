package hangmanGame;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.util.Scanner;

public class WriteWordToFile {
	// write a word and its definition to dictionary(.csv file)
	public boolean writeAWordToDictionary(String word) {

		FileWriter pw;
		try { 
			pw = new FileWriter("dictionary.csv",true);
			CSVPrinter csvPrinter = new CSVPrinter( pw, CSVFormat.DEFAULT );

			char[] lettersOfWord = word.toCharArray();
			for(char ch : lettersOfWord) {
				if( (ch-'a' < 0) || (ch-'a' > 26) ) {
					csvPrinter.flush();
					csvPrinter.close();
					pw.close();
					return false;
				}
			}
			Scanner scan = new Scanner(System.in);
			System.out.println("Type the definition of this word:");
			String definition =  scan.nextLine();
			csvPrinter.printRecord((String) word,"x",definition);

			csvPrinter.flush();
			csvPrinter.close();
			pw.close();
			scan.close();
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} 

	}
}
