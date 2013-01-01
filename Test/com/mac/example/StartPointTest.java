package com.mac.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StartPointTest {

	private StartPoint startPoint;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		startPoint = new StartPoint();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdder() {
		
		assertEquals("Result", 26, startPoint.adder(24, 2));
	}

	@Test
	public void test() {

		int add_ans = startPoint.adder(24, 2);

		if (add_ans == 26) {
			System.out.println("good 1");
		} else {
			System.out.println("good bad ans = " + add_ans);
			fail("Not yet implemented");

		}
	}

}
