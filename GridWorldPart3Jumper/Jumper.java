import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
 
/**
*  A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
*  turn. A jumper can remove another jumper by jumping on them.
*
*  @author  Ethan Chang
*  @version 10/20/2021
*  @author  Period: 6
*  @author  Assignment: GridWorld_Part3_Jumper
*
*  @author  Sources:
*/
public class Jumper extends Bug implements Edible
{
   // TODO constructor(s)
    public Jumper ()
    {
    }
 
   // TODO method(s)
    public void act()
    {
        Location location = canMoveHelper();
 
        if (location != null)
        {
            move(location);
        }
 
        else
        {
            turn();
        }
    }
 
    private Location canMoveHelper()
    {
        Location location = getLocation();
        Location location2 = null;
 
        switch (getDirection())
        {
            case Location.NORTH:
                if (location.getRow() < 2)
                {
                    return null;
                }
 
                location2 = new Location(location.getRow() - 2, location.getCol());
              
                Actor other = getGrid().get(location2);
 
                if (other == null || !(other instanceof Edible))
                {
                    return null;
                }
 
                break;
          
            case Location.NORTHEAST:
                if (location.getRow() < 2 || location.getCol() > getGrid().getNumCols() - 1)
                {
                    return null;
                }
 
                location2 = new Location(location.getRow() - 2, location.getCol() + 2);
              
                other = getGrid().get(location2);
 
                break;
 
            case Location.EAST:
                if (location.getCol() > getGrid().getNumCols() - 1)
                {
                    return null;
                }
 
                location2 = new Location(location.getRow(), location.getCol() + 2);
              
                other = getGrid().get(location2);
 
                break;
 
            case Location.SOUTHEAST:
                if (location.getRow() > getGrid().getNumRows() - 1 || location.getCol() > getGrid().getNumCols() - 1)
                {
                    return null;
                }
 
                location2 = new Location(location.getRow() + 2, location.getCol() + 2);
              
                other = getGrid().get(location2);
 
                break;
 
            case Location.SOUTH:
                if (location.getRow() > getGrid().getNumRows() - 1)
                {
                    return null;
                }
 
                location2 = new Location(location.getRow() + 2, location.getCol());
              
                other = getGrid().get(location2);
 
                break;
 
            case Location.SOUTHWEST:
                if (location.getRow() > getGrid().getNumRows() - 1 || location.getCol() < 2)
                {
                    return null;
                }
 
                location2 = new Location(location.getRow() + 2, location.getCol() - 2);
              
                other = getGrid().get(location2);
 
                break;
 
            case Location.WEST:
                if (location.getCol() < 2)
                {
                    return null;
                }
 
                location2 = new Location(location.getRow(), location.getCol() - 2);
              
                other = getGrid().get(location2);
              
                break;
 
           case Location.NORTHWEST:
                if (location.getCol() < 2 || location.getRow() < 2)
                {
                    return null;
                }
 
                location2 = new Location(location.getRow() - 2, location.getCol() - 2);
              
                other = getGrid().get(location2);
 
                break;
              
       }
        return location2; // check location that will be moving to
   }
 
   public void move (Location location2)
   {
        Grid<Actor> temp = getGrid(); // should it be Grid<Actor>? Before it was just Grid temp = ...
        removeSelfFromGrid();
        putSelfInGrid(temp, location2);
 
   }
 
   public boolean canMove()
   {
        return canMoveHelper() != null;
   }
}