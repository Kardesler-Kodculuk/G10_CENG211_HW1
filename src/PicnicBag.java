
public class PicnicBag<T> implements IBag<T> {
	
	private int size;
	private T[] picnicBag;
	private int totalAmount = getItemCount();

	/**
	 * The constructor of PicnicBag class
	 * @param size	"small" (5), "normal" (10) or "large" (15)
	 */
	@SuppressWarnings("unchecked")
	public PicnicBag(String size) {
		switch(size) {
		case "small":
			this.size = 5;
			break;
		case "normal":
			this.size = 10;
			break;
		case "large":
			this.size = 15;
			break;

		}
		picnicBag = (T[]) new Object[this.size];
	}
	
	@Override
	public boolean add(T newItem) {
		if(isFull()) 
		{return false;}
		
		else 
		{
			for(int i = 0; i < size; i++)
			{
				if(picnicBag[i] == null)
				{
					picnicBag[i] = newItem;
					break;
				}
			}
		return true;	
		}
		
	}

	@Override
	public boolean isEmpty() {
		if(getItemCount() == 0) {return true;}
		else {return false;}
		
	}


	@Override
	public boolean isFull() {
		if(getItemCount() == size) {return true;}
		else {return false;}
	}

	@Override
	public T removeByIndex(int index) {
		if(picnicBag[index] == null) {return null;}
		else {
			T removedItem = picnicBag[index];
			picnicBag[index] = null;
			totalAmount--;
			return removedItem;
		}
	}

	@Override
	public T remove() {
		for(int i = 0; i < size; i++)
		{
			if(picnicBag[size - (i+1)] != null)
			{
				T removedItem = picnicBag[size - (i+1)];
				picnicBag[size - (i+1)] = null;
				return removedItem;
			}
		}
		return null;
	}

	@Override
	public T remove(T item) {
		if(contains(item)) {
			int itemIndex = getIndexOf(item);
			picnicBag[itemIndex] = null;
			totalAmount--;
			return item;
		}
		else {
			return null;
		}
	}

	@Override
	public int getItemCount() {
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(picnicBag[i] == null) {
				continue;
			}
			else {
				count++;
			}
		}
		return count;
	}

	@Override
	public int getIndexOf(T item) {
		for(int i = 0; i < picnicBag.length; i++) {
			if(picnicBag[i] != null && picnicBag[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(T item) {
		for(T e:picnicBag) {
			if(e == item) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void displayItems() {
		for(int i = 0; i < size; i++)
		{
			if(getItem(i) != null)
			{
				System.out.println((i + 1) + " - " + getItem(i));				
			}

		}
		
	}
		

	@Override
	public void dump() {
		for(int i = 0; i < picnicBag.length; i++) {
			picnicBag[i] = null;
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
	
	/**
	 * Consumes the item and transfers it to a trashBag by it's disposableType.
	 * 
	 * @param item - item's name
	 * @param trashBags - an array that holds organic,plastic and paper trashBags
	 * @return true if consumed, false if item doesn't exist
	 */
	@SuppressWarnings("unchecked")
	public boolean consume(T item, IBag<T>[] trashBags) {
		if(contains(item)) 
		{
			Item consumedItem = (Item) this.remove(item);
			String disposableType = consumedItem.getDisposibleType();

			switch(disposableType)
			{
			case "organic":
				trashBags[0].add((T) consumedItem);
				break;
			case "plastic":
				trashBags[1].add((T) consumedItem);
				break;
			case "paper":
				trashBags[2].add((T) consumedItem);
				break;
			}
			return true;
		}
		else {return false;}
	}

	/**
	 * Gets element by it's index.
	 * 
	 * @param index - index of the element
	 * @return element of the bag
	 */
	public T getItem(int index)
	{
		if(index >= 0 && index < size) {
			return picnicBag[index];
		}
		else {return null;}
	}
}
