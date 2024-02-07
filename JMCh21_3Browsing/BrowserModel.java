
// import java.util.List;
import java.util.Stack;

/**
 * @author me
 * @version 1
 */
public class BrowserModel
{
    private BrowserView    view;
    private Stack<Integer> backStk;
    private Stack<Integer> forwardStk;
    private int            topLine;

    /**
     * @param pew
     *            is view in disguise
     */
    public BrowserModel(BrowserView pew)
    {
        view = pew;
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
        topLine = 0;
        
        view.update(0);

    }


    /**
     * a
     */
    public void back()
    {
        if (!hasBack())
        {
            return;
        }

        int i = (int)backStk.pop();
        forwardStk.push(topLine);
        topLine = i;
        view.update(i);
    }


    /**
     * should be opposite of back
     */
    public void forward()
    {
        if (!hasForward())
        {
            return;
        }

        int i = (int)forwardStk.pop();
        backStk.push(topLine);
        topLine = i;
        view.update(i);
    }


    /**
     * s
     */
    public void home()
    {
        view.update(0);
        backStk.push(topLine);
        topLine = 0;
        forwardStk.clear();
    }


    /**
     * @param n
     *            is an int
     */
    public void followLink(int n)
    {
        view.update(n);
        backStk.push(topLine);
        topLine = n;
        forwardStk.clear();
    }


    /**
     * @return sees if empty
     */
    public boolean hasBack()
    {
        return !backStk.isEmpty();
    }


    /**
     * @return sees if empty
     */
    public boolean hasForward()
    {
        return !forwardStk.isEmpty();
    }


    // The following are for test purposes only
    /**
     * asd
     * 
     * @return get
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }


    /**
     * asdg
     * 
     * @return get
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }


    /**
     * asg
     * 
     * @return get
     */
    public int getTopLine()
    {
        return topLine;
    }
}
