
import acm.program.*;

public class NameFixer extends ConsoleProgram
{

    public void run()
    {
        while(true){

            String name = readLine("Enter your name: ");
            int space = name.indexOf(" ");
            String first = name.substring(0, space);
            String last = name.substring(space + 1);
            println(last + ", " + first); // + means "concatenate"

        }
    }

}
