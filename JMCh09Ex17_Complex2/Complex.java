public class Complex
{
    // TODO instance variables

    double real, imaginary;


    // TODO Constructors

    public Complex( int a ) {
        real = a;
        imaginary = 0;
    }
    public Complex( int a , int b ) {
        real = a;
        imaginary = b;
    }


    // TODO Methods
    public double abs () {
        return Math.sqrt ( (real * real) + (imaginary * imaginary) );
    }

    public Complex add (Complex other) {
        return Complex ( real + other.real , imaginary + other.imaginary);
    }

    public Complex multiply ( Complex other ) {
        return Complex ( (real * other.real) - (imaginary * other.imaginary) , (real * other.imaginary) + (imaginary * other.real) );
    }

    public Complex add ( double other ) {
        return Complex ( real + other , imaginary);
    }

    public Complex multiply ( double other ) {
        return Complex ( real * other , imaginary * other );
    }
    
    public String toString()
    {
        return real + " + " + imaginary + "i";
    }
}
