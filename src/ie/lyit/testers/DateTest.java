package ie.lyit.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ie.lyit.hotel.*;
public class DateTest {

	
	@Before
	public void setUp() throws Exception {
		d1=new Date();
		// Check d1’s day is 0
		assertEquals(d1.getDay(), 0);
		// Check d1’s month is 0, if it is not display appropriate message
		 assertEquals("Month should be 0", d1.getMonth(), 0);
		// Check d1’s year is 5, if it is not display appropriate message
		// NOTE : This should fail!
		assertEquals("Year should be 0", d1.getYear(), 5);

	}

	@Test
	public void testDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDateIntIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDay() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMonth() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetYear() {
		fail("Not yet implemented");
	}

}
