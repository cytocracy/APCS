
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Tree extends GraphicsProgram
{

    public void run()
    {
        branch(120, 200, 50 , 90);
    }

    private void branch(double x, double y, double len, double angle)
    {
        pause(20);
        if (len < 2)
        {}
        else
        {
            double angleR = angle * Math.PI / 180;
            double xEnd = x + Math.cos(angleR) * len;
            double yEnd = y - Math.sin(angleR) * len;
            GLine line = new GLine(x, y, xEnd, yEnd);
            add(line);
            branch(xEnd, yEnd, len * 0.75, angle + 20);
            branch(xEnd, yEnd, len * 0.75, angle - 20);
        }
    }

}
