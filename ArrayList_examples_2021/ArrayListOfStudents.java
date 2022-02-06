
import acm.program.*;
import java.util.ArrayList;

public class ArrayListOfStudents extends ConsoleProgram
{

    public void run()
    {
        ArrayList<String> students = new ArrayList<String>();
        initializeStudents(students);

        if (students.get(12).length() > students.get(15).length())
            println(students.get(3));
        else
            println(students.get(11));
            
        students.add(9, "Leah Morris");
        students.set(5, "Ryan Morris");
        students.remove(24);

        for (int i=0; i<students.size(); i++)
        {
            println(students.get(i));
        }
        
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
        students.add("Amelie Boom");
        students.add("Ellie Brew");
        students.add("Nicholas Chin");
        students.add("Alberto Clegg Gonzalez");
        students.add("Neha Lalia");
        students.add("Leila Nawas");
        students.add("Nic Nikcevic");
        students.add("Theo Parker");
        students.add("Ava Shenk");
        students.add("Ian Smith");
        students.add("Bella Summe");
        students.add("Colleen Tanona");
        students.add("Louka Triant");
        students.add("Catherine Zhu");
    }
}
