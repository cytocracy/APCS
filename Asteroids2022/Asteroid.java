import acm.graphics.*;
import java.awt.Color;

public class Asteroid extends GVectorPolygon
{
    private double rotation;

    public Asteroid(int windowWidth, int windowHeight)
    {
       super(windowWidth, windowHeight);
       rotation = Math.random();
       
       initVertices();
       recenter();
    }
    
    public void initVertices(){
        int[][] vertices = {
            {0, 0},
            {45, -10},
            {60, 18},
            {55, 50},
            {25, 55},
            {10, 45},
            {-1, 40},
            {-5, 19},
            {-7, 12},
            {-3, 7},
            {}
        };
        
        for(int[] point : vertices){
            addVertex(point[0], point[1]);
        }
    }
    
    

    
}
