import java.util.Arrays;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  Aaron Lee
   @version 3/7/2022

   @author  Period - 6
   @author  Assignment - Heap Sort

   @author  Sources - none
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    //   using the Mergesort algorithm
    public static void sort(double[] a)
    {
        int n = a.length;
        for (int i = n/2; i >= 1; i--) {
            reheapDown(a, i, n);
        }

        while (n > 1) {
        // swap a[0] with a[n-1]:
            double temp = a[0];
            a[0] = a[n-1]; 
            a[n-1] = temp;
            n--;
            reheapDown(a, 1, n);
        }

        //Arrays.sort(a);
        //System.out.println(Arrays.toString(a));
    }

    // Should be private - made public for testing
    public static void reheapDown(double[] a, int i, int n)
    {   
        for (;((i * 2) - 1) < n; i *= 2) {
            int leftNode = i * 2;

            if (leftNode < n && a[leftNode] > a[leftNode - 1]) {
                leftNode++;  
            }

            if (a[leftNode - 1] > a[i - 1]) {
                double temp = a[leftNode - 1];
                a[leftNode - 1] = a[i - 1];
                a[i - 1] = temp;
            } 
            
        }
    }
}