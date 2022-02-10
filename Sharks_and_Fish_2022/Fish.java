import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;

public class Fish extends Critter
{
    // constants (note that these are "protected", so they are
    // available in subclasses of Fish)
    protected final static int BREEDAGE = 5;
    protected final static int OLDAGE = 15;
    protected final static double PROBOFDYING = 0.20;

    // private instance variables
    private int age;
        
    public Fish()
    {
        super();
        age=0;
    }
    
    public void act(){
        super.act();
        if(age >= OLDAGE && Math.random() < PROBOFDYING) removeSelfFromGrid();
        age++;
    }
    
    public void processActors(ArrayList<Actor> actors){return;}
    
    public int getAge(){return age;}
    
    // finish this up
    
}
