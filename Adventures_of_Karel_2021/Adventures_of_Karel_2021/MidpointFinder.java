import stanford.karel.*;

public class MidpointFinder extends Karel
{

    public void run()
    {
        layRowOfBeepers(); //leave first and last space empty :)
        //you must start on a beeper
        while(beepersPresent()){
            pickUpLastBeeperAtOtherEnd(); //reposition so you are on a beeper
        }
        turnAround();
        move();
        turnAround();
    }
    public void layRowOfBeepers(){
        move();
        while(frontIsClear()){
            putBeeper();
            move();
        }
        turnAround();
        move();
    }
    public void turnAround(){
        turnLeft();
        turnLeft();
    }
    public void pickUpLastBeeperAtOtherEnd(){
        while(beepersPresent()){
            move();
        }
        turnAround();
        move();
        pickBeeper();
        move();
    }

}
