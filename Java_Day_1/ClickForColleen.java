
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class ClickForColleen extends GraphicsProgram
{

    public void run()
    {
        
    }

    public void mouseMoved(MouseEvent event){
        int x = event.getX();
        int y = event.getY();
        GImage colleen = new GImage("colleen.jpg", x, y);
        add(colleen);
    }
}

