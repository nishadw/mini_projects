/**
 *  
 * @author Nishad Wajge
 * @version 2/9/22
 * @author Period - 4
 * @author Assignment - JM 24.3 Lab: Cryptogram Solver
 * @author Sources - hola me llamo nishad y me gusta la cienca de computadoras.
 */
public class Enigma
{
    private char[] lookupTable;

    /**
     * 
     * @param numLetters n
     */
    public Enigma(int numLetters)
    {
        lookupTable = new char[numLetters];
    }

    /**
     * 
     * @param index i
     * @param ch c
     */
    public void setSubstitution(int index, char ch)
    {
        lookupTable[index] = ch;
    }

    /**
     * 
     * @param text h
     * @return alot
     */
    public String decode(String text)
    {

        StringBuffer buffer = new StringBuffer(text.length());

        for (int i = 0; i < text.length(); i++)
        {
            
            char origC = text.charAt(i);    
            char newC;
            int numeric = Character.getNumericValue(origC);
           
            if (numeric == -1 || (numeric >= 0 && numeric < 10))
            {
                newC = origC;
            }
            else    
            {
                newC = lookupTable[numeric - Character.getNumericValue('A')];

                if ((int) origC >= 97)
                {
                    newC += 32;
                }
            }
            buffer.append((char)newC);
        }

        return buffer.toString();
    }

    /**
     * 
     * @param text t
     * @param lettersByFrequency l
     * @return g
     */
    public String getHints(String text, String lettersByFrequency)
    {
        int[] counts = countLetters(text);
        StringBuffer buffer = new StringBuffer(lettersByFrequency.length());

        for (int i = 0; i < counts.length; i++)
        {
            int index = 0;

            for (int j = 0; j < counts.length; j++)
            {
                if ((counts[i] > counts[j]) || 
                    (counts[i] == counts[j]) && (i > j))
                {
                    index += 1;
                }
            }

            buffer.insert(i, lettersByFrequency.charAt(index));
        }

        return buffer.toString();
    }

    /**
     * 
     * @param text t
     * @return t
     */
    private int[] countLetters(String text)
    {
        int[] counts = new int[lookupTable.length];

        for (int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);

            int index = Character.getNumericValue(c) -
                Character.getNumericValue('A');

            if (index > 25 && index < 52)
            {
                index -= 26;
            }

            else if (index >= 52 || index < 0)
            {
                continue;
            }

            counts[index]++;
        }

        return counts;
    }

    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation

    /**
     * 
     * @return g
     */
    public char[] getLookupTable()
    {
        return lookupTable;
    }

    /**
     * 
     * @param text y
     * @return g
     */
    public int[] getCountLetters(String text)
    {
        return countLetters(text);
    }

}