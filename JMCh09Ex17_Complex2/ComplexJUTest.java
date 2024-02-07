import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 *  Test for the complex number class.
 *  
 *  testConstructor1Param - test the 1 parameter constructor
 *  testConstructor2Param - test the 2 parameter constructor
 *  testAddRealAndComplexNum - addition of a complex number 
 *     with a real number
 *  testAdd2ComplexNums - addition of two complex numbers
 *  testMultiply2ComplexNums - multiplication of two complex numbers
 *  testMultiplyRealAndComplexNum - multiplication of a complex number
 *     with a real number
 *  testAbsoluteValue - absolute value of a complex number
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    @Test
    public void testConstructor1Param()
    {
        // TODO complete test
        assertEqual(true, true);
    }

    @Test
    public void testConstructor2Param()
    {
        // TODO complete test
        assertEqual(true, true);
    }

    @Test
    public void testAddRealAndComplexNum()
    {
        // TODO complete test
        int adder = 13;
        Complex c1 = new Complex(10, 12);
        assertEqual(Complex(23, 12), c1.add(adder));
    }
    
    @Test
    public void testAdd2ComplexNums()
    {
        // TODO complete test
        Complex c1 = new Complex(10, 12);
        Complex c2 = new Complex(12, 28);
        assertEqual(Complex(22, 40), c1.add(c2));
    }

    @Test
    public void testMultiply2ComplexNums()
    {
        // TODO complete test
        Complex c1 = new Complex(10, 12);
        Complex c2 = new Complex(12, 28);
        assertEqual(Complex(120 - 330, 280 + 144), c1.multiply(c2));
    }

    @Test
    public void testMultiplyRealAndComplexNum()
    {
        // TODO complete test
        int multiplier = 7;
        Complex c1 = new Complex(10, 12);
        assertEqual(Complex(70, 84), c1.multiply(multiplier));
    }

    @Test
    public void testAbsoluteValue()
    {
        // TODO complete test
        Complex c1 = new Complex(5, 12);
        assertEqual(13, c1.abs());
    }
    
    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }

    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
