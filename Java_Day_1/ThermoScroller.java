
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class ThermoScroller extends GraphicsProgram
{
    private static final double BUTTON_SIZE = 60;
    private static final double OFFSET = 100;
    private static final double WINDOW_WIDTH = 754;
    private static final double WINDOW_HEIGHT = 492;
    
    GLabel label;
    GRect coldButton;
    GRect hotButton;
    Thermostat therm;
    
    public void run()
    {
        initializeVariables();
        animationLoop();
    }
    
    public void initializeVariables(){
        coldButton = new GRect(OFFSET, OFFSET, BUTTON_SIZE, BUTTON_SIZE);
        coldButton.setFilled(true);
        coldButton.setColor(Color.blue);
        add(coldButton);
        
        hotButton = new GRect(WINDOW_WIDTH-OFFSET-BUTTON_SIZE, OFFSET, BUTTON_SIZE, BUTTON_SIZE);
        hotButton.setFilled(true);
        hotButton.setColor(Color.red);
        add(hotButton);
        
        therm = new Thermostat(0,100);
        
        label = new GLabel("Temperature = " + therm.getValue(), 0, WINDOW_HEIGHT-OFFSET);
        add(label);      
    }
    
    public void animationLoop(){
        while(true){
            pause(10);
            label.setText("Temperature = " + therm.getValue());
            label.move(1,0);
            if(label.getX() > WINDOW_WIDTH){
                label.setLocation(0-label.getWidth(), label.getY());
            }
        }
    }
    
    public void mouseMoved(MouseEvent e){
        if(getElementAt(e.getX(), e.getY()) == coldButton){
            therm.colder();
            return;
        }
        if(getElementAt(e.getX(), e.getY()) == hotButton){
            therm.warmer();
            return;
        }
        if(getElementAt(e.getX(), e.getY()) == label){
            label.setColor(Color.pink);
            return;
        }
        label.setColor(Color.black);
    }
}
