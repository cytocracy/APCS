
import acm.program.*;
import java.util.ArrayList;

public class PartnerPickerC extends ConsoleProgram
{

    public void run()
    {
        ArrayList<String> students = new ArrayList<String>();
        initializeStudents(students);
        while (students.size()  > 1)
        {
            int index = (int)(Math.random() * students.size());
            print(students.get(index) + " and ");
            students.remove(index);
            index = (int)(Math.random() * students.size());
            println(students.get(index));
            students.remove(index);
        }
        if (students.size() != 0)
        println(students.get(0));
        /*
         * 0.  Add some students.
         * 1.  Pick two random students and remove them from the ArrayList.
         * 2.  Repeat step #1 until there are no more students.
         * 3.  What if there are an odd number of students?
         *     Either make one person go solo, or make one group of three.
         */

    }
    
    
    public void initializeStudents(ArrayList<String> students)
    {
        students.add("Aidan Bhatnagar");
        students.add("Aarav Chandrasekar");
        students.add("Ben Co");
        students.add("Steve Daheb");
        students.add("Beau Dunlevie");
        students.add("Paul Fong");
        students.add("Ayaan Govil");
        students.add("Armin Hamrah");   
        students.add("Lucy Knox");
        students.add("Aroosh Kumar");
        students.add("Millie Muir");
        students.add("Julia Soderbery");
        students.add("Sean Tinsley");
        students.add("Alyssa Turenne");
        students.add("Bear Weigle");
        students.add("Ella Woodhead");
        students.add("Jerry Xu");
    }
}