import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

class InventoryBagTest {

	private InventoryBag<String> inventory;
	
	@BeforeEach
	void setUp() throws Exception {
		inventory = new InventoryBag<String>(2);
	}

	@Test
	void testAdd() {
		inventory.add("Cat");
		assertEquals(true, inventory.add("Cat"));
		assertEquals(false, inventory.add("Cat"));
	}

	@Test
	void testIsEmpty() {
		assertEquals(true, inventory.isEmpty());
		inventory.add("Cat");
		assertEquals(false, inventory.isEmpty());
	}

	@Test
	void testIsFull() {
		assertEquals(false, inventory.isFull());
		inventory.add("Cat");
		assertEquals(false, inventory.isFull());
		inventory.add("Cat");
		assertEquals(true, inventory.isFull());
	}

	@Test
	void testRemoveByIndex() {
		inventory.add("Cat");
		assertEquals("Cat", inventory.removeByIndex(0));
		assertEquals(null, inventory.removeByIndex(0));
	}

	@Test
	void testRemove() {
		inventory.add("Cat");
		assertEquals("Cat", inventory.remove());
		assertEquals(null, inventory.remove());
	}

	@Test
	void testRemoveT() {
		inventory.add("Cat");
		assertEquals("Cat", inventory.remove("Cat"));
		assertEquals(null, inventory.remove("Doggo")); //You cannot remove a doggo.
	}

	@Test
	void testGetItemCount() {
		assertEquals(0, inventory.getItemCount());
		inventory.add("Cat");
		assertEquals(1, inventory.getItemCount());
	}

	@Test
	void testGetIndexOf() {
		assertEquals(-1, inventory.getIndexOf("Cat"));
		inventory.add("Cat");
		assertEquals(0, inventory.getIndexOf("Cat"));
		assertEquals(-1, inventory.getIndexOf("Doggo")); //Doggos can't be indexed.
	}

	@Test
	void testContains() {
		assertEquals(false, inventory.contains("Cat"));
		inventory.add("Cat");
		assertEquals(true, inventory.contains("Cat"));
		inventory.remove("Cat");
		assertEquals(false, inventory.contains("Cat"));
		assertEquals(false, inventory.contains("Doggo"));
	}

	@Test
	void testDump() {
		inventory.add("Cat");
		inventory.dump();
		assertEquals(0, inventory.getItemCount());
	}

}
