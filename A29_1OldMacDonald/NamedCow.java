/**
 * @author Nishad Wajge
 * @version 11/1/21
 */
class NamedCow
   extends Cow
{
   private String myName;

   /**
    * Initializes a newly created NamedCow object so that it represents Cow of
    * the specified type that makes the specified name.
    * 
    * @param type
    *           the type of Cow
    * @param sound
    *           the sound the Cow makes
    */
   public NamedCow(String type, String sound)
   {
      super(type, sound);
   }


   /**
    * Initializes a newly created NamedCow object so that it represents Cow of
    * the specified type that makes the specified name.
    * 
    * @param type
    *           the type of Cow
    * @param sound
    *           the sound the Cow makes
    * @param name
    *           the name of the Cow
    */
   public NamedCow(String type, String name, String sound)
   {
      super(type, sound);
      myName = name;
   }


   /**
    * @return the name of the cow
    */
   public String getName()
   {
      return myName;
   }
}
