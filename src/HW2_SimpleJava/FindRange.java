package HW2_SimpleJava;/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		/* You fill this in */
		Integer min = null;
		Integer max = null;
		int input;
		println("This program finds the smallest and largest number that you enter.");
		do {
			input = readInt("? ");
			if (min == null || input < min) {
				min = input;
			}
			if (max == null || input > max) {
				max = input;
			}
		} while (input != 0);
		println("smallest: " + min);
		println("greatest: " + max);
	}
	public static void main(String[] args) {
		ConsoleProgram consoleProgram = new FindRange();
		consoleProgram.start();
	}
}

