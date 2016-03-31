package sorter;

import java.util.ArrayList;
import java.util.Scanner;

/*
Class info:
This is the runnable class
    Members:
    A scanner object, for input.
    An array list for students.
COMPILE IN JAVA 8.
The package sorter contains the first answer
 */

public class SorterMain
{
    private static final Scanner s = new Scanner(System.in);

    private static ArrayList<Student> students = new ArrayList();

    private static int comparator(Student a1, Student a2)
    {
        int returnValue = new Integer(a2.totalMarks).compareTo(a1.totalMarks);
        //return the comparator for the greater marks

        //in case the two total marks are equal, update the comparator subject wise, in priority order, until the return value is not zero
        for(int markIndex = 0; markIndex < 5 && returnValue == 0; markIndex++)
            returnValue = new Integer(a2.marks[markIndex]).compareTo(a1.marks[markIndex]);

        //return the final returnvalue
        return returnValue;
    }

    public static void main(String[] args)
    {
        //Enter the number of students
        System.out.print("How many students?: ");
        int n = s.nextInt();

        for(int index = 0; index < n; index++)
        {
            //add n students
            students.add(new Student());
        }

        //sort the student list with the custom comparator
        students.sort((o1, o2) -> comparator(o1, o2));

        for(Student student : students)
            System.out.println(student);
        //print the data in the end
    }
}
