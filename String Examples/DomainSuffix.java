
import acm.program.*;

public class DomainSuffix extends ConsoleProgram
{

    public void run()
    {
        while(true){String url = readLine("Enter a url: ");
        int index = url.indexOf(".");
        String rest = url.substring(index +1);
        index = rest.indexOf(".");
        println(rest.substring(index +1, index +4));}
        
    }


}
