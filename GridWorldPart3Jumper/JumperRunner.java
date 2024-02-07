import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location; // I added this myself
import info.gridworld.actor.Flower;
 
/**
*  TODO Write a one-sentence summary of your class here.
*  TODO Follow it with additional details about its purpose, what abstraction
*  it represents, and how to use it.
*
*  @author  Ethan Chang
*  @version 10/20/2021
*  @author  Period: 6
*  @author  Assignment: GridWorld_Part3_Jumper
*
*  @author  Sources:
*/
public class JumperRunner
{
    Jumper jumper = new Jumper();
    static Location test = new Location(7, 8);

    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
      
        world.add( test, alice );
        world.show();  
   }
}
