
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class RandomCircles extends GraphicsProgram
{

    public void run()
    {
        int numCircles = (int)(Math.random() * 500) + 100;
        for (int i=0; i<numCircles; i++)
        {
            int x = (int)(Math.random() * getWidth());
            int y = (int)(Math.random() * getHeight());
            int diam = (int)(Math.random() * 200) + 50;
            GOval circle = new GOval(x, y, diam, diam);
            circle.setFilled(true);
            int red = (int)(Math.random() * 256);
            int green = (int)(Math.random() * 256);
            int blue = (int)(Math.random() * 256);
            Color randomColor = new Color(red, green, blue);
            circle.setColor(randomColor);
            add(circle);
        }
    }


}
