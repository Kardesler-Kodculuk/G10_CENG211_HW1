import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class PicnicBagApp {

	/**
	 * Ask the user the size of the picnic bag
	 * @param input - Scanner object for user input
	 * @return null if wrong.
	 * @return small for user input 1.
	 * @return normal for user input 2.
	 * @return large for user input 3.
	 */
	private static String determinePicnicBagSize(Scanner input) {
		String picnicSize = null;
		System.out.println("Select a bag size:\n"
				+ "1 for Small (5)\n"
				+ "2 for Normal (10)\n"
				+ "3 for Large (15)");
		int sizeSelection = input.nextInt();

		switch(sizeSelection)
		{
		case 1:
			picnicSize = "small";
			break;
		case 2:
			picnicSize = "normal";
			break;
		case 3:
			picnicSize = "large";
			break;
		}
		return picnicSize;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Conduct Testing Here.
		IBag<Item> inventory = FileIO.readInventory();
		Scanner input = new Scanner(System.in);
		// Select bag size 
		String picnicSize;
		
		// Will loop as long as the user doesn't enter an acceptable input.
		do {
			picnicSize = determinePicnicBagSize(input);
			if (picnicSize != null) break;
			System.out.println("Please enter an acceptable input");
		} while (true);

		PicnicBag<Item> picnic = new PicnicBag<Item>(picnicSize);
		
		// Item select for picnic
		inventory.displayItems();
		System.out.println("Please enter the ID of the stuff "
				+ "you want to take with you. When finished, "
				+ "enter 0.");
		int prompt = input.nextInt();
		while (prompt != 0) {
			Item item = inventory.removeByIndex(prompt - 1); // If the item is removable
			if (item != null) { // That means item does exist, so it can be transferred
				inventory.add(item); // We add the item back, so it won't make a change
				inventory.transferTo(picnic, item); // And then transfer.
				if (picnic.isFull()) {
					System.out.println("No more space in picnic box, exiting loop...");
					break;
				}
			} else {
				System.out.println("Item doesn't exist.");
			}
			inventory.displayItems();
			prompt = input.nextInt();
			
		}
		System.out.println("You are goin to the picnic now...");
		

		// Creates the trash bags
		IBag<Item>[] trashBags = new IBag[3];
		trashBags[0] = new OrganicTrashBag<Item>();
		trashBags[1] = new PlasticTrashBag<Item>();
		trashBags[2] = new PaperTrashBag<Item>();		
		
		// Now in picnic. User can consume items or/and end the picnic
		prompt = -1;
		while(prompt != 0)
		{
			System.out.println("Enter the item number that you wanna consume. "
					+ "When finished, enter 0.");
			picnic.displayItems();
			prompt = input.nextInt();
			if(prompt != 0) {
				picnic.consume(picnic.getItem(prompt - 1), trashBags);
			}
			if(picnic.getItemCount() == 0) {
				System.out.println("All items consumed.");
				break;
			}
		}
		input.close();
		
		// Prints the trashes and the number of the trashes in the trash bags
		System.out.println("Organic trashes: " + trashBags[0].getItemCount());
		trashBags[0].displayItems();
		System.out.println("Plastic trashes: " + trashBags[1].getItemCount());
		trashBags[1].displayItems();
		System.out.println("Paper trashes: " + trashBags[2].getItemCount());
		trashBags[2].displayItems();
		
		// Dumps the trash bags
		for(int i = 0; i <= 2; i++)
		{
			trashBags[i].dump();
		}
		
		System.out.println("The trashes are dumped!");
		
	}
	

}
