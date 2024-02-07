import java.util.*;

/**
 * it was good
 * 
 * @author nw
 * @version 1/18/22
 * 
 * @author Period - 6
 * @author Assignment - tbh
 * 
 * @author Sources - tbh
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;
    
    
    public MailServer() {
        actors = new TreeSet<Actor>();
    }

    public void signUp(Actor actor) {
        actors.add(actor);
    }

    public void dispatch(Message msg) {
        Actor recepient = msg.getRecipient();

        if (recepient == null) {
            for (Actor actor : actors) {
                if (!actor.equals(msg.getSender())) {
                    actor.receive(msg);
                }
            }
        }
        else {
            recepient.receive(msg);
        }
    }
    
    
    // for testing purposes only
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
