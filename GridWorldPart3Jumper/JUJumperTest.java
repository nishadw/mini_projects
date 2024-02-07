import info.gridworld.actor.*;
import info.gridworld.grid.*;
 
import org.junit.*;
import static org.junit.Assert.*;
 
/**
*  Jumper tests:.
*  test01 - jumper next to edge of grid - should turn
*  test02 - jumper 2 from edge of grid - should turn
*  test03 - 1 in front of jumper is empty, 2 in front is rock - should turn
*  test04 - 1 in front of jumper is empty, 2 in front is an Actor that implements Edible - should move forward by 2
*  test05 - another jumper is two spaces ahead - should move forward by 2
*  (this is basically the same as test04 because jumper enables Edible so no need for a test05)
*  test06 - N/A
*  test07 - N/A
*
*  @author  Ethan Chang
*  @version 10/26/2021
*
*  @author  Period: 6
*  @author  Assignment - GridWorld Part 3 Jumper
*
*  @author  Sources:
*/
public class JUJumperTest
{
   /*
    * Variables used by the test methods.
    */
   private Grid<Actor> grid;
   private ActorWorld world;
   private Jumper jumper1;
 
   /**
    * Invoked before each test to instantiate the objects
    * used for every test.
    */
   @Before public void initialize()
   {
       grid = new BoundedGrid<Actor>(8, 8);
       world = new ActorWorld(grid);
       jumper1 = new Jumper();
   }
 
   /**
    * test01 - jumper next to edge of grid - should turn
    */
   @Test
   public void jumperNextToEdgeOfGridShouldTurn()
   {
       Location loc = new Location(0, 3);
       world.add(loc, jumper1);
       jumper1.act();
 
       assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
   }
 
   /**
    * test02 - jumper 2 from edge of grid - should turn.
    */
   @Test
   public void jumper2FromEdgeOfGridShouldTurn()
   {
       Location loc = new Location(1, 3);
       world.add(loc, jumper1);
       jumper1.act();
 
       assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
   }
 
   /**
    * test03 - 1 in front of jumper is empty, 2 in front is rock - should turn
    */
   @Test
   public void test03()
   {
       Location loc = new Location(2, 3);
       world.add(loc, jumper1);
       jumper1.act();
 
       assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
   }
 
   /**
    * test04 - another jumper (Edible object) is two spaces ahead - should move forward by 2
    */
   @Test
   public void test04()
   {
       Jumper jumper2 = new Jumper();
 
       Location loc = new Location(2, 3);
       world.add(loc, jumper1);
       jumper1.act();
 
       Location loc2 = new Location(0, 3);
       world.add(loc2, jumper2);
       assertTrue(testOccupied(loc, jumper1, Location.NORTH));
   }
 
   /**
    * test05 -
    */
   @Test
   public void test05()
   {
      
   }
 
   /**
    * test06 -
    */
   @Test
   public void test06()
   {
      
   }
 
   /**
    * test07 -
    */
   @Test
   public void test07()
   {
      
   }
 
   /**
    * Test helper method to test for empty location.
    *
    * @param loc null location if empty
    * @return true if all assertions pass
    */
   private boolean testEmpty(Location loc)
   {
       Actor empty = grid.get( loc );
       assertNull( "<<<<< " + loc + " should be empty. >>>>>", empty );
 
       return true;
   }
 
   /**
    * Test helper method to test that object is in a location, and has
    * a consistent loc, and direction dir.
    *
    * @param loc location that should be occupied
    * @param a   actor that should be in location loc
    * @param dir direction this actor should be facing
    * @return true if all assertions pass
    */
   private boolean testOccupied(Location loc, Actor a, int dir)
   {
       Actor found = grid.get( loc );
       assertSame( "<<<<< " + loc + " should contain the actor. >>>>>",
           a, found );
       assertEquals( "<<<<< Loc should be " + loc + " >>>>>",
           loc, found.getLocation() );
       assertEquals( "<<<<< Dir should be " + dir + " >>>>>",
           dir, found.getDirection() );
 
       return true;
   }
}
