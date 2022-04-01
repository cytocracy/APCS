
import acm.program.*;
import java.util.ArrayList;

public class AuthorshipDetection extends ConsoleProgram
{
    private static final String PUNCTUATION = "'!\",;:.-?)([]<>*#\n\t\r ";
    private static final double[] WEIGHT = {11.0, 33.0, 50.0, 0.4, 4.0};
    private AuthorSignature[] authors;

    public void run()
    {
        loadAuthorSignatures();
        
        String filename = readLine("Enter file name: ");
        String fileContents = FileHelper.getFileContents(filename);
        
        ArrayList<String> sentences = getSentencesFromContents(fileContents);
        ArrayList<String> words = getAllWordsFromSentences(sentences);
        //ArrayList<String> cleanWords = new ArrayList<String>();
        /*for(int i=0; i<words.size(); i++){
            if(clean(words.get(i)) != null) cleanWords.add(clean(words.get(i)));
        }*/
        //println("Number of sentences = " + sentences.size());
        for (int i=0; i<1000; i++)
            println(words.get(i));
    }

    // you'll do tasks #2 through #12 here
    private ArrayList<String> getSentencesFromContents(String fileContents){
        int sentenceStart = 0;
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0; i<fileContents.length(); i++){
            String symbol = fileContents.substring(i, i+1);
            if(symbol.equals(".") || symbol.equals("?") || symbol.equals("!")){
                String sentence = fileContents.substring(sentenceStart, i+1);
                result.add(sentence);
                sentenceStart = i+1;
            }
        }
        if(sentenceStart < fileContents.length()-1){
            String sentence = fileContents.substring(sentenceStart);
            result.add(sentence);
        }
        return result;
    }
    
    private ArrayList<String> getWordsFromSentence(String sentence){
        int wordStart = 0;
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0; i<sentence.length(); i++){
            String symbol = sentence.substring(i, i+1);
            if(symbol.equals(" ")){
                String word = sentence.substring(wordStart, i);
                if(clean(word) != null) result.add(clean(word));
                wordStart = i+1;
            }
        }
        if(wordStart < sentence.length()-1){
            String word = sentence.substring(wordStart);
            result.add(word);
        }
        return result;
    }
    
    private String clean(String word){
        String result = word.toLowerCase();
        if(result.length() ==0 )return null;
        while(PUNCTUATION.indexOf(result.substring(0,1)) != -1){
            result = result.substring(1);
            if(result.length() ==0 )return null;
        }
        while(PUNCTUATION.indexOf(result.substring(result.length()-1)) != -1){
            result = result.substring(0, result.length()-1);
            if(result.length() == 0)return null;
        }
        return result;
    }
    
    private ArrayList<String> getAllWordsFromSentences(ArrayList<String> sentences){
        ArrayList<String> result = new ArrayList<String>();
        
        for(int i = 0; i<sentences.size(); i++){
            ArrayList<String> words = getWordsFromSentence(sentences.get(i));
            for(int j = 0; j<words.size(); j++) result.add(words.get(j));
        }
        return result;
    }
    
    // I wrote this method for you
    private void loadAuthorSignatures()
    {
        authors = new AuthorSignature[13];
        authors[0] = new AuthorSignature("Agatha Christie", 4.40212537354, 0.103719383127, 0.0534892315963, 10.0836888743, 1.90662947161);
        authors[1] = new AuthorSignature("Alexandre Dumas", 4.38235547477, 0.049677588873, 0.0212183996175, 15.0054854981, 2.63499369483);
        authors[2] = new AuthorSignature("Brothers Grimm", 3.96868608302, 0.0529378997714, 0.0208217283571, 22.2267197987, 3.4129614094);
        authors[3] = new AuthorSignature("Charles Dickens", 4.34760725241, 0.0803220950584, 0.0390662700499, 16.2613453121, 2.87721723105);
        authors[4] = new AuthorSignature("Douglas Adams", 4.33408042189, 0.238435104414, 0.141554321967, 13.2874354561, 1.86574870912);
        authors[5] = new AuthorSignature("Emily Bronte", 4.35858972311, 0.089662598104, 0.0434307152651, 16.1531664212, 2.93439550141);
        authors[6] = new AuthorSignature("Fyodor Dostoevsky", 4.34066732195, 0.0528571428571, 0.0233414043584, 12.8108273249, 2.16705364781);
        authors[7] = new AuthorSignature("James Joyce", 4.52346300961, 0.120109917189, 0.0682315429476, 10.9663296918, 1.79667373227);
        authors[8] = new AuthorSignature("Jane Austen", 4.41553119311, 0.0563451817574, 0.02229943808, 16.8869087498, 2.54817097682);
        authors[9] = new AuthorSignature("Lewis Caroll", 4.22709528497, 0.111591342227, 0.0537026953444, 16.2728740581, 2.86275565124);
        authors[10] = new AuthorSignature("Mark Twain", 4.33272222298, 0.117254215021, 0.0633074228159, 14.3548573631, 2.43716268311);
        authors[11] = new AuthorSignature("Sir Arthur Conan Doyle", 4.16808311494, 0.0822989796874, 0.0394458485444, 14.717564466, 2.2220872148);
        authors[12] = new AuthorSignature("William Shakespeare", 4.16216957834, 0.105602561171, 0.0575348730848, 9.34707371975, 2.24620146314);
    }

}