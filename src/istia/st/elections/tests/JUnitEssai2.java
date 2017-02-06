package istia.st.elections.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnitEssai2 {

	@Before
	public void setUp() throws Exception {
		System.out.println("tearUP");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void t1() {
		System.out.println("Test 1");
		assertEquals(1, 1);
		
	}
	@Test
	public void t2() {
		System.out.println("Test 2");
		assertEquals(1, 2);
		
	}

}
