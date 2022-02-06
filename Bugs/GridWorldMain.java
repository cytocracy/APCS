
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
        world.add(new LeftBug());
        world.add(new BoxBug(5));
        world.add(new SHPBug());
        world.show();
    }
}
