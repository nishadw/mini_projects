class OldMacDonald
{
   public static void main(String[] args)
   {
      Cow c = new Cow("cow", "moo");
      System.out.println( c.getType() + " goes " + c.getSound() );

      Pig p = new Pig("pig", "oink");
      System.out.println( p.getType() + " goes " + p.getSound() );

      Chick h = new Chick("chick", "cluck");
      System.out.println( h.getType() + " goes " + h.getSound());

      Chick i = new Chick("chick", "cluck", "cheep");
      System.out.println( i.getType() + " goes " + i.getSound() + " or " + i.getSound());

      NamedCow n = new NamedCow("cow", "carl", "moo");
      System.out.println("The " + n.getType() + "'s name is " + n.getName() + " and it goes " + n.getSound());
   }
}
