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
        
        setColor(Color.white);
    }

    public void initVertices(){
        double[][] vertices = {
                {0.0, 0.0},
                {22.0, -21.0},
                {29.0, -19.0},
                {42.0, -19.0},
                {55.0, -14.0},
                {64.0, -8.0},
                {73.0, 2.0},
                {72.0, 15.0},
                {90.0, 25.0},
                {89.0, 32.0},
                {79.0, 47.0},
                {86.0, 57.0},
                {84.0, 71.0},
                {77.0, 80.0},
                {69.0, 87.0},
                {62.0, 98.0},
                {50.0, 101.0},
                {30.0, 101.0},
                {13.0, 111.0},
                {1.0, 107.0},
                {-16.0, 94.0},
                {-26.0, 83.0},
                {-29.0, 70.0},
                {-31.0, 57.0},
                {-21.0, 46.0},
                {-17.0, 28.0},
                {-16.0, 17.0},
                {-8.0, 15.0},
                {-5.0, 4.0},
            };

        for(double[] point : vertices){
            addVertex(point[0], point[1]);
        }
    }

    @Override
    public void updatePosition(){
        rotate(rotation);
        super.updatePosition();
    }
}
