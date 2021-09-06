package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//import testing.register_test_class;

class register_classTest extends register_class{

	@Test
	// testing class not null
	public void testConstructor() {
		register_class rtc = new register_class();
		assertNotNull(rtc);
	}
	
	@Test
	// Register inserting test pass
	public void testGetters() {
		register_class rt = new register_class("sudikshya","sudi","04/11/2002","female", "sudikshya11");
		String expected = "sudi";
		String actual = rt.getusername();
		
		assertEquals(expected,actual);
	}
	
	     @Test
	    // Register inserting test fail
		public void testGetters1() {
			register_class rt = new register_class("sudikshya","sudi","04/11/2002","female", "sudikshya11");
			String expected = "sudikshya";
			String actual = rt.getusername();
			
			assertEquals(expected,actual);
		}
}
