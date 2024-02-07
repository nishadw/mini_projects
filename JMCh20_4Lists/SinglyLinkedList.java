import java.util.Iterator;
import javax.imageio.IIOException;

/**
 * Implements a singly-linked list.
 * 
 * @author Nishad
 * @version T minus 7 days until Winter Break
 * @author Period - the first "perfect" number (a number whose factors add up to that number)
 * @author Assignment - this one
 * @author Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E>
    implements Iterable<E>
{
    private ListNode<E> head;
    private int         nodeCount;

    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }


    /**
     * Constructor: creates a list that contains all elements from the array
     * values, in the same order
     * 
     * @param values
     *            array containing all elements for this list
     */
    public SinglyLinkedList(E[] values)
    {
        ListNode<E> tail = null;
        for (E value : values) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>(value, null);
            if (head == null)
                head = node;
            else
                tail.setNext(node);
            tail = node;    // update tail
        }

        nodeCount = values.length;
    }


    /**
     * Return true if this list is empty; otherwise returns false.
     * 
     * @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        return nodeCount == 0;
    }


    /**
     * Returns the number of elements in this list.
     * 
     * @return number of elements in this list.
     */
    public int size()
    {
        return nodeCount;
    }


    /**
     * Returns true if this list contains an Object equal to obj; otherwise
     * returns false.
     * 
     * @return true if this list contains an Object equal to obj
     */
    public boolean contains(Object obj)
    {
        return indexOf(obj) >= 0;
    }


    /**
     * Returns the index of the first Object equal to obj; if not found, returns
     * -1.
     * 
     * @param obj
     *            Object to find
     * @return the index of the first Object in equal to obj; if not found,
     *         returns -1.
     */
    public int indexOf(Object obj)
    {
        int count = 0;
        ListNode<E> n = head;

        for (n = head; n != null; n = n.getNext(), count++)
        {
            if (obj.equals(n.getValue()))
            {
                return count;
            }

        }

        return -1;
    }


    /**
     * Adds obj to this collection. Returns true if successful; otherwise
     * returns false.
     * 
     * @param obj
     *            element to add to this collection
     * @return true if successful; otherwise returns false.
     */
    public boolean add(E obj)
    {
        add(nodeCount, obj);

        return true;
    }


    /**
     * Removes the first element that is equal to obj, if any. Returns true if
     * successful; otherwise returns false.
     * 
     * @param obj
     *            element to remove
     * @return true if successful; otherwise returns false.
     */
    public boolean remove(E obj)
    {
        ListNode<E> b = head;
        ListNode<E> n = head;
        int count = 0;

        for (n = head; n != null; n = n.getNext())
        {
            if (n.getValue().equals(obj))
            {
                if (n == head)
                {
                    head = head.getNext();
                    count++;
                    
                }
                else
                {
                    b.setNext(n.getNext());
                    count++;
                    
                }
                
            }

            else
            {
                b = n;
            }
        }
        
        nodeCount -= count;
        return count > 0;
    }


    /**
     * Returns the i-th element.
     * 
     * @param i
     *            element to get from the list
     * @return element at index i
     * @throws IndexOutOfBoundsException
     */
    public E get(int i)
    {
        
        if (nodeCount == 0 || i >= nodeCount || i < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        E finalAnswer = null;
        ListNode<E> n = head;

        for (n = head; n != null; n = n.getNext(), count++)
        {
            if (count == i)
            {
                finalAnswer = n.getValue();
            }
        }

        return finalAnswer;
    }


    /**
     * Replaces the i-th element with obj and returns the old value.
     * 
     * @param i
     *            index of element to replace
     * @param obj
     *            replacement element of element at index i
     * @return old value previously located at index i
     * @throws IndexOutOfBoundsException
     */
    public E set(int i, E obj)
    {
        if (nodeCount == 0 || i >= nodeCount || i < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        E finalAnswer = null;
        ListNode<E> n = head;

        for (n = head; n != null; n = n.getNext(), count++)
        {
            if (count == i)
            {
                finalAnswer = n.getValue();
                n.setValue(obj);

                return finalAnswer;
            }
        }

        return finalAnswer;

    }


    /**
     * Inserts obj to become the i-th element. Increments the size of the list
     * by one.
     * 
     * @param i
     *            insertion point in list for obj
     * @param obj
     *            element to insert into list
     * @throws IndexOutOfBoundsException
     */
    public void add(int i, E obj)
    {
        if (nodeCount == 0 && i != 0)
        {             // list is size 0 but wants to add i.e. 2
            throw new IndexOutOfBoundsException();
        }

        if (i > nodeCount || i < 0)
        {               // if i out of range
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        ListNode<E> b = head;

        if (head == null)
        {
            head = new ListNode<E>(obj, null);
            nodeCount++;

            return;
        }

        ListNode<E> n = head;

        for (n = head; count <= nodeCount; n = n.getNext(), count++)
        {
            if (count == i)
            {
                if (i == nodeCount)
                {
                    b.setNext(new ListNode<E>(obj, null));
                }
                else if (i == 0)
                {
                    head = new ListNode<E>(obj, head);
                }
                else
                {
                    b.setNext(new ListNode<E>(obj, n));
                }

                nodeCount++;
                return;
            }
            else
            {
                b = n;
            }
        }
    }


    /**
     * Removes the i-th element and returns its value. Decrements the size of
     * the list by one.
     * 
     * @param i
     *            index of element to remove
     * @return element removed from this list
     */
    public E remove(int i)
    {
        
        if (nodeCount == 0 || i >= nodeCount || i < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        E finalAnswer = null;
        ListNode<E> b = head;
        ListNode<E> n = head;

        for (n = head; n != null; n = n.getNext(), count++)
        {
            if (count == i)
            {
                if (count == 0)
                {
                    finalAnswer = head.getValue();
                    head = head.getNext();
                }
                else
                {
                    finalAnswer = n.getValue();
                    b.setNext(n.getNext());
                }
                nodeCount--;
            }
            else
            {
                b = n;
            }
        }

        return finalAnswer;
    }


    /**
     * Returns a string representation of this list.
     * 
     * @return a string representation of this list.
     */
    public String toString()
    {
        
        String almostDone = "[";
        ListNode<E> n = head;

        for (n = head; n != null; n = n.getNext())
        {
            almostDone +=  "" + n.getValue();

            if (n.getNext() != null)
                almostDone += ", ";

        }
        almostDone += "]";

        return almostDone;
    }


    /**
     * Returns an iterator for this collection.
     * 
     * @return an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>(head);
    }
}
