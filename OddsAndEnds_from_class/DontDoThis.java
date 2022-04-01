
import acm.program.*;

public class DontDoThis extends ConsoleProgram
{

    public void run()
    {
        mystery(7);
    }
    
    public void mystery(int n)
    {            
        println(n);
        mystery(n);         
    }

}
