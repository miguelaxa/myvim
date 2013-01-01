/**
 * 
 */
package com.mac.example;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author mac
 * 
 */
public class shapeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testShape() {
		shape myShape = new shape(3, "red");
		assertEquals("Result", 16, myShape.multShape(2, 2, 4));
	}

	@Test
	public void testPshape() {
		shape myShape = new shape(6, "blue");
		assertEquals("Result", 16, myShape.multShape(2, 2, 4));
	}

	@Test
	public void testmmshape() {
		shape myShape = new shape(9, "yellow");
		assertEquals("Result", 288, myShape.multShape(12, 12, 2));
	}

}
