
import acm.program.*;

public class DistanceFormula extends ConsoleProgram
{

    public void run()
    {
        while(true){
            double firstX = readDouble("Enter the first x-coordinate: ");
            double firstY = readDouble("Enter the first y-coordinate: ");
            
            double secondX = readDouble("Enter the second x-coordinate: ");
            double secondY = readDouble("Enter the second y-coordinate: ");
            
            double dist = distance(firstX, firstY, secondX, secondY);
            println("Distance = " + dist);
        
        }
    }
    
    public double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
    }

}
