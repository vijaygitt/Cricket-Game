package Game_Of_Cricket;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainClass {
    /**
     * Main class of the Cricket Game
     */
    public static void main(String[] args) throws InterruptedException {
        int play;
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to play and any other digit to exit");
        play = sc.nextInt();
        while (play == 1) {
            /*
             * calling MatchController class to play the game
             */
            MatchController mc = new MatchController();
            mc.play();

            System.out.println("Hope you enjoyed this game");
            System.out.println("Want to play again");
            System.out.println("Press 1 to play and any other digit to exit");
            play = sc.nextInt();
        }
    }
}