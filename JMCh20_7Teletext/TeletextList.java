// Implements the list of messages for teletext

import java.awt.Graphics;

/**
 * @author the names nishad, nishad wajge
 * @version 7.1.2022
 */
public class TeletextList
{
    private ListNode2<String> heading;
    private ListNode2<String> topNode;

    /**
     * Creates a circular list of headlines. First creates a circular list with
     * one node, "Today's headlines:". Saves a reference to that node in
     * heading. Adds a node holding an empty string before heading and another
     * node holding an empty string after heading. Appends all the strings from
     * headlines to the list, after the blank line that follows heading,
     * preserving their order. Sets topNode equal to heading.
     * 
     * @param h
     *            Strings to add to circular list
     */
    public TeletextList(String[] h)
    {
        heading = new ListNode2<String>("Today's headlines:", null, null);
        heading.setPrevious(new ListNode2<String>("", null, heading));
        heading.setNext(new ListNode2<String>("", heading, null));
        ListNode2<String> t = heading.getNext();
        for (int i = 0; i < h.length; i++)
        {
            t.setNext(new ListNode2<String>(h[i], t, heading.getPrevious()));
            t = t.getNext();
        }
        t.setNext(heading.getPrevious());
        heading.getPrevious().setPrevious(t);
        topNode = heading;

    }


    /**
     * Inserts a node with msg into the headlines list after the blank /line
     * that follows heading.
     * 
     * @param msg
     *            String to add to headlines list
     */
    public void insert(String msg)
    {
        ListNode2<String> hNext = heading.getNext();
        ListNode2<String> hNextNext = heading.getNext().getNext();
        ListNode2<String> t = new ListNode2<String>(msg, hNext, hNextNext);
        heading.getNext().setNext(t);
        heading.getNext().getNext().setPrevious(t);
    }


    /**
     * Deletes the node that follows topNode from the headlines list, unless
     * that node happens to be heading or the node before or after heading that
     * holds a blank line.
     */
    public void delete()
    {

        ListNode2<String> next = topNode.getNext();
        ListNode2<String> hnext = heading.getNext();
        if (next.equals(hnext) || next.equals(heading))
        {
        }
        else
        {
            topNode.setNext(topNode.getNext().getNext());
        }
    }


    /**
     * Scrolls up the headlines list, advancing topNode to the next node.
     */
    public void scrollUp()
    {
        topNode = topNode.getNext();
    }


    /*
     * Adds a new node with msg to the headlines list before a given node.
     * Returns a referenece to the added node.
     */
    /**
     * @param node
     *            n
     * @param msg
     *            m
     * @return s
     */
    private ListNode2<String> addBefore(ListNode2<String> node, String msg)
    {
        ListNode2<String> newNode = new ListNode2<String>(msg,
            node.getPrevious(), node);
        node.getPrevious().setNext(newNode);
        node.setPrevious(newNode);
        return newNode;
    }


    /*
     * Adds a new node with msg to the headlines list after a given node.
     * Returns a referenece to the added node.
     */
    /**
     * @param node
     *            n
     * @param msg
     *            m
     * @return s
     */
    private ListNode2<String> addAfter(ListNode2<String> node, String msg)
    {
        ListNode2<String> mode2 = new ListNode2<String>(msg, 
            node, node.getNext());
        node.getNext().setPrevious(mode2);
        node.setNext(mode2);

        return mode2;
    }


    /*
     * Removes a given node from the list.
     */
    /**
     * @param node
     *            n
     */
    private void remove(ListNode2<String> node)
    {
        node.getPrevious().setNext(node.getNext());
    }


    /*
     * Draws nLines headlines in g, starting with topNode at x, y and
     * incrementing y by lineHeight after each headline.
     */
    /**
     * @param g
     *            g
     * @param x
     *            x
     * @param y
     *            y
     * @param lineHeight
     *            h
     * @param nLines
     *            n
     */
    public void draw(Graphics g, int x, int y, int lineHeight, int nLines)
    {
        ListNode2<String> node = topNode;
        for (int k = 1; k <= nLines; k++)
        {
            g.drawString(node.getValue(), x, y);
            y += lineHeight;
            node = node.getNext();
        }
    }


    /**
     * Returns a string representation of this TeletextList.
     * 
     * @return a string representation of this TeletextList.
     */
    public String toString()
    {
        String str = getClass().getName() + "[";
        String separator = "";

        for (ListNode2<String> node = heading; 
            node.getNext() != heading; node = node.getNext())
        {
            str += (separator + node.getValue());
            separator = ", ";
        }

        return str + "]";
    }
}
