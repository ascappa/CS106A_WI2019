package HW2_SimpleJava;/*
 * File: Pyramid.java
 * Name:
 * Section Leader:
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class Pyramid extends GraphicsProgram {

    /**
     * Width of each brick in pixels
     */
    private static final int BRICK_WIDTH = 30;

    /**
     * Height of each brick in pixels
     */
    private static final int BRICK_HEIGHT = 12;

    /**
     * Number of bricks in the base of the pyramid
     */
    private static final int BRICKS_IN_BASE = 14;

    public void run() {
        /* You fill this in. */
        for (int i = 0; i < BRICKS_IN_BASE; i++) {
            for (int j = 0; j < i * 2 + 1; j++) {
                double startX = getWidth() / 2.0 - i * BRICK_WIDTH;
                GRect brick = new GRect(startX + j * BRICK_WIDTH, (getHeight() - (BRICKS_IN_BASE - i) * BRICK_HEIGHT),
                        BRICK_WIDTH, BRICK_HEIGHT);
                add(brick);
            }
        }
    }

    public static void main(String[] args) {

        Pyramid gObjects = new Pyramid();
        gObjects.start();
        gObjects.getGCanvas();
    }
}

