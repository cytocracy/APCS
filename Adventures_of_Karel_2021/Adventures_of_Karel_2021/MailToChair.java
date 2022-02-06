import stanford.karel.*;

public class MailToChair extends Karel
{

    public void run()
    {
        move();
        turnLeft();
        move();
        turnRight();
        move();
        pickBeeper();
        turnAround();
        move();
        move();
        move();
        putBeeper();
        turnAround();
        move();
        turnRight();
        move();
        turnLeft();
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
