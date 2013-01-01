/**
 * 
 */
package com.mac.example;

/**
 * @author mac
 * 
 */
public class StartPoint {

	// public static shape shape;

	/**
	 * 
	 */
	public StartPoint() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("time is now 5 mins after the hour");
		shape myshape = new shape(4,"blue");
		myshape.multShape(3,4,5);

	}

	public int adder(int n1, int n2) {

		float add_res = n1 + n2;

		return (int) add_res;
	}

}
