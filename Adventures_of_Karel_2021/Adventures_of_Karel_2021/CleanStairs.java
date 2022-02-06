//Theo Parker

import stanford.karel.*;

public class CleanStairs extends Karel
{

    public void run()
    {
        while (frontIsBlocked()){
            goUpOneStep();
            pickBeeper();
        }
        
        //karel celebrates!
        endSequence();
        
    }
    public void goUpOneStep(){
        turnLeft();
        move();
        turnRight();
        move();
    }
    public void turnRight(){
        for(int i =0; i < 3; i++){
            turnLeft();
        }
    }
    public void endSequence(){
        move();
        move();
        turnRight();
        while (frontIsClear()){
            descend();
        }
        turnLeft();
    }
    public void spin(){
        for (int i=0;i<4; i++){
            turnLeft();
        }
    }
    public void descend(){
        move();
        spin();
    }
}
