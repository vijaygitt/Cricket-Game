package Game_Of_Cricket;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Inning {
    Teams teamchosenhere;
    Teams team_not_chosen_here;
    public void playInning(boolean automated,int choice,int overs,Team team1,Team team2) throws InterruptedException {
        int bowlstoplay = overs * 6;
        if (choice == 1) {
            teamchosenhere = team1;
            team_not_chosen_here = team2;
        }
        else{
            teamchosenhere = team2;
            team_not_chosen_here=team1;
        }
        while (bowlstoplay > 0 && teamchosenhere.getWickets()<10) {
            if(automated)
                System.out.println("Next ball");
            else
                System.out.println("Press 1 to play next Ball");

            int userentry=0;
            int bowlresult=0;
            Scanner sc=new Scanner(System.in);
            while(userentry!=1){
                userentry= (automated) ? 1:sc.nextInt();
                if(userentry==1)
                    bowlresult = (int) (Math.random() * 8);
                else
                    System.out.println("Invalid Input");
            }

            switch (bowlresult) {
                case 0, 1, 2, 3, 4, 6 -> {
                    bowlstoplay--;
                    System.out.println(bowlresult + " runs");
                    teamchosenhere.runs(bowlresult);
                }
                case 5 -> {
                    System.out.println("Wide");
                    teamchosenhere.extras();
                }
                case 7 -> {
                    bowlstoplay--;
                    System.out.println("Out");
                    teamchosenhere.wickets();
                    teamchosenhere.showPlayerFinalScore();
                }
            }

            teamchosenhere.showTeamScore();

            if(team_not_chosen_here.getBallPlayed()==overs*6||team_not_chosen_here.getWickets()==10) {
                if (teamchosenhere.getScore() <= team_not_chosen_here.getScore()&&bowlstoplay!=0)
                    System.out.println((team_not_chosen_here.getScore() + 1 - teamchosenhere.getScore()) + " runs to win in " + bowlstoplay + " bowls");
                else
                    break;
            }
            TimeUnit.SECONDS.sleep(1);

        }
    }
}
