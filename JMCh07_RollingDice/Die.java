/**
 *  Simulates a six-sided die.
 *
 *  @author  TODO your Name
 *  @version TODO date
 *  @author  Period: TODO your period
 *  @author  Assignment: JMCh07_RollingDice
 *
 *  @author  Sources: TODO collaborators
 */
public class Die
{
    private int numDots;

    
    public static void main(String[] args)
    {
        Die die = new Die();
        die.roll();
        System.out.println(die.getNumDots());
        die.roll();
    }
    
    public void roll()
    {
        // TODO your code goes here
        numDots = 1 + (int)(Math.random() * (6));
    }
    
    /**
     * Returns the value of the most recent roll.
     * @return numDots
     */
    public int getNumDots()
    {
        return numDots; 
    }
}
