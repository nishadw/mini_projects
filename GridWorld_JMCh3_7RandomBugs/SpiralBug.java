import info.gridworld.actor.Bug;


public class SpiralBug extends Bug
{
    // TODO instance variables

    private int steps;
    private int sideLength;

    public SpiralBug( int n )
    {
        // TODO complete constructor
        steps = 0;
        sideLength = n;
    }

    public void act()
    {
        if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
            sideLength++;
        }
    }
}