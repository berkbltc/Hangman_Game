package bb222ji_assignment2;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class WriteWordToFile {
	// write a word to dictionary(csv file)
	public void writeAWordToDictionary() {

		FileWriter pw;
		try {

			pw = new FileWriter("dictionary.csv",true);
			CSVPrinter csvPrinter = new CSVPrinter( pw, CSVFormat.DEFAULT );
			
			//
			csvPrinter.flush();
			csvPrinter.close();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}
