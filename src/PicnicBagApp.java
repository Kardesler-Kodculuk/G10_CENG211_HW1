import java.util.Scanner;

public class PicnicBagApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Conduct Testing Here.
		IBag<Item> inventory = FileIO.readInventory();
		
		// Select bag size 
		String picnicSize = null;
		System.out.println("Select a bag size:\n"
				+ "1 for Small (5)\n"
				+ "2 for Normal (10)\n"
				+ "3 for Large (15)");
		Scanner input = new Scanner(System.in);
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
		PicnicBag<Item> picnic = new PicnicBag<Item>(picnicSize);
		
		// Item select for picnic
		inventory.displayItems();
		System.out.println("Please enter the ID of the stuff "
				+ "you want to take with you. When finished, "
				+ "enter 0.");
		boolean enoughSpace;
		int prompt = input.nextInt();
		while (prompt != 0) {
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
			inventory.displayItems();
			prompt = input.nextInt();
			
		}
		System.out.println("You are goin to the picnic now...");
		

		// Creates the trash bags
		@SuppressWarnings("unchecked")
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
