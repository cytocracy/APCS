//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class aChandiBool implements McCoveyPlayer {
    int score = 13;
    int initScore;
    boolean checkFirst;
    boolean isFirst;

    public aChandiBool() {
        this.initScore = this.score;
        this.checkFirst = true;
        this.isFirst = false;
    }

    public boolean rollAgain(int myScore, int yourScore, int turnScore) {
        return myScore + turnScore >= 44 ? false : this.determineChoice(myScore, yourScore, turnScore);
    }

    public boolean determineChoice(int myScore, int yourScore, int turnScore) {
        if (myScore + turnScore > 32) {
            return true;
        } else if (yourScore > 29) {
            return true;
        } else if (yourScore > 23) {
            return turnScore < 18;
        } else if (myScore + turnScore < yourScore) {
            return turnScore < this.score + 2;
        } else if (myScore + turnScore < yourScore - 10) {
            return turnScore < this.score + 3;
        } else if (myScore + turnScore < yourScore - 15) {
            return turnScore < this.score + 4;
        } else if (myScore + turnScore > 27) {
            return turnScore < this.score - 2;
        } else {
            return turnScore < this.score;
        }
    }
}
