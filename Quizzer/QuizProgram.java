import java.util.*;
import acm.program.*;

public class QuizProgram extends ConsoleProgram
{

    public void run()
    {
        println("Welcome to my quiz!");
        ArrayList<Question> questions = new ArrayList<Question>();
        int score = 0;
        
        for(int i=0; i<10; i++){
            double num = Math.random();
            if(num <1.0/4) questions.add(new ArithmeticQuestion());
            else if (num <2.0/4) questions.add(new StateCapitalQuestion());
            else if (num < 3.0/4) questions.add(new MultipleChoiceQuestion());
            else questions.add(new RhetoricalQuestion());
        }
        for(int i=0; i<questions.size(); i++){
            println(questions.get(i).getQuestion());
            println();
            String response = readLine("Your response: ");
            if(questions.get(i).isCorrect(response)){
                println("Correct");
                score++;
            } else{
                println("Incorrect!");
                println("The correct answer was " + questions.get(i).getAnswer());
            }
            println();
        }
        println("Your score was " + score + "/" + questions.size());
    }


}
