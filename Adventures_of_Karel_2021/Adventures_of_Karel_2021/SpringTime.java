//Theo Parker


import stanford.karel.*;

public class SpringTime extends Karel {


    public void run()
    {
        for (int i =0; i <5; i++){
            findStump();
            ascendStump();
            makeFlower();
            descendStump();
        }
    }
    public void findStump(){
        while(frontIsClear()){
            move();
        }
    }
    public void ascendStump(){
        turnLeft();
        while(rightIsBlocked()){
            move();
        }
    }
    public void makeFlower(){
        putBeeper();
        move();
        putBeeper();
        turnRight();
        move();
        putBeeper();
        turnRight();
        move();
        putBeeper();
    }
    public void turnRight(){
        for (int i =0; i <3; i++){
            turnLeft();
        }
    }
    public void descendStump(){
        while (frontIsClear()){
            move();
        }
        turnLeft();
    }

}
