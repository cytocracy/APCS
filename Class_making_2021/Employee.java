

public class Employee
{
    private double salary;
    private String name;
    
    public Employee(String givenName, double startSalary)
    {
        name = givenName;
        salary = startSalary;
    }
    
    public void raiseSalary(double raise){
        salary += raise;
    }
    
    public String getName(){
        return name;
    }
    
    public double getSalary(){
        return salary;
    }
    

}
