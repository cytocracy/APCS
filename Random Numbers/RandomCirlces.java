
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class RandomCirlces extends GraphicsProgram
{

    public void run()
    {
        int numCircles = (int)(Math.random() * 100) + 200;
        for(int i=0; i<numCircles; i++){
            int x = (int)(Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight());
            int diameter = (int)(Math.random() * 181) + 20;
            GOval circle = new GOval(x, y, diameter, diameter);
            circle.setFilled(true);
            int red = (int)(Math.random() * 256);
            int blue = (int)(Math.random() * 256);
            int green = (int)(Math.random() * 256);
            Color myColor = new Color(red, green, blue);
            circle.setColor(myColor);
            add(circle);
        }
    }


}
