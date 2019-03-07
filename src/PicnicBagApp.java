import java.util.Scanner;

public class PicnicBagApp {

	public static void main(String[] args) {
		// Conduct Testing Here.
		FileIO fileInterface = new FileIO("CENG112_Homework1_Bags_Inventory.txt");
		IBag<Item> inventory = fileInterface.readInventory();
		IBag<Item> picnic = new PicnicBag<Item>("large");
		System.out.println("Please enter the ID of the stuff"
				+ "you want to take with you. When finished,"
				+ "enter -1.");
		int prompt = 0;
		boolean enoughSpace;
		Scanner input = new Scanner(System.in);
		 while (prompt != -1) {
			prompt = input.nextInt();
			Item item = inventory.removeByIndex(prompt);
			if (item != null) {
				inventory.add(item);
				enoughSpace = inventory.transferTo(picnic, item);
				if (!enoughSpace) {
					System.out.println("No more space in picnic box, exiting loop...");
					break;
				}
			} else {
				System.out.println("Item doesn't exist.");
			}
		}
		input.close();
		System.out.println("You are goin to the picnic now...");
	}
	

}
