import java.awt.Color;

public class Fire2 extends Particle
{
    private int age;
    
    public Fire2(int initAge)
    {
        super(ParticlesProgram.FIRE2, Color.orange);
        age=initAge;
    }
    public void incrementAge(){
        age++;
    }
    public int getAge(){
        return age;
    }
    
    
}
    

