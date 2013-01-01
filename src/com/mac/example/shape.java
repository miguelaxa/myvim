/**
 * 
 */
package com.mac.example;

/**
 * @author mac
 * 
 */
public class shape {

	int sides, l, w, h;
	String color;

	public shape(int s, String colr) {
		// TODO Auto-generated constructor stub
		sides = s;
		color = colr;
		System.out.println("in pshape ");

	}

	int multShape(int l, int w, int h) {
		int volume = l * w * h;

		System.out.println(" A " + color + " shape with " + sides + " sides");
		return volume;
	}

}
