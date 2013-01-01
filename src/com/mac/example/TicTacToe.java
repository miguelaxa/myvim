package com.mac.example;

/***
Original Author:  Edwin Torres

If you like this program, please add me to your circle on Google+:  
https://plus.google.com/u/0/116783892481278720529/posts

Please feel free to use, modify, re-implement this 
source code as long as you keep this comment banner in the code.

 ***/

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.util.ArrayList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TicTacToe extends Applet implements MouseListener {

	private char[] Xarr;
	private char[] Oarr;
	private char[] turnArr;
	private int saveIndex;
	private int[] arrX, arrY;
	private char[] arrLetter;
	private char[][] board; // 'X' or 'O'
	private boolean Done;
	private byte totalTurns;
	private int winStartX, winStartY, winEndX, winEndY;

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe(); // define applet of interest
		JFrame myFrame = new JFrame("Tic Tac Toe"); // create frame with title
		ttt.init();

		myFrame.add(ttt, BorderLayout.CENTER);
		myFrame.pack(); // set window to appropriate size (for its elements)
		myFrame.setSize(400, 400);
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setVisible(true); // usual step to make frame visible
	} // end main

	public TicTacToe() {
		addMouseListener(this);
		Xarr = new char[] { 'X' };
		Oarr = new char[] { 'O' };

		// board data
		board = new char[3][3];
	}

	public void init() {
		totalTurns = 0;
		initBoard();

		saveIndex = 0;
		arrX = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		arrY = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		arrLetter = new char[] { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

		setDone(false);
		turnArr = Xarr; // X goes first
	}

	public void start() {

	}

	public void stop() {

	}

	public void destroy() {

	}

	public void paint(Graphics g) {
		// draw grid
		g.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight());
		g.drawLine(getWidth() / 3 * 2, 0, getWidth() / 3 * 2, getHeight());
		g.drawLine(0, getHeight() / 3, getWidth(), getHeight() / 3);
		g.drawLine(0, getHeight() / 3 * 2, getWidth(), getHeight() / 3 * 2);

		// draw any existing letters
		g.setFont(new Font("Arial", Font.BOLD, 50));
		int x, y;
		char[] let = new char[] { ' ' };
		for (int i = 0; i < 9; i++) {
			let[0] = arrLetter[i];
			if (let[0] != ' ') {
				x = arrX[i];
				y = arrY[i];
				g.drawChars(let, 0, 1, x, y);
			}

		}

		// draw the winning line (if there's a winner)
		if (getWinner() != ' ') {
			g.setColor(Color.RED);
			g.drawLine(winStartX, winStartY, winEndX, winEndY);
			g.setColor(Color.BLACK);
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		drawLetter(arg0.getX(), arg0.getY(), this.getGraphics());
	System.out.println("clicked");
		
	int[] array = {1,2,3};
	for (int i = 0; i < array.length; i++) {
		System.out.println("\nced " + i);
	}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	public void drawLetter(int x, int y, Graphics g) {

		if (isDone() || (totalTurns == 9)) {
			init();
			repaint();
			return;
		}

		int centerX, centerY;
		int xindex, yindex;

		// find center X
		if (x < getWidth() / 3) {
			centerX = (getWidth() / 3) / 2;
			yindex = 0;
		} else if (x < getWidth() / 3 * 2) {
			centerX = (getWidth() / 3 + getWidth() / 3 * 2) / 2;
			yindex = 1;
		} else {
			centerX = (getWidth() / 3 * 2 + getWidth()) / 2;
			yindex = 2;
		}

		// find center Y
		if (y < getHeight() / 3) {
			centerY = (getHeight() / 3) / 2;
			xindex = 0;
		} else if (y < getHeight() / 3 * 2) {
			centerY = (getHeight() / 3 + getHeight() / 3 * 2) / 2;
			xindex = 1;
		} else {
			centerY = (getHeight() / 3 * 2 + getHeight()) / 2;
			xindex = 2;
		}

		// is spot taken?
		if (board[xindex][yindex] != ' ')
			return;

		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawChars(turnArr, 0, 1, centerX - 18, centerY + 18);

		// save letter and position for repaint()
		arrX[saveIndex] = centerX - 18;
		arrY[saveIndex] = centerY + 18;
		arrLetter[saveIndex] = turnArr[0];
		saveIndex++;

		totalTurns++;

		board[xindex][yindex] = turnArr[0];
		if (getWinner() != ' ') {
			Done = true;
			g.setColor(Color.RED);
			g.drawLine(winStartX, winStartY, winEndX, winEndY);
			g.setColor(Color.BLACK);
		}

		if (turnArr == Xarr)
			turnArr = Oarr;
		else
			turnArr = Xarr;

	}

	public char getWinner() {
		// returns 'X' if X has won, 'O' if O has won, or ' ' if there is no
		// current winner
		int row, col;

		// check for horizontal winner
		for (row = 0; row < 3; row++) {

			if (board[row][0] == ' ' || board[row][1] == ' '
					|| board[row][2] == ' ')
				continue;

			if ((board[row][0] == board[row][1])
					&& (board[row][0] == board[row][2])) {
				winStartX = 0;
				winEndX = getWidth();
				winStartY = (getHeight() / 3) / 2 + row * getHeight() / 3;
				winEndY = winStartY;
				return board[row][0];
			}
		}

		// check for vertical winner
		for (col = 0; col < 3; col++) {

			if (board[0][col] == ' ' || board[1][col] == ' '
					|| board[2][col] == ' ')
				continue;

			if ((board[0][col] == board[1][col])
					&& (board[0][col] == board[2][col])) {
				winStartY = 0;
				winEndY = getHeight();
				winStartX = (getWidth() / 3) / 2 + col * getWidth() / 3;
				winEndX = winStartX;
				return board[0][col];
			}
		}

		// check for diagonal winner
		if ((board[0][0] == board[1][1]) && (board[0][0] == board[2][2])) {
			if (board[0][0] != ' ') {
				winStartX = 0;
				winStartY = 0;
				winEndX = getWidth();
				winEndY = getHeight();
				return board[0][0];
			}
		}
		if ((board[2][0] == board[1][1]) && (board[2][0] == board[0][2])) {
			if (board[2][0] != ' ') {
				winStartX = getWidth();
				winStartY = 0;
				winEndX = 0;
				winEndY = getHeight();
				return board[2][0];
			}
		}

		return ' ';
	}

	public void initBoard() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				board[row][col] = ' ';
			}
		}
	}

	public boolean isDone() {
		return Done;
	}

	public void setDone(boolean done) {
		Done = done;
	}

}
