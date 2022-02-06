import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** ADD ALL NEW METHODS HERE */
    
    public void zeroGreen(){
        Pixel[] pixels = getPixels();
        
        for(Pixel pixel : pixels) {
            pixel.setGreen(0);
        }
    }
    public void swapRedBlue(){
        Pixel[] pixels = getPixels();
        
        for(Pixel pixel : pixels) {
            int redValue = pixel.getRed();
            pixel.setRed(pixel.getBlue());
            pixel.setBlue(redValue);
        }
    }
    public void grayScale(){
        Pixel[] pixels = getPixels();
        for(Pixel pixel : pixels){
            int average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3;
            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
        }
    }
    public void revealGold(){
        Pixel[] pixels = getPixels();
        for(Pixel pixel : pixels){
            pixel.setRed(pixel.getRed() * 10);
            pixel.setBlue(pixel.getRed());
            pixel.setGreen(pixel.getRed());
        }
    }
    public void upsideDown(){
        Pixel[][] pixels = getPixels2D();
        
        for (int r=0; r<pixels.length/2; r++){
            for (int c=0; c<pixels[0].length; c++){
                Color save = pixels[r][c].getColor();
                pixels[r][c].setColor(pixels[pixels.length-1-r][c].getColor());
                pixels[pixels.length-1-r][c].setColor(save);
            }
        }
    }
    public void edgeDetection(int rgbBuffer){
        Pixel[][] pixels = getPixels2D();
        
        for (int r=0; r<pixels.length; r++){
            for (int c=0; c<pixels[0].length-1; c++){
                if(pixels[r][c].colorDistance(pixels[r][c+1].getColor()) > rgbBuffer)
                    pixels[r][c].setColor(Color.black);
                else pixels[r][c].setColor(Color.white);
            }
        }
    }
} // this } is the end of class Picture, put all new methods before this
