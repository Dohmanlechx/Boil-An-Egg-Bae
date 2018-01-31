package com.dohman.boilaneggbae;

/**
 * Created by David Öhman on 2018-01-31.
 */

public abstract class GamePlayer {

    private String playerName;
    private String suit;
    private int wins;

    public GamePlayer(String playerName, String suit) {
        this.playerName = playerName;
        this.suit = suit;
        this.wins = 0;
    }

    public boolean checkInput(String input) {
        if (input.equals("a1") || input.equals("a2") || input.equals("a3")
                || input.equals("b1") || input.equals("b2") || input.equals("b3")
                || input.equals("c1") || input.equals("c2") || input.equals("c3")) {
            return true;
        } else {
            return false;
        }
    }

    public abstract String makeInput();

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
}
