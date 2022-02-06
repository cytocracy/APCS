import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.Color;


public class SHPBug extends Bug
{
    public SHPBug()
    {
        super();
        setColor(Color.red);
    }
    
    public void act(){
        if(getColor().equals(Color.red)) super.setColor(Color.white);
        else super.setColor(Color.red);
        super.act();
    }
    
    public void setColor(Color color){return;}

}
