import java.awt.Color;

public class Fire extends Particle
{
    private int age;
    
    public Fire(int initAge)
    {
        super(ParticlesProgram.FIRE, Color.red);
        age=initAge;
    }
    
    public Fire(){
        super(ParticlesProgram.FIRE, Color.red);
        age =0;
    }
    
    public void incrementAge(){
        age++;
    }
    public int getAge(){
        return age;
    }
    
    
    
    


}
