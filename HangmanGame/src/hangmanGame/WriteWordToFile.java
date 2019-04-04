package hangmanGame;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class WriteWordToFile {
	// write a word to dictionary(csv file)
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
			
			
			csvPrinter.flush();
			csvPrinter.close();
			pw.close();
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} 

	}
}
