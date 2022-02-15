import java.util.Scanner;

public class VendingMachine
{
	public static void main(String[] args)
	{
		String[] snacks = {"Chips", "Cookies", "Gum", "Pretzels", "Crackers"};
		double[] prices = {1.50, 1.50, 0.50, 1.00, 1.00};

		Scanner input = new Scanner(System.in);
		double money = promptMoney(input);
		int snackIndex = promptSnack(input, snacks, prices);

		//TODO: Connect the user input to which snack they want with confirmation(commit 3)
		//TODO: Subtract price of snack to amount given.  Give change and goodbye message if they have enough, give error if they don't.
	}

	public static double promptMoney(Scanner input) {
		while (true) {
			System.out.println("Welcome!  Please enter the amount of money to insert:");
			try {
				return Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("That's not a valid amount. Please make sure you are only inserting $1 bills.");
			}
		}
	}

	public static int promptSnack(Scanner input, String[] snacks, double[] prices) {
		String[] options = new String[snacks.length];
		for (int i = 0; i < snacks.length; i++) {
			options[i] = String.format("[$%.2f] %s", prices[i], snacks[i]);
		}

		return promptUser(
			input,
			"Please enter the number associated with the snack you want:",
			options
		);
	}

	// Prompt the user for a decision, e.g. yes/no questions, or a selection, and return the index
	public static int promptUser(Scanner input, String question, String[] options) {
		while (true) {
			// Ask the question
			System.out.println(question);
			for (int i = 0; i < options.length; i++) {
				System.out.println(i + ") " + options[i]);
			}
			System.out.print("=> ");

			String line = input.nextLine();

			try {
				int choice = Integer.parseInt(line);
				if (choice >= 0 && choice < options.length) {
					return choice;
				}
				// Must have been out of range
			} catch (NumberFormatException e) {
				// Invalid number
			}

			System.out.println("That's not a valid option. Please try again.");
			// Back to top!
		}
	}
}
