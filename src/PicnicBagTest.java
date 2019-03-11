import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PicnicBagTest {

	private PicnicBag picnic;

	@BeforeEach
	void setUp() throws Exception {
		picnic = new PicnicBag<String>("small");
	}

	@Test
	void testAdd() {
		assertEquals(true, picnic.add("kedi"));
		for (int i = 0; i <= 4; i++) {
			picnic.add("lol");
		}
		assertEquals(false, picnic.add("ibra"));
	}

	@Test
	void testIsEmpty() {
		assertEquals(true, picnic.isEmpty());
		picnic.add("oðuzhan.");
		assertEquals(false, picnic.isEmpty());
	}

	@Test
	void testIsFull() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testRemoveByIndex() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testRemove() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testRemoveT() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetItemCount() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetIndexOf() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testContains() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDisplayItems() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDump() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testTransferTo() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testConsume() {
		fail("Not yet implemented"); // TODO
	}

}
