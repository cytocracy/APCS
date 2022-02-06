

public class ClassModerator extends Teacher implements Advisor
{

    public ClassModerator(String givenName)
    {
        super(givenName);
    }
    
    public String giveAdvice(Student student){
        return "Yo " + student.getName() + ", you should work together and clean up.";
    }


}
