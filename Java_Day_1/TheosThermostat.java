//Theo Parker

import acm.program.*;

public class TheosThermostat extends ConsoleProgram
{

    public void run()
    {
        println("Oh no, its too hot...");
        Thermostat ac = new Thermostat(60, 95);
        while (ac.getValue() < 93){
            ac.warmer();
        }
        println("The temperature is " + ac.getValue() + "*F! Lets cool it down a bit.");
        while (ac.getValue() > 72){
            ac.colder();
            println("The current temperature is " + ac.getValue() + "*F.");
            
        }
        println("Ahhh, " + ac.getValue() + "*F sure feels a lot better.");
    }


}
