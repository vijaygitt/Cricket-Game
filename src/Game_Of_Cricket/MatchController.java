package Game_Of_Cricket;

import java.util.Scanner;

public class MatchController {

    int overs;
    int battingteamindex;
    int playernumber;
    //initialises overs
    public void setMatchOvers(int overs){
        if(overs>=1&&overs<=10)
            this.overs=overs;
    }

    public void setUserTeam(int userteam){

    }

    //toss
    public int toss(){
        int matchtoss=(int)(Math.random()*2);
        return matchtoss+1;
    }

    public void setBattingTeam(int index){
        battingteamindex=index;
    }
    public int getTeam1Score(){
        return teamscore[0];
    }
    public int getTeam2Score(){
        return teamscore[1];
    }

    //sets score for batting team and player
    public void setScores(int score) {
        if(score<=6){
            teamscore[battingteamindex]+=score;
            if(battingteamindex==0)
                t1players[playernumber]+=score;
            else
                t2players[playernumber]+=score
        }
        //score=7 means wicket
        else{
            playernumber++;
        }
    }
}
