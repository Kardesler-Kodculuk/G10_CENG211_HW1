
public class Item {
	private String name;
	private String disposableType;
	
	/** Construct an Item. */
	public Item(String name, String disposableType) {
		this.name = name;
		this.disposableType = disposableType;
	}

	/** Return the disposable type.*/
	public String getDisposibleType() {
		return this.disposableType;
	}
	
	/** Returns string representation. */
	public String toString() {
		return this.name;
	}
	
	/** Implements the equals method for Item class. */
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!obj.getClass().equals(this.getClass())) return false;
		Item comperessantItem = (Item) obj;
		return this.name.equals(comperessantItem.name) && 
				this.disposableType.equals(comperessantItem.disposableType);
	}
}
