
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class BarGraph extends GraphicsProgram
{
    private static final int NUMBARS=12;
    private static final int BARWIDTH=20;
    private static final int TALLESTBARHEIGHT=256;
    private static final int DECREASEBARAMOUNT=10;
    private static final int BOTTOMLEFT_X = 45;
    private static final int BOTTOMLEFT_Y = 310;
    
    GLabel label;
    public void run()
    {
       int currHeight = TALLESTBARHEIGHT;
       for(int i=0; i<NUMBARS; i++){
           GRect bar = new GRect(BOTTOMLEFT_X + BARWIDTH*i, BOTTOMLEFT_Y - currHeight, BARWIDTH, currHeight);
           bar.setColor(Color.blue);
           add(bar);
           currHeight -= DECREASEBARAMOUNT;
       }
       label = new GLabel("Hello world", 50, 50);
        label.setFont("Arial-Plain-36");
        add(label);
    }
    public void mouseMoved(MouseEvent event){
        label.setText("X = " + event.getX() + ", Y = " + event.getY());
        
    }
}