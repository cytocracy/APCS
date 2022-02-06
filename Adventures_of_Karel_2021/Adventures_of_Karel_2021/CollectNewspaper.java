
import stanford.karel.*;

public class CollectNewspaper extends Karel
{

    public void run()
    {
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        pickBeeper();
        turnAround();
        move();
        move();
        move();
        turnRight();
        move();
        turnRight();
    }
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    public void turnAround(){
        turnLeft();
        turnLeft();
    }

}
