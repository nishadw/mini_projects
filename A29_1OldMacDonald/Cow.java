/**
 * Implements the minimum requirements specified by the Animal interface
 * 
 * @author George Peck
 * @version June 22, 2003 Period - 1-7 Assignment - A29.1 - Old MacDonald
 *          Sources - Roger Frank
 */
public class Cow
  implements Animal
{
  private String myType;
  private String mySound;

  /**
   * Initializes a newly created Cow object so that it represents an Animal of
   * the specified type that makes the specified sound.
   * 
   * @param type
   *          the type of Cow
   * @param sound
   *          the sound the Cow makes
   */
  public Cow(String type, String sound)
  {
    myType = type;
    mySound = sound;
  }


  /**
   * @return the sound of the cow
   */
  public String getSound()
  {
    return mySound;
  }


  /**
   * @return the type of the animal
   */
  public String getType()
  {
    return myType;
  }
}
