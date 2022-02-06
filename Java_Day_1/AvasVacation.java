
import acm.program.*;

public class AvasVacation extends ConsoleProgram
{

    public void run()
    {
        println("Ava's on a fantastic vacation.");
        HotelTelevision tv = new HotelTelevision(5);
        tv.channelUp();
        println("Ava's TV is now on channel " + tv.getChannel());
        println("Ava is excited because that channel is " + tv.getChannelName());
    }


}
