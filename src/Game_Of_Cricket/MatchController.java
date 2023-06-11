package Game_Of_Cricket;

import java.io.IOException;
import java.util.Scanner;

public class MatchController {
    int overs;
    String team1name;
    String team2name;
    Team1 team1;
    Team2 team2;
    Scanner sc = new Scanner(System.in);

    public void play() throws IOException {

/**
 * To add player details of team1
 */
        System.out.println("Enter Team 1 Name");
        team1name = sc.nextLine();
        team1 = new Team1(team1name);
        System.out.println("Enter team " + team1name + " Players details");
        addPlayersTeam1(11);

/**
 * To add player details of team2
 */
        System.out.println("Enter Team 2 Name");
        team2name = sc.nextLine();
        team2 = new Team2(team2name);
        System.out.println("Enter team " + team2name + " Players details");
        addPlayersTeam2(11);

/**
 *   overs of an inning
 */
        System.out.println("Set Number of Overs in an inning");
        System.out.println("Enter between 1-10");
        overs = sc.nextInt();
        setOvers(overs);

/**
 * toss to decide who bats first
 */
        int bat = toss();

/**
 * to play first and second innings of the match
 */
        if(bat==1) {
            System.out.println("First inning Starts");
            team1PlaysFirstInning();
            System.out.println("First inning Ends");
            System.out.println("Second inning Starts");
            team2PlaysSecondInning();
            System.out.println("Second inning Ends");
        }
        else{
            System.out.println("First inning Starts");
            team2PlaysFirstInning();
            System.out.println("First inning Ends");
            System.out.println("Second inning Starts");
            team1PlaysSecondInning();
            System.out.println("Second inning Ends");
        }

/**
 * shows the match result
  */
        showMatchResult(bat);

    }








    /**
     * adds players to team1
     *
     * @param count no of players to add
     */
    public void addPlayersTeam1(int count) {
        int added = 0;
        while (added < count) {
            System.out.println("Enter Player " + ++added + " name");
            String playername = "a";
            team1.players.add(new Player(playername));
        }
    }

    /**
     * adds players of team2
     *
     * @param count no of players to add
     */
    public void addPlayersTeam2(int count) {
        int added = 0;
        while (added < count) {
            System.out.println("Enter Player " + ++added + " name");
            String playername = "a";
            team2.players.add(new Player(playername));
        }
    }

    /**
     * sets overs of an inning
     *
     * @param overs no of overs in an inning
     */
    public void setOvers(int overs) {
        do {
            if (overs <= 10 && overs >= 1)
                this.overs = overs;
            else
                System.out.println("Enter overs in range 1-10");
        } while (overs < 1 && overs > 10);
    }

    /**
     * to decide who bats and who bowls
     *
     * @return integer denoting the teamno who bats first
     */
    public int toss() {
        return (int) (Math.random() * 2) + 1;
    }

    public int bowlRandomFunction() {
        return (int) (Math.random() * 8);
    }

    /**
     * the function works if team1 plays first inning
     */
    public void team1PlaysFirstInning() {
        int bowlstoplay = overs * 6;
        while (bowlstoplay > 0 && team1.wickets<10) {
            System.out.println("Press 1 to play next Ball");
            int userentry=0;
            int bowlresult=0;
            while(userentry!=1){
                userentry=sc.nextInt();
                if(userentry==1)
                    bowlresult = bowlRandomFunction();
                else
                    System.out.println("Invalid Input");
            }
            switch (bowlresult){
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    bowlstoplay--;
                System.out.println(bowlresult+" runs");
                team1.runs(bowlresult);
                break;
                case 5:
                System.out.println("Wide");
                team1.extras();
                break;
                case 7:
                    bowlstoplay--;
                System.out.println("Out");
                team1.wickets();
                team1.showPlayerFinalScore();
                break;
            }
            team1.showTeamScore();
        }
    }

    public void team2PlaysFirstInning() {
        int bowlstoplay = overs * 6;
        while (bowlstoplay > 0 && team2.wickets<10) {
            System.out.println("Press 1 to play next Ball");
            int userentry=0;
            int bowlresult=0;
            while(userentry!=1){
                userentry=sc.nextInt();
                if(userentry==1)
                    bowlresult = bowlRandomFunction();
                else
                    System.out.println("Invalid Input");
            }
            switch (bowlresult){
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    bowlstoplay--;
                    System.out.println(bowlresult+" runs");
                    team2.runs(bowlresult);
                    break;
                case 5:
                    System.out.println("Wide");
                    team2.extras();
                    break;
                case 7:
                    bowlstoplay--;
                    System.out.println("Out");
                    team2.wickets();
                    team2.showPlayerFinalScore();
                    break;
            }
            team2.showTeamScore();
        }
    }

    public void team1PlaysSecondInning() {
        int bowlstoplay = overs * 6;
        while (bowlstoplay > 0 && team1.wickets<10) {
            System.out.println("Press 1 to play next Ball");
            int userentry=0;
            int bowlresult=0;
            while(userentry!=1){
                userentry=sc.nextInt();
                if(userentry==1)
                    bowlresult = bowlRandomFunction();
                else
                    System.out.println("Invalid Input");
            }
            switch (bowlresult){
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    bowlstoplay--;
                    System.out.println(bowlresult+" runs");
                    team1.runs(bowlresult);
                    break;
                case 5:
                    System.out.println("Wide");
                    team1.extras();
                    break;
                case 7:
                    bowlstoplay--;
                    System.out.println("Out");
                    team1.wickets();
                    team1.showPlayerFinalScore();
                    break;
            }
            team1.showTeamScore();
            if(team1.score<team2.score){
                System.out.println(team2.score-team1.score+" runs to win in "+ bowlstoplay+" bowls");
            }
        }
    }public void team2PlaysSecondInning() {
        int bowlstoplay = overs * 6;
        while (team2.score<team1.score && bowlstoplay > 0 && team2.wickets<10) {
            System.out.println("Press 1 to play next Ball");
            int userentry=0;
            int bowlresult=0;
            while(userentry!=1){
                userentry=sc.nextInt();
                if(userentry==1)
                    bowlresult = bowlRandomFunction();
                else
                    System.out.println("Invalid Input");
            }
            switch (bowlresult){
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    bowlstoplay--;
                    System.out.println(bowlresult+" runs");
                    team2.runs(bowlresult);
                    break;
                case 5:
                    System.out.println("Wide");
                    team2.extras();
                    break;
                case 7:
                    bowlstoplay--;
                    System.out.println("Out");
                    team2.wickets();
                    team2.showPlayerFinalScore();
                    break;
            }
            team2.showTeamScore();
            if(team1.score>team2.score){
                System.out.println(team1.score-team2.score+" runs to win in "+ bowlstoplay+" bowls");
            }
        }
    }

    public void showMatchResult(int batfirst){
        if(batfirst==1){
            if(team1.score>team2.score)
                System.out.println(team1name+" wins by "+ (team1.score-team2.score) +" runs");
            else
                System.out.println(team2name+" wins by "+ (10-team2.wickets) +" wickets");
        }
        else{
            if(team1.score<team2.score)
                System.out.println(team2name+" wins by "+ (team2.score-team1.score) +" runs");
            else
                System.out.println(team2name+" wins by "+ (10-team1.wickets) +" wickets");
        }
    }

}
