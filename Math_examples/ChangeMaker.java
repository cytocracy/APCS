
import acm.program.*;

public class ChangeMaker extends ConsoleProgram
{

    public void run()
    {
        double cost = readDouble("Enter the cot of the item: ");
        double paid = readDouble("Enter the amount paid: ");
        int change = (int)(100 * (paid - cost) + 0.5);
        int dollars =  change / 100;
        change = change % 100;
        int quarters = change/25;
        change = change % 25;
        int dimes = change /10;
        change = change % 10;
        int nickels = change / 5;
        int pennies = change % 5;
        
        
        println("Your change is " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, " + nickels  + " nickels, and " + pennies + " pennies.");
    }


}
