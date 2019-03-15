
public interface IBag<T> {
	
	/**
	 * Adds new item to the bag.
	 * 
	 * @param newItem - item to add
	 * @return true if added, false if bag is empty
	 */
	public boolean add(T newItem);
	
	/**
	 * Checks the bag is empty or not.
	 * 
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Checks the bag is full or not.
	 * 
	 * @return true if full, false otherwise
	 */
	public boolean isFull();
	
	/**
	 * Removes the item by it's index from the bag
	 * 
	 * @param index - index of the item
	 * @return element of the bag
	 */
	public T removeByIndex(int index);
	
	/**
	 * Removes the last item.
	 * 
	 * @return element of the bag
	 */
	public T remove();
	
	/**
	 * Removes the item by it's name.
	 * 
	 * @param item - item's name
	 * @return element of the bag
	 */
	public T remove(T item);
	
	/**
	 * Gets the total item number in the bag.
	 * 
	 * @return total number of items
	 */
	public int getItemCount();
	
	/**
	 * Gets the index of the item.
	 * 
	 * @param item - item's name
	 * @return index of the item in the bag
	 */
	public int getIndexOf(T item);
	
	/**
	 * Checks the bag contains the item or not.
	 * 
	 * @param item - item's name
	 * @return true if exists, false otherwise
	 */
	public boolean contains(T item);
	
	
	/**
	 * Displays all items in the bag 
	 */
	public void displayItems();

	/**
	 * Dumps all items in the bag.
	 */
	public void dump();
	
	/**
	 * Transfers item from a bag to another.
	 * 
	 * @param targetBag - name of the target bag
	 * @param item - name of the item
	 * @return true if transfers, false otherwise
	 */
	public boolean transferTo(IBag<T> targetBag, T item);
}
