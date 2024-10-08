package HW3_Breakout;/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 *
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Breakout extends GraphicsProgram {

    // Dimensions of the canvas, in pixels
    // These should be used when setting up the initial size of the game,
    // but in later calculations you should use getWidth() and getHeight()
    // rather than these constants for accurate size information.
    public static final double CANVAS_WIDTH = 420;
    public static final double CANVAS_HEIGHT = 600;

    // Number of bricks in each row
    public static final int NBRICK_COLUMNS = 10;

    // Number of rows of bricks
    public static final int NBRICK_ROWS = 10;

    // Separation between neighboring bricks, in pixels
    public static final double BRICK_SEP = 4;

    // Width of each brick, in pixels
    public static final double BRICK_WIDTH = Math.floor(
            (CANVAS_WIDTH - (NBRICK_COLUMNS + 1.0) * BRICK_SEP) / NBRICK_COLUMNS);

    // Height of each brick, in pixels
    public static final double BRICK_HEIGHT = 8;

    // Offset of the top brick row from the top, in pixels
    public static final double BRICK_Y_OFFSET = 70;

    // Dimensions of the paddle
    public static final double PADDLE_WIDTH = 60;
    public static final double PADDLE_HEIGHT = 10;

    // Offset of the paddle up from the bottom
    public static final double PADDLE_Y_OFFSET = 30;

    // Radius of the ball in pixels
    public static final double BALL_RADIUS = 10;

    // The ball's vertical velocity.
    public static final double VELOCITY_Y = 3.0;

    // The ball's minimum and maximum horizontal velocity; the bounds of the
    // initial random velocity that you should choose (randomly +/-).
    public static final double VELOCITY_X_MIN = 1.0;
    public static final double VELOCITY_X_MAX = 3.0;

    // Animation delay or pause time between ball moves (ms)
    public static final double DELAY = 1000.0 / 60.0;

    // Number of turns
    public static final int NTURNS = 3;

    private RandomGenerator rnGen = RandomGenerator.getInstance();

    private GRect paddle;

    private GOval ball;

    private double vx, vy;
    private double NBricksLeft;

    public static void main(String[] args) {
        new Breakout().start();
    }

    public void run() {
        Color[] brickColors = {Color.RED, Color.BLUE, Color.PINK, Color.YELLOW};
        NBricksLeft = brickColors.length * 2 * NBRICK_COLUMNS;
        vx = rnGen.nextDouble(VELOCITY_X_MIN, VELOCITY_X_MAX);
        if (rnGen.nextBoolean(0.5)) vx *= -1;
        vy = 3.0;
        // Set the window's title bar text
        setTitle("Luke e Andrew breakout");

        // Set the canvas size.  In your code, remember to ALWAYS use getWidth()
        // and getHeight() to get the screen dimensions, not these constants!
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);

        /* You fill this in, along with any subsidiary methods */
        paddle = new GRect((getWidth() - PADDLE_WIDTH) / 2, getHeight() - PADDLE_HEIGHT - 30, PADDLE_WIDTH,
                PADDLE_HEIGHT);
        paddle.setColor(Color.BLUE);
        paddle.setFilled(true);
        add(paddle);

        ball = new GOval((getWidth() - BALL_RADIUS) / 2,
                (getHeight() - BALL_RADIUS) / 2, BALL_RADIUS, BALL_RADIUS);

        ball.setColor(Color.BLACK);
        ball.setFilled(true);
        add(ball);

        for (int c = 0; c < brickColors.length; c++) {

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < NBRICK_COLUMNS; j++) {
                    GRect brick = new GRect(2 + j * (BRICK_WIDTH + BRICK_SEP + 1),
                            BRICK_Y_OFFSET + (c * 2 + i) * (BRICK_HEIGHT + BRICK_SEP),
                            BRICK_WIDTH, BRICK_HEIGHT);
                    brick.setColor(brickColors[c]);
                    brick.setFilled(true);
                    add(brick);
                }
            }
        }

        while (true) {
            ball.move(vx, vy);

            if (ball.getX() <= 0 || ball.getRightX() >= getWidth()) vx *= -1;
            if (ball.getY() <= 0) vy *= -1;
            if (ball.getBottomY() >= getHeight()) break;
            GObject collObj = getCollidingObject();

            if (collObj == paddle) {
                vy = -vy;
                ball.move(vx, vy);
            } else if (collObj != null) {
                vy = -vy;
                remove(collObj);
            }
            pause(DELAY);
        }
        removeAll();
        GLabel text = new GLabel("you lost!");
        text.setCenterLocation((double) (getWidth()) / 2, (double) (getHeight()) / 2);
        add(text);
    }

    private GObject getCollidingObject() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                GObject collElement = getElementAt(ball.getX() + 2 * BALL_RADIUS * i,
                        ball.getY() + 2 * BALL_RADIUS * j);
                if (collElement != null) return collElement;
            }
        }
        return null;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        paddle.setCenterX(e.getX());
    }
}
