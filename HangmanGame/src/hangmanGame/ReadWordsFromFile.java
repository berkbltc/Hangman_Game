package hangmanGame;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	public String readWordFromCSV(String fileName)  {
		
		//char[] punctuations = "~!@#$%^&*()_+{}|:<>?-=[];\'./,\"".toCharArray() ;
    	FileReader pw;
    	String word="" ;
		try {
			pw = new FileReader( fileName );
	        CSVParser csvParser = new CSVParser(pw, CSVFormat.DEFAULT);
	        List<CSVRecord> rowList = csvParser.getRecords();
	        Random r = new Random(); 
	        int rowNumber = r.nextInt(54535);
	        //System.out.println("Row Number is:" + rowNumber);
	        CSVRecord row = rowList.get(rowNumber);
	        //word = row.get(0);
	        word = "bass";
	        csvParser.close();
	        pw.close();
	        word=purifyWord(word);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return word;
	}
}
