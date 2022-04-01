
import acm.program.*;

public class WhatDoesItDoPartI extends ConsoleProgram
{
 
    public void run()
    {
        setFont("*-36-*"); // makes the font bigger
        
        int a = 7;
        Student x = new Student("Aidan");
        int b = a; //b=7
        Student y = x; //Aidan
         
        println(a + " " + b); //7 7 
        println(x.getName() + " " + y.getName()); //Aidan Aidan
        
        a = 6;
        b = 5;
        y.setName("Armin");
        x.setName("Aarav");
        
        println(a + " " + b); //6 5
        println(x.getName() + " " + y.getName()); //aarav aarav
    }
    
    


}
