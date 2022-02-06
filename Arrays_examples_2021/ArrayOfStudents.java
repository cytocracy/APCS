
import acm.program.*;

public class ArrayOfStudents extends ConsoleProgram
{

    public void run()
    {
        String[] students;
        students = new String[31];
        initializeStudents(students);
        
        println(students[22].substring(8) + 
                students[9].substring(5, 7) + 
                students[1].substring(7, 11) + 
                students[13].substring(4,5));
        if (students[12].length() > students[16].length())
            println(students[23]);
        else
            println(students[11]);
            
        //for (int i=0; i <students.length; i++){
           // println(students[i]);
        //}
        
        for(int i=0; i<students.length; i++)
            if(students[i].indexOf("e") != -1) println(students[i]);
            
        int counter = 0;
        for(int i=0; i<students.length; i++)
            if(students[i].indexOf("k") != -1) counter++;
            
        println("There are " + counter + " students with k's in their name.");
        
        String champ = students[0];
        
        for(int i=0; i<students.length; i++){
            if(students[i].length() < champ.length()) champ = students[i];
        }
        print(champ + " is the shortest.");
            
            
       }

    public void initializeStudents(String[] students)
    {
        students[0] = "Aidan Bhatnagar";
        students[1] = "Aarav Chandrasekar";
        students[2] = "Ben Co";
        students[3] = "Steve Daheb";
        students[4] = "Beau Dunlevie";
        students[5] = "Paul Fong";
        students[6] = "Ayaan Govil";
        students[7] = "Armin Hamrah";   
        students[8] = "Lucy Knox";
        students[9] = "Aroosh Kumar";
        students[10] = "Millie Muir";
        students[11] = "Julia Soderbery";
        students[12] = "Sean Tinsley";
        students[13] = "Alyssa Turenne";
        students[14] = "Bear Weigle";
        students[15] = "Ella Woodhead";
        students[16] = "Jerry Xu";
        students[17] = "Amelie Boom";
        students[18] = "Ellie Brew";
        students[19] = "Nicholas Chin";
        students[20] = "Alberto Clegg Gonzalez";
        students[21] = "Neha Lalia";
        students[22] = "Leila Nawas";
        students[23] = "Nic Nikcevic";
        students[24] = "Theo Parker";
        students[25] = "Ava Shenk";
        students[26] = "Ian Smith";
        students[27] = "Bella Summe";
        students[28] = "Colleen Tanona";
        students[29] = "Louka Triant";
        students[30] = "Catherine Zhu";
    }
}
