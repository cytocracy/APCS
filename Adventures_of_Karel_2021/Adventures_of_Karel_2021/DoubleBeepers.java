import stanford.karel.*;

public class DoubleBeepers extends Karel
{

    public void run()
    {
        move();
        doubleThePileImStandingOn();
        moveBackwards();
    }
    public void moveBackwards(){
       turnAround();
       move();
       turnAround();
    }
    public void turnAround(){
        turnLeft();
        turnLeft();
    }
    
    public void doubleThePileImStandingOn(){
        makeAPileTwiceAsBigNextDoor();
        movePileNextDoorBack();
    }
    public void makeAPileTwiceAsBigNextDoor(){
        while(beepersPresent()){
            pickBeeper();
            move();
            putBeeper();
            putBeeper();
            moveBackwards();
        }
    }
    public void movePileNextDoorBack(){
        move();
        while(beepersPresent()){
            pickBeeper();
            moveBackwards();
            putBeeper();
            move();
        }
        moveBackwards();
    }
}
