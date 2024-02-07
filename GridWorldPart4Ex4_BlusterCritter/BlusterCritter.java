import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;

import java.awt.Color;

/**
 * @author Nishad
 * @version 11/16
 * @author Period: 6
 * @author Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 * @author Sources: I received help from my brain (well done brain)
 */
public class BlusterCritter
    extends Critter
{
    private int          numero;
    private final double factor = 0.05;

    /**
     * 
     * @param c is the # of critters it takes for the chameleon to darken
     */
    public BlusterCritter(int c)
    {
        numero = c;
        setColor(Color.GREEN);
    }


    /**
     * sees how many critters are there in those 24 respective blocks
     * Postcondition: The state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();

        for (int row = this.getLocation().getRow() - 2; 
            row <= this.getLocation().getRow() + 2; 
            row++)
        {
            for (int col = this.getLocation().getCol() - 2;
                col <= this.getLocation().getCol() + 2; 
                col++)
            {
                Location location = new Location(row, col);
                if (this.getGrid().isValid(location))
                {
                    Actor isActoratLocation = this.getGrid().get(location);

                    if (isActoratLocation instanceof Critter)
                    {

                        // instancof sees if there is an "instance" of critter
                        // in that grid piece

                        actors.add(isActoratLocation);
                    }
                }
            }
        }

        actors.remove(this);
        return actors;
    }


    /**
     * The method sees if the total number of critters in that range is greater
     * than c. Then it does its respective method (darken or brighten) <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * 
     * @param actors
     *            the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        if (actors.size() >= this.numero)
        {
            this.darken();
        }

        else
        {
            this.lighten();
        }
    }


    /**
     * darkens the color of the chameleon by a constant
     */
    private void darken()
    {
        Color color = getColor();

        int red = (int)(color.getRed() * (1 - factor));
        int green = (int)(color.getGreen() * (1 - factor));
        int blue = (int)(color.getBlue() * (1 - factor));

        setColor(new Color(red, green, blue));
    }


    /**
     * lightens the chameleon by a constant
     */
    private void lighten()
    {
        Color color = getColor();
        int red = (int)(color.getRed() * (1 + factor));
        int green = (int)(color.getGreen() * (1 + factor));
        int blue = (int)(color.getBlue() * (1 + factor));

        if (red > 255)
        {
            red = 255;
        }

        if (green > 255)
        {
            green = 255;
        }

        if (blue > 255)
        {
            blue = 255;
        }

        setColor(new Color(red, green, blue));
    }
}
