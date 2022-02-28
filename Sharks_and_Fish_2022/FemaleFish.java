import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class FemaleFish extends Fish
{
    // constants
    private final static int GESTATIONPERIOD = 5;
    
    // private instance variables
    private int turnsPregnant;
    private boolean isPregnant;
    
    public FemaleFish()
    {
        super();  // needed to call Fish constructor, which initializes age
        setColor(Color.PINK);
    }
    
    public void processActors(ArrayList<Actor> actors){
        if(getAge() >= BREEDAGE && !isPregnant){
           for(Actor a : actors){
               if(a instanceof MaleFish){
                   MaleFish mf = (MaleFish) a;
                   if(mf.getAge() >= BREEDAGE){
                       isPregnant = true;
                       setColor(Color.RED);
                       turnsPregnant = 0;
                   }
               } 
            }
        } else if (isPregnant){
            turnsPregnant++;
            if(turnsPregnant > GESTATIONPERIOD){
                if(giveBirth(getLocation())){
                    isPregnant = false;
                    setColor(Color.PINK);
                }
            }
        }
    }
    
    //return "success" of giving birth
    public boolean giveBirth(Location momLoc){
        //selectMoveLocation() just returns a random loc, so we can use that
        if(getMoveLocations().size() == 0) return false;
        Location birthLoc = selectMoveLocation(getMoveLocations());
        Fish f = Math.random() < 0.5 ? new MaleFish() : new FemaleFish();
        
        f.putSelfInGrid(getGrid(), birthLoc);
        return true;
    }
}
