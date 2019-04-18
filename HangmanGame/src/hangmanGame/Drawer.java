package hangmanGame;

public class Drawer {
	public void drawTheMan(int lifechances) {
		String figure = null ;
		switch (lifechances) { 
		//I get this ASCII figures from https://code.sololearn.com/cR7XYX7xVY5F/#py
		case 8:
			figure="-----\r\n" + 
					"|   \r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"--------";
			break;

		case 7:
			figure ="-----\r\n" + 
					"|   |\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"--------";
			break;
		case 6:
			figure="-----\r\n" + 
					"|   |\r\n" + 
					"|   0\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"--------";
			break;
		case 5:
			figure="-----\r\n" + 
					"|   |\r\n" + 
					"|   0\r\n" + 
					"|  -+-\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"--------";
			break;
		case 4:
			figure="-----\r\n" + 
					"|   |\r\n" + 
					"|   0\r\n" + 
					"| /-+-\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"--------";
			break;
		case 3:
			figure="-----\r\n" + 
					"|   |\r\n" + 
					"|   0\r\n" + 
					"| /-+-\\ \r\n" + 
					"|   | \r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"--------";
			break;
		case 2:
			figure="-----\r\n" + 
					"|   |\r\n" + 
					"|   0\r\n" + 
					"| /-+-\\ \r\n" + 
					"|   | \r\n" + 
					"|   | \r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"|\r\n" + 
					"--------";
			break;
		case 1:
			figure="-----\r\n" + 
					"|   |\r\n" + 
					"|   0\r\n" + 
					"| /-+-\\ \r\n" + 
					"|   | \r\n" + 
					"|   | \r\n" + 
					"|  | \r\n" + 
					"|  | \r\n" + 
					"|\r\n" + 
					"--------";
			break;
		case 0:
			figure="-----\r\n" + 
					"|   |\r\n" + 
					"|   0\r\n" + 
					"| /-+-\\ \r\n" + 
					"|   | \r\n" + 
					"|   | \r\n" + 
					"|  | | \r\n" + 
					"|  | | \r\n" + 
					"|\r\n" + 
					"--------";
			break;

		}
		System.out.println(figure);
	}
}
