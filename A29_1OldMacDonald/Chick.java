/**
 * @author Nishad Wajge
 * @version 11/1/21
 */
class Chick
   implements Animal
{
   private String myType;
   private String mySound;
   private String mySound2;

   /**
    * Initializes a newly created Chick object so that it represents an Animal
    * of the specified type that makes the specified sound.
    * 
    * @param type
    *           the type of Chick
    * @param sound
    *           the sound the Chick makes
    */
   public Chick(String type, String sound)
   {
      myType = type;
      mySound = sound;
   }


   /**
    * Initializes a newly created Chick object so that it represents an Animal
    * of the specified type that makes the specified sound.
    * 
    * @param type
    *           the type of Chick
    * @param sound
    *           the sound the Chick makes
    * @param sound2
    *           the sound the Chick makes #2
    */
   public Chick(String type, String sound1, String sound2)
   {
      myType = type;
      mySound = sound1;
      mySound2 = sound2;
   }


   /**
    * @return the sound, which has a 50/50 if the second constructor is used
    */
   public String getSound()
   {
      try
      {
         double number = Math.random();
         if (number > 0.5)
         {
            return mySound;
         }
         else
         {
            return mySound2;
         }
      }
      catch (Exception e)
      {
         return mySound;
      }
   }


   /**
    * @return the type of the animal
    */
   public String getType()
   {
      return myType;
   }
}
