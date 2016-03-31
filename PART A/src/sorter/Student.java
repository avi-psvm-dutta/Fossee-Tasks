package sorter;

import java.util.Scanner;

public class Student
{
    private static final Scanner s = new Scanner(System.in); //a scanner for user input

    public int rollNo;
    private String name;
    public int[] marks = new int[5]; //marks are ordered by priority order for sorting {Math, Science, Environmental Studies, Language 2, Language 1}
    public int totalMarks;
    //member variables

    public Student()
    {
        //input
        System.out.print("Roll No.: ");
        rollNo = s.nextInt();
        System.out.print("Name: ");
        s.nextLine();
        name = s.nextLine();
        System.out.println("Language 1, Language 2, Math, Science, Environmental Studies (separated by spaces): ");
        marks[4] = s.nextInt();
        marks[3] = s.nextInt();
        marks[0] = s.nextInt();
        marks[1] = s.nextInt();
        marks[2] = s.nextInt();

        //calculate total
        for(int mark : marks)
            totalMarks += mark;
    }

    @Override
    public String toString()
    {
        //output the student's info in formatted mode
        return "Roll No.: " + rollNo +
                "\nName: " + name +
                "\nLanguage1, Language2, Math, Science, Environmental Studies: " + marks[4] + ", " + marks[3] + ", " + marks[0] + ", " + marks[1] + ", " + marks[2];
    }
}