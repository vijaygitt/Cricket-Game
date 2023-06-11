package Game_Of_Cricket;

import java.util.ArrayList;

public class Team2 implements Teams{
    String name;
    int score;
    int ballplayed;
    int wickets;
    int extras;
    ArrayList<Player> players=new ArrayList<Player>(11);
    Team2(String name){
        this.name=name;
    }
    public void setName(String name) {

        this.name = name;
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
    public void extras(){
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
