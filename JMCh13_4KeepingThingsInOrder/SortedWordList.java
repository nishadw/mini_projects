/**
 * Implements a sorted list of words
 * 
 * @author Nishad
 * @version sometime
 * @author Period - 6
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 * @author Sources - spongebob
 */
public class SortedWordList
  extends java.util.ArrayList<String>
{
  public SortedWordList()
  {
    super();
  }


  public SortedWordList(int i)
  {
    super(i);
  }


  /**
   * @param word
   *          is a string
   * @return is a boolean
   */
  public boolean contains(String word)
  {
    return (indexOf(word) >= 0);
  }


  public int indexOf(String word)
  {
    int zero = 0;
    int midpoint = 0;
    int len = size() - 1;

    while (zero <= len)
    {
      midpoint = (zero + len) / 2;
      int x = word.compareToIgnoreCase(get(midpoint));

      if (x > 0)
      {
        zero = midpoint + 1;
      }

      else if (x < 0)
      {
        len = midpoint - 1;
      }

      else
      {
        return midpoint;
      }
    }

    return -1;
  }


  /**
   * @param numero
   *          is a num
   * @param word
   *          is string
   * @return str is a string
   */
  public String set(int numero, String word)
  {
    String str = "";

    if (numero < 0 || numero >= size())
    {
      throw new IllegalArgumentException("word =" + word + " i =" + numero);
    }

    if (numero == 0 || numero == size() - 1)
    {
      if (size() == 1)
      {
        str = super.set(numero, word);
      }

      else
      {
        if (numero == 0 && word.compareTo(get(numero + 1)) < 0)
        {
          str = super.set(numero, word);
        }
        else if (word.compareTo(get(numero - 1)) > 0 && word.compareTo(get(numero + 1)) < 0)
        {
          str = super.set(numero, word);
        }
        else
        {
          throw new IllegalArgumentException("word =" + word + " i =" + numero);
        }
      }
    }

    else
    {
    }

    return str;
  }


  /**
   * @param numero
   *          is a num
   * @param word
   *          is a string
   */
  public void add(Object numero, String word)
  {
    if (contains(word) && get((int)numero - 1) == word && get((int)numero) == word)
    {
      throw new IllegalArgumentException();
    }
  }


  /**
   * @return boolean is a boolean
   */
  public boolean add(String word)
  {
    if (contains(word))
    {
      return false;
    }

    else
    {
      int num = indexOf(word);
      // System.out.println(num);
      set(num, word);
      return true;
    }

  }


  /**
   * @param additionalWords
   *          is sortedwords
   */
  public void merge(SortedWordList additionalWords)
  {

    int i = 0, j = 0, k = 0;

    for (i = 0; i < additionalWords.size(); i++)
    {
      if (!contains(additionalWords.get(i)))
      {
        additionalWords.add(size(), "");
      }
    }

    int place = 0;
    for (j = additionalWords.size(); j > 0; j--)
    {
      place = indexOf(additionalWords.get(j));
      additionalWords.set(place, additionalWords.get(j));
    }

  }
}
