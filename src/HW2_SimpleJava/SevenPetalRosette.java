package HW2_SimpleJava;

import acm.graphics.*;
import acm.program.*;

/**
 * Seven Petal Rosette
 * This program is buggy! Trace through it and find out
 * what fixes the sectionee should make. You should not
 * modify the program!!!
 * <p>
 * -------------------
 * <p>
 * Part A]
 * For the first three "iterations" of the loop
 * what are the values of "i", the "angle" of the
 * outer circle, and the "id" of the outer circle.
 * The angle you report should be the value passed
 * to "drawOuterCircle."
 * <p>
 * First iteration:
 * i =
 * angle =
 * outerCircle id =
 * expected angle = 51.43
 * <p>
 * Second iteration:
 * i =
 * angle =
 * outerCircle id =
 * expected angle = 102.86
 * <p>
 * Third iteration:
 * i =
 * angle =
 * outerCircle id =
 * expected angle = 154.29
 * <p>
 * -------------------------------
 * <p>
 * Part B]
 * Step through the for loop in the run method.
 * How many times does the for loop run?
 * times run =
 * <p>
 * ------------------------------
 * <p>
 * Part C]
 * What fixes would you suggest to your sectionee?
 */
public class SevenPetalRosette extends GraphicsProgram {

    // Each circle has this radius
    private static final int RADIUS = 100;

    // There should be this many circles around the center circle
    private static final int N_OUTER_CIRCLES = 7;

	public static void main(String[] args) {
		new SevenPetalRosette().start();
	}

    // Draw the
    public void run() {
        double angle = 0;
        for (int i = 0; i < N_OUTER_CIRCLES; i++) {
            double delta = (360 / N_OUTER_CIRCLES);
            angle += delta;
            drawOuterCircle(angle);
        }
        drawCenteredCircle();
    }

    private void drawOuterCircle(double outerAngle) {
        GOval outerCircle = makeCenteredOval();
        add(outerCircle);
        outerCircle.movePolar(RADIUS, outerAngle);
    }

    private void drawCenteredCircle() {
        GOval centeredCircle = makeCenteredOval();
        add(centeredCircle);
    }

    private GOval makeCenteredOval() {
        double x = getWidth() / 2 - RADIUS;
        double y = getHeight() / 2 - RADIUS;
        double width = RADIUS * 2;
        double height = width;
        GOval circle = new GOval(x, y, width, height);
        circle.setLineWidth(5);
        return circle;
    }


}
