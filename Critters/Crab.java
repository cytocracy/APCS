import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.Color;
import java.util.ArrayList;

public class Crab extends Critter
{
    public Crab()
    {
        super();
        setColor(Color.red);
    }
    public ArrayList<Location> getMoveLocations(){
        ArrayList<Location> result = new ArrayList<Location>();
        Location curr = getLocation();
        int dir = getDirection();
        Grid<Actor> gr = getGrid();
        
        Location left = curr.getAdjacentLocation(dir + Location.LEFT);
        if(gr.isValid(left) && gr.get(left) == null){
            result.add(left);
        }
        
        Location right = curr.getAdjacentLocation(dir + Location.RIGHT);
        if(gr.isValid(right) && gr.get(right) == null){
            result.add(right);
        }
            
        return result;
    }
    public void makeMove(Location loc){
        if(getLocation().equals(loc)){
            if (Math.random() < 0.5) setDirection(getDirection() + Location.LEFT);
            else setDirection(getDirection() + Location.RIGHT);
        } else super.makeMove(loc);
    }
    public ArrayList<Actor> getActors(){
        ArrayList<Actor> result = new ArrayList<Actor>();
        Location curr = getLocation();
        int dir = getDirection();
        Grid<Actor> gr = getGrid();
        
        Location left = curr.getAdjacentLocation(dir + Location.HALF_LEFT);
        if(gr.isValid(left) && gr.get(left) != null){
            result.add(gr.get(left));
        }
        
        Location right = curr.getAdjacentLocation(dir + Location.HALF_RIGHT);
        if(gr.isValid(right) && gr.get(right) != null){
            result.add(gr.get(right));
        }
        
        Location front = curr.getAdjacentLocation(dir + Location.AHEAD);
        if(gr.isValid(front) && gr.get(front) != null){
            result.add(gr.get(front));
        }
        
        
        return result;
    }
}
