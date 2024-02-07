/**
 * @author Nishad Wajge
 * @author 10/29
 * @version 5
 */

public class CollegeStudent
    extends Student
{

    private String major;
    private int    year;

    /**
     * @param myName
     *            the name of the person
     * @param myAge
     *            the age of the person
     * @param myGender
     *            the gender of the person
     * @param myIdNum
     *            the id number of the person
     * @param myGPA
     *            the grades of the person
     * @param year
     *            the year they are in of the person
     * @param major
     *            the major of the person
     */
    public CollegeStudent(
        String myName,
        int myAge,
        String myGender,
        String myIdNum,
        double myGPA,
        int year,
        String major)
    {
        super(myName, myAge, myGender, myIdNum, myGPA);
        this.major = major;
        this.year = year;
    }


    /**
     * @return the year they are in
     */
    public int getYear()
    {
        return year;
    }


    /**
     * @return their major
     */
    public String getMajor()
    {
        return major;
    }


    /**
     * @param num
     *            a new year they are
     */
    public void setYear(int num)
    {
        year = num;
    }


    /**
     * @param str
     *            their new major
     */
    public void setMajor(String str)
    {
        major = str;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + year + ", major: " + major;
    }
}
