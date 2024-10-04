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

    public GImage blurWeird(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        for (int i = 0; i < pixelArray.length; i++) {
            int[] row = pixelArray[i];
            for (int j = 0; j < row.length; j++) {
                int sum = 0;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        int pixelX = j - 1 + n;
                        int pixelY = i - 1 + m;
                        if (pixelX > -1 && pixelX < row.length && pixelY > -1 && pixelY < pixelArray.length) {
                            sum += pixelArray[pixelY][pixelX];
                        }
                    }
                }
                int avg = sum / 9;
                pixelArray[i][j] = avg;
            }
        }
        return new GImage(pixelArray);
    }

    public GImage blurStrong(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        for (int i = 0; i < pixelArray.length; i++) {
            int[] row = pixelArray[i];
            for (int j = 0; j < row.length; j++) {
                int red = 0;
                int green = 0;
                int blue = 0;
                int numPixels = 0;
                int pixelAnchor = pixelArray[i][j];
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        int currPixel;
                        int pixelX = j - 1 + n;
                        int pixelY = i - 1 + m;
                        if (pixelX > -1 && pixelX < row.length && pixelY > -1 && pixelY < pixelArray.length) {
                            numPixels++;
                            currPixel = pixelArray[pixelY][pixelX];
                            red += GImage.getRed(currPixel);
                            green += GImage.getGreen(currPixel);
                            blue += GImage.getBlue(currPixel);
                        }
                    }
                }

                pixelArray[i][j] = GImage.createRGBPixel(red / numPixels,
                        green / numPixels, blue / numPixels, GImage.getAlpha(pixelAnchor));
            }
        }
        return new GImage(pixelArray);
    }
    public GImage blur(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        int[][] pixelArrayCopy = new int[pixelArray.length][pixelArray[0].length];
        for (int i = 0; i < pixelArray.length; i++) {
            int[] row = pixelArray[i];
            for (int j = 0; j < row.length; j++) {
                int red = 0;
                int green = 0;
                int blue = 0;
                int numPixels = 0;
                int pixelAnchor = pixelArray[i][j];
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        int currPixel;
                        int pixelX = j - 1 + n;
                        int pixelY = i - 1 + m;
                        if (pixelX > -1 && pixelX < row.length && pixelY > -1 && pixelY < pixelArray.length) {
                            numPixels++;
                            currPixel = pixelArray[pixelY][pixelX];
                            red += GImage.getRed(currPixel);
                            green += GImage.getGreen(currPixel);
                            blue += GImage.getBlue(currPixel);
                        }
                    }
                }

                pixelArrayCopy[i][j] = GImage.createRGBPixel(red / numPixels,
                        green / numPixels, blue / numPixels, GImage.getAlpha(pixelAnchor));
            }
        }
        return new GImage(pixelArrayCopy);
    }


    public GImage crop(GImage source, int cropX, int cropY, int cropWidth, int cropHeight) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        int[][] croppedImage = new int[cropHeight][cropWidth];
        for (int i = 0; i < cropHeight; i++) {
            for (int j = 0; j < cropWidth; j++) {
                croppedImage[i][j] = pixelArray[cropY + i][cropX + j];
            }
        }
        return new GImage(croppedImage);
    }

    public GImage equalize(GImage source) {
        // TODO
        return null;
    }
}
