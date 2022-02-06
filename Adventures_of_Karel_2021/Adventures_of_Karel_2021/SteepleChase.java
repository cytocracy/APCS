import stanford.karel.*;

public class SteepleChase extends Karel
{

    public void run()
    {
       for (int i=0; i < 8; i++){
           jumpHurdle();
       }
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
    public void jumpHurdle(){
        ascendHurdle();
        move();
        descendHurdle();
    }
    public void ascendHurdle(){
        turnLeft();
        while(rightIsBlocked()){
            move();
        }
        turnRight();
    }
    public void descendHurdle(){
        turnRight();
        while (frontIsClear()){
            move();
        }
        turnLeft();
    }
}
