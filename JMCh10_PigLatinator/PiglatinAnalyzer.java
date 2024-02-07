import java.util.Scanner;
/**
 

   @author  nishad
   @version today

   @author  Period - 6
   @author  Assignment - pig

   @author  Sources - me
 */
public class PiglatinAnalyzer
{
    private String text;

    // Constructor: saves the text string
    public PiglatinAnalyzer(String text)
    {
        this.text = text;
    }

    /**
     * Converts a string to it piglatin form according to the following rules:
     *   a. If there are no vowels in englishWord, then pigLatinWord is just
     *      englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o',
     *      and 'u', and their uppercase counterparts.)
     *   b. Else, if englishWord begins with a vowel, then pigLatinWord is just
     *      englishWord + "yay".
     *   c. Otherwise (if englishWord has a vowel in it and yet doesn't start
     *      with a vowel), then pigLatinWord is end + start + "ay", where end
     *      and start are defined as follows:
     *        1. Let start be all of englishWord up to (but not including) its
     *           first vowel.
     *        2. Let end be all of englishWord from its first vowel on.
     *        3. But, if englishWord is capitalized, then capitalize end and
     *           "uncapitalize" start.
     *
     * @return   piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";
        String currentString = "";
        String str = "";

        for (int x = 0; x < phraseToTranslate.length();) {
            if (Character.isLetter(phraseToTranslate.charAt(x))) {
                
                currentString = extractWord(x);


                str = wordToPigLatin(currentString);

                translation += str;

                x += currentString.length();

            }
            else {

                translation += phraseToTranslate.charAt(x);
                x++;
                
            }
                       
        }
        return translation;
                
    }

    /**
     *  Converts an "english" word to its piglatin form
     *
     * @param  englishWord  a string representing an english word
     * @return              piglatin form of the english word
     */
    public String wordToPigLatin(String englishWord)
    {
        String word = englishWord;

        String pigLatinWord = "";
        String start = "";
        String end = "";

        String a = "a";
        String e = "e";
        String i = "i";
        String o = "o";
        String u = "u";

        String A = "A";
        String E = "E";
        String I = "I";
        String O = "O";
        String U = "U";

        /*
        char chara = 'a';
        char chare = 'e';
        char chari = 'i';
        char charo = 'o';
        char charu = 'u';

        char charA = 'A';
        char charE = 'E';
        char charI = 'I';
        char charO = 'O';
        char charU = 'U';
        */

        if (word.indexOf(a) == 0 || word.indexOf(A) == 0 || 
            word.indexOf(e) == 0 || word.indexOf(E) == 0 || 
            word.indexOf(i) == 0 || word.indexOf(I) == 0 || 
            word.indexOf(o) == 0 || word.indexOf(O) == 0 || 
            word.indexOf(u) == 0 || word.indexOf(U) == 0) {
                    
                return word + "yay";
            }

        else if (!word.contains(a) && !word.contains(A) &&                 
                 !word.contains(e) && !word.contains(E) &&
                 !word.contains(i) && !word.contains(I) &&
                 !word.contains(o) && !word.contains(O) &&
                 !word.contains(u) && !word.contains(U)) {
               
                return word + "ay";
            }
                
        else {
            for (int x = 1; x < word.length(); x++) {
                if (word.indexOf(a) == x || word.indexOf(A) == x || 
                    word.indexOf(e) == x || word.indexOf(E) == x ||
                    word.indexOf(i) == x || word.indexOf(I) == x ||
                    word.indexOf(o) == x || word.indexOf(O) == x ||
                    word.indexOf(u) == x || word.indexOf(U) == x) {
                        
                        String firstLetter = "" + word.charAt(0);
                        String firstLetterNoCaps = firstLetter.toLowerCase();

                        if (firstLetter.equals(firstLetterNoCaps)) {
                            
                            start = word.substring(0, x);
                            end = word.substring(x);

                            pigLatinWord = end + start + "ay";
                        
                            return pigLatinWord;
                        }
                        else {
                            

                            start = word.substring(0, x);
                            start = start.toLowerCase();

                            String str = word.substring(x+1);

                            end = "" + word.charAt(x);
                            end = end.toUpperCase();
                           

                            pigLatinWord = end + str + start + "ay";
                            return pigLatinWord;
                        }

                }
            }
        }
        return pigLatinWord;
    }

    public String extractWord(int pos) {
        int firstBound = 0;
        int lastBound = 0;
        int pos2 = pos;
        String str = "";

        while (pos2 > 0 && Character.isLetter(text.charAt(pos2))) {
            firstBound = pos2 - 1;
            pos2--;

        }
        firstBound = pos2;

        pos2 = pos;
        while (pos2 < text.length() && Character.isLetter(text.charAt(pos2))) {
            
            lastBound = pos2 + 1;
                        
            pos2++;

        }
        lastBound = pos2;
        str = text.substring(firstBound, lastBound);

        return str;
    }

}
