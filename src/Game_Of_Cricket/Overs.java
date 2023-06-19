package Game_Of_Cricket;

import java.util.Scanner;

public class Overs {
    public int inningOvers(){
        System.out.println("Set Number of Overs in an inning");
        Scanner sc=new Scanner(System.in);
        int over;
        do{
            over=sc.nextInt();
            System.out.println("1-10");
        }
        while (10<over||1>over);
        return over;
    }
}
