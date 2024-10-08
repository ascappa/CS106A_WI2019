package HW2_SimpleJava;/*
 * File: Countdown.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the Countdown problem.
 */

import acm.program.*;

public class Countdown extends ConsoleProgram {
	
	/** Count down to 0 from this number */
	private static final int START = 10;

	public void run() {
		/* You fill this in. */
		for (int i = 10; i > 0; i--) {
			println(i);
		}
		print("Lift off!");
	}
	public static void main(String[] args) {
		new Countdown().start();
	}
}

