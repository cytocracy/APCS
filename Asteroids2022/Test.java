
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;


public class Test extends GraphicsProgram
{

    public void run()
    {
        resize(400, 400);
        GVectorPolygon gvp = new GVectorPolygon(400, 400);
        
        gvp.addVertex(10, 0);
        gvp.addVertex(20, -10);
        gvp.addVertex(35, 15);
        gvp.addVertex(30, 25);
        gvp.addVertex(12, 40);
        gvp.addVertex(8, 17);
        gvp.addVertex(-1, 18);
        gvp.addVertex(-13, 19);
        gvp.addVertex(-15, 12);
        gvp.addVertex(-3, 7);
        
        gvp.rotate(13);
        gvp.increaseVelocity(2.5);
        
        add(gvp);
        
        while(true){
            gvp.updatePosition();
            pause(20);
        }
    }


}
