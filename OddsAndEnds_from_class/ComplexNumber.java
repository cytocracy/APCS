

public class ComplexNumber
{
    private double realPart;
    private double imagPart;
    
    public ComplexNumber(double realPart, double imagPart)
    {
        this.realPart = realPart;
        this.imagPart = imagPart;
    }
    
    public ComplexNumber(double realPart)
    {
        this.realPart = realPart;
        this.imagPart = 0;
    }

    
    public ComplexNumber()
    {
        this.realPart = 0;
        this.imagPart = 0;
    }
    
    public String toString()
    {
        return "Here's your complex number: " + this.realPart + " + " + this.imagPart + "i";
    }
    
    public ComplexNumber add(ComplexNumber other)
    {
        double realResult = this.realPart + other.realPart;
        double imagResult = this.imagPart + other.imagPart;
        return new ComplexNumber(realResult, imagResult);
    }
    
    public ComplexNumber add(double num)
    {
        ComplexNumber other = new ComplexNumber(num);
        return this.add(other);
    }

    
    public ComplexNumber multiply(ComplexNumber other)
    {
         double realResult = this.realPart * other.realPart - this.imagPart * other.imagPart;
         double imagResult = this.realPart * other.imagPart + this.imagPart * other.realPart;
         return new ComplexNumber(realResult, imagResult);       
    }
    
    public ComplexNumber squared()
    {
        return this.multiply(this);
    }

}
