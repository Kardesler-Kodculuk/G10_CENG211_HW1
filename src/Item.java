/** The item class implements an item. */

public class Item {
	private String name;
	private String disposableType;
	private boolean initilised = true;
	
	/** Construct an Item.
	 * @param name - Name of the item
	 * @param disposableType - Disposable type of the item. */
	public Item(String name, String disposableType) {
		this.name = name;
		this.disposableType = disposableType;
		this.initilised = true;
	}
	
	/** Check if the onject is initilised correctly.
	 * @throws SecurityException if initilised incorrectly.
	 */
	private void checkInitilisation() {
		if (!this.initilised) {
			throw new SecurityException("Incorrect Initilisation");
		}
	}

	/** Return the disposable type.
	 * @return Disposbile type*/
	public String getDisposibleType() {
		checkInitilisation();
		return this.disposableType;
	}
	
	/** Returns string representation. 
	 * @return Name of the object. */
	public String toString() {
		checkInitilisation();
		return this.name;
	}
	
	/** Implements the equals method for Item class.
	 * Determining the equality depends on the equality of the,
	 * name and the disposable type.
	 * @param obj - Object to compare with
	 * @return true if equals
	 * @return false if it doesn't equal.*/
	public boolean equals(Object obj) {
		checkInitilisation();
		if (obj == null) return false;
		if (!obj.getClass().equals(this.getClass())) return false;
		Item comperessantItem = (Item) obj;
		return this.name.equals(comperessantItem.name) && 
				this.disposableType.equals(comperessantItem.disposableType);
	}
}
