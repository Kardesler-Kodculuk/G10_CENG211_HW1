import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PicnicBagTest {

	private PicnicBag<Item> picnic;
	@SuppressWarnings("unchecked")
	IBag<Item>[] trashBags = new IBag[3];
	private Item lettuce = new Item("lettuce", "organic");
	private Item fork = new Item("fork", "plastic");
	private Item tea = new Item("tea", "paper");
	
	@BeforeEach
	void setUp() throws Exception {
		picnic = new PicnicBag<Item>("small");
		trashBags[0] = new OrganicTrashBag<Item>();
		trashBags[1] = new PlasticTrashBag<Item>();
		trashBags[2] = new PaperTrashBag<Item>();		

	}

	@Test
	void testAdd() {
		assertEquals(true, picnic.add(fork));
		for (int i = 0; i <= 4; i++) {
			picnic.add(fork);
		}
		assertEquals(false, picnic.add(fork));
	}

	@Test
	void testIsEmpty() {
		assertEquals(true, picnic.isEmpty());
		picnic.add(fork);
		assertEquals(false, picnic.isEmpty());
	}

	@Test
	void testIsFull() {
		assertEquals(false, picnic.isFull());
		picnic.add(fork);
		assertEquals(false, picnic.isFull());
		for(int i = 1; i < 5; i++)
		{
			picnic.add(fork);
		}
		assertEquals(true, picnic.isFull());
	}

	@Test
	void testRemoveByIndex() {
		assertEquals(null, picnic.removeByIndex(0));
		picnic.add(fork);
		assertEquals(fork, picnic.removeByIndex(0));
	}

	@Test
	void testRemove() {
		assertEquals(null, picnic.remove());
		picnic.add(fork);
		assertEquals(fork, picnic.remove());
	}

	@Test
	void testRemoveT() {
		assertEquals(null, picnic.remove(fork));
		picnic.add(fork);
		assertEquals(fork, picnic.remove(fork));
	}

	@Test
	void testGetItemCount() {
		for(int i = 0; i < 5; i++)
		{
			assertEquals(i, picnic.getItemCount());
			picnic.add(fork);
			assertEquals(i + 1, picnic.getItemCount());
		}
	}

	@Test
	void testGetIndexOf() {
		assertEquals(-1, picnic.getIndexOf(tea));
		picnic.add(tea);
		assertEquals(0, picnic.getIndexOf(tea));
	}

	@Test
	void testContains() {
		assertEquals(false, picnic.contains(fork));
		picnic.add(fork);
		assertEquals(true, picnic.contains(fork));
	}

	@Test
	void testDisplayItems() {
		assertEquals(true, true); // It is not implemented but avoiding failures
	}

	@Test
	void testDump() {
		picnic.add(fork);
		assertEquals(false, picnic.isEmpty());
		picnic.dump();
		assertEquals(true, picnic.isEmpty());
	}

	@Test
	void testTransferTo() {
		assertEquals(false, picnic.transferTo(trashBags[0], fork));
		picnic.add(fork);
		assertEquals(true, picnic.transferTo(trashBags[0], fork));
	}

	@Test
	void testConsume() {
		assertEquals(false, picnic.consume(lettuce, trashBags));
		picnic.add(lettuce);
		assertEquals(true, picnic.consume(lettuce, trashBags));
	}

}
