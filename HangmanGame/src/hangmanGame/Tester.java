package hangmanGame;

import static org.junit.Assert.*;
import org.junit.Test;

public class Tester {

	@Test
	public void shouldReturnTrueIfUnexpectedLetter() {

		boolean expected = true;
		boolean actual = Hangman.isUnexpectedLetter('4');
		assertEquals(expected,actual);
		actual = Hangman.isUnexpectedLetter('ç');
		assertEquals(expected,actual);
		actual = Hangman.isUnexpectedLetter('*');
		assertEquals(expected,actual);
		actual = Hangman.isUnexpectedLetter('T');
		assertEquals(expected,actual);
		actual = Hangman.isUnexpectedLetter('<');
		assertEquals(expected,actual);		
	}
	
	@Test
	public void shouldReturnFixedString() {
		
		ReadWordsFromFile sut = new ReadWordsFromFile();
		String expected = "love";
		String actual = sut.purifyWord("LOVE");
		assertEquals(expected,actual);
		actual = sut.purifyWord("lov*?^e");
		assertEquals(expected,actual); 
	}
	
	@Test
	public void shouldReturnNotEmptyString() {
		
		ReadWordsFromFile sut = new ReadWordsFromFile();
		String actual = sut.readWordFromCSV("dictionary.csv").x;
		assertNotNull(actual);
		assertNotEquals("",actual);		
	}	
	
	@Test
	public void shouldReturnTrueIfWrittenWordIsProper() {
		
		WriteWordToFile sut = new WriteWordToFile();
		boolean expected = true ;
		boolean actual = sut.writeAWordToDictionary("berk") ;
		assertEquals(expected,actual);
		expected = false ;
		actual = sut.writeAWordToDictionary("b3Rk?") ;
		assertEquals(expected,actual); 
	}

}
