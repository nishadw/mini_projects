import java.util.*;

/**
   @author  nw
   @version 2.14

   @author Period - 6
   @author Assignment - JM24.6 - Search Engine

   @author Sources - h
 */
public class SearchEngine
{
    
    private String myURL; // holds the name for the "url" (file name)
    private Map<String, List<String>> myIndex; // holds the word index

    /**
     * 
     * @param url s
     */
    public SearchEngine(String url) {
        myURL = url;
        myIndex = new HashMap<String, List<String>>(20000);
    }

    /**
     * 
     * @return s
     */
    public String getURL() {
        return myURL;
    }

    /**
     * 
     * @param line s
     */
    public void add(String line) {
        Set<String> set = parseWords(line);

        for (String word : set) {
            
            if (myIndex.get(word) == null) {
                myIndex.put(word, new LinkedList<String>());
            }
            
            myIndex.get(word).add(line);
        }
    }

    /**
     * 
     * @param word s
     * @return s
     */
    public List<String> getHits(String word) {
        return myIndex.get(word);
    }

    /**
     * 
     * @param line s
     * @return s
     */
    private Set<String> parseWords(String line) {
        String[] array = line.split("\\W+");
        Set<String> set = new TreeSet<String>();
        
        for (int i = 0; i < array.length; i++) {
            set.add(array[i].toLowerCase());
        }

        return set;
    }


    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation
    /**
     * 
     * @return s
     */
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
