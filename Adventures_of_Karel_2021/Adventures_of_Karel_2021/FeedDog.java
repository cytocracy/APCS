import stanford.karel.*;

public class FeedDog extends Karel
{

    public void run()
    {
        move();
        move();
        turnLeft();
        move();
        turnRight();
        move();
        move();
        turnLeft();
        move();
        move();
        turnRight();
        move();
        turnRight();
        move();
        putBeeper();
        turnAround();
        move();
        turnLeft();
        move();
        move();
        turnLeft();
        move();
        move();
        turnRight();
        move();
        turnAround();
    }
    
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    public void turnAround() {
        turnLeft();
        turnLeft();
    }
}
