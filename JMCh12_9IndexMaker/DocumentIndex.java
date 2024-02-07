import java.util.ArrayList;

/**
 * @author is me
 * @version today
 */
public class DocumentIndex
    extends ArrayList<IndexEntry>
{
    /**
     * Creates an empty DocumentIndex with the default initial capacity.
     */
    public DocumentIndex()
    {
        super();

    }


    /**
     * Creates an empty DocumentIndex with a given initial capacity.
     * 
     * @param initialCapacity basically the person gives the number they want
     */
    public DocumentIndex(int initialCapacity)
    {
        super(initialCapacity);
    }


    /**
     * @param word
     *            is a word
     * @param num
     *            is a num If word is not yet in this DocumentIndex, creates a
     *            new IndexEntry for word, and inserts it into this list in
     *            alphabetical order; adds num to this word's IndexEntry by
     *            calling its add(num) method.
     */
    public void addWord(String word, int num)
    {
        int i = foundOrInserted(word);
        if (size() == 0)
        {
            IndexEntry index = new IndexEntry(word);
            this.add(index);
            index.add(num);
            return;
        }
        if (word.equals(""))
        {
            return;
        }
        else
        {
            for (i = 0; i < super.size(); i++)
            {

                if (get(i).getWord().equalsIgnoreCase(word))
                {
                    super.get(i).add(num);
                    return;
                }
                else if (get(i).getWord().compareToIgnoreCase(word) > 0)
                {
                    IndexEntry index = new IndexEntry(word);

                    this.add(i, index);
                    index.add(num);
                    return;
                }

            }
        }

        IndexEntry index = new IndexEntry(word);
        this.add(index);
        index.add(num);

    }


    /**
     * For each word in str, calls addWord(word, num).
     * 
     * @param str
     *            is a string
     * @param num
     *            is a num
     */
    public void addAllWords(String str, int num)
    {
        String[] list = str.split("\\W+");
        for (int i = 0; i < list.length; i++)
        {
            if (!list[i].equals(""))
            {
                addWord(list[i], num);
            }
        }
    }


    // Tries to find an EndexEntry with a given word in this
    // DocumentIndex. If not found, inserts a new EndexEntry for
    // word at the appropriate place (in lexicographical order).
    // Returns the index of the found or inserted IndexEntry
    /**
     * not used
     * 
     * @param word
     *            is the string
     * @return just a number never used
     */
    private int foundOrInserted(String word)
    {

        return 0;
    }
}
