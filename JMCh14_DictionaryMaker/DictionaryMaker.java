import java.util.Scanner;
import java.io.*;

/**
 * @author Nishad
 * @version 11/19
 * @author Period - 6
 * @author Assignment - JM Ch14 - DictionaryMaker
 * @author Sources - "m" + "e"
 */
public class DictionaryMaker
{
    private static final int  MINLENGTH = 3, MAXLENGTH = 5;
    public static Scanner     fileIn;       // public for test purposes
    public static PrintWriter fileOut;  // public for test purposes

    public static void main(String[] args)
        throws IOException
    {
        Scanner kboard = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter input file name: ");
        String fileName = kboard.next();

        openInputFile(fileName);
        if (fileIn == null)
        {
            System.out.println("*** Can't open " + fileName + " ***");
            kboard.close();
            return;
        }

        createOutputFile("RamblecsDictionary.java");
        if (fileOut == null)
        {
            fileIn.close();
            System.out.println("*** Can't create RamblecsDictionary.java ***");
            kboard.close();
            return;
        }

        int count = copyWords();
        System.out.println("Done: " + count + " words.");

        fileIn.close();
        fileOut.close();
        kboard.close();
    }


    /**
     * Opens a file fileName (in the current folder) and places a reference to
     * it into fileIn
     */
    public static void openInputFile(String fileName)
    {
        try
        {
            fileIn = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException exception)
        {

        }
    }


    /**
     * Creates a new file fileName (in the current folder) and places a
     * reference to it into fileOut
     */
    public static void createOutputFile(String fileName)
    {
        try
        {
            fileOut = new PrintWriter(fileName);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found Exception");
        }
    }


    /**
     * Reads all words from fileIn, selects the words that have from MINLENGTH
     * to MAXLENGTH letters, converts them into upper case and writes the words
     * into fileOut in Java syntax
     * 
     * @return number of words processed
     */
    public static int copyWords()
    {
        fileOut.println("public class RamblecsDictionary");
        fileOut.println("{");
        fileOut.println("\tpublic String words[] =");
        fileOut.println("\t{");
        int count = 0;
        String word;

        while (fileIn.hasNextLine())
        {
            word = fileIn.nextLine().trim();
            if (word.length() >= MINLENGTH && word.length() <= MAXLENGTH)
            {
                fileOut.println("\t\t\t\"" + word.toUpperCase() + "\",");
                count++;
            }

        }

        fileOut.println("\t};");
        fileOut.println("}");

        return count;
    }
}
