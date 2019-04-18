package hangmanGame;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.*;
import java.io.FileNotFoundException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ReadWordsFromFile {
	// read words from a .csv file
	public String purifyWord(String word) {
		char[] punctuations = "~!@#$%^&*()_+{}|:<>?-=[];\'./,\"".toCharArray() ;
		char[] pureKeyword = word.toCharArray();
		for(int i=0 ; i<pureKeyword.length;i++) {
			for(int j=0;j<punctuations.length;j++) {
				if(pureKeyword[i] == punctuations[j]) {
					pureKeyword[i]=' ' ;
					break; 
				}
			} 		 
		}
		word=new String(pureKeyword);
		word=word.replaceAll(" +","").toLowerCase();
		return word;
	}

	public Pair<String,String> readWordFromCSV(String fileName)  {

		FileReader pw;  	
		Pair<String, String> word = null ;

		try {
			pw = new FileReader( fileName );
			CSVParser csvParser = new CSVParser(pw, CSVFormat.DEFAULT);
			List<CSVRecord> rowList = csvParser.getRecords();
			Random r = new Random(); 
			int rowNumber = r.nextInt(54535);

			CSVRecord row = rowList.get(rowNumber);
			word = new Pair<String, String>(row.get(0), row.get(2));

			csvParser.close();
			pw.close();
			word.x=purifyWord(word.x);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return word;
	}
}
