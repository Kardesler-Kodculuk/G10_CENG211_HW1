import java.util.Scanner;

public class PicnicBagApp {

	public static void main(String[] args) {
		// Conduct Testing Here.
		FileIO fileInterface = new FileIO("CENG112_Homework1_Bags_Inventory.txt");
		IBag<Item> inventory = fileInterface.readInventory();
		PicnicBag<Item> picnic = new PicnicBag<Item>("small");
		System.out.println("Please enter the ID of the stuff "
				+ "you want to take with you. When finished, "
				+ "enter -1.");
		boolean enoughSpace;
		Scanner input = new Scanner(System.in);
		int prompt = input.nextInt();
		while (prompt != -1) {
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
			prompt = input.nextInt();
		}
		input.close();
		System.out.println("You are goin to the picnic now...");
		
		@SuppressWarnings("unchecked")
		IBag<Item>[] trashBags = (IBag<Item>[]) new Object[3]; // TODO fix
		trashBags[0] = new OrganicTrashBag<Item>(); // fix also
		trashBags[1] = new PlasticTrashBag<Item>(); // fix also
		trashBags[2] = new PaperTrashBag<Item>(); // fix also
		
		while(prompt != 0)
		{
			System.out.println("Enter the item number that you wanna consume. "
					+ "When finished, enter 0.");
			picnic.displayItems();
			prompt = input.nextInt();
			picnic.consume(picnic.getItem(prompt - 1), trashBags);
		}
		System.out.println("Organic trashs" + trashBags[0].getItemCount());
		trashBags[0].displayItems();
		System.out.println("Plastic trashs" + trashBags[1].getItemCount());
		trashBags[1].displayItems();
		System.out.println("Paper trashs" + trashBags[2].getItemCount());
		trashBags[2].displayItems();
		
		for(int i = 0; i <= 2; i++)
		{
			trashBags[i].dump();
		}
		
		
		
		
		
		// ----------------------------------------------------------------
		// Don't ask about this testing chaos!
//		PicnicBag<String> bagLarge = new PicnicBag<String>("large");
//		PicnicBag<String> bagNormal = new PicnicBag<String>("normal");
//		PicnicBag<String> bagSmall = new PicnicBag<String>("small");
//		System.out.println(bagSmall.isEmpty());
//		System.out.println(bagSmall.isFull());
//		bagSmall.add("banana");
//		bagSmall.add("banana");
//		bagSmall.add("egg");
//		bagSmall.add("egg");
//		bagSmall.add("lemon");
//		bagSmall.displayItems();
//		System.out.println(bagSmall.getItemCount());
//		bagSmall.remove("banana");
//		bagSmall.removeByIndex(2);
//		bagSmall.remove();
//		bagSmall.displayItems();
//		System.out.println(bagSmall.getItemCount());
//		bagSmall.add("e");
//		bagSmall.add("e");
//		bagSmall.add("e");
//		bagSmall.add("e");
//		bagSmall.displayItems();
//		System.out.println(bagSmall.getItemCount());
//		System.out.println(bagSmall.isEmpty());
//		bagNormal.remove();
//		bagSmall.remove("lemon");
//		System.out.println(bagSmall.getIndexOf("egg"));
//		System.out.println(bagSmall.getIndexOf("salam"));
//		bagSmall.dump();
//		bagSmall.add("lemon");
//		bagSmall.displayItems();
//		bagSmall.transferTo(bagNormal, "lemon");
//		bagSmall.transferTo(bagNormal, "egg");
//		bagSmall.displayItems();
//		bagNormal.displayItems();
//		bagSmall.add("egg");
//		bagSmall.add("banana");
//		bagSmall.consume("banana");
//		bagSmall.consume("milk");
//		bagSmall.displayItems();
//		bagSmall.removeByIndex(3);
//		bagLarge.getItemCount();		
		
	}
	

}
