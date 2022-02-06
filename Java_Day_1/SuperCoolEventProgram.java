//Theo Parker

import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class SuperCoolEventProgram extends GraphicsProgram
{
    GOval light;
    GRect square1;
    GRect square2;
    GRect square3;
    GRect square4;
    Boolean isFlashlightOn = true;
    public void run()
    {
        light = new GOval(50, 50, 100, 100);
        light.setFilled(true);
        light.setColor(Color.yellow);
        add(light);
        
        square1 = new GRect(20, 400, 50, 50);
        square2 = new GRect(200, 400,50, 50);
        square3 = new GRect(20, 50, 50, 50 );
        square4 = new GRect(200, 50,50, 50);
        
        square1.setFilled(true);
        square2.setFilled(true);
        square3.setFilled(true);
        square4.setFilled(true);
        
        add(square1);
        add(square2);
        add(square3);
        add(square4);
        
    }
    
    public void mouseMoved(MouseEvent e){
        light.setLocation(e.getX()-50, e.getY()-50);
        if(isFlashlightOn == true){
                if(getElementAt(e.getX(), e.getY()) == square1){
                square1.setColor(Color.white);
            } else {
                square1.setColor(Color.black);
            }
            if(getElementAt(e.getX(), e.getY()) == square2){
                square2.setColor(Color.white);
            } else {
                square2.setColor(Color.black);
            }
            if(getElementAt(e.getX(), e.getY()) == square3){
                square3.setColor(Color.white);
            } else {
                square3.setColor(Color.black);
            }
            if(getElementAt(e.getX(), e.getY()) == square4){
                square4.setColor(Color.white);
            } else {
                square4.setColor(Color.black);
            }
        }
        
    }
    public void mouseClicked(MouseEvent e){
        if(isFlashlightOn == true){
            isFlashlightOn = false;
            light.setVisible(false);
        } else {
            isFlashlightOn = true;
            light.setVisible(true);
        }
    }

}
