
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Traffic extends GraphicsProgram
{
    private static final int NUMTYPES = 8;
    private static final int NUMLANES = 12;
    private static final int VEHICLEHEIGHT = 80;

    public void run()
    {
        setSize(1200, NUMLANES*VEHICLEHEIGHT);
        
        GImage[] vehicles = new GImage[NUMLANES];
        double[] speeds = new double[NUMLANES];
        
        for(int i=0; i<vehicles.length; i++){
            int x = (int)(Math.random() * 1200);
            int num = (int) (Math.random() * NUMTYPES);
            vehicles[i] = new GImage("vehicle" + num + ".jpg", x, VEHICLEHEIGHT * i);
            add(vehicles[i]);
            
            speeds[i] = Math.random() * 5 + 2;
            
            
        }
        
        while (true){
            pause(20);
            for(int i=0; i<vehicles.length; i++){
                vehicles[i].move(-speeds[i], 0);
                if(vehicles[i].getX() < 0-vehicles[i].getWidth())vehicles[i].setLocation(1200, vehicles[i].getY());
            }
        }

    }

}

