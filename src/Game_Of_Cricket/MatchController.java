package Game_Of_Cricket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MatchController {
    int overs;
    Team team1;
    Team team2;
    Team teamchosenhere;
    Team team_not_chosen_here;
    Scanner sc = new Scanner(System.in);

    public void play() throws InterruptedException {

        /*
          To add team details
         */
        System.out.println("Enter 1 to automatically assign teams and their players OR enter 2 to choose them yourself");
        int automanual = sc.nextInt();
        FillTeamDetails teamDetails = new FillTeamDetails();

        if (automanual == 1) {
            ArrayList<Team> teamarr = teamDetails.teamDetailsAuto();
            team1 = teamarr.get(0);
            team2 = teamarr.get(1);
        }
        else if (automanual == 2) {
            System.out.println("Enter team 1 details");
            team1 = teamDetails.teamDetailsManual(11, team1);

            System.out.println("Enter team 2 details");
            team2 = teamDetails.teamDetailsManual(11, team2);
        }
        else {
            System.out.println("Invalid Input");
            return;
        }

        /*
         overs of an inning
        */
        Overs matchovers = new Overs();
        overs = matchovers.inningOvers();

        /*
         toss to decide who bats first
        */
        int bat = (int) (Math.random() * 2) + 1;
        if (bat == 1)
            System.out.println(team1.getName() + " bats first");
        else
            System.out.println(team2.getName() + " bats first");

        /*
         to play first and second innings of the match
        */
        System.out.println("Want match automated or manual?");
        System.out.println("Enter true for automating the match else for manual enter false");
        boolean automated = sc.nextBoolean();
        Inning inning = new Inning();
        System.out.println("First inning Starts");
        if (bat == 1)
            inning.playInning(automated, 1, overs, team1, team2);
        else
            inning.playInning(automated, 2, overs, team1, team2);
        System.out.println("First inning Ends");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Second inning Starts");
        if (bat == 1)
            inning.playInning(automated, 2, overs, team1, team2);
        else
            inning.playInning(automated, 1, overs, team1, team2);
        System.out.println("Second inning Ends");

        /*
        * shows the match result
        */
        MatchResult result = new MatchResult();
        result.showMatchResult(bat, team1, team2);
    }
}
