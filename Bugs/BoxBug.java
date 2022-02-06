import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.Color;

public class BoxBug extends Bug
{

    private int counter;
    private int length;
    public BoxBug(int size)
    {
        super();
        setColor(Color.magenta);
        counter = 0;
        length = size;
    }

    public void act(){
        if(counter < length && canMove()){
            move();
            counter++;
        }else{
            counter = 0;
            turn();
            turn();
        }
    }

}
