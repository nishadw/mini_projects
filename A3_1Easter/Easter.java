import java.lang.reflect.*;
import java.util.Scanner;


public class Easter
{
    private int y;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int k;
    private int r;
    private int m;
    private int n;
    private int p;

    public Easter( int year )
    {
        y = year;
    }

    public void calculate( )
    {
        a = y % 19;
        System.out.println( "a = " + a );
        b = y / 100;
        System.out.println( "b = " + b );

        // TODO: complete method
        c = y % 100;
        d = b / 4;
        e = b % 4;
        f = (b + 8) / 25;
        g = (b - f + 1) / 3;
        h = (19 * a + b - d - g + 15) % 30;
        i = c / 4;
        k = c % 4;
        r = (32 + 2 * e + 2 * i - h - k) % 7;
        m = (a + 11 * h + 22 * r) / 451;
        n = ( h + r - 7 * m + 114) / 31;
        p = (h + r - 7 * m + 114) % 31;

       
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        System.out.println("g = " + g);
        System.out.println("h = " + h);
        System.out.println("i = " + i);
        System.out.println("k = " + k);
        System.out.println("r = " + r);
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        System.out.println("p = " + p);

        System.out.println("Easter in " + y + " falls on " + n + "/" + (p+1));

    }

    /**
     * Intended only for debugging.
     * 
     * <p>A generic toString implementation that uses reflection to print
     * names and values of all fields <em>declared in this class</em>.
     * Note that superclass fields are left out of this implementation.</p>
     * 
     * @return a string representation of this Easter.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }
            separator = ", ";
        }
        return str + "]";
    }


    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the year (yyyy) --> " );
        int year = console.nextInt();

        Easter bunny = new Easter( year );
        bunny.calculate();
        console.close();
    }
}
