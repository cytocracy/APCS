

import info.gridworld.actor.Critter;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import java.awt.Color;
import info.gridworld.grid.*;

public class Shark extends Critter
{
    // constants
    private static final int MUSTEAT = 8;

    // private instance variables
    private int turnsSinceEaten;
    
    public Shark()
    {
        super();
        setColor(Color.black);
        turnsSinceEaten = 0;
    }

    @Override
    public void act(){
        if(getGrid() == null) return;   
        processActors(getActors());
        
        makeMove(selectMoveLocation(getMoveLocations()));
        if(turnsSinceEaten > MUSTEAT){
            removeSelfFromGrid();
        }
    }
        
    public void processActors(ArrayList<Actor> actors){
        ArrayList<Actor> fishToEat = new ArrayList<Actor>();
        for (Actor a : actors){
            if(a instanceof Fish) fishToEat.add(a);
        }
        
        if(fishToEat.size() > 0){
            int index = (int) (Math.random() * fishToEat.size());
            fishToEat.get(index).removeSelfFromGrid();
            turnsSinceEaten = 0;
            return;
        }
        turnsSinceEaten++;
    }
    
    public void makeMove(Location loc){
        Location curr = getLocation();
        if(curr.equals(loc)){
            if(Math.random() < 0.5){
                setDirection(getDirection() + Location.HALF_LEFT);
            } else setDirection(getDirection() + Location.HALF_RIGHT);
            return;
        }
        int dir = curr.getDirectionToward(loc);
        setDirection(dir);
        super.makeMove(loc);
    }
    
    @Override
    public ArrayList<Location> getMoveLocations(){
        ArrayList<Location> result = new ArrayList<Location>();
        Location curr = getLocation();
        Grid<Actor> gr = getGrid();
        int dir = getDirection();
        
        Location left = curr.getAdjacentLocation(dir + Location.HALF_LEFT);
        if(gr.isValid(left) && gr.get(left) == null){
            result.add(left);
        }
        
        Location right = curr.getAdjacentLocation(dir + Location.HALF_RIGHT);
        if(gr.isValid(right) && gr.get(right) == null){
            result.add(right);
        }
        
        Location center = curr.getAdjacentLocation(dir + Location.AHEAD);
        if(gr.isValid(center) && gr.get(center) == null){
            result.add(center);
        }
        
        return result;
    }   
    
    public Location selectMoveLocation(ArrayList<Location> locs){
        return locs.size() != 0 ? super.selectMoveLocation(locs) : getLocation();
    }
    
    
    
}
