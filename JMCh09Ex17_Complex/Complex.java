/**
 * This class implements several different operators on complex numbers (a +
 * bi).
 * 
 * @author Nishad
 * @version 10/5
 * @author Period - 6
 * @author Assignment - Complex
 * @author Sources - me, myself, i
 */
public class Complex
{

    private double real;
    private double imaginary;

    /**
     * @param a
     *            = real
     */
    public Complex(double a)
    {
        real = a;
        imaginary = 0;
    }


    /**
     * @param a
     *            = real
     * @param b
     *            = imaginary
     */
    public Complex(double a, double b)
    {
        real = a;
        imaginary = b;
    }


    /**
     * @return the absolute value of the two numbers thru pyth theorem
     */
    public double abs()
    {
        return Math.sqrt((real * real) + (imaginary * imaginary));
    }


    /**
     * @param other
     *            = the imported Complex object being added with the given one
     * @return the addition of the real and imaginary numbers as a new Complex
     *         object
     */
    public Complex add(Complex other)
    {
        return new Complex(real + other.real, imaginary + other.imaginary);
    }


    /**
     * @param other
     *            = another Complex object
     * @return the multiplication of the two Complex nums
     */
    public Complex multiply(Complex other)
    {
        return new Complex(
            (real * other.real) - (imaginary * other.imaginary),
            (real * other.imaginary) + (imaginary * other.real));
    }


    /**
     * @param other
     *            just a double
     * @return real + double and keeps imaginary the same
     */
    public Complex add(double other)
    {
        return new Complex(real + other, imaginary);
    }


    /**
     * @param other
     *            just a double
     * @return using multiplcation property
     */
    public Complex multiply(double other)
    {
        return new Complex(real * other, imaginary * other);
    }


    /**
     * @return just puts it in nice format
     */
    public String toString()
    {
        return real + " + " + imaginary + "i";
    }
}
