/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - JMCh10 Lipogrammer
 * 
 * @author Sources - TODO list collaborators
 */
public class LipogramAnalyzer {
    private String text;

    /**
     * Constructor: Saves the text string
     * 
     * @param text String to analyze
     */
    public LipogramAnalyzer(String text) {
        this.text = text;
    }

    /**
     * Returns the text string with all characters equal to letter replaced with
     * '#'.
     * 
     * @param letter character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark(char letter) {
        int n = text.indexOf(letter);
        String f = "";

        if (n != -1) {
            f = text.replace(letter, '#');
        }

        return f;
    }

    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once; there
     * are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith(char letter) {
        String result = "";
        String s = "";

        for (int i = 0; i < text.length() - 1; i++) {

            s = extractWord(i);
            s = s.toLowerCase();
            
            for (int m = 0; m < s.length(); m++) {

                if (s.charAt(m) == letter) {

                    if (result.indexOf(s) == -1) {

                        result += s + "\n";

                    }
                }
            }
            
        }
        result = result.replace(" ", "");
        result += "\n";
        return result;
    }

    /**
     * Returns the word that contains character at pos excluding any punctuation or
     * whitespace.
     * 
     * @param pos location of character
     * 
     * @return word that contains character at pos
     */
    public String extractWord(int pos) {
        int firstBound = 0;
        int lastBound = 0;
        int pos2 = pos;
        String str = "";

        while (Character.isLetter(text.charAt(pos2)) && pos2 > 0) {
            firstBound = pos2 - 1;
            pos2--;
        }

        pos2 = pos;
        while (pos2 < text.length() && Character.isLetter(text.charAt(pos2)) && pos2 <= text.length() - 1) {
            
            lastBound = pos2 + 1;
            pos2++;
        }
        str = text.substring(firstBound, lastBound);
        /*
        if (firstBound + 2 == lastBound && lastBound == text.length() - 1) {
            int s = firstBound + 1;
            str = "" +  text.charAt(s);
        }
        */
        if (firstBound + 1 == lastBound) {
            str = "" + text.charAt(firstBound + 1);
            System.out.println(str);
        }
        
        
        
        
        
        
        return str;
    }
}
