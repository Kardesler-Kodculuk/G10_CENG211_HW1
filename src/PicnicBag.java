
public class PicnicBag<T> implements IBag<T> {

	@Override
	public boolean add(T newItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T removeByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndexOf(T item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void displayItems() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean consume(T item) {
		return false;
	}
	
}
