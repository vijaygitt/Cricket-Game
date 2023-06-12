package Game_Of_Cricket;

public class Player {
    private final String name;
    private int score;
    private int ballplayed;
    private boolean out;
    Player(String name){
        this.name=name;
    }
    public void playerScore(int run){
        score+=run;
        ballplayed++;
    }

    public void isOut(boolean out) {
        ballplayed++;
        this.out = out;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getBallPlayed() {
        return ballplayed;
    }

    public boolean isOut() {
        return out;
    }

    public void displayFinalScore(){
        System.out.println(getName()+" -> "+getScore()+" "+getBallPlayed()+" "+isOut());
    }

}