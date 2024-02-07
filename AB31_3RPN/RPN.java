import java.util.*;

/**
 * RPN Calculator
 *
 * @author nishad
 * @version 01/01101
 * @author Period: 6
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: import me;
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );
    
    private Stack<Integer> myStack;
    private Queue<String> myQ;

    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }
    
    /**
     *  **** Used for testing - Do Not Remove ***
     *  
     *  Constructs an RPN Calculator and then redirects the Scanner input
     *  to the supplied string.
     *  
     *  @param console  replaces console input
     */
    public RPN(String console)
    {
        this();
        scan = new Scanner( console );
    }

    /**
     * calculates using rpn way
     */
    public void calculate()
    {
        myQ.add("");
        boolean keepGoing = true;
        String str = "";
        int num = 0;
        int num1 = 0;
        int num2 = 0;
        ArrayList<String> tracker = new ArrayList<String>();
        
        System.out.println("Type 'Q' or 'q' to terminate.");
        System.out.println("Type a number or operation ('*', '/', '+', '-'): ");

        while(keepGoing) {
            try {
                num = scan.nextInt();
                myStack.push(num);
                
                tracker.add("" + num);
            }

            catch (Exception e) {
                str = scan.nextLine();

                if (str.equalsIgnoreCase("q")) {
                    keepGoing = false;
                }

                else if(str.equals("*")) {
                    num2 = myStack.pop();
                    num1 = myStack.pop();
                    
                    myStack.push(multiplication(num1, num2));
                    tracker.add(str);
                }
                
                else if(str.equals("/")) {
                    num2 = myStack.pop();
                    num1 = myStack.pop();
                    
                    myStack.push(division(num1, num2));
                    tracker.add(str);
                }
                
                else if(str.equals("+")) {
                    num2 = myStack.pop();
                    num1 = myStack.pop();
                    
                    myStack.push(addition(num1, num2));
                    tracker.add(str);
                    //myQ.poll();
                }
                
                else if(str.equals("-")) {
                    num2 = myStack.pop();
                    num1 = myStack.pop();
                    
                    myStack.push(subtraction(num1, num2));
                    tracker.add(str);
                    //myQ.poll();
                }

                else {
                    System.out.println("Type a valid number/operation or type 'Q' or 'q' to quit: ");
                }     
            }
        } 
        print(tracker, myStack.pop());
    }

    private int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    private int division(int num1, int num2) {
        return num1 / num2;
    }

    private int addition(int num1, int num2) {
        return num1 + num2;
    }

    private int subtraction(int num1, int num2) {
        return num1 - num2;
    }

    private void print(ArrayList<String> tracker, int answer) {
        String toBePrinted = "";

        for (String element : tracker) {
            toBePrinted += element + " ";
        }

        toBePrinted += "= " + answer;
        System.out.println(toBePrinted);
    }
    
    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args  command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}