import stanford.karel.*;

public class HurricaneDamage extends Karel
{

    public void run()
    {
        for(int i =0; i <3; i ++){
            findRubble();
            buildHouse();
        }
    }
    
    public void findRubble(){
        while (noBeepersPresent()){
            move();
        }
        pickBeeper();
    }
    public void buildHouse(){
        move();
        turnLeft();
        buildThree();
        turnLeft();
        move();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
        buildThree();
        turnLeft();
        move();
        turnLeft();
        move();
        buildThree();
        turnLeft();
        move();
        move();
        if(frontIsClear()){
            move();
        } else {
            celebrate();
        }
        
    }
    public void turnRight(){
        for (int i = 0; i <3; i++){
            turnLeft();
        }
    }
    public void buildThree(){
        for(int i = 0; i <2; i++){
            putBeeper();
            move();
        }
        putBeeper();
    }
    public void celebrate(){
        turnLeft();
        while(frontIsClear()){
            move();
        }
        turnLeft();
        while(frontIsClear()){
            putBeeper();
            move();
        }
        putBeeper();
    }
}
