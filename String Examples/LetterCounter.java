
import acm.program.*;

public class LetterCounter extends ConsoleProgram
{

    public void run()
    {
        String response = "yes";
        while(response.substring(0,1).equals("y")){
            String str = readLine("Enter a word or phrase: ");
            String letter = readLine("What letter do you want to search for? ");
            int count = countLetters(str, letter);
            println("There are " + count + " " + letter + "'s in your string.");
            
            response = readLine("Do you want to do it again?");
            response = response.toLowerCase();
        }
        println("Have a nice day.");
    }

    public int countLetters(String str, String letter){
        int chops = 0;
        while(str.indexOf(letter) > -1){
            int index = str.indexOf(letter);
            str = str.substring(index + 1);
            chops++;
        }
        return chops;
    }

}
