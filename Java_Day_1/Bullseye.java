
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Bullseye extends GraphicsProgram
{
    private static final int NUMRINGS = 10;
    private static final int RINGWIDTH = 20;
    private static final int INITIALX = 260;
    private static final int INITIALY = 210;

    public void run()
    {
        int index;
        Color myColor = Color.red;
        for(int i=0; i<NUMRINGS; i++){
            index = NUMRINGS-i;
            GOval ring = new GOval(INITIALX-(RINGWIDTH)*index, 
            INITIALY-(RINGWIDTH)*index, (index)*(RINGWIDTH*2), (index)*(RINGWIDTH*2));
            ring.setFilled(true);
            ring.setColor(myColor);
            if(myColor == Color.red){
                myColor = Color.black;
            } else {
                myColor = Color.red;
            }
            
            
            add(ring);
        }
    }

}

