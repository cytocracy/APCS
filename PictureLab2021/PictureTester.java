/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
    public static void main(String[] args)
    {
        Picture picture = new Picture("images/" + "baby.jpg");
        picture.show();
        picture.edgeDetection(2); 
        picture.explore();
        //picture.upsideDown(); 
        
        //picture.explore();
    }
}