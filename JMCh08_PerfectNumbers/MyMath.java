/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  TODO your name
 *  @version TODO the date
 *  @author  Period: TODO 
 *  @author  Assignment: JMCh08_PerfectNumbers
 *
 *  @author  Sources: TODO list collaborators
 */
public class MyMath
{
    /**
     * Returns true if n is a prime; otherwise returns false.
     * @param n  number to check if prime
     * @return  true if n is a prime; otherwise returns false
     */
    public static boolean isPrime( int n )
    {
        if ( n <= 1 )
            return false;

        int m = 2;

        while ( m * m <= n )
        {
            if ( n % m == 0 )
                return false;
            m++;
        }

        return true;
    }


    /**
     * Question 8-15 Returns the n-th Fibonacci number
     * 
     * Find and read a few informative websites dedicated to Fibonacci numbers.
     * The following recursive method returns the n-th Fibonacci number:
     * 
     *   // Returns the n-th Fibonacci number.
     *   // Precondition: n >= 1
     *   public static long fibonacci(int n)
     *   {
     *     if (n == 1 || n == 2)
     *       return 1;
     *     else
     *       return fibonacci(n - 1) + fibonacci(n - 2);
     *   }
     * Rewrite it without recursion, using one loop.
     *
     * @param n  Fibonacci number to find
     * @return  n-th Fibonacci number
     */
    public static long fibonacci( int n )
    {
        // TODO your code here

        return 0; // ** FIX THIS
    }


    /**
     * Returns true if n is a perfect number, false otherwise.
     * 
     * @param n  number to test
     * @return   true if n is a perfect number, false otherwise.
     */
    public static boolean isPerfect( int n )
    {
        int num=2;
        for (int i = 0; i < n; i++) {
            num *= 2 * n;
        if (n == (2 ** (n-1)) * ((2 ** (n)) - 1){

        }

        return false; // ** FIX THIS
    }


    /**
     * Prints the first n perfect numbers
     * 
     * @param n number of perfect numbers to print
     */
    public static void printPerfectNums( int n )
    {
        System.out.println( "Perfect numbers: " );
        int count = 0;
        for ( int k = 1; count < n; k++ )
        {
            if ( isPerfect( k ) )
            {
                System.out.print( k + " " );
                count++;
            }
        }
        System.out.println();
    }


    /**
     * Prints the first n Mersenne primes
     * 
     * @param n number of Mersenne primes to print
     */
    public static void printMersennePrimes( int n )
    {
        System.out.println( "Mersenne primes: " );

        // TODO your code here

        System.out.println();
    }


    /**
     * Prints the first n even perfect numbers
     */
    public static void printEvenPerfectNums( int n )
    {
        System.out.println( "Even perfect numbers: " );

        // TODO your code here
        for (int x; isPrime(n); x++) {

        }

        System.out.println();
    }


    /*********************************************************************/

    public static void main( String[] args )
    {
        int n = 19;
        System.out.println( n + "-th Fibonacci number = " + fibonacci( n ) );

        printPerfectNums( 4 );
        printMersennePrimes( 6 );
        printEvenPerfectNums( 6 );
    }
}
/*
19-th Fibonacci number = 4181
Perfect numbers: 
6 28 496 8128 
Mersenne primes: 
3 7 31 127 8191 131071
Even perfect numbers: 
6 28 496 8128 33550336 8589869056
*/
