
public class AuthorSignature
{ 
    private String authorName;
    private double avgWordLength;
    private double differentWordRatio;
    private double hapaxRatio;
    private double avgWordsPerSentence;
    private double avgPhrasesPerSentence;
    
    public AuthorSignature(String authorName, double avgWordLength, 
    double differentWordRatio, double hapaxRatio, double avgWordsPerSentence, double avgPhrasesPerSentence )
    {
        this.authorName = authorName;
        this.avgWordLength = avgWordLength;
        this.differentWordRatio = differentWordRatio;
        this.hapaxRatio = hapaxRatio;
        this.avgWordsPerSentence = avgWordsPerSentence;
        this.avgPhrasesPerSentence = avgPhrasesPerSentence;
    }
    
    public String getAuthorName(){return authorName;}
    public double getAvgWordLength(){return avgWordLength;}
    public double getDifferentWordRatio(){return differentWordRatio;}
    public double getHapaxRatio(){return hapaxRatio;}
    public double getAvgWordsPerSentence(){return avgWordsPerSentence;}
    public double getAvgPhrasesPerSentence(){return avgPhrasesPerSentence;}
}
