import java.awt.Color;

public class Ship extends GVectorPolygon
{

    //private double vRotation;
    
    public Ship(int windowWidth, int windowHeight)
    {
        super(windowWidth, windowHeight);
        initVertices();
        
        recenter();
        setColor(Color.white);
        rotate(90);
        //vRotation = 0;
    }
    
    public void initVertices(){
        double[][] points = {
            {0, 0},
            {-20, 8},
            {-15, 0},
            {-20, -8}
        };
        
        for(double[] point : points){
            addVertex(point[0], point[1]);
        }
    }
    
    /*public void changeRotation(boolean direction){
        vRotation = direction ? vRotation + 1 : vRotation - 1;
    }*/
    
    @Override
    public void updatePosition(){
        /*if(vRotation > 10) vRotation = 10;
        if(vRotation < -10) vRotation = 10;
        */
        /*rotate(vRotation);
        if(vRotation > 0) vRotation --;
        else vRotation++;*/
        System.out.println(getTheta());
        super.updatePosition();
        
        
    }

    
    
    // you'll add a method here in version 0.5.1

}
