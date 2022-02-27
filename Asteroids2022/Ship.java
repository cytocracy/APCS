import java.awt.Color;

public class Ship extends GVectorPolygon
{
    private static final int MAXSHIPSPEED = 5;
    
    public Ship(int windowWidth, int windowHeight)
    {
        super(windowWidth, windowHeight);
        initVertices();
        
        recenter();
        setColor(Color.white);
        rotate(90);
    }
    
    public void initVertices(){
        double[][] points = {
            {0, 0},
            {-20, 8},
            {-15, 0},
            {-20, -8}
        };
        
        for(double[] point : points){
            addVertex(point[0], point[1]);
        }
    }
    
    public void boost(double fMagnitude){
        applyForce(fMagnitude, getTheta());
    }
    
    public void brake(double fMagnitude){
        applyForce(fMagnitude, getMovementAngle());
    }
    
    public void applyForce(double fMagnitude, double angle){
        double vxf = fMagnitude * Math.cos(Math.toRadians(angle));
        double vyf = fMagnitude * Math.sin(Math.toRadians(angle));
        
        double vxn = getVelocityX() + vxf;
        double vyn = getVelocityY() + vyf;
        
        double nMag = Math.sqrt(vxn*vxn + vyn*vyn);
        double nTheta;
        if(vxn == 0) nTheta = vyn>0 ? 90 : -90;
        else nTheta = Math.toDegrees(Math.atan(vyn/vxn));

        if(nMag>MAXSHIPSPEED){
            if(vxn<0){
                if(vyn <0) nTheta-=180;
                else nTheta+= 180;
            }
            vxn = MAXSHIPSPEED * Math.cos(Math.toRadians(nTheta));
            vyn = MAXSHIPSPEED * Math.sin(Math.toRadians(nTheta));
        }
        
        setVX(vxn);
        setVY(vyn);
    }

    
    public double getMovementAngle(){
        double velVx = getVelocityX();
        double velVy = getVelocityY();
        
        if(velVx == 0) return velVy > 0 ? 90 : -90;
        
        double moveTheta = Math.toDegrees(Math.atan(velVy/velVx));
        if(velVx < 0){
            if(velVy < 0) moveTheta -=180;
            else moveTheta += 180;
        }
        return moveTheta;
    }
    
    public Bullet makeBullet(){
        Bullet b = new Bullet((int) getWindowWidth(), (int) getWindowHeight());
        b.rotate(getTheta());
        b.setLocation(getX(), getY());
        b.movePolar(5, getTheta());
        b.increaseVelocity(7);
        return b;
    }
    
}
