// Theo Parker

import stanford.karel.*;

public class PickUpRemote extends Karel
{

    public void run()
    {
        move();
        move();
        pickBeeper();
        turnLeft();
        move();
        turnRight();
        move();
        putBeeper();
        move();
        
    }
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
   
}
