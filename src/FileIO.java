import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/** FileIO class handles the inventory
 */
public class FileIO {
	
	private String[] linesArray;
	private int[] itemCounts;
	private Item[] items;
	private String fileName;
	
	/** Initilise a fileIO object with a fileName.
	 * 
	 * @param fileName
	 */
	public FileIO(String fileName) {
		this.fileName = fileName;
	}
	
	/** A private method to determine the inventory size
	 * so that the lines array may be initilised.
	 * @param fileName - Name of the file to be parsed
	 * @return true if successful.
	 * @return false if unsuccessful.
	 */
	private boolean readInventoryFile(String fileName) {
		try {
			// Determine the size of the file.
			int lineCount = 0;
			BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
			while (fileIn.ready()) {
				fileIn.read();
				lineCount++;
			}
			fileIn.close();
			// Read the file now.
			fileIn = new BufferedReader(new FileReader(fileName));
			this.linesArray = new String[lineCount];
			this.items = new Item[lineCount];
			this.itemCounts = new int[lineCount];
			/* Now I can use lineLength rather than while loop
			 * Since I know the length of the file, and can use the i
			 * for assignment.*/
			
			for (int i = 0; i < lineCount; i++) {
				this.linesArray[i] = fileIn.readLine();
			}
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}

	/** Populate the inventoryBag and return it.
	 * 
	 * @return inventoryBag object holding the inventory.
	 */
	public IBag<Item> readInventory() {
		boolean success = readInventoryFile(this.fileName);
		StringTokenizer commaSeperator;
		String name;
		String disposableType;
		int number;
		int sum = 0;
		// Populating the arrays.
		for (int i = 0; i < this.linesArray.length; i++) {
			commaSeperator = new StringTokenizer(this.linesArray[i], ",");
			name = (String) commaSeperator.nextElement();
			disposableType = (String) commaSeperator.nextElement();
			number = (int) commaSeperator.nextElement();
			this.items[i] = new Item(name, disposableType);
			this.itemCounts[i] = number;
		}
		//Finding the size for the inventory
		
		for(int i = 0; i < this.itemCounts.length; i++) {
			sum += this.itemCounts[i];
		}
		
		//Initilising the InventoryBag
		
		IBag <Item> inventory = new InventoryBag<Item>(sum);
		
		// Iteratively adding the items
		
		for (int i = 0; i < this.items.length; i++) {
			for (int j = 0; j < this.itemCounts[i]; j++) {
				inventory.add(this.items[i]);
			}
		}

		return inventory;
	}
}
