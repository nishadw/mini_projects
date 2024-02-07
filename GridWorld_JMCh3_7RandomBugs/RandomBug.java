import info.gridworld.actor.Bug;
import java.awt.Color;

public class RandomBug extends Bug
{
    public RandomBug()
    {
        setColor( Color.YELLOW );
    }

    public RandomBug( Color bugColor )
    {
        setColor( bugColor );
    }

    public void turn(int angle)
    {
        
        setDirection(getDirection() + angle);
    }

    // Overrides Bug's act method
    public void act()
    {
        if ( canMove() && canMove()) 
        {
            move();
            int angle = 45 * (int)(Math.random() * 8);
            setDirection(getDirection() + angle);
        }
        else
        {
            turn();
        }
    }
}
