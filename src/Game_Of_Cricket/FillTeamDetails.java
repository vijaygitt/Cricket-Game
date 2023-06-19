package Game_Of_Cricket;

import java.util.ArrayList;
import java.util.Scanner;

public class FillTeamDetails {

    String[] team1players={"Hitman Rohit","Shubhman","King Kohli","Rahane","Pujara","Kishan","Lord Shardul","Sir Jadeja","Bumrah","Shami","Siraj"};
    String[] team2players={"Warner","Usman","Labuschagne","Smith","Travis","Cameron","Carey","Starc","Cummins","Lyon","Boland"};
    String team1name="India";
    String team2name="Australia";
    public ArrayList<Team> teamDetailsAuto(){
        ArrayList<Team> teamarr=new ArrayList<>();
        teamarr.add(new Team(team1name));
        teamarr.add(new Team(team2name));
        for(int i=0;i<11;i++){
            teamarr.get(0).setPlayer(new Player(team1players[i]));
            teamarr.get(1).setPlayer(new Player(team2players[i]));
        }
        System.out.println("Ind vs Aus");
        return teamarr;
    }

    public Team teamDetailsManual(int count, Team team) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Team Name");
        String name=sc.nextLine();
        team =new Team(name);
        System.out.println("Enter team " + team.getName() + " Players details");
        int added = 0;
        while (added < count) {
            System.out.println("Enter Player " + ++added + " name");
            String playername = "a";//sc.nextLine();
            team.setPlayer(new Player(playername));
        }
        return team;
    }
}
