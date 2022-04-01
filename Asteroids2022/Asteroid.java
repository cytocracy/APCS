import acm.graphics.*;
import java.awt.Color;

public class Asteroid extends GVectorPolygon
{
    private static final int NUMNODES = 20;
    private static final int MINRADIUS = 50;
    private static final int MAXRADIUS = 70;
    
    private double rotation;
    
    public Asteroid (int windowWidth, int windowHeight){
        super(windowWidth, windowHeight);
        rotation = Math.random();
        rotation = Math.random()<0.5 ? rotation * -1 : rotation;

        initVertices(NUMNODES);
        recenter();
        
        setColor(Color.white);
    }

    public void initVertices(int numNodes){
        double angleStep = Math.PI *2 / numNodes; //start with a circle, have this much angle turn per point
        for(int i=0; i< numNodes; i++){
            double targetAngle = angleStep *i; // angle to form circle for this bit of the circle
            double angle = targetAngle + (Math.random()-0.5) * angleStep * 0.25; // add randomness in angle
            double radius = MINRADIUS + Math.random()* (MAXRADIUS-MINRADIUS); //add randomness in height
            double x = Math.cos(angle) * radius; //find x and y components of these angles
            double y = Math.sin(angle) * radius;
            addVertex(x, y);
        }
    }

    @Override
    public void updatePosition(){
        rotate(rotation);
        super.updatePosition();
    }
}
