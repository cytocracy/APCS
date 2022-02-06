
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Pattern extends GraphicsProgram
{
    private static final double STARTX = 60;
    private static final double STARTY = 40;
    private static final int NUMSTRIPES = 13;
    private static final double WIDTH = 380;
    private static final double STRIPEHEIGHT = 30;

    public void run()
    {
        Color myColor = Color.pink;
        for(int i =0; i<NUMSTRIPES; i++){
            GRect stripe = new GRect(STARTX, STARTY + i*STRIPEHEIGHT, WIDTH, STRIPEHEIGHT);
            stripe.setFilled(true);
            stripe.setColor(myColor);
            add(stripe);
            if(myColor == Color.pink){
                myColor = Color.red;
            } else {
                myColor = Color.pink;
            }
        }
    }

}
