
public class BookTest
{
  
    public static void main( String[] args )
    {
        /* TODO *** TO BE IMPLEMENTED *** */
        
        Book nextd = new Book(3);
        
        System.out.println(Book.getNumPages());
        System.out.println(Book.getCurrentPage());
        
        nextd.nextPage();
        System.out.println(Book.getCurrentPage());
        nextd.nextPage();
        System.out.println(Book.getCurrentPage());
        nextd.nextPage();
        System.out.println(Book.getCurrentPage());

    }
}
