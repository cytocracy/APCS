import java.util.ArrayList;

public class ZoomStudent
{
    private String name;
    private String location;
    private ArrayList<String> moviesWatched;
    
    public ZoomStudent(String name, String location)
    {
        this.name = name;
        this.location = location;
        moviesWatched = new ArrayList<String>();
    }
    
    /**
     * @return a string representing your location
     */
    public String getLocation(){return location;}
    public String getName(){return name;}
    public int getNumMoviesWatched(){return moviesWatched.size();}
    
    
    /**
     * This method changes where you are during Zoom times.
     * I hope you're not in a hot tub.
     * @param otherLocation the place you are now
     */
    public void setLocation(String otherLocation){location = otherLocation;}
    
    public void watchMovie(String title){moviesWatched.add(title);}
    


}
