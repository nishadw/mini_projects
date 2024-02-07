import java.lang.reflect.*;

/**
   This class implements a vendor that sells one kind of item.
   A vendor carries out sales transactions.

   @author  TODO Your Name
   @version TODO Date

   @author Period - TODO Your Period
   @author Assignment - Java Methods Ch09 - SnackBar

   @author Sources - TODO list collaborators
 */
public class Vendor
{
    // Fields:
    //...
    // the available stock (the number of remaining items for sale), 
    // the price, the currently deposited amount, 
    // and the change due to the customer from the last sale

    // Vendor’s constructor sets the price and the initial stock and zeroes out the deposit and change fields.
    private int stock, price, given, change;
    private static double totalSales;

    public static double getTotalSales ()
    {
        double x = totalSales;
        totalSales = 0;
        return x;
    }
    //  Constructor
    //  Parameters:
    //    int price of a single item in cents
    //    int number of items to place in stock
    //... Vendor ...
    public Vendor (int priceOfGood, int itemsInStock)
    {
        stock = itemsInStock;
        price = priceOfGood;

    }

    //  Sets the quantity of items in stock.
    //  Parameters:
    //    int number of items to place in stock
    //  Return:
    //    None
    //... setStock ...
    public void setStock (int numOfItemsToPlace)
    {
        //...
        stock = numOfItemsToPlace;
    }

    //  Returns the number of items currently in stock.
    //  Parameters:
    //    None
    //  Return:
    //    int number of items currently in stock
    // ... getStock ...
    public int getStock ()
    {
        //...
        return stock;
    }

    //  Adds a specified amount (in cents) to the deposited amount.
    //  Parameters:
    //    int number of cents to add to the deposit
    //  Return:
    //    None
    //... addMoney ...
    public void addMoney (int userDeposit)
    {
        //...
        if (stock != 0) {
            given += userDeposit;
        }
        
    }

    //  Returns the currently deposited amount (in cents).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current deposit
    //... getDeposit ...
    public int getDeposit ()
    {
        //...
        return given;
    }

    //  Implements a sale.  If there are items in stock and
    //  the deposited amount is greater than or equal to
    //  the single item price, then adjusts the stock
    //  and calculates and sets change and returns true;
    //  otherwise refunds the whole deposit (moves it into change)
    //  and returns false.
    //  Parameters:
    //    None
    //  Return:
    //    boolean successful sale (true) or failure (false)
    // ... makeSale ...
    public boolean makeSale ()
    {
        //...
        if (stock > 0 && given >= price) {
            totalSales += ((double) price) / 100.0;
            stock = stock - 1;
            change = given - price;
            given = 0;
            return true;
        }
        else {
            change = given;
            given = 0;
            return false;
        }
    }

    //  Returns and zeroes out the amount of change (from the last
    //  sale or refund).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current change
    //... getChange ...
    public int getChange ()
    {
        //...
        //change = 0;
        //int x = given - change;
        given = 0;
        return change;
    }

    /**
        Intended only for debugging.
        
        <p>A generic toString implementation that uses reflection to print
        names and values of all fields <em>declared in this class</em>.
        Note that superclass fields are left out of this implementation.</p>
        
        @return  a string representation of this Vendor.
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
                str += separator + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
