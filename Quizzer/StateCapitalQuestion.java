

public class StateCapitalQuestion implements Question
{
    private String state;
    private String capital;
       
    
    public StateCapitalQuestion()
    {
        String[] states = {"California", "Oregon", "Washington"};
        String[] capitals = {"Sacramento", "Salem", "Olympia"};
        int index = (int) (Math.random() * states.length);
        
        state = states[index];
        capital = capitals[index];
    }
    
    public String getQuestion(){
        return "What is the capital of " + state + "?";
    }
    
    public String getAnswer(){
        return capital;
    }
    
    public boolean isCorrect(String response){
        return capital.equalsIgnoreCase(response);
    }

}
