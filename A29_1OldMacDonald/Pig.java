/**
 * @author Nishad Wajge
 * @version 11/1/21
 */
class Pig
   implements Animal
{
   private String myType;
   private String mySound;

   /**
    * Initializes a newly created Pig object so that it represents an Animal of
    * the specified type that makes the specified sound.
    * 
    * @param type
    *           the type of Pig
    * @param sound
    *           the sound the Pig makes
    */
   public Pig(String type, String sound)
   {
      myType = type;
      mySound = sound;
   }


   /**
    * @return the sound of the pig
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
