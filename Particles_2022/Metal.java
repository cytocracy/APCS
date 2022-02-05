import java.awt.Color;

public class Metal extends Particle
{
    private int age;
    private int timeSinceHeated;
    public Metal(int initAge)
    {
        super(ParticlesProgram.METAL, Color.gray);
        age = initAge;
        timeSinceHeated=0;
    }
    
    public Metal(){
        super(ParticlesProgram.METAL, Color.gray);
        age = 0;
        timeSinceHeated=0;
    }
    
    public void incrementAge(){
        age++;
    }
    public int getAge(){
        return age;
    }
    
    public void incrementTime(){
        timeSinceHeated++;
    }
    public void resetTime(){
        timeSinceHeated =0;
    }
    public int getTime(){
        return timeSinceHeated;
    }
    
    public void changeColor(Color c){
        setColor(c);
    }

}
