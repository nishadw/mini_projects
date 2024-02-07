import java.util.*;

/**
 * Java Methods Chapter 10 Exercises 2, 6 - 11, 14 - 15, 20 & 22
 * 
 * @author Nishad
 * @version TODO Date
 * 
 * @author Period - 6
 * @author Assignment - Ch10Exercises
 * 
 * @author Sources - Nishad
 */
public class JMCh10Exercises {
    Scanner scan;

    /**
     * Constructs a Scanner for input from the console.
     */
    public JMCh10Exercises() {
        scan = new Scanner(System.in);
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str input for the various methods
     */
    public JMCh10Exercises(String str) {
        scan = new Scanner(str);
    }

    // 10-2(a)
    public boolean endsWithStar(String s) {
        return (s != "" && s.charAt(s.length() - 1) == '*');
    }

    // 10-2(b)
    public boolean endsWith2Stars(String s) {

        return (s.length() >= 2 && s.charAt(s.length() - 1) == '*' && s.charAt(s.length() - 2) == '*');
    }

    // 10-6
    public String scroll(String s) {
        char x = s.charAt(0);
        String str = s.substring(1) + x;

        return str;
    }

    // 10-7
    public String convertName(String name) {
        String n = name.trim();
        int x = n.indexOf(",");
        String first = n.substring(x + 2);
        String last = n.substring(0, x);
        String fullName = first + " " + last;
        return fullName;
    }

    // 10-8
    public String negate(String str) {
        String s = str.replace("1", "4");
        s = s.replace("0", "1");
        s = s.replace("4", "0");
        return s;
    }

    // 10-9
    public boolean isConstant(String s) {
        char c = s.charAt(0);
        String t = "" + c;
        String str = s.replace(t, "");

        return (str.equals(""));
    }

    // 10-10
    public String removeComment(String str) {

        int k = str.indexOf("/*");
        int n = str.lastIndexOf("*/");
        if (k != -1 && n != -1) {
            String s = str.substring(k, n + 2);
            str = str.replace(s, "");

        }
        return str;
    }

    // 10-11
    public String cutOut(String s, String s2) {
        int a = s.indexOf(s2);
        s = s.substring(0, a) + s.substring(s2.length() + a);

        return s;
    }

    // 10-14
    public String removeHtmlTags(String str) {
        int k1 = str.indexOf("<");
        int k2 = str.indexOf(">");
        String inside = str.substring(k1 + 1, k2);

        int w1 = str.lastIndexOf("<");
        int w2 = str.lastIndexOf(">");
        String secondInside = str.substring(w1 + 1, w2);

        System.out.println("Inside = " + inside + " | secondInside = " + secondInside);

        String news = "/" + inside;
        if (news.equals(secondInside)) {
            str = str.substring(0, k1) + str.substring(k2 + 1, w1) + str.substring(w2 + 1);
        }

        return str;
    }

    // 10-15
    public boolean onlyDigits(String s) {
        s = s.replace("0", "");
        s = s.replace("1", "");
        s = s.replace("2", "");
        s = s.replace("3", "");
        s = s.replace("4", "");
        s = s.replace("5", "");
        s = s.replace("6", "");
        s = s.replace("7", "");
        s = s.replace("8", "");
        s = s.replace("9", "");

        return s.equals("");
    }

    // 10-20
    public static boolean isValidISBN(String isbn) {
        char first = (isbn.charAt(0));
        int first1 = 10 * Character.digit(first, 10);

        char second = (isbn.charAt(1));
        int second1 = 9 * Character.digit(second, 10);

        char third = (isbn.charAt(2));
        int third1 = 8 * Character.digit(third, 10);

        char fourth = (isbn.charAt(3));
        int fourth1 = 7 * Character.digit(fourth, 10);

        char fifth = (isbn.charAt(4));
        int fifth1 = 6 * Character.digit(fifth, 10);

        char sixth = (isbn.charAt(5));
        int sixth1 = 5 * Character.digit(sixth, 10);

        char seventh = (isbn.charAt(6));
        int seventh1 = 4 * Character.digit(seventh, 10);

        char eighth = (isbn.charAt(7));
        int eighth1 = 3 * Character.digit(eighth, 10);

        char ninth = (isbn.charAt(8));
        int ninth1 = 2 * Character.digit(ninth, 10);

        int tenth1;
        if (isbn.charAt(9) != 'X' || isbn.charAt(9) != 'x') 
        {
            char tenth = (isbn.charAt(9));
            tenth1 = Character.digit(tenth, 10);
        } 
        else 
        {
            tenth1 = 0;
        }
        int total = first1 + second1 + third1 + fourth1 + fifth1 + sixth1 + seventh1 + eighth1 + ninth1 + tenth1;

        return (total % 11 == 0);
    }

    // 10-22
    public String shuffle(String s) {
        StringBuffer strb = new StringBuffer();
        strb = strb.append(s);

        int n = strb.length();
        int len = strb.length();
        int x;
        while (n > 1) {
            x = (int) (Math.random() * (n));
            char sn = strb.charAt(x);

            strb.append(sn);
            strb.deleteCharAt(x);

            char c = strb.charAt(len - 2);
            strb.deleteCharAt(len - 2);
            strb.insert(x, c);

            n -= 1;
        }
        String news = new String(strb);

        return news;
    }

    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes each
     * method.
     * 
     * @param args command line parameters (not used)
     */
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean done = false;

        JMCh10Exercises exercise = new JMCh10Exercises();

        do {
            System.out.println();
            System.out.println();
            System.out.println("Make a selection");
            System.out.println();
            System.out.println("   (1) 10-2(a) endsWithStar( String s )");
            System.out.println("   (2) 10-2(b) endsWith2Stars( String s )");
            System.out.println("   (3) 10-6 scroll( String s )");
            System.out.println("   (4) 10-7 convertName( String name )");
            System.out.println("   (5) 10-8 negate( String str )");
            System.out.println("   (6) 10-9 isConstant( String s )");
            System.out.println("   (7) 10-10 removeComment( String str )");
            System.out.println("   (8) 10-11 cutOut( String s, String s2 )");
            System.out.println("   (9) 10-14 removeHtmlTags( String str )");
            System.out.println("   (A) 10-15 onlyDigits( String s )");
            System.out.println("   (B) 10-20 isValidISBN( String isbn )");
            System.out.println("   (C) 10-22 shuffle( String s )");
            System.out.println("   (Q) Quit");
            System.out.println();
            System.out.print("Enter a choice:  ");
            String response = kbd.nextLine();

            if (response.length() > 0) {
                System.out.println();

                switch (response.charAt(0)) {
                    case '1':
                        String end1Star = "**endsWith**Star*";
                        System.out.println("endsWithStar(" + end1Star + ") = " + exercise.endsWithStar(end1Star));
                        String ends0Star = "**endsWith**Star*No";
                        System.out.println("endsWithStar(" + ends0Star + ") = " + exercise.endsWithStar(ends0Star));
                        break;
                    case '2':
                        String end2Str = "**endsWith**2Stars**";
                        System.out.println("endsWith2Stars(" + end2Str + ") = " + exercise.endsWith2Stars(end2Str));
                        String endsWith1Star = "**endsWith**2Stars*";
                        System.out.println(
                                "endsWith2Stars(" + endsWith1Star + ") = " + exercise.endsWith2Stars(endsWith1Star));
                        break;
                    case '3':
                        String scrollStr = "bdfhjlnprtvxz";
                        System.out.println(
                                "scroll(\"" + scrollStr + "\") --> " + "\"" + exercise.scroll(scrollStr) + "\"");
                        break;
                    case '4':
                        String convStr = "von Neumann, John";
                        System.out.println(
                                "convertName(\"" + convStr + "\") --> " + "\"" + exercise.convertName(convStr) + "\"");
                        break;
                    case '5':
                        String negStr = "1001110001010101110";
                        System.out.println("negate(\"" + negStr + "\") --> " + "\"" + exercise.negate(negStr) + "\"");
                        break;
                    case '6':
                        String constStr1 = "0000000000000000000";
                        String constStr2 = "1001110001010101110";
                        System.out.println("isConstant(\"" + constStr1 + "\") = " + exercise.isConstant(constStr1));
                        System.out.println("isConstant(\"" + constStr2 + "\") = " + exercise.isConstant(constStr2));
                        break;
                    case '7':
                        String comment = "/* this should be gone */ int a = 0;";
                        String notComment = "/* this should stay /* int a = 0;";
                        System.out.println("removeComment(\"" + comment + "\") --> " + "\""
                                + exercise.removeComment(comment) + "\"");
                        System.out.println("removeComment(\"" + notComment + "\") --> " + "\""
                                + exercise.removeComment(notComment) + "\"");
                        break;
                    case '8':
                        String cutstr = "Hi-ho, hi-ho";
                        String cutOutstr = "-ho";
                        System.out.println("cutOut(\"" + cutstr + "\", \"" + cutOutstr + "\") --> " + "\""
                                + exercise.cutOut(cutstr, cutOutstr) + "\"");
                        break;
                    case '9':
                        String htmlStr = "Strings are <b>immutable</b>";
                        System.out.println("removeHtmlTags(\"" + htmlStr + "\") --> " + "\""
                                + exercise.removeHtmlTags(htmlStr) + "\"");
                        break;
                    case 'A':
                    case 'a':
                        String digitStr = "123456789";
                        String dStr = "1234V5678";
                        System.out.println("onlyDigits(\"" + digitStr + "\") = " + exercise.onlyDigits(digitStr));
                        System.out.println("onlyDigits(\"" + dStr + "\") = " + exercise.onlyDigits(dStr));
                        break;
                    case 'B':
                    case 'b':
                        String validISBN = "096548534X";
                        String invalidISBN = "1234567890";
                        System.out.println("isValidISBN(\"" + validISBN + "\") = " + exercise.isValidISBN(validISBN));
                        System.out
                                .println("isValidISBN(\"" + invalidISBN + "\") = " + exercise.isValidISBN(invalidISBN));
                        break;
                    case 'C':
                    case 'c':
                        String str = "The quick brown fox";
                        System.out.println("shuffle(\"" + str + "\") --> " + "\"" + exercise.shuffle(str) + "\"");
                        System.out.println("shuffle(\"" + str + "\") --> " + "\"" + exercise.shuffle(str) + "\"");
                        break;
                    default:
                        if (response.toLowerCase().charAt(0) == 'q') {
                            done = true;
                        } else {
                            System.out.print("Invalid Choice");
                        }
                        break;
                }
            }
        } while (!done);
        System.out.println("Goodbye!");
    }
}
