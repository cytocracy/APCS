
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateAsteroid extends GraphicsProgram
{

    private boolean hasStarted = false;
    private double startX;
    private double startY;
    private ArrayList<GPoint> points = new ArrayList<GPoint>();
    GPolygon p;
    
    public void run()
    {
        p = new GPolygon();
        p.move(100,100);
    }
    
    public void mouseClicked(MouseEvent e){
        if(!hasStarted){
            startX = e.getX();
            startY = e.getY();
            //GPoint point = new GPoint(0, 0);
            p.addVertex(0, 0);
            points.add(new GPoint(0, 0));
            add(p);
            hasStarted = true;
            return;
        }
        double x = e.getX() - 100;
        double y = e.getY() - 100;
        p.addVertex(x, y);
        points.add(new GPoint(x, y));
        reDraw();
        
    }


    public void reDraw(){
        removeAll();
        add(p);
    }
    
    public ArrayList<GPoint> getPoints(){
        return points;
    }
}
