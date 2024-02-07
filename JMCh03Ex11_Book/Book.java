
public class Book
{
    // TODO implement data fields
    private static int numPages;
    private static int currentPage;

    // TODO implement constructor
    public Book(int x) 
    {
        numPages = x;
        currentPage = 1; 
    }

    // TODO implement methods
    public void nextPage() {
        if (currentPage < numPages) {
            currentPage++;
        }
        else {
            currentPage = numPages;
        }
    }
    public static int getNumPages() {
        return numPages;
    }
    public static int getCurrentPage() {
        return currentPage;
    }
}
