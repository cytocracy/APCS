

public abstract class Employee extends Person
{
    private double salary;
    public Employee(String givenName, double startingSalary)
    {
        super(givenName);
        salary = startingSalary;
    }
    
    public double getSalary(){return salary;}
}
