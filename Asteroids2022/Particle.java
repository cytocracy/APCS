import java.awt.Color;

public class Particle extends GVectorPolygon
{

    public Particle(int windowWidth, int windowHeight)
    {
        super(windowWidth, windowHeight);

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

}
