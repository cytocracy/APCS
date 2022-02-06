

public class MultipleChoiceQuestion implements Question
{
    public static final String LETTERS = "ABCD";
    
    private int x;
    private int y;
    private int answer;
    private int[] choices;
    
    public MultipleChoiceQuestion()
    {
        x = (int)(Math.random() * 10);
        y = (int)(Math.random() * 10);
        answer = x+y;
        choices = new int[]{x+y, getRand(), getRand(), getRand()};
        
        //randomizes pos of answer
        int index = (int)(Math.random() * 4);
        int temp = choices[0];
        choices[0] = choices[index];
        choices[index] = temp;
    }
    
    public int getRand(){
        int num = (int)(Math.random() * 20);
        while(num==answer){
            num = (int)(Math.random() * 20);
        }
        return num;
    }
    public String getQuestion(){
        return "What is " + x + " plus " + y + "?" + "  Choices: a)" + choices[0] + " b)" + choices[1] + " c)" + choices[2] + " d)" + choices[3];
    }
    public String getAnswer(){
        return answer + "";
    }
    public boolean isCorrect(String response){
        int x;
        if((x = LETTERS.indexOf(response.toUpperCase())) != -1)
            return choices[x]==answer;
        return false;
    }


}
