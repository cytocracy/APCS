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
        
        vy *=-1;
        
        
        
        
        
        
        //vx = 
        
        
    }

    public void updatePosition()
    {
        
        move(vx, vy);
        GRectangle box = getBounds();
        
        //setBounds(box.setLocation(0 - box.getWidth(), box.getY()));
        
        if(box.getX() > maxX) move(-(maxX + box.getWidth()), 0);
        else if(box.getX() < 0 - box.getWidth()) move(maxX + box.getWidth(), 0);
        
        if(getY() > maxY + box.getHeight()) move(0, -(maxY + box.getHeight()));
        else if(box.getY() < 0 - box.getHeight()) move(0, maxY+box.getHeight());
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
