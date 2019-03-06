
public class InventoryBag<T> implements IBag<T> {

	private int[] itemCounts; //A paralel list stracture where the index
	private T[] items; // Matches items to their counts.
	private int length;
	private int pointer;

	@SuppressWarnings("unchecked")
	public InventoryBag(int size) {
		items = (T[]) new Object[size];
		itemCounts = new int[size];
		this.length = size;
		this.pointer = 0;
	}

	@Override
	public boolean add(T newItem) {
		if (this.contains(newItem)) {
			int indexOfItem = getIndexOf(newItem);
			itemCounts[indexOfItem]++;
			return true;
		}
		if (this.pointer == this.length) {
				return false;
		}
		
		items[this.pointer] = newItem;
		itemCounts[this.pointer]++;
		this.pointer++;
		return true;
	}
	

	/** Return true if empty, false otherwise. */
	@Override
	public boolean isEmpty() {
		for (int i = 0; i < itemCounts.length; i++) {
			if (itemCounts[i] != 0) {
				return false;
			}
		}
		return true;
	}

	/** Return true if full. */
	@Override
	public boolean isFull() {
		return this.length == (this.pointer + 1);
	}

	/** Remove one member of the item from the inventory
	 * @param index index of the item to be removed.
	 * @return element if not already 0, else, null.*/
	@Override
	public T removeByIndex(int index) {
		if (itemCounts[index] > 0) {
			itemCounts[index]--;
			return items[index];
		}

		return null;
	}

	/** Remove one member of any item from the inventory 
	 * @return an item.
	 * */
	@Override
	public T remove() {
		for (int i = 0; i < itemCounts.length; i++) {
			if (itemCounts[i] > 0) {
				itemCounts[i]--;
				return items[i];
			}
		}
		return null;
	}

	/** Remove one member of the item 
	 * @param item item to be removed.
	 * @return item if removed, null if not.*/
	@Override
	public T remove(T item) {
		int itemIndex = getIndexOf(item);
		if (itemCounts[itemIndex] > 0) {
			itemCounts[itemIndex]--;
			return item;
		}
		return null;
	}

	/** Get the total number of items hold by the bag. 
	 * @return number of items hold.
	 * */
	@Override
	public int getItemCount() {
		int sum = 0;
		for (int i = 0; i < itemCounts.length; i++) {
			sum += itemCounts[i];
		}
		return sum;
	}

	/**Return the index if object exists, else return -1
	 * @param item - item to be checked
	 * @return index of item or -1*/
	@Override
	public int getIndexOf(T item) {
		int index = -1;
		for (int i = 0; i < this.items.length; i++) {
			if (items[i].equals(item)) {
				index = i;
				break;
			}
		}
		return index;
	}

	/**Implements the contains public method.
	 * @param item to check if it is in the bag.
	 * @return true if is in, false if not.*/
	@Override
	public boolean contains(T item) {
		for (int i = 0; i < this.items.length; i++) {
			if (item.equals(this.items[i]) && this.itemCounts[i] > 0) {
				return true;
			}
		}
		return false;
	}

	/**Print the items as a list with each item
	 * occupying one line. with its value. */
	@Override
	public void displayItems() {
		String string = "";
		for (int i = 0; i < items.length; i++) {
			if (itemCounts[i] > 0) {
				string += items[i].toString() +  ((Integer) itemCounts[i]).toString() + "\n";
			}
		}
		System.out.println(string);
	}

	@Override
	public void dump() {
		for (int i = 0; i < items.length; i++) {
			itemCounts[i] = 0;
		}
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		// TODO Auto-generated method stub
		return false;
	}

}
