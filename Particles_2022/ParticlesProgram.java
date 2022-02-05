import java.awt.*;
import java.util.*;
import acm.program.*;

public class ParticlesProgram extends Program
{
    //add constants for particle types here
    public static final int EMPTY = 0;
    public static final int METAL = 1;
    public static final int WATER = 2;
    public static final int SAND = 3;
    public static final int WOOD = 4;
    public static final int FIRE = 5;
    public static final int ICE = 6;
    public static final int BLACKHOLE = 7;
    public static final int EXPLOSION = 8;

    public static final int HEATEDWOOD = 1000;
    public static final int FIRE2 = 1001;
    public static final int MELTEDMETAL = 10002;
    public static final int OBSIDIAN = 1003;
    //do not add any more private instance variables
    private Particle[][] grid;
    private ParticlesDisplay display;

    public void init()
    {
        initVariables(120, 80);
    }    

    public void initVariables(int numRows, int numCols)
    {
        String[] names;
        names = new String[9];
        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[WATER] = "Water";
        names[SAND] = "Sand";
        names[WOOD] = "Wood";
        names[FIRE] = "Fire";
        names[ICE] = "Ice";
        names[BLACKHOLE] = "Black hole";
        names[EXPLOSION] = "Boom!";

        display = new ParticlesDisplay("Particles Game", 
            numRows, numCols, names);
        // initialize the grid here (task 0.1)
        grid = new Particle[numRows][numCols];
        for (int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                grid[r][c] = new Empty();
            }
        }

    }
    //called when the user clicks on a location using the given particleType
    private void locationClicked(int row, int col, int particleType)
    {
        // finish this cascading if (task 0.2)
        if (particleType == EMPTY)
            grid[row][col] = new Empty();
        else if (particleType == METAL)
            grid[row][col] = new Metal();
        else if (particleType == WATER)
            grid[row][col] = new Water();
        else if (particleType == SAND)
            grid[row][col] = new Sand();
        else if (particleType == WOOD)
            grid[row][col] = new Wood();
        else if (particleType == FIRE){

            grid[row][col] = new Fire(0);
            if(row+1 != grid.length)grid[row+1][col] = new Fire(0);
            if(row != 0)grid[row-1][col] = new Fire(0);
            if(col+1 != grid[0].length)grid[row][col+1] = new Fire(0);
            if(col !=0) grid[row][col-1] = new Fire(0);

        } else if(particleType == ICE)
            grid[row][col] = new Ice();
        else if (particleType == BLACKHOLE){
            grid[row][col] = new Blackhole();

        } else if (particleType == EXPLOSION) grid[row][col] = new Explosion(0);

    }
    //called repeatedly.
    //causes one random particle to maybe do something.
    public void step()
    {
        int row = (int)(Math.random() * grid.length);
        int col = (int)(Math.random() * grid[0].length);
        Particle particle = grid[row][col];
        switch (particle.getType()){
            case EMPTY: 
            case OBSIDIAN: 
            case BLACKHOLE: 
            break;

            case METAL: metalBehavior(row, col); break;
            case WATER: waterBehavior(row, col); break;
            case SAND: sandBehavior(row, col); break;

            case FIRE: 
            case FIRE2: 
            fireBehavior(row, col); break;

            case ICE: iceBehavior(row, col); break;
            case WOOD: woodBehavior(row, col); break;
            case HEATEDWOOD: heatedWoodBehavior(row, col); break;
            case MELTEDMETAL: meltedMetalBehavior(row, col); break;
            case EXPLOSION: explosionBehavior(row, col); break;

        }
    }

    public void explosionBehavior(int row, int col){
        Explosion e = (Explosion) grid[row][col];
        e.incrementAge();

        if(e.getAge() > 10 || e.getGen() > 20){
            grid[row][col] = new Empty();
        }

        if(Math.random() > 0.5){
            int num = (int)(Math.random() * 4);
            if(num == 0){
                //top
                if(row !=0){
                    grid[row-1][col] = new Explosion(e.getGen()+1);
                }
            } else if (num == 1){
                //left
                if(col !=0){
                    grid[row][col-1] = new Explosion(e.getGen()+1);
                }
            } else if (num == 2){
                //down
                if(row != grid.length-1){
                    grid[row+1][col] = new Explosion(e.getGen()+1);
                }

            } else {
                //right
                if(col != grid[0].length-1){
                    grid[row][col+1] = new Explosion(e.getGen()+1);
                }
            }
        }

    }

    
    public void meltedMetalBehavior(int row, int col){
        MeltedMetal m = (MeltedMetal) grid[row][col];
        m.incrementAge();

        if(m.getAge() > 500){
            grid[row][col] = new Metal();
            return;
        }

        if(row != 0 && grid[row-1][col].getType() == WATER) grid[row][col] = new Obsidian();
        else if(row != grid.length-1 && grid[row+1][col].getType() == WATER) grid[row][col] = new Obsidian();
        else if(col != 0 && grid[row][col-1].getType() == WATER) grid[row][col] = new Obsidian();
        else if(col != grid[0].length-1 && grid[row][col+1].getType() == WATER)grid[row][col] = new Obsidian();

        if(Math.random() < 0.7){
            tryToMoveDown(row, col, true);
        } else

        if(row != grid.length-1 && (grid[row+1][col].getType() == MELTEDMETAL || grid[row+1][col].getType() == METAL)){
            if(Math.random() < 0.5){
                if(col != 0 && grid[row][col-1].getType() == EMPTY){

                    grid[row][col-1] = new MeltedMetal(m.getAge());
                    grid[row][col] = new Empty();
                } 
            } else {
                if (col != grid[0].length-1 && grid[row][col+1].getType() == EMPTY){

                    grid[row][col+1] = new MeltedMetal(m.getAge());
                    grid[row][col] = new Empty();
                }

            }

        }

    }

    public void metalBehavior(int row, int col){
        Metal m = (Metal) grid[row][col];
        m.incrementAge();

        if(row != 0 && (grid[row-1][col].getType() == FIRE || grid[row-1][col].getType()== FIRE2)) heatMetal(row, col);
        else if(row != grid.length-1 && (grid[row+1][col].getType() == FIRE || grid[row+1][col].getType()== FIRE2)) heatMetal(row, col);
        else if(col != 0 && (grid[row][col-1].getType() == FIRE || grid[row][col-1].getType()== FIRE2)) heatMetal(row, col);
        else if(col != grid[0].length-1 && (grid[row][col+1].getType() == FIRE || grid[row][col+1].getType()== FIRE2)) heatMetal(row, col);
        else coolMetal(row, col);

    }

    public void coolMetal(int row, int col){
        Metal m = (Metal) grid[row][col];
        m.incrementTime();
        if(m.getTime() > 100 && !(grid[row][col].getColor().equals(Color.gray))){

            Color startColor = grid[row][col].getColor();
            int green = startColor.getGreen()+5;
            int red = startColor.getRed();
            int blue = startColor.getBlue()+5;

            Color endColor = new Color(red, green, blue);
            if(!(endColor.equals(Color.gray)))m.changeColor(endColor);

        }
    }

    public void heatMetal(int row, int col){

        Color startColor = grid[row][col].getColor();
        int green = startColor.getGreen()-10;
        int red = startColor.getRed();
        int blue = startColor.getBlue()-10;

        Color endColor = new Color(red, green, blue);
        Metal m = (Metal) grid[row][col];
        m.resetTime();
        m.changeColor(endColor);

        if(m.getColor().getGreen() <10){
            grid[row][col] = new MeltedMetal(0);
        }

    }

    public ArrayList<ArrayList<Integer>> getBlackholes(){
        ArrayList<ArrayList<Integer>> locations = new ArrayList<ArrayList<Integer>>();

        for(int r=0; r< grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c].getType() == BLACKHOLE){
                    ArrayList<Integer> coords = new ArrayList<Integer>();
                    coords.add(r);
                    coords.add(c);
                    locations.add(coords);
                }
            }
        }

        return locations;

    }

    public int determineBHMovement(int row, int col, ArrayList<ArrayList<Integer>> blackholes){
        //0 north
        //1 east
        //2 south
        //3 west
        //4 touching, should disappear

        //find closest black hole
        double distance = 999999;
        int champ = 0;

        for(int i=0; i < blackholes.size(); i++){
            int rowOffset = Math.abs(row-blackholes.get(i).get(0));
            int colOffset = Math.abs(col-blackholes.get(i).get(1));

            double totalOffset = Math.sqrt(Math.pow(rowOffset, 2) + Math.pow(colOffset, 2));
            if(totalOffset < distance) {
                champ = i;
                distance = totalOffset;
            }
        }

        //find direction
        int bhRow = blackholes.get(champ).get(0);
        int bhCol = blackholes.get(champ).get(1);
        boolean north = false;
        boolean east = false;
        boolean south = false;
        boolean west = false;

        int champRowOffset = Math.abs(row - bhRow);
        int champColOffset = Math.abs(col - bhCol);

        if(champRowOffset <=1 && champColOffset <=1){
            return 4;
        }

        if(row-bhRow > 0) north = true;
        else if (row-bhRow < 0) south = true;

        if(col-bhCol > 0) west = true;
        else if(col - bhCol < 0)east = true;

        if(Math.random() <0.5){
            if(north) return 0;
            else if (south) return 2;
            else{
                if (Math.random() < 0.5) return 0;
                else return 2;
            }
        } else {
            if(east) return 1;
            else if (west) return 3;
            else {
                if(Math.random() < 0.5) return 1;
                else return 3;
            }
        }

    }

    public void heatedWoodBehavior(int row, int col){
        HeatedWood h = (HeatedWood) grid[row][col];
        h.incrementAge();

        if(row != 0 && (grid[row-1][col].getType() == FIRE || grid[row-1][col].getType()== FIRE2)) grid[row][col] = new Fire();
        if(row != grid[0].length && (grid[row+1][col].getType() == FIRE || grid[row+1][col].getType()== FIRE2)) grid[row][col] = new Fire();
        if(col != 0 && (grid[row][col-1].getType() == FIRE || grid[row][col-1].getType()== FIRE2)) grid[row][col] = new Fire();
        if(col != grid.length && (grid[row][col+1].getType() == FIRE || grid[row][col+1].getType()== FIRE2)) grid[row][col] = new Fire();

        if(h.getAge() > 250){
            grid[row][col] = new Wood();
        }
    }

    public boolean testBlackholes(int row, int col){
        ArrayList<ArrayList<Integer>> bh = getBlackholes();
        if(bh.size() != 0){
            int movement = determineBHMovement(row, col, bh);
            switch(movement){
                case 0:
                tryToMoveUp(row, col); break;
                case 1:
                tryToMoveRight(row, col); break;
                case 2:
                tryToMoveDown(row, col, true); break;
                case 3:
                tryToMoveLeft(row, col); break;
                case 4:
                grid[row][col] = new Empty();
            }
            return true;
        }
        return false;
    }

    public void woodBehavior(int row, int col){
        if(testBlackholes(row, col)) return;

        if(row != 0 && (grid[row-1][col].getType() == FIRE || grid[row-1][col].getType()== FIRE2)) grid[row][col] = new HeatedWood();
        if(row != grid[0].length && (grid[row+1][col].getType() == FIRE || grid[row+1][col].getType()== FIRE2)) grid[row][col] = new HeatedWood();
        if(col != 0 && (grid[row][col-1].getType() == FIRE || grid[row][col-1].getType()== FIRE2)) grid[row][col] = new HeatedWood();
        if(col != grid.length && (grid[row][col+1].getType() == FIRE || grid[row][col+1].getType()== FIRE2)) grid[row][col] = new HeatedWood();

    }

    public void iceBehavior(int row, int col){

        Ice p = (Ice) grid[row][col];
        p.incrementAge();
        if(p.hasMelted()){
            grid[row][col] = new Water();
        }

    }

    public void fireBehavior(int row, int col){
        Particle p = grid[row][col];
        Particle newp = new Fire(0);
        int age = 0;
        if (p.getType() == FIRE){
            Fire f = (Fire) grid[row][col];
            f.incrementAge();
            age = f.getAge();
            newp = f;

            if (f.getAge() >10){
                newp = new Fire2(age);
            }

        } else {
            Fire2 f = (Fire2) grid[row][col];
            f.incrementAge();
            age = f.getAge();
            newp = f;
        }

        if((Math.random() <.10 && p.getType() == FIRE) || (Math.random() < .25 && p.getType() == FIRE2))grid[row][col] = new Empty();
        else if(Math.random()>.25){
            tryToMoveUp(row, col);
        } else {
            if(Math.random() <.5){
                if(col != 0 && grid[row][col-1].getType() == EMPTY){
                    grid[row][col-1] = newp;
                    grid[row][col] = new Empty();
                }
            }else {
                if(col != grid[0].length-1 && grid[row][col+1].getType() == EMPTY){
                    grid[row][col+1] = newp;
                    grid[row][col] = new Empty();
                }
            }

        }

    }

    public void sandBehavior(int row, int col){
        if(testBlackholes(row, col)) return;
        tryToMoveDown(row, col, true);

    }

    public void waterBehavior(int row, int col){
        if(testBlackholes(row, col)) return;
        int num = (int)(Math.random() * 3); 
        if(num == 0){
            tryToMoveDown(row, col, false);
        } else if (num == 1){
            if(col != 0 && grid[row][col-1].getType() == EMPTY){
                grid[row][col-1] = new Water();
                grid[row][col] = new Empty();
            }
        }else if (num == 2){
            if(col != grid[0].length-1 && grid[row][col+1].getType() == EMPTY){
                grid[row][col+1] = new Water();
                grid[row][col] = new Empty();
            }
        }

    }

    public void tryToMoveDown(int row, int col, boolean canFallThroughWater){
        Particle particle = grid[row][col];
        if(row != grid.length-1 && (grid[row+1][col].getType() == EMPTY || (canFallThroughWater && grid[row+1][col].getType() == WATER))){
            Particle below = grid[row+1][col];
            grid[row+1][col] = particle;
            grid[row][col] = below;
        }
    }

    public void tryToMoveUp(int row, int col){
        Particle particle = grid[row][col];
        if(row != 0 && (grid[row-1][col].getType() == EMPTY)){
            Particle above = grid[row-1][col];
            grid[row-1][col] = particle;
            grid[row][col] = above;
        }
    }

    public void tryToMoveRight(int row, int col){
        Particle particle = grid[row][col];
        if(col != grid[0].length-1 && grid[row][col+1].getType() == EMPTY){
            grid[row][col+1] = grid[row][col];
            grid[row][col] = new Empty();
        }

    }

    public void tryToMoveLeft(int row, int col){
        Particle particle = grid[row][col];
        if (col !=0 && grid[row][col-1].getType() == EMPTY){
            grid[row][col-1] = grid[row][col];
            grid[row][col] = new Empty();
        }
    }
    //copies each element of grid into the display (don't modify this)
    public void updateDisplay()
    {
        for (int r=0; r<grid.length; r++)
            for (int c=0; c<grid[0].length; c++)
                display.setColor(r, c, grid[r][c].getColor());
    }

    // repeatedly calls step and updates the display
    // (don't modify this)
    public void run()
    {
        while (true)
        {
            for (int i = 0; i < display.getSpeed(); i++)
                step();
            updateDisplay();
            display.repaint();
            display.pause(1);  //wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null)  //test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }
}
