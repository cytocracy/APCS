
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Blocks extends GraphicsProgram
{

    public void run()
    {
        for (int i =0; i < 15; i++){
            GRect block = new GRect(100, 200 + 60*i, 40, 50);
            add(block);
        }
    }

}
