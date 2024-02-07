import java.util.ArrayList;
/**
 * @author Nishad Wajge
 * @version right now
 */
public class IndexEntry
{
    private String word;
    private ArrayList<Integer> numList;

    // Constructs an IndexEntry for a given word
    // (converted to upper case); sets numsList
    // to an empty ArrayList.
    /**
     * 
     * @param word is a string
     */
    public IndexEntry(String word)
    {
        this.word = word.toUpperCase();
        numList = new ArrayList<Integer>();
    }

    // Returns the word of this IndexEntry object.
    /**
     * 
     * @return getter method
     */
    public String getWord()
    {
        return this.word;
    }

    // If num is not already in the list, adds num
    // at the end of this IndexEntry's list
    // of numbers.
    /**
     * 
     * @param num imports a num
     */
    public void add(int num)
    {
        Integer x = num;
        if (!numList.contains(x)) {
            numList.add(x);
        }
    }

    // Converts this IndexEntry into a string in the
    // following format: the word followed by a space, followed by
    // numbers separated by a comma and a space.
    /**
     * @return str overides toString method
     */
    public String toString()
    {
        String str = this.word + " " + numList.get(0);
        for (int i = 1; i < numList.size(); i++) {
            str += ", " + numList.get(i);
        }
        return str;
    }
}
