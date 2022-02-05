import java.awt.Color;

public class MeltedMetal extends Particle
{
    private int age;
    public MeltedMetal(int initAge)
    {
        super(ParticlesProgram.MELTEDMETAL, Color.red);
        age=initAge;
    }
    public void incrementAge(){
        age++;
    }
    public int getAge(){
        return age;
    }

}
