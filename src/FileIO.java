import java.io.*;
import java.util.StringTokenizer;

/** FileIO class handles the inventory
 */
public class FileIO {
	
	/** Read the file to determine its line count/size
	 * 
	 * @param fileName - Name of the file
	 * @return line count if sucessful
	 * @return -1 if file not found
	 * @return -2 if ioException.
	 */
	
	private static int determineFileSize(String fileName) {
		try {
			// Determine the size of the file.
			int lineCount = 0;
			BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
			while (fileIn.ready()) {
				fileIn.readLine();
				lineCount++;
			}
			fileIn.close();
			return lineCount;
		} catch (FileNotFoundException e) {
			return -1;
		} catch (IOException e) {
			return -2;
		}
	}
	
	private static boolean populateLinesArray(int lineCount, String[] linesArray, String fileName) {
		try {
			// Read the file now.
			BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
			/* Now I can use lineLength rather than while loop
			 * Since I know the length of the file, and can use the i
			 * for assignment.*/
			
			for (int i = 0; i < lineCount; i++) {
				linesArray[i] = fileIn.readLine();
			}
			fileIn.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}
	
	/**Determine the inventory size
	 * so that the lines array may be initialised.
	 * and then Populate the inventoryBag and return it.
	 * 
	 * @return inventoryBag object holding the inventory.
	 * @return null if unsucessfull.
	 */
	
	public static InventoryBag<Item> readInventory() {
		// TODO implement the updated version  public static InventoryBag<Item> readInventory();
		String fileName = "CENG112_Homework1_Bags_Inventory.txt";
		int lineCount = determineFileSize(fileName);
		String[] linesArray = new String[lineCount];
		Item[] items= new Item[lineCount];
		int[] itemCounts = new int[lineCount];
		populateLinesArray(lineCount, linesArray, fileName); //Populate the lines array

		
		StringTokenizer commaSeperator;
		String name;
		String disposableType;
		int number;
		int sum = 0;
		
		/** Populating the other arrays.
		 * This is done via splitting each element of line array,
		 * And creating items and item lists, which are used to populate
		 * The inventoryBag.
		 */
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
