
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Stoplight extends GraphicsProgram
{
    private static final double BULB_RADIUS = 60; 
    private static final double WINDOW_WIDTH = 754; 
    private static final double WINDOW_HEIGHT = 492;

    public void run()
    {
        createRect();
        createYellowBulb();
        createRedBulb();
        createGreenBulb();
    }
    public void createRect(){
        GRect box = new GRect(WINDOW_WIDTH/2-BULB_RADIUS, WINDOW_HEIGHT/2-BULB_RADIUS*3, BULB_RADIUS*2, BULB_RADIUS * 6);
        box.setFilled(true);
        box.setColor(Color.gray);
        add(box);
    }
    public void createYellowBulb(){
        GOval yCircle = new GOval(WINDOW_WIDTH/2-BULB_RADIUS, WINDOW_HEIGHT/2-BULB_RADIUS, BULB_RADIUS*2, BULB_RADIUS*2);
        yCircle.setFilled(true);
        yCircle.setColor(Color.yellow);
        add(yCircle);
    }
    public void createRedBulb(){
        GOval rCircle = new GOval(WINDOW_WIDTH/2-BULB_RADIUS, WINDOW_HEIGHT/2-BULB_RADIUS*3, BULB_RADIUS*2, BULB_RADIUS*2);
        rCircle.setFilled(true);
        rCircle.setColor(Color.red);
        add(rCircle);
    }
    public void createGreenBulb(){
        GOval gCircle = new GOval(WINDOW_WIDTH/2-BULB_RADIUS, WINDOW_HEIGHT/2+BULB_RADIUS, BULB_RADIUS*2, BULB_RADIUS*2);
        gCircle.setFilled(true);
        gCircle.setColor(Color.green);
        add(gCircle);
    }


}
