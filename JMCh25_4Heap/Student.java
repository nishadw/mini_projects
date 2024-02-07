/**
   Student.java

   Stores the following information about students
      grade
      name (first and last)
      Lynbrook id

 */
public class Student implements Comparable
{
    private String lynbrookId;
    private String firstName;
    private String lastName;
    private int grade;

    public Student( String id, String fName, String lName, int g )
    {
        lynbrookId = id;
        firstName = fName;
        lastName = lName;
        grade = g;
    }

    public Student()
    {
        this( "", "", "", 0 );
    }

    /**
     * s
     * 
     * @param obj
     * @return s
     */
    public int compareTo( Object obj )
    {
        if (obj == null) {
            return 1;
        }
        Student student = (Student) obj;

        if (grade == student.getGrade()) {
            return lynbrookId.compareTo(student.getID());
        }
        else if (grade < student.getGrade()) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public int getGrade() {
        return grade;
    }

    public String getID() {
        return lynbrookId;
    }
    public Object clone()
    {
        return new Student( lynbrookId, firstName, lastName, grade );
    }

    public String toString()
    {
        return lynbrookId + " " + firstName + " " + lastName + " " + grade;
    }
}
