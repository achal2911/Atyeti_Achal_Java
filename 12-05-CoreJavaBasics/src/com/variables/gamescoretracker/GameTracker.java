package com.variables.gamescoretracker;

public class GameTracker {
    private String playerName;
    private int score;
    private int level;

    final int MAX_LEVEL = 10;

    public GameTracker(String playerName, int score, int level) {
        this.playerName = playerName;
        this.score = score;
        this.level = 1;
    }

    public void increaseScore(int score) {
        this.score += score;
        System.out.println("Player :" + playerName);
        System.out.println("current score " + score);
        System.out.println("increasedScore " + this.score);
        System.out.println("Current Level : " + levelUp());
    }

    public int levelUp() {

        if (level < 10) {

            int range = score / 10;

            switch (range) {

                case 1:

                    return level = 1;

                case 2:

                    return level = 2;

                case 3:

                    return level = 3;

                case 4:

                    return level = 4;

                case 5:

                    return level = 5;

                case 6:

                    return level = 6;

                case 7:

                    return level = 7;

                case 8:

                    return level = 8;

                case 9:

                    return level = 9;

                case 10:

                    return level = 10;

                default:

                    break;

            }

        }

        return level;

    }

    public static void main(String[] args) {
        GameTracker player1 = new GameTracker("Allen", 20, 0);
        player1.increaseScore(2);
    }


}
