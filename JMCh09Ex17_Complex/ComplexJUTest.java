import org.junit.*;
// import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 * Test for the complex number class. testConstructor1Param - test the 1
 * parameter constructor testConstructor2Param - test the 2 parameter
 * constructor testAddRealAndComplexNum - addition of a complex number with a
 * real number testAdd2ComplexNums - addition of two complex numbers
 * testMultiply2ComplexNums - multiplication of two complex numbers
 * testMultiplyRealAndComplexNum - multiplication of a complex number with a
 * real number testAbsoluteValue - absolute value of a complex number
 */
public class ComplexJUTest
    extends junit.framework.TestCase
{
    @Test
    public void testConstructor1Param()
    {
        // TODO complete test
        Complex c1 = new Complex(2);
        // assertEquals(2.0, c1.real);
        // assertEquals(0.0, c1.imaginary);
        assertEquals("2.0 + 0.0i", c1.toString());
    }


    @Test
    public void testConstructor2Param()
    {
        // TODO complete test
        Complex c1 = new Complex(2, 3);

        // assertEquals(2.0, c1.real);
        // assertEquals(3.0, c1.imaginary);
        assertEquals("2.0 + 3.0i", c1.toString());
    }


    @Test
    public void testAddRealAndComplexNum()
    {
        // TODO complete test
        int adder = 13;
        Complex c1 = new Complex(10, 12);
        Complex c2 = new Complex(23, 12);
        Complex c3 = c1.add(adder);
        // assertEquals(c2.real, c3.real);
        // assertEquals(c2.imaginary, c3.imaginary);
        assertEquals(c2.toString(), c3.toString());

    }


    @Test
    public void testAdd2ComplexNums()
    {
        // TODO complete test
        Complex c1 = new Complex(10, 12);
        Complex c2 = new Complex(12, 28);
        Complex c3 = new Complex(22, 40);
        Complex c4 = c1.add(c2);
        // assertEquals(c3.real, c4.real);
        // assertEquals(c3.imaginary, c4.imaginary);
        assertEquals(c3.toString(), c4.toString());

    }


    @Test
    public void testMultiply2ComplexNums()
    {
        // TODO complete test
        Complex c1 = new Complex(10.0, 12.0);
        Complex c2 = new Complex(12.0, 28.0);
        Complex c3 = new Complex(120.0 - 336.0, 280.0 + 144.0);
        Complex c4 = c1.multiply(c2);
        // assertEquals(c3.real, c4.real);
        // assertEquals(c3.imaginary, c4.imaginary);
        assertEquals(c3.toString(), c4.toString());

    }


    @Test
    public void testMultiplyRealAndComplexNum()
    {
        // TODO complete test
        int multiplier = 7;
        Complex c1 = new Complex(10, 12);
        Complex c2 = new Complex(70.0, 84.0);
        Complex c3 = c1.multiply(multiplier);
        // assertEquals(c2.real, c3.real);
        // assertEquals(c2.imaginary, c3.imaginary);
        assertEquals(c2.toString(), c3.toString());
    }


    @Test
    public void testAbsoluteValue()
    {
        // TODO complete test
        Complex c1 = new Complex(5, 12);
        assertEquals(13.0, c1.abs());
    }


    public void testToString()
    {
        Complex c1 = new Complex(2, 3);
        String s1 = c1.toString();
        assertEquals("2.0 + 3.0i", s1);
    }


    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter(ComplexJUTest.class);
    }


    public static void main(String args[])
    {
        org.junit.runner.JUnitCore.main("ComplexJUTest");
    }
}
