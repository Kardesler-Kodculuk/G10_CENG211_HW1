import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {
	
	private Item item;

	@BeforeEach
	void setUp() throws Exception {
		item = new Item("Cat", "Animal");
	}

	@Test
	void testGetDisposibleType() {
		assertEquals("Animal", item.getDisposibleType());
	}

	@Test
	void testToString() {
		assertEquals("Cat", item.toString()); // TODO
	}

	@Test
	void testEqualsObject() {
		assertEquals(false, item.equals(new Item("Doggo", "Animal")));
		assertEquals(false, item.equals(new Item("Cat", "Mamal")));
		assertEquals(false, item.equals(new Item("Doggo", "Canis")));
		assertEquals(true,  item.equals(new Item("Cat", "Animal")));
		assertEquals(false, item.equals(new Item("cat", "animal")));
		assertEquals(false, item.equals(new Item("Cat", "animal")));
		assertEquals(false, item.equals(new Item("cat", "Animal")));
	}

}
