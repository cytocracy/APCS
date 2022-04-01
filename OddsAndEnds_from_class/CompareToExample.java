
import acm.program.*;

public class CompareToExample extends ConsoleProgram
{

    public void run()
    {
        while (true)
        {
            String first = readLine("Enter the first word: ");
            String second = readLine("Enter the second word: ");
            if (first.compareTo(second) < 0)
                println(first + " is \"less than\" " + second);
            else if (first.compareTo(second) > 0)
                println(second + " is \"less than\" " + first);
            else // if (first.compareTo(second) == 0)
                println("\"" + first + "\"" + ".equals(\"" + second + "\")");
            println();
        }
    }

}
