/**
 * 
 */
package mutationAssignment;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Admin
 *
 */
class StoreInventoryManagerTest { 
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() { // Normal item has to degrade by 1 and sell value decrease by 1
		StoreInventoryManager.Item item = new StoreInventoryManager.Item("item", 5, 10);
		StoreInventoryManager store = new StoreInventoryManager(new StoreInventoryManager.Item[]{item});
		store.updateQuality();
		
		assertEquals("item, 4, 9", store.getItems()[0].toString());
		
		// Added after mutation for line 48
		StoreInventoryManager.Item item2 = new StoreInventoryManager.Item("item", -1, 0);
		StoreInventoryManager store2 = new StoreInventoryManager(new StoreInventoryManager.Item[]{item2});
		store2.updateQuality();
		
		assertEquals("item, -2, 0", store2.getItems()[0].toString());
	}
	
	@Test
	void test2() {  // Quality of a normal item cannot be negative
		StoreInventoryManager.Item item = new StoreInventoryManager.Item("item", 5, 0);
		StoreInventoryManager store = new StoreInventoryManager(new StoreInventoryManager.Item[]{item});
		store.updateQuality();
		
		assertEquals("item, 4, 0", store.getItems()[0].toString());
		
		// Added after mutation for line 45
		StoreInventoryManager.Item item2 = new StoreInventoryManager.Item("item", 1, 2);
		StoreInventoryManager store2 = new StoreInventoryManager(new StoreInventoryManager.Item[]{item2});
		store2.updateQuality();
		
		assertEquals("item, 0, 1", store2.getItems()[0].toString());
	}
	
	@Test
	void test3() {  // Quality to Aurumback show increases by 2
		StoreInventoryManager.Item item = new StoreInventoryManager.Item("Concert Tickets to Aurumback show", 10, 10);
		StoreInventoryManager store = new StoreInventoryManager(new StoreInventoryManager.Item[]{item});
		store.updateQuality();
		
		assertEquals("Concert Tickets to Aurumback show, 9, 12", store.getItems()[0].toString());
		
		// Added from mutation phase for line 27
		StoreInventoryManager.Item item2 = new StoreInventoryManager.Item("Concert Tickets to Aurumback show", 6, 49);
		StoreInventoryManager store2 = new StoreInventoryManager(new StoreInventoryManager.Item[]{item2});
		store2.updateQuality();
		
		assertEquals("Concert Tickets to Aurumback show, 5, 50", store2.getItems()[0].toString());
	}
	
	@Test
	void test4() {  // Quality to Aurumback show increases by 3 when selling is less than 6
		StoreInventoryManager.Item item = new StoreInventoryManager.Item("Concert Tickets to Aurumback show", 5, 10);
		StoreInventoryManager store = new StoreInventoryManager(new StoreInventoryManager.Item[]{item});
		store.updateQuality();
		
		assertEquals("Concert Tickets to Aurumback show, 4, 13", store.getItems()[0].toString());
		
		// Added from mutation phase for line 26
		StoreInventoryManager.Item item2 = new StoreInventoryManager.Item("Concert Tickets to Aurumback show", 11, 10);
		StoreInventoryManager store2 = new StoreInventoryManager(new StoreInventoryManager.Item[]{item2});
		store2.updateQuality();
		
		assertEquals("Concert Tickets to Aurumback show, 10, 11", store2.getItems()[0].toString());
	}
	
	@Test
	void test5() {  // Quality to Aurumback show drops to 0 after the event is over
		StoreInventoryManager.Item item = new StoreInventoryManager.Item("Concert Tickets to Aurumback show", 0, 10);
		StoreInventoryManager store = new StoreInventoryManager(new StoreInventoryManager.Item[]{item});
		store.updateQuality();
		
		assertEquals("Concert Tickets to Aurumback show, -1, 0", store.getItems()[0].toString());
		
		// Added after mutation phase for line 33
		StoreInventoryManager.Item item2 = new StoreInventoryManager.Item("Concert Tickets to Aurumback show", 5, 48);
		StoreInventoryManager store2 = new StoreInventoryManager(new StoreInventoryManager.Item[]{item2});
		store2.updateQuality();
		
		assertEquals("Concert Tickets to Aurumback show, 4, 50", store2.getItems()[0].toString());
	}
	
	@Test
	void test6() {  // Quality of Excalibur never gets minus 1
		StoreInventoryManager.Item item = new StoreInventoryManager.Item("Excalibur", 5, 10);
		StoreInventoryManager store = new StoreInventoryManager(new StoreInventoryManager.Item[]{item});
		store.updateQuality();
		
		assertEquals("Excalibur, 5, 10", store.getItems()[0].toString());
	}
	
	@Test
	void test7() {  // Quality of Gorquefort cannot go above 50
		StoreInventoryManager.Item item = new StoreInventoryManager.Item("Gorquefort", 5, 50);
		StoreInventoryManager store = new StoreInventoryManager(new StoreInventoryManager.Item[]{item});
		store.updateQuality();
		
		assertEquals("Gorquefort, 4, 50", store.getItems()[0].toString());
	}
	
	@Test
	void test8() {  // Minus sellin tested
		StoreInventoryManager.Item item = new StoreInventoryManager.Item("item", -2, 5);
		StoreInventoryManager store = new StoreInventoryManager(new StoreInventoryManager.Item[]{item});
		store.updateQuality();
		
		assertEquals("item, -3, 3", store.getItems()[0].toString());
	}
	
	@Test
	void test9() {  // minus gorque tested
		StoreInventoryManager.Item item = new StoreInventoryManager.Item("Gorquefort", -2, 15);
		StoreInventoryManager store = new StoreInventoryManager(new StoreInventoryManager.Item[]{item});
		store.updateQuality();
		
		assertEquals("Gorquefort, -3, 17", store.getItems()[0].toString());
		
		// Added after mutation for line 57
		StoreInventoryManager.Item item2 = new StoreInventoryManager.Item("Gorquefort", -4, 50);
		StoreInventoryManager store2 = new StoreInventoryManager(new StoreInventoryManager.Item[]{item2});
		store2.updateQuality();
		
		assertEquals("Gorquefort, -5, 50", store2.getItems()[0].toString());
	}
	
	@Test
	void test10() {  // Over 50 quality on concert tickets
		StoreInventoryManager.Item item = new StoreInventoryManager.Item("Concert Tickets to Aurumback show", 12, 55);
		StoreInventoryManager store = new StoreInventoryManager(new StoreInventoryManager.Item[]{item});
		store.updateQuality();
		
		assertEquals("Concert Tickets to Aurumback show, 11, 55", store.getItems()[0].toString());
		
		// Added after mutation for line 32
		StoreInventoryManager.Item item2 = new StoreInventoryManager.Item("Concert Tickets to Aurumback show", 6, 45);
		StoreInventoryManager store2 = new StoreInventoryManager(new StoreInventoryManager.Item[]{item2});
		store2.updateQuality();
		
		assertEquals("Concert Tickets to Aurumback show, 5, 47", store2.getItems()[0].toString());
	}

}
