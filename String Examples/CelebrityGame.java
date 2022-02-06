
import acm.program.*;

public class CelebrityGame extends ConsoleProgram
{

    public void run()
    {
        println("Welcome to the Celebrity Game!"); println();

        String p1 = readLine("Player 1, enter your name: ");
        String p2 = readLine("Player 2, enter your name: ");
        
        
        boolean turn1 = false;
        playGame(p1, p2, turn1);

        
    }

    public void playGame(String p1, String p2, boolean turn1){
        println(p2 + " should close his/her eyes...");
        String celeb = readLine(p1 + " should enter the name of a celebrity: ");
        String firstName = celeb.substring(0, celeb.indexOf(" "));
        String lastName = celeb.substring(celeb.indexOf(" ") + 1);

        clearConsole();
        println("OK, " + p2 + ". It is time to guess the celebrity.");
        println("Here's your clue: " + firstName.substring(firstName.length()-2) + " " + lastName.substring(0,3));

        doGuesses(celeb);
        if(readLine("Would you like to play again? ").toLowerCase().substring(0,1).equals("y")){
            clearConsole();
            if(turn1 == true){
                playGame(p1, p2, turn1);
            } else {
                playGame(p2, p1, turn1);
            }
            
        } else {
            println("have a nice day.");
        }
    }

    public boolean checkGuess(String celeb){
        String guess = readLine("What is your guess? ");
        if(guess.toLowerCase().equals(celeb)) return true;
        return false;
    }

    public void doGuesses(String celeb){
        int i = 3;
        while (i>0){
            if(checkGuess(celeb) == true){
                println("Correct!");
                return;
            } else{
                i--;
                if(i == 0){
                    println("Incorrect! The correct answer was " + celeb);
                    return;
                }

                println("Incorrect! You have " + i + " lives left.");
            }
        }
    }

}
