import java.awt.Color;

public class Bullet extends GVectorPolygon
{
    private int numTurns;
    
    private static final int MAXTURNS=75;
    
    public Bullet(int windowWidth, int windowHeight)
    {
       super(windowWidth, windowHeight);  
       numTurns = 0;
       initVertices();
       setColor(Color.white);
       setFilled(true);
    }
    
    public void initVertices(){
        double[][] points = {
            {0,0},
            {2,0},
            {2,2},
            {0,2}
        };
        for(double[] point : points){
          addVertex(point[0], point[1]);  
        }
    }
    // complete this in version 0.5
    @Override
    public void updatePosition(){
        numTurns++;
        super.updatePosition();
    }
    
    public boolean stillMoving(){
        return numTurns<MAXTURNS;
    }


}
