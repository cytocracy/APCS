
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class SpotLight extends GraphicsProgram
{
    GOval light; //global variable
    public void run()
    {
        
        light = new GOval(0, 0, 100, 100);
        light.setFilled(true);
        light.setColor(Color.yellow);
        add(light);
    }
    
    public void mouseMoved(MouseEvent event){
       light.setLocation(event.getX()-50, event.getY()-50); 
    }
    public void mouseClicked(MouseEvent event){
        light.setLocation(0,0);
    }
    
}
