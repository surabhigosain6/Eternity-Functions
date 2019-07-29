package Surbhi;

import junit.framework.TestCase;

public class TestLog extends TestCase {
	
	public void testZero() {
		LogXb obj = new LogXb();
		Double result = obj.calcLog(0, 0);
		assertEquals(result, 0.0);
	}
	
	public void testOne() {
		LogXb obj = new LogXb();
		Double result = obj.calcLog(1, 1);
		assertEquals(result, 0.0);
	}
	
	public void testTwo() {
		LogXb obj = new LogXb();
		Double result = obj.calcLog(5, 5);
		assertEquals(result, 1.0);
	}
	
	public void testThree() {
		LogXb obj = new LogXb();
		Double result = obj.calcLog(189, 45);
		assertEquals(result, 1.3660521596484092);
	}
	
	public void testFour() {
		LogXb obj = new LogXb();
		Double result = obj.calcLog(9.8, 4.2);
		assertEquals(result, 1.5904166935507735);
	}
}
