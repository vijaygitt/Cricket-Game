package Game_Of_Cricket;

import java.util.ArrayList;

public class Team1 implements Teams{
    String name;
    private int score;
    int ballplayed;
    private int wickets;
    int extras;
    ArrayList<Player> players=new ArrayList<>(11);
    Team1(String name){
        this.name=name;
    }
    public void setName(String name) {

        this.name = name;
    }

    public void setPlayer(Player player) {
        players.add(player);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setBallPlayed(int ballplayed) {
        this.ballplayed = ballplayed;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public void setExtras(int extras) {
        this.extras = extras;
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

    public int getWickets() {
        return wickets;
    }

    public int getExtras() {
        return extras;
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public void runs(int run){
        players.get(wickets).playerScore(run);
        score+=run;
        ballplayed++;
    }
    public void wickets(){
        players.get(wickets).isOut(true);
        wickets++;
        ballplayed++;
    }
    public void extras() {
        extras++;
        score++;
    }
    public void showPlayerFinalScore(){
        players.get(wickets-1).displayFinalScore();
    }
    public void showTeamScore(){
        System.out.println(name+" -> "+score+"/"+wickets+" "+ballplayed+" "+extras);
    }
}
