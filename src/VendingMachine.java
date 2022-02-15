import java.util.Locale;
import java.util.Scanner;

public class VendingMachine
{
	static Scanner input;
	static String[] snacks;
	static double[] prices;
	static int snackIndex;
	static double money;

	public static void main(String[] args)
	{
		snacks = new String[]{"Chips", "Cookies", "Gum", "Pretzels", "Crackers"};
		prices = new double[]{1.50, 1.50, 0.50, 1.00, 1.00};

		input = new Scanner(System.in);
		money = promptMoney(input);
		snackIndex = promptSnack(input, snacks, prices);

		if(money < prices[snackIndex])
		{
			System.out.println("You can't afford this item.  Please insert more money.");

			//If the user is broke, run the whole program again to give them another chance.
			main(args);
			return;
		}
		else confirmPurchase();

		System.out.printf("$%.2f is your change.%n", money);
	}


	public static boolean confirmPurchase()
	{
		boolean confirm = promptUser(
				input,
				"Are you sure you want to buy " + snacks[snackIndex].toLowerCase() + "?",
				new String[]{"No", "Yes"}
		) == 1; // "Yes" is second (index 1)

		if (confirm) {
			money -= prices[snackIndex];
			System.out.println("Transaction confirmed. Enjoy your " + snacks[snackIndex].toLowerCase() + "!");
		} else {
			System.out.println("Transaction cancelled.  Goodbye");
		}

		return confirm;
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
