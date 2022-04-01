
import acm.program.*;
import java.util.*;
import java.io.*;

public class ReadingFromFiles extends ConsoleProgram
{

    public void run()
    { 
        try
         {
            File file = new File("asteroids_handout_2022.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                if (words.length>0)
                {
                    String wordToShow = getFirstWordAlphabetically(words);
                    println(wordToShow);
                }
            }
        }
        catch (Exception ex)
        {
            println("Oh no!  Something went wrong!");
            println("Let me tell you about it...");
            println(ex.toString());
        }
    }
    
    private String getFirstWordAlphabetically(String[] words)
    {
        String champ = words[0];
        for (int i=1; i<words.length; i++)
        {
            if (words[i].compareTo(champ)<0)
               champ = words[i];
        }
        return champ;
    }

}
