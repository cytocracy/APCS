
import acm.program.*;

public class Ponies extends ConsoleProgram
{

    public void run()
    {
        println("Welcome to the pony program!");
        String yourName;
        yourName = readLine("What is your name? ");
        println("Nice to meet you, " + yourName + ". I hope you're having a nice day.");
        int numPonies;
        numPonies = readInt("How many ponies? ");
        println("You have " + numPonies + " ponies.");
        int numLegs;
        numLegs = numPonies * 4;
        println("There are " + numLegs + " legs!!!!");
        if (numLegs > 100)
        {
            println("Wow!  That's a lot of pony legs!");
        }
    }


}
