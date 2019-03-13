import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/** FileIO class handles the inventory
 */
public class FileIO {
	/**Determine the inventory size
	 * so that the lines array may be initialised.
	 * and then Populate the inventoryBag and return it.
	 * 
	 * @return inventoryBag object holding the inventory.
	 * @return null if unsucessfull.
	 */
	public static InventoryBag<Item> readInventory() {
		// TODO implement the updated version  public static InventoryBag<Item> readInventory();
		String[] linesArray;
		Item[] items;
		int[] itemCounts;
		String fileName = "CENG112_Homework1_Bags_Inventory.txt";
		try {
			// Determine the size of the file.
			int lineCount = 0;
			BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
			while (fileIn.ready()) {
				fileIn.readLine();
				lineCount++;
			}
			fileIn.close();
			// Read the file now.
			fileIn = new BufferedReader(new FileReader(fileName));
			linesArray = new String[lineCount];
			items = new Item[lineCount];
			itemCounts = new int[lineCount];
			/* Now I can use lineLength rather than while loop
			 * Since I know the length of the file, and can use the i
			 * for assignment.*/
			
			for (int i = 0; i < lineCount; i++) {
				linesArray[i] = fileIn.readLine();
			}
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		 // Check if it errors out.
		StringTokenizer commaSeperator;
		String name;
		String disposableType;
		int number;
		int sum = 0;
		// Populating the arrays.
		for (int i = 0; i < linesArray.length; i++) {
			commaSeperator = new StringTokenizer(linesArray[i], ",");
			name = commaSeperator.nextElement().toString();
			disposableType = commaSeperator.nextElement().toString();
			number = Integer.parseInt(commaSeperator.nextElement().toString());
			items[i] = new Item(name, disposableType);
			itemCounts[i] = number;
		}
		//Finding the size for the inventory
		
		for(int i = 0; i < itemCounts.length; i++) {
			sum += itemCounts[i];
		}
		
		//Initialise the InventoryBag
		
		InventoryBag<Item> inventory = new InventoryBag<Item>(sum);
		
		// Iteratively adding the items
		
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < itemCounts[i]; j++) {
				inventory.add(items[i]);
			}
		}

		return inventory;
	}
}
