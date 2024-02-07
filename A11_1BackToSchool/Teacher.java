/**
 * @author Nishad Wajge
 * @author 10/29
 * @version 5
 */

public class Teacher
    extends Person
{
    private String subject;
    private double salary;

    /**
     * @param myName
     *            the name of the person
     * @param myAge
     *            the age of the person
     * @param myGender
     *            the gender of the person
     * @param subject
     *            the subject the person is teaching
     * @param salary
     *            the salary of the person
     */
    public Teacher(String myName, 
        int myAge, 
        String myGender, 
        String subject, 
        double salary)
    {
        super(myName, myAge, myGender);
        this.subject = subject;
        this.salary = salary;
    }


    /**
     * @return of the subject the person teaches
     */
    public String getSubject()
    {
        return subject;
    }


    /**
     * @return the salary of the person
     */
    public double getSalary()
    {
        return salary;
    }


    /**
     * @param str
     *            gives the new subject
     */
    public void setSubject(String str)
    {
        subject = str;
    }


    /**
     * @param num
     *            gives new salary
     */
    public void setSalary(double num)
    {
        salary = num;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + 
            subject + ", salary: " + salary;
    }
}
