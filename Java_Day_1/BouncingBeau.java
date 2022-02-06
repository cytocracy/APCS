
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class BouncingBeau extends GraphicsProgram
{

    public void run()
    {
        GImage beau = new GImage("beau.jpg", 100, 150);
        add(beau);
        
        int vx = 1;
        int vy = 1;
        while(true){ //animation loop
            beau.move(vx,vy);
            if(beau.getY() + beau.getHeight() > getHeight()){
                vy = -vy;
            }
            if(beau.getX()+ beau.getWidth()> getWidth()){
                vx = -vx;
            }
            if(beau.getY() < 0){
                vy = -vy;
            }
            if(beau.getX() < 0){
                vx = -vx;
            }
            pause(1);
        }
    }
}
