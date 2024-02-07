import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements a BST with TreeNode nodes.
 * 
 * @author nishad
 * @version 1/26/22
 * @author Period - 6
 * @author Assignment - super()
 * @author Sources - NISHADWAJGE feat. ME
 */
public class MyTreeSet<E>
    implements Iterable<E>
{
    private TreeNode<E> root; // holds the root of this BST

    // Constructor: creates an empty BST.
    public MyTreeSet()
    {
        root = null; // new TreeNode<E>(null);
    }


    // Returns true if this BST contains value; otherwise returns false.
    public boolean contains(E value)
    {
        return contains(root, value);
    }


    // Adds value to this BST, unless this tree already holds value.
    // Returns true if value has been added; otherwise returns false.
    public boolean add(E value)
    {
        if (contains(value))
            return false;
        root = add(root, value);
        return true;
    }


    // Removes value from this BST. Returns true if value has been
    // found and removed; otherwise returns false.
    public boolean remove(E value)
    {
        if (!contains(value))
            return false;
        root = remove(root, value);
        return true;
    }


    // Returns a string representation of this BST.
    public String toString()
    {
        String str = toString(root);
        if (str.endsWith(", "))
            str = str.substring(0, str.length() - 2);
        return "[" + str + "]";
    }


    // Returns an iterator for this BST.
    public Iterator<E> iterator()
    {
        return new MyTreeSetIterator(root);
    }

    // *************** Private helper methods: *********************


    // Returns true if the BST rooted at node contains value;
    // otherwise returns false (recursive version).
    private boolean contains(TreeNode<E> node, E value)
    {
        if (node == null)
            return false;
        else
        {
            int diff = ((Comparable<E>)value).compareTo(node.getValue());
            if (diff == 0)
                return true;
            else if (diff < 0)
                return contains(node.getLeft(), value);
            else // if (diff > 0)
                return contains(node.getRight(), value);
        }
    }

    /*
     * // Iterative version: private boolean contains(TreeNode<E> node, E value)
     * { while (node != null) { int diff = ( (Comparable<E>)value).compareTo(
     * node.getValue() ); if (diff == 0) return true; else if (diff < 0) node =
     * node.getLeft(); else // if (diff > 0) node = node.getRight(); } return
     * false; }
     */


    // Adds value to the BST rooted at node. Returns the
    // root of the new tree.
    // Precondition: the tree rooted at node does not contain value.
    private TreeNode<E> add(TreeNode<E> node, E value)
    {
        if (node == null)
            node = new TreeNode(value);
        else
        {
            int diff = ((Comparable<E>)value).compareTo(node.getValue());
            if (diff < 0)
                node.setLeft(add(node.getLeft(), value));
            else // if (diff > 0)
                node.setRight(add(node.getRight(), value));
        }
        return node;
    }


    // Removes value from the BST rooted at node.
    // Returns the root of the new tree.
    // Precondition: the tree rooted at node contains value.
    private TreeNode<E> remove(TreeNode<E> node, E value)
    {
        int diff = ((Comparable<E>)value).compareTo(node.getValue());
        if (diff == 0) // base case
            node = removeRoot(node);
        else if (diff < 0)
            node.setLeft(remove(node.getLeft(), value));
        else // if (diff > 0)
            node.setRight(remove(node.getRight(), value));
        return node;
    }


    // Removes the root of the BST rooted at root
    // replacing it with the smallest node from the right subtree.
    // Returns the root of the new tree.
    private TreeNode<E> removeRoot(TreeNode<E> root)
    {
        TreeNode<E> node = root.getRight();

        if (root == null || node == null)
        {
            node = root.getLeft();
            return node;
        }

        else if (node.getLeft() == null)
        {
            node.setLeft(root.getLeft());
            return node;
        }

        else
        {
            TreeNode<E> parent = node;
            node = node.getLeft();

            while (node.getLeft() != null)
            {
                parent = parent.getLeft();
                node = node.getLeft();
            }
            
            parent.setLeft(null);
            root.setValue(node.getValue());
            
            return root;
        }

        
    }


    // Utility routine to print the structure of the BST
    public void printSideways()
    {
        if (root == null)
            return;
        printSideways(root, 0);
    }


    // Precondition: original argument != null
    private void printSideways(TreeNode<E> t, int depth)
    {
        if (t.getRight() != null)
            printSideways(t.getRight(), depth + 1);

        process(t.getValue(), depth);

        if (t.getLeft() != null)
            printSideways(t.getLeft(), depth + 1);
    }


    // Simply display the toString version of my_data
    private void process(E obj, int depth)
    {
        for (int j = 1; j <= depth; j++)
            System.out.print("    ");
        System.out.println(obj.toString());
    }


    // Returns a string representation of the tree rooted at node.
    private String toString(TreeNode<E> node)
    {
        if (node == null)
            return "";
        else
            return toString(node.getLeft()) + node.getValue() + ", " + toString(node.getRight());
    }

    // Implements an Iterator for this tree.
    private class MyTreeSetIterator
        implements Iterator<E>
    {
        Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
        TreeNode<E>        tNode;

        public MyTreeSetIterator(TreeNode<E> root)
        {
            
            tNode = root;

            while (tNode != null)
            {
                stack.push(tNode);
                tNode = tNode.getLeft();
            }
        }


        public boolean hasNext()
        {
            return !stack.isEmpty();
        }


        public E next()
        {
            /**
            if (hasNext())
            {
                throw new NoSuchElementException();
            }

            tNode = stack.pop();
            E obj = tNode.getValue();
            tNode = tNode.getRight();

            while (tNode != null)
            {
                stack.push(tNode);
                tNode = tNode.getLeft();
            }

            return obj;
            */

            TreeNode<E> next = stack.peek().getRight();
            TreeNode<E> returnVal = stack.pop();
            while (next != null) {
                stack.push(next);
                next = next.getLeft();
            }
            return returnVal.getValue();
        }


        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    // ************************** main: **************************

    public static void main(String[] args)
    {
        String[] words =
            { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
        MyTreeSet bst = new MyTreeSet();

        for (String word : words)
        {
            System.out.println("Added: " + word + " " + bst.add(word));
            System.out.println("Contains: " + word + " " + bst.contains(word));
            if (bst.add(word))
                System.out.println("*** Added a duplicate value ***");
            System.out.println(bst);
        }
        bst.printSideways();

        System.out.println("Traversal with an iterator:");
        for (Object obj : bst)
            System.out.print(obj + " ");
        System.out.println();

        for (String word : words)
        {
            System.out.println("Removed: " + word + " " + bst.remove(word));
            if (bst.remove(word))
                System.out.println("*** Removed a non-existent value ***");
            System.out.println(bst);
            bst.printSideways();
        }
    }
}
