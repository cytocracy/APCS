
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;

public class GridWorldMain
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Bug());
        world.add(new Rock());
        world.add(new Critter());
        world.add(new Chameleon());
        world.add(new Crab());
        world.show();
    }
}
