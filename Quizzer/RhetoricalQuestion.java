

public class RhetoricalQuestion implements Question
{
    
    private String question;
    
    public RhetoricalQuestion()
    {
        String[] questions = {"What's wrong with you?", "Are you kidding me?", "Are you serious?", "Is the Pope Catholic?"};
        question = questions[(int) (Math.random() * questions.length)];
    }
    
    public String getQuestion(){
        return question;
    }
    public String getAnswer(){
        return "";
    }
    public boolean isCorrect(String response){
        return false;
    }

}
