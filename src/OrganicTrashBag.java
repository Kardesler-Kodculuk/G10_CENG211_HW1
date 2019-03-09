
public class OrganicTrashBag<T> implements IBag<T> {

	private T[] trashBag;
	
	@SuppressWarnings("unchecked")
	public OrganicTrashBag()
	{
		trashBag = (T[]) new Object[15];
	}
	
	// adds a new item to the bag
	@Override
	public boolean add(T newItem) {
		if(isFull()) 
		{return false;}
		
		else 
		{
			for(int i = 0; i < 15; i++)
			{
				if(trashBag[i] == null)
				{
					trashBag[i] = newItem;
					break;
				}
			}
		return true;	
		}
	}
	
	// if bag is empty returns true else returns false
	@Override
	public boolean isEmpty() {
		if(getItemCount() == 0) {return true;}
		else {return false;}
	}
	
	// bag is empty, return true. else return false.
	@Override
	public boolean isFull() {
		if(getItemCount() == 15) {return true;}
		else {return false;}
	}
	
	// remove an item by its index and return that item. if no item returns null
	@Override
	public T removeByIndex(int index) {
		if(trashBag[index] == null) {return null;}
		else {
			T removedItem = trashBag[index];
			trashBag[index] = null;
			return removedItem;
		}
	}
	
	// removes the last item in the bag. if its empty returns null
	@Override
	public T remove() {
		for(int i = 0; i < 15; i++)
		{
			if(trashBag[15 - (i+1)] != null)
			{
				T removedItem = trashBag[15 - (i+1)];
				trashBag[15 - (i+1)] = null;
				return removedItem;
			}
		}
		return null;
	}

	// remove an item by its name. if item does not exist return null
	@Override
	public T remove(T item) {
		if(contains(item)) {
			int itemIndex = getIndexOf(item);
			trashBag[itemIndex] = null;
			return item;
		}
		else {
			return null;
		}
	}

	// returns how much item exists in the bag
	@Override
	public int getItemCount() {
		int count = 0;
		for(int i = 0; i < 15; i++) {
			if(trashBag[i] == null) {
				continue;
			}
			else {
				count++;
			}
		}
		return count;
	}

	// returns the index of the specified item. if item doesn't exist returns -1.
	@Override
	public int getIndexOf(T item) {
		for(int i = 0; i < trashBag.length; i++) {
			if(trashBag[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	// if bag contains the item returns true, else returns false.
	@Override
	public boolean contains(T item) {
		for(T e:trashBag) {
			if(e == item) {
				return true;
			}
		}
		return false;
	}
	
	// shows the items in the bag. doesn't return anything.
	@Override
	public void displayItems() {
		for(T e:trashBag) {
			System.out.println(e);
		}
	}

	// clears the bag. returns nothing.
	@Override
	public void dump() {
		for(int i = 0; i < trashBag.length; i++) {
			trashBag[i] = null;
		}
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		if(contains(item)) {
			remove(item);
			targetBag.add(item);
			return true;
		}
		return false;
	}

}
