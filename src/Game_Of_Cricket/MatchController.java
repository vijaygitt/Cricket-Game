package Game_Of_Cricket;
import java.util.Scanner;

public class MatchController {
    int overs;
    String team1name;
    String team2name;
    Teams teamchosenhere;
    Teams team_not_chosen_here;
    Team1 team1;
    Team2 team2;
    Scanner sc = new Scanner(System.in);

    public void play(){

/**
 * To add player details of team1
 */
        System.out.println("Enter Team 1 Name");
        team1name = sc.nextLine();
        team1 = new Team1(team1name);
        System.out.println("Enter team " + team1name + " Players details");
        addPlayers(1,11);

/**
 * To add player details of team2
 */
        System.out.println("Enter Team 2 Name");
        team2name = sc.nextLine();
        team2 = new Team2(team2name);
        System.out.println("Enter team " + team2name + " Players details");
        addPlayers(2,11);

/**
 *   overs of an inning
 */
        System.out.println("Set Number of Overs in an inning");
        Overs();

/**
 * toss to decide who bats first
 */
        int bat = toss();
        if(bat==1)
            System.out.println(team1name+" bats first");
        else
            System.out.println(team2name+" bats first");

/**
 * to play first and second innings of the match
 */
        System.out.println("First inning Starts");
        if(bat==1) {
            playFirstInning(1);
            System.out.println("First inning Ends");
            System.out.println("Second inning Starts");
            playSecondInning(2);
        }
        else{
            playFirstInning(2);
            System.out.println("First inning Ends");
            System.out.println("Second inning Starts");
            playSecondInning(1);
        }
        System.out.println("Second inning Ends");

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
    public void addPlayers(int teamnumber,int count) {
        int added = 0;
        if(teamnumber==1)
            teamchosenhere =team1;
        else
            teamchosenhere =team2;
        while (added < count) {
            System.out.println("Enter Player " + ++added + " name");
            String playername = "a";
            teamchosenhere.setPlayer(new Player(playername));
        }
    }


    /**
     * sets overs of an inning
     *
     */
    public void Overs() {
        int overinput;
        do {
            System.out.println("Enter between 1-10");
            overinput = sc.nextInt();
        } while (overinput < 1 || overinput > 10);
            overs = overinput;
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
    public void playFirstInning(int choice) {

        int bowlstoplay = overs * 6;

        teamchosenhere= (choice==1)?team1:team2;

        while (bowlstoplay > 0 && teamchosenhere.getWickets()<10) {
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
        }
    }


    public void playSecondInning(int choice) {
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
            if(teamchosenhere.getScore()<=team_not_chosen_here.getScore()){
                System.out.println((team_not_chosen_here.getScore()+1-teamchosenhere.getScore()) +" runs to win in "+ bowlstoplay+" bowls");
            }
            else
                break;
        }
    }

    public void showMatchResult(int batfirst){
        if(batfirst==1){
            if(team1.getScore()>team2.getScore())
                System.out.println(team1name+" wins by "+ (team1.getScore()-team2.getScore()) +" runs");
            else
                System.out.println(team2name+" wins by "+ (10-team2.getWickets()) +" wickets");
        }
        else{
            if(team1.getScore()<team2.getScore())
                System.out.println(team2name+" wins by "+ (team2.getScore()-team1.getScore()) +" runs");
            else
                System.out.println(team2name+" wins by "+ (10-team1.getScore()) +" wickets");
        }
    }
}
