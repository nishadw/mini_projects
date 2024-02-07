import info.gridworld.actor.Actor;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;


public class SpiralBugRunner
{
    public static void main( String[] args )
    {
        UnboundedGrid grid = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld( grid );

        // TODO runner code
        SpiralBug alice = new SpiralBug( 6 );
        world.add( new Location( 7, 8 ), alice );
        world.show();
    }
}