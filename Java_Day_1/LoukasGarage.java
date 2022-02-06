
import acm.program.*;

public class LoukasGarage extends ConsoleProgram
{

    public void run()
    {
        println("Louka likes cars");
        Car prius = new Car(42,9);
        prius.fillup(4.5);
        println("The prius is " + prius.getGasGauge() + "% full of gas.");
        prius.drive(11.2);
        println("Now, the prius is " + prius.getGasGauge() + "% full of gas.");
        
        println("Hey, look, Louka now has a hummer!");
        Car hummer = new Car(8, 30);
        hummer.fillup(17);
        hummer.drive(26.5);
        println("The hummer has gone " + hummer.getOdometer() + " miles.");
    }


}
