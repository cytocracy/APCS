

public class MagicEightBall implements Advisor
{

    public String giveAdvice(Student student){
        return "Hey " + student.getName() + ", you should ask again.";
    }
}
