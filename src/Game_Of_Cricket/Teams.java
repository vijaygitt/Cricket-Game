package Game_Of_Cricket;

public interface Teams {
    /**
     * to set the Teams name
     * @param name Team's name
     */
    void setName(String name);
    /**
     * to increase score after each ball and count of balls
     * @param run runs made in a ball
     */
    void runs(int run);

    /**
     * to increase the wicket count when a player gets out
     */
    void wickets();

    /**
     * to count extra runs in a team's inning
     */
    void extras();
    /**
     * to add players to the team
     */

    void setPlayer(Player player);
    void setScore(int score);

    void setBallPlayed(int ballplayed);

    void setWickets(int wickets);

    void setExtras(int extras);
    String getName();

    int getScore();

    int getBallPlayed();

    int getWickets();

    int getExtras();

    Player getPlayer(int index);
    void showPlayerFinalScore();
    void showTeamScore();
}
