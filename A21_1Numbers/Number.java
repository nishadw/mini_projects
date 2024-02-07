import java.util.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author  Period - TODO Your Period
   @author  Assignment - TODO Assignment Name

   @author  Sources - TODO list collaborators
 */
public class Number
{
  int base;
  int value;
  ArrayList<Digit> list;

  public Number() {
    base = 10;
    value = 0;

    list = new ArrayList<Digit>();
    list.add(new Digit(value, base));
  }

  public Number(int val, int bas) {
    base = bas;
    value = val;
    list = new ArrayList<Digit>();

    int remainder;
    int quotient = value;
    while (quotient != 0) {
      remainder = quotient % base;
      list.add(0, new Digit(remainder, base));

      quotient /= base;
    }
  }

  public void increment() {
    for (int i = list.size() - 1; i >= 0; i--) {
      Digit digit = list.get(i);
      if (!digit.increment()) {
        return;
      }
      else {
        if (i == 0) {
          list.add(0, new Digit(1, base));
          return;
        }
      }
    }
  }

  public String toString() {

    String str = "";
    for (Digit digit : list) {
      str += digit.toString();
    }
    return str;
  }

}
