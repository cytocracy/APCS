import java.awt.Color;

public class Explosion extends Particle
{
    private int age;
    private int gen;
    
    public Explosion(int generation)
    {
        super(ParticlesProgram.EXPLOSION, Color.red);
        age=0;
        gen = generation;
    }
    
    public void incrementAge(){
        age++;
    }
    public int getAge(){
        return age;
    }
    
    public int getGen(){
        return gen;
    }

}
