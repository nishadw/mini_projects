import info.gridworld.actor.Bug;


public class CircleBug extends Bug
{
    // TODO instance variables
    private int steps;
    private int sideLength;

    public CircleBug( int n )
    {
        // TODO complete constructor
        steps = 0;
        sideLength = n;
    }

    public void act()
    {
        // TODO complete act method
        if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
}