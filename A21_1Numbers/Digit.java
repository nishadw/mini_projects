/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author mi nombre es nishad.
 * @version 4.1
 * @author Period - 6
 * @author Assignment - numeros
 * @author Sources - yo
 */
public class Digit
{
  int base;
  int value;

  public Digit()
  {
    base = 10;
    value = 0;
  }


  public Digit(int val, int bas)
  {
    base = bas;
    value = val;
  }


  public boolean increment()
  {
    if (value + 1 >= base)
    {
      value = 0;
      return true;
    }
    value++;
    return false;
  }


  public String toString()
  {
    if (base >= 10 && value >= 10)
    {
      String abc = "ABCDEF";

      return "" + abc.charAt(value - 10);  
    }
    else
    {
      return "" + value;
    }
  }
}
