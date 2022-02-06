import acm.program.*;
import java.util.*;
import java.math.BigInteger;

public class Decrypt extends ConsoleProgram {
    private String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz .,?!;:()'";
    private String numbers = "0123456789";
    public void run(){
        String input = readLine("Input: ");
        ArrayList<BigInteger> possible = new ArrayList<BigInteger>();
        ArrayList<String> actual = new ArrayList<String>();
        ArrayList<Integer> initBases = new ArrayList<Integer>();
        ArrayList<Integer> endBases = new ArrayList<Integer>();
        Cryptography cr = new Cryptography();

        for(int i=2; i <=72; i++){
            possible.add(new BigInteger(cr.baseNToBase10(i, input)));

        }
        for(int i=0; i<possible.size(); i++){
            for(int j=2; j<=72; j++){
                actual.add(cr.base10ToBaseN(j, possible.get(i).toString()));
                initBases.add(i);
                endBases.add(j);
            }
        }
        for(int i=0; i < actual.size(); i++){
            if(actual.get(i).equals("") || actual.get(i).length() ==1 ){
                actual.remove(i);
                initBases.remove(i);
                endBases.remove(i);
                i--;

            }

        }
        for(int i=0; i<actual.size(); i++){

            for(int j=0; j< 10; j++){
                if(actual.get(i).indexOf(String.valueOf(j)) != -1){
                    actual.remove(i);
                    initBases.remove(i);
                    endBases.remove(i);
                    i--;
                    break;
                }
            }

        }
        for(int i=0; i< actual.size(); i++){
            println(initBases.get(i) + ", " + endBases.get(i) + ": " + actual.get(i));
        }
        println();
        println("caesar cipher cases:");
        println();
        CaesarCipher c = new CaesarCipher(); 
        for(int j = 0; j<actual.size(); j++){
            for(int i = 0; i< 26; i++){
                println(c.encrypt(actual.get(j), 26-i));
            }

        }
    }
}
