
import acm.program.*;
import java.util.ArrayList;

public class Josephus extends ConsoleProgram
{

    public void run()
    {
        ArrayList<String> students = new ArrayList<String>();
        initializeStudents(students);
        int index = 0;
        while(students.size() > 1){
            if(index == students.size()) index = 0;
            println(students.get(index) +  " has length = " + students.get(index).length());
            println("So let's remove the student " + students.get(index).length() + " places after " + students.get(index)+ "...");
            
            index += students.get(index).length();
            if(index > students.size())
                index  %= students.size();
            
            
            
            println("Goodbye " + students.get(index) + ". You were removed.");
            println();
            students.remove(index);
            
        }
        println(students.get(0) + " is the winner!");
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
