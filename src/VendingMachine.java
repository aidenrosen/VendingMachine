public class VendingMachine
{
	public static void main(String[] args)
	{
		String[] snacks = {"Chips", "Cookies", "Gum", "Pretzels", "Crackers"};
		String[] prices = {"$1.50", "$1.50", "$0.50", "$1.00", "$1.00"};
		System.out.println("Welcome!  Please enter the amount of money to insert, followed by the number associated with the snack you want (in a separate line).");
		for(int i = 0; i < snacks.length; i++)
		{
			System.out.println(i + 1 + ": " + snacks[i] + ", " + prices[i]);
		}

		//TODO: Allow for user input (commit 2)
		//TODO: Connect the user input to which snack they want with confirmation(commit 3)
		//TODO: Subtract price of snack to amount given.  Give change and goodbye message if they have enough, give error if they don't.
	}
}
