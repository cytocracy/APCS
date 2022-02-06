
import acm.program.*;

public class Ponies extends ConsoleProgram
{

    public void run()
    {
        String name = readLine("What is your name?");
        println("Nice to meet you, " + name + ". Have a great day!");
        println("Welcome to the pony leg calculator!");
        int numPonies = readInt("How many ponies do you have? ");
        println("You have " + numPonies + " ponies!");
        int numLegs = numPonies * 4;
        println("That means you have " + numLegs + " pony legs!");
        if(numLegs >100){
            println("Wow, thats a lot of legs");
        }
    }


}
