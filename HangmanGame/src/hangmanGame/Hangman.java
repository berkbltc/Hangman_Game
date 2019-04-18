package hangmanGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {
	
	public static boolean isUnexpectedLetter(char ch) {
		if( (ch-'a' >= 0) && (ch-'a' < 26) ) {
			return false ;
		}
		return true; 
	}
	
	public static void displayWord (String name,List<Character> guess) {
		for(int i=0; i<name.length(); i++)  
			System.out.print(guess.get(i) + " ");
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			
			boolean[] label = new boolean[26]; // all of them false at beginning
			
			System.out.println("Welcome to the HANGMAN !\n");
			System.out.println("1)Start a round\n"
					+ "2)Add a new word to dictionary\n"
					+ "3)Exit\n");
			
			System.out.print("Please select your choice:");
			int choice=scan.nextInt();
			switch(choice) {

			case 1 : //Take name and password from user and start a round.

				System.out.println("\n***** The round is starting... *****\n");
				ReadWordsFromFile rw = new ReadWordsFromFile();
				List<Character> guess = new ArrayList<Character>();
				int lifeChances=8; 
				Pair<String,String> word = rw.readWordFromCSV("dictionary.csv");
				String name = word.x , definition = word.y; 
				//System.out.println("The word is   : " + name );
				Drawer myDrawer = new Drawer();

				for(int i=0; i<name.length(); i++) 
					guess.add('_');
				
				myDrawer.drawTheMan(lifeChances);
				System.out.print("Guess this word : ");
				displayWord (name,guess);
				System.out.println("");

				int count = name.length();
				char[] charsOfWord = name.toCharArray();

				while(lifeChances!=0 && count!=0) {

					System.out.print("Guess a letter in the word : ");
					char ch = scan.next().charAt(0);
					
					if( !isUnexpectedLetter(ch) && (label[ch - 'a'] == false) ) { 
						// control for used or an unexpected character
						boolean flag = false;
						for(int i=0; i<name.length(); i++) { 
							if(charsOfWord[i] == ch ) {
								guess.set(i, ch);
								count--;
								flag=true;
							}
						}	
						if(flag==false)
							lifeChances--;
						if(flag==false &&lifeChances!=0 && count!=0) 
							System.out.println("  You have " + lifeChances + " life chances !");
						myDrawer.drawTheMan(lifeChances);
						displayWord (name,guess);
						System.out.println("");
						label[ch - 'a']=true;
					}
					else {
						System.out.println("You are already used this letter or it is an unexpected character!");
					}
				}
				if(lifeChances!=0)
					System.out.println("\nYou found the word and got " + lifeChances +" points :) ");
				else
					System.out.println("\nYou are hanged :( \n  The word was : " + word.x );
				System.out.println("Do you want to see the definition of the word? "
						+ "\n(Type 1 for Yes, other numbers for No)");
				int c = scan.nextInt();
				if(c == 1) 
					System.out.println("The definition is  : " + definition );
				System.out.println("\n***** The round is over! *****\n\n");
				
				break; 

			case 2 : //Take a word and its definition from user and add them to the dictionary
				WriteWordToFile fw = new WriteWordToFile();
				System.out.println("Type the word you want to add:");
				scan.nextLine();
				String newWord=scan.nextLine();
				if(!fw.writeAWordToDictionary(newWord))
					System.out.println("Incorrect word name!(Only lowercase English letters(a-z) are allowed)");
				else
					System.out.println("'"+newWord+"'"+" is added to dictionary!");

				break;

			case 3 : //Exit the program
				System.out.println("\nThe program will be terminated. Are you sure?\n"
						+ "(Type 1 for Yes, 2 for going back to Menu");
				int end=1;
				while(end!=1 || end!=2) {
					end=scan.nextInt();
					if(end==1) {
						System.out.println("The program is terminating. Good bye :) ");
						System.exit(0);
					}else {
						break;
					}
				}

				break;

			default : // Wrong Input!
				System.out.println("Wrong Input!");
				
			}
		}
	}
}
