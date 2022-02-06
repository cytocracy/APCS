
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class MouseTracker extends GraphicsProgram
{
    GLabel label;
    GOval circle;
    public void run()
    {
        label = new GLabel("Hello world", 50, 50);
        label.setFont("Arial-Plain-36");
        add(label);

        circle = new GOval(-1000,-1000, 150, 150);
        circle.setFilled(true);
        circle.setColor(Color.gray);
        add(circle);
    }
    public void mouseClicked(MouseEvent event){
        circle.setLocation(event.getX()-75, event.getY()-75);
    }
    public void mouseMoved(MouseEvent event){
        label.setText("X = " + event.getX() + ", Y = " + event.getY());
        if(getElementAt(event.getX(), event.getY()) == label){
            label.setColor(Color.magenta);
        } else {
            if(getElementAt(event.getX(), event.getY()) == circle){
                label.setColor(Color.cyan);
            } else {
                label.setColor(Color.black);
            }
        }
    }
}
