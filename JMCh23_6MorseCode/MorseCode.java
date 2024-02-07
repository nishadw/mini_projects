import java.util.TreeMap;

/**
 * "can i get an e for effort? e"
 * 
 * @author name
 * @version date
 * @author Period - period
 * @author Assignment - assignment
 * @author Sources - sources
 */
public class MorseCode
{
    private static final char                 DOT  = '.';
    private static final char                 DASH = '-';

    private static TreeMap<Character, String> codeMap;
    private static TreeNode<Character>        decodeTree;

    public static void start()
    {
        codeMap = new TreeMap<Character, String>();

        // put a space in the root of the decoding tree
        decodeTree = new TreeNode<Character>(' ', null, null);  // autoboxing

        addSymbol('A', ".-");
        addSymbol('B', "-...");
        addSymbol('C', "-.-.");
        addSymbol('D', "-..");
        addSymbol('E', ".");
        addSymbol('F', "..-.");
        addSymbol('G', "--.");
        addSymbol('H', "....");
        addSymbol('I', "..");
        addSymbol('J', ".---");
        addSymbol('K', "-.-");
        addSymbol('L', ".-..");
        addSymbol('M', "--");
        addSymbol('N', "-.");
        addSymbol('O', "---");
        addSymbol('P', ".--.");
        addSymbol('Q', "--.-");
        addSymbol('R', ".-.");
        addSymbol('S', "...");
        addSymbol('T', "-");
        addSymbol('U', "..-");
        addSymbol('V', "...-");
        addSymbol('W', ".--");
        addSymbol('X', "-..-");
        addSymbol('Y', "-.--");
        addSymbol('Z', "--..");
        addSymbol('0', "-----");
        addSymbol('1', ".----");
        addSymbol('2', "..---");
        addSymbol('3', "...--");
        addSymbol('4', "....-");
        addSymbol('5', ".....");
        addSymbol('6', "-....");
        addSymbol('7', "--...");
        addSymbol('8', "---..");
        addSymbol('9', "----.");
        addSymbol('.', ".-.-.-");
        addSymbol(',', "--..--");
        addSymbol('?', "..--..");
    }


    /**
     * Inserts a letter and its Morse code string into the encoding map and
     * calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol(char letter, String code)
    {
        codeMap.put(letter, code);
        treeInsert(letter, code);
    }


    /**
     * Inserts a letter and its Morse code string into the decoding tree. Each
     * dot-dash string corresponds to a path in the tree from the root to a
     * node: at a "dot" go left, at a "dash" go right. The node at the end of
     * the path holds the symbol for that code string.
     */
    private static void treeInsert(char letter, String code)
    {
        TreeNode<Character> tree = decodeTree;

        for (int i = 0; i < code.length(); i++)
        {

            char ch = code.charAt(i);

            if (ch == DOT)
            {
                if (tree.getLeft() == null)
                {
                    tree.setLeft(new TreeNode<Character>(' ', null, null));
                }
                tree = tree.getLeft();
            }

            if (ch == DASH)
            {
                if (tree.getRight() == null)
                {
                    tree.setRight(new TreeNode<Character>(' ', null, null));
                }
                tree = tree.getRight();
            }
        }
        tree.setValue(letter);
    }


    /**
     * Converts text into a Morse code message. Adds a space after a dot-dash
     * sequence for each letter. Other spaces in the text are transferred
     * directly into the encoded message.
     *
     * @return the encoded message.
     */
    public static String encode(String text)
    {
        String str = "";
        text = text.toUpperCase();
        for (char cha : text.toCharArray())
        {
            if (cha == ' ')
            {
                str += " ";
            }

            else
            {
                if (codeMap.containsKey(cha))
                {
                    str += " " + codeMap.get(cha);
                }
            }
        }
        return str.substring(1);
    }


    /**
     * Converts a Morse code message into a text string. Assumes that dot-dash
     * sequences for each letter are separated by one space. Additional spaces
     * are transferred directly into text.
     *
     * @return the plain text message.
     */
    public static String decode(String morse)
    {
        StringBuffer text = new StringBuffer(100);
        String[] wordSplitter = morse.split(" ");

        for (String s : wordSplitter)
        {
            if (s == " ")
            {
                text.append(" ");
            }

            else
            {
                char[] charSplitter = s.toCharArray();
                TreeNode<Character> root = decodeTree;

                for (char ch : charSplitter)
                {
                    if (ch == DOT)
                    {
                        root = root.getLeft();
                    }

                    else if (ch == DASH)
                    {
                        root = root.getRight();
                    }

                    else
                    {

                    }
                }
                text.append(root.getValue());
            }
        }

        return text.toString();

        /*
         * easier to just to ch by ch (use split method mroe) String text = "";
         * TreeNode<Character> root = decodeTree; for (char ch :
         * morse.toCharArray()) { if (ch == ' ') { text += root.getValue(); root
         * = decodeTree; } else { if (ch == DOT) { root = root.getLeft(); } else
         * if (ch == DASH) { root = root.getRight(); } } if (root != decodeTree)
         * { text += root.getValue(); } } return text.substring(1);
         */
    }

    // --------------------------------------------------------------------
    // For test purposes only. Not to be used in completing the assignment


    public TreeMap<Character, String> getCodeMap()
    {
        return codeMap;
    }


    public TreeNode<Character> getDecodeTree()
    {
        return decodeTree;
    }
}
