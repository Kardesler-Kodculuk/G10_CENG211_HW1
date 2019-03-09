
public class PicnicBag<T> implements IBag<T> {
	
	private int size;
	private T[] picnicBag;
	private int totalAmount = getItemCount();

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
	
	
	/** Adds new item
	 * @param newItem - item to add
	 * @return true if success, false if not
	 */
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
		if(this.totalAmount == 0) {return true;}
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
			@SuppressWarnings("unchecked")
			T itemType = (T) picnicBag[index].getClass();
			picnicBag[index] = null;
			totalAmount--;
			return itemType;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove() {
		for(int i = 0; i < size; i++)
		{
			if(picnicBag[size - (i+1)] != null)
			{
				T removedItem = picnicBag[size - (i+1)];
				picnicBag[size - (i+1)] = null;
				return (T) removedItem.getClass();
			}
		}
		return null;
	}

	@Override
	public T remove(T item) {
		if(contains(item)) {
			int itemIndex = getIndexOf(item);
			@SuppressWarnings("unchecked")
			T itemType = (T) item.getClass();
			picnicBag[itemIndex] = null;
			totalAmount--;
			return itemType;
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
			if(picnicBag[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		for(T e:picnicBag) {
			if(e == item) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void displayItems() {
		for(T e:picnicBag) {
			System.out.println(e);
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

	public boolean consume(T item) {
		if(contains(item)) {
			remove(item);
			return true;
		}
		return false;
	}
	
}
