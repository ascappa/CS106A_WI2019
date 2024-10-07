package HW2_SimpleJava;/*
 * File: DrawCenteredRect.java
 * Name:
 * Section Leader:
 * ----------------------
 * This file is the starter file for the DrawCenteredRect problem.
 */

import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class DrawCenteredRect extends GraphicsProgram {

    /**
     * Size of the centered rect
     */
    private static final int WIDTH = 350;
    private static final int HEIGHT = 270;

    public void run() {
        /* You fill this in. */
        GRect gRect = new GRect((getWidth() - WIDTH) / 2.0, (getHeight() - HEIGHT) / 2.0, WIDTH, HEIGHT);
        gRect.setColor(Color.BLUE);
        gRect.setFilled(true);
        add(gRect);
    }

    public static void main(String[] args) {
       GraphicsProgram graphicsProgram = new DrawCenteredRect();
       graphicsProgram.start();
    }
}

