package Game_Of_Cricket;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args)throws Exception {
        MatchController controller = new MatchController();

        Scanner sc = new Scanner(System.in);

        int choice=1;
        do{
        System.out.println("Enter Overs of the Match between 1-10");
        int overs = sc.nextInt();
        controller.setMatchOvers(overs);

        System.out.println("User Team vs Com");
        System.out.println("Select 1 for choosing Team1 or select 2 for choosing Team2");
        int userteam = sc.nextInt();
        controller.setUserTeam(userteam);

        controller.playMatch();

        System.out.println("Want to play again?");
        System.out.println("Select 1 to play 0 to exit");
        choice = sc.nextInt();
        }while(choice!=0);
    }
}
