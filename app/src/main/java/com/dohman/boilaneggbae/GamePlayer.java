package com.dohman.boilaneggbae;

/**
 * Created by David Öhman on 2018-01-31.
 */

public class GamePlayer {

    private String playerName;
    private String suit;
    private int wins;

    public GamePlayer(String playerName, String suit) {
        this.playerName = playerName;
        this.suit = suit;
        this.wins = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getSuit() {
        return suit;
    }

    public int getWins() {
        return wins;
    }

    public void gameAddWin() {
        this.wins++;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
