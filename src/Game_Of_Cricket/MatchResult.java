package Game_Of_Cricket;

import java.util.concurrent.TimeUnit;

public class MatchResult {

    public void showMatchResult(int batfirst,Team team1,Team team2) throws InterruptedException {
        if(batfirst==1){
            if(team1.getScore()>team2.getScore())
                System.out.println(team1.getName()+" wins by "+ (team1.getScore()-team2.getScore()) +" runs");
            else
                System.out.println(team2.getName()+" wins by "+ (10-team2.getWickets()) +" wickets");
        }
        else{
            if(team1.getScore()<team2.getScore())
                System.out.println(team2.getName()+" wins by "+ (team2.getScore()-team1.getScore()) +" runs");
            else
                System.out.println(team2.getName()+" wins by "+ (10-team1.getWickets()) +" wickets");
        }
        TimeUnit.SECONDS.sleep(5);
    }
}
