
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class ShowGObject extends GraphicsProgram
{

    public void run()
    {
        Ship a = new Ship(400, 400);
        a.move(100,100);
        add(a);
        
    }


}
