import java.awt.Color;

public class HeatedWood extends Particle
{
    private int age;
    public HeatedWood(int initAge)
    {
        super(ParticlesProgram.HEATEDWOOD, new Color(165, 42, 42));
        age = initAge;
    }
    
    public HeatedWood(){
        super(ParticlesProgram.HEATEDWOOD, new Color(165, 42, 42));
        age = 0;
    }
    
    public void incrementAge(){
        age++;
    }
    
    public int getAge(){
        return age;
    }


}
