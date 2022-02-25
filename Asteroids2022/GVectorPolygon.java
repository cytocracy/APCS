import acm.graphics.*;

public class GVectorPolygon extends GPolygon
{
    private double vx, vy;
    private double theta;
    private double maxX, maxY; // dimensions of the "window" to enable "wrapping around"

    private static final double MAXVELOCITY = 3;

    public GVectorPolygon(int windowWidth, int windowHeight)
    {
       // to be written in version 0.1
    }

    public void increaseVelocity(double numPixels)
    {
       // to be written in version 0.1
    }

    public void updatePosition()
    {
        // to be written in version 0.1
    }

    public void rotate(double angle)
    {
        // to be written in version 0.1 
    }

    public double getTheta()
    {
        return theta;
    }

    public double getVelocityX()
    {
        return vx;
    }

    public double getVelocityY()
    {
        return vy;
    }

    public double getWindowWidth()
    {
        return maxX;
    }
    
    public double getWindowHeight()
    {
        return maxY;
    }
}
