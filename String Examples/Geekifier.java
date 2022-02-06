
import acm.program.*;

public class Geekifier extends ConsoleProgram
{

    public void run()
    {
        String str = readLine("Enter a word, name or phrase: ");
        String geekedStr = geekify(str);
        println(geekedStr);
    }

    public String geekify(String str){
        str = replace(str, "a", "@");
        str = replace(str, "s", "$");
        str = replace(str, "l", "1");
        str = replace(str, "e", "3");
        str = replace(str, "o", "0");
        str = replace(str, "t", "+");
        
        return str;
    }

    public String replace(String str, String letter, String symbol){

        
        while(str.indexOf(letter) > -1){
            int index = str.indexOf(letter);
            String before = str.substring(0, index);
            String after = str.substring(index+1);
            str = before + symbol + after;

        }
        return str;

        
    }

}
