
public class CollegeCounselor extends Employee implements Advisor
{
    public CollegeCounselor(String givenName)
    {
        super(givenName, 40000);
    }

    public void doWork(double hours){
        System.out.println(getName() + " wrote " + (4*hours/3) + " letters of recommendation.");
    }
        
    public String giveAdvice(Student student){
        return "Hello " + student.getName() + ", you should do well on your SATs.";
    }
}
