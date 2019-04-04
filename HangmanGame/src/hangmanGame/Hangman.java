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
	//
	public static void main(String[] args) {

		boolean[] label = new boolean[26]; // all of them false at beginning

		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to the HANGMAN !\n");
			System.out.println("1)Start a round\n"
					+ "2)View High Score List\n"
					+ "3)Add a new word to dictionary\n"
					+ "4)Exit\n");
			System.out.print("Please select your choice:");

			int choice=scan.nextInt();

			switch(choice) {

			case 1 : //Take name and password from user and start a round.
				
				System.out.println("\n***** The round is starting... *****\n");
				ReadWordsFromFile rw = new ReadWordsFromFile();
				List<Character> guess = new ArrayList<Character>();

				String word = rw.readWordFromCSV("dictionary.csv");
				//System.out.println("The word is   : " + word );

				for(int i=0; i<word.length(); i++) 
					guess.add('_');
				System.out.print("Guess this word : ");
				for(int i=0; i<word.length(); i++) { 
					System.out.print(guess.get(i));
					System.out.print(" ");
				}
				System.out.println("");
				int lifeChances=8; 
				int count = word.length();
				char[] charsOfWord = word.toCharArray();

				while(lifeChances!=0 && count!=0) {

					System.out.print("Guess a letter in the word : ");
							// PLEASE TYPE ONLY LOWERCASE LETTERS.
					char ch = scan.next().charAt(0);
					//
					if( !isUnexpectedLetter(ch) && (label[ch - 'a'] == false) ) { 
						// control for used or an unexpected character
						boolean flag = false;
						for(int i=0; i<word.length(); i++) { 
							if(charsOfWord[i] == ch ) {
								guess.set(i, ch);
								count--;
								flag=true;
							}
						}
						for(int i=0; i<word.length(); i++) { 
							System.out.print(guess.get(i));
							System.out.print(" ");
						}
						System.out.println("");

						if(flag==false)
							lifeChances--;

						if(flag==false &&lifeChances!=0 && count!=0) 
							System.out.println("  You have " + lifeChances + " life chances !");

						label[ch - 'a']=true;
					}
					else {
						System.out.println("You are already used this letter or it is an unexpected character!");
					}
				}

				if(lifeChances!=0)
					System.out.println("\nYou found the word and got " + lifeChances +" points :) ");
				else
					System.out.println("\nYou are out of your lifechances :( \n  The word was : " + word );

				System.out.println("\n***** The round is over! *****\n\n");

				break; 

			case 2 : //Display High Score List

				break; 

			case 3 : //Take a word from user and add it to the dictionary
				WriteWordToFile fw = new WriteWordToFile();
				break;

			case 4 : //Exit the program
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