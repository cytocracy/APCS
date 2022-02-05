
public class SmurfVillage
{
    public static void main(String[] args)
    {
        Picture village = new Picture("images/" + "village.jpg");
        Picture smurf = new Picture("images/" + "smurfA.png");
        Picture smurf2 = new Picture("images/" + "smurfA.png");
        smurf2.mirror();
        
        //village.insert(smurf, 100, 150);
        
        Picture smurfette = new Picture("images/" + "smurfette.png");
        Picture smurfette2 = new Picture("images/" + "smurfette.png");
        smurfette2.flip();
        
        //smurfette.mirror(); 
        //village.insert(smurfette, 300, 300);
        int rows = 3;
        int cols = 5;
        
        for(int smurfRow = 0; smurfRow <rows; smurfRow++){
            for(int smurfCol = 0; smurfCol <cols; smurfCol++){
                if (smurfRow == 0  || smurfCol == 0 || smurfRow == rows-1 || smurfCol == cols-1)
                    village.insert(smurfette, smurfRow*smurf.getHeight(), smurfCol*smurf.getWidth());
                else
                    village.insert(smurfette2, smurfRow*smurf.getHeight(), smurfCol*smurf.getWidth());
                
            }
        }
       
        village.show();
        //smurf.show();
        
    }
}