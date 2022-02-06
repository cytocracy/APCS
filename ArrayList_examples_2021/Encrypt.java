import acm.program.*;
import java.math.*;

public class Encrypt extends ConsoleProgram {
    private String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz .,?!;:()'";
    private String numbers = "0123456789";
    
    public void run()
    {
        Cryptography c = new Cryptography();
        CaesarCipher cr = new CaesarCipher();
        while(true){
            String input = readLine("Input: ");
            int initBase = readInt("initBase: ");
            int endBase = readInt("endBase: ");
            int shift = readInt("cesar shift: ");
            String shiftStr = cr.encrypt(input, shift).toString();
            println(c.baseNToBaseN(shiftStr, initBase, endBase));
        }
    }
}
