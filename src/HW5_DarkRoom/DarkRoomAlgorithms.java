package HW5_DarkRoom;/*
 * Note: these methods are public in order for them to be used by other files
 * in this assignment; DO NOT change them to private.  You may add additional
 * private methods to implement required functionality if you would like.
 *
 * You should remove the stub lines from each method and replace them with your
 * implementation that returns an updated image.
 */

// TODO: comment this file explaining its behavior

import acm.graphics.GImage;

public class DarkRoomAlgorithms implements DarkRoomAlgorithmsInterface {

    public GImage rotateLeft(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        int[][] leftRotatedArray = new int[pixelArray[0].length][pixelArray.length];

        for (int i = 0; i < pixelArray.length; i++) {
            for (int j = 0; j < pixelArray[i].length; j++) {
                leftRotatedArray[pixelArray[i].length - 1 - j][i] = pixelArray[i][j];
            }
        }
		return new GImage(leftRotatedArray);
    }

    public GImage rotateRight(GImage source) {
        // TODO
		int[][] pixelArray = source.getPixelArray();
		int[][] leftRotatedArray = new int[pixelArray[0].length][pixelArray.length];

		for (int i = 0; i < pixelArray.length; i++) {
			for (int j = 0; j < pixelArray[i].length; j++) {
				leftRotatedArray[j][pixelArray.length - 1 - i] = pixelArray[i][j];
			}
		}
		return new GImage(leftRotatedArray);
    }

    public GImage flipHorizontal(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();


        for (int[] row : pixelArray) {
            for (int j = 0; j < row.length / 2; j++) {
                int tmp = row[j];
                row[j] = row[row.length - 1 - j];
                row[row.length - 1 - j] = tmp;
            }

        }
        return new GImage(pixelArray);
    }

    public GImage negative(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        for (int[] row : pixelArray) {
            for (int j = 0; j < row.length; j++) {
                int pixel = row[j];
                int red = GImage.getRed(pixel);
                int green = GImage.getGreen(pixel);
                int blue = GImage.getBlue(pixel);
                row[j] = GImage.createRGBPixel(255 - red, 255 - green, 255 - blue);
            }
        }
        return new GImage(pixelArray);
    }

    public GImage greenScreen(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        for (var row : pixelArray) {
            for (int j = 0; j < row.length; j++) {
                int pixel = row[j];
                int red = GImage.getRed(pixel);
                int green = GImage.getGreen(pixel);
                int blue = GImage.getBlue(pixel);
                row[j] = green >= 2 * Math.max(red, blue) ? GImage.createRGBPixel(red, green, blue, 0) : pixel;
            }
        }
        return new GImage(pixelArray);
    }

    public GImage blur(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        for (var row : pixelArray) {
            for (int j = 0; j < row.length; j++) {
                int pixel = row[j];
                int red = GImage.getRed(pixel);
                int green = GImage.getGreen(pixel);
                int blue = GImage.getBlue(pixel);
                row[j] = green >= 2 * Math.max(red, blue) ? GImage.createRGBPixel(red, green, blue, 0) : pixel;
            }
        }
        return new GImage(pixelArray);
    }

    public GImage crop(GImage source, int cropX, int cropY, int cropWidth, int cropHeight) {
        // TODO
        return null;
    }

    public GImage equalize(GImage source) {
        // TODO
        return null;
    }
}
