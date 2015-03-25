/**
 * 
 */
package $test;

import java.util.Random;
import java.util.Scanner;

/**
 * @author MAANESHWAR
 * 
 */
public class Guessing_Game {

	public static void main(String[] args) {
		GuessMyNo();
	}

	public static void GuessMyNo() {
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 100, user = 0, comp = 0;
		String userInput;
		try {
			System.out.print("Guess a number between 1 and 100: ");
			user = scan.nextInt();
			if (user > 0 && user <= 100) {
				do {
					comp = random.nextInt(max - min + 1) + min;
					System.out.println("Is the number " + comp + "?");
					userInput = scan.next();
					if (userInput.trim().equalsIgnoreCase("higher")) {
						min = comp;
					} else if (userInput.trim().equalsIgnoreCase("lower")) {
						max = comp;
					} else if (userInput.trim().equalsIgnoreCase("yes")) {
						System.out.println("Great. We are done.");
						System.out.println("Would you like to play again y/n?");
						String playAgain = scan.next();
						if (playAgain.trim().equalsIgnoreCase("y")
								|| playAgain.trim().equalsIgnoreCase("yes")) {
							GuessMyNo();
						} else {
							System.out.println("See you Next Time");
						}
					} else if (userInput.trim().equalsIgnoreCase("end")) {
						System.out.println("See you Next Time");
					} else {
						System.out.println("Invalid Input.");
						userInput = scan.next();
					}
				} while (user != comp);
			} else {
				System.out
						.println("You should Guess a number between 1 and 100");
				GuessMyNo();
			}
		} catch (Exception e) {
			System.err.println("Exception while Guessing the Number. caused by "+ e.getMessage());
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}
}
