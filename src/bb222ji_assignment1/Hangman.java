package bb222ji_assignment1;

import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {
		System.out.println("Welcome to the HANGMAN !");
		System.out.println("1)Start a round\n"
				+ "2)View High Score List\n"
				+ "3)Add a new word to dictionary\n"
				+ "4)Exit\n");
		System.out.print("Please select your choice:");
		Scanner scan = new Scanner(System.in);
		int choice=scan.nextInt();
		
		switch(choice) {
		
		   case 1 : //Take name and password from user
		      
		      break; 
		   
		   case 2 : //Display High Score List
		      
		      break; 
		   
		   case 3 : //Take a word from user and add it to the dictionary
			   
			  break;
			  
		   case 4 : //Exit the program
			   System.exit(1);
			   break;
			   
		   default : // Wrong Input!
		      System.out.println("Wrong Input!");
		}
		scan.close();
	}
}
