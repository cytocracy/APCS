import acm.graphics.*;

public class GVectorPolygon extends GPolygon
{
    private double vx, vy;
    private double theta;
    private double maxX, maxY; // dimensions of the "window" to enable "wrapping around"

    private static final double MAXVELOCITY = 3;

    public GVectorPolygon(int windowWidth, int windowHeight)
    {
       super();
       vx = 0;
       vy = 0;
       theta = 0;
       maxX = windowWidth;
       maxY = windowHeight;
    }

    public void increaseVelocity(double numPixels)
    {
        double currVelocity = Math.sqrt(vx*vx + vy*vy);
        
        double targetVelocity = currVelocity + numPixels > MAXVELOCITY ? MAXVELOCITY : currVelocity + numPixels;
        vx = targetVelocity * Math.cos(Math.toRadians(theta));
        vy = targetVelocity * Math.sin(Math.toRadians(theta));
    }

    public void updatePosition()
    {
        move(vx, vy);
        if(getX() > maxX) setLocation(-getWidth(), getY());
        else if(getX() < -getWidth()) setLocation(maxX, getY());
        
        if(getY() > maxY) setLocation(getX(), -getHeight());
        else if(getY() < -getHeight()) setLocation(getX(), maxY);
    }

    public void rotate(double angle)
    {
        theta += angle;
        super.rotate(angle);
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
