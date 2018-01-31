package com.dohman.boilaneggbae;

import java.util.Scanner;

/**
 * Created by David Öhman on 2018-01-31.
 */

public class GamePlayerHuman extends GamePlayer {
    private Scanner sc = new Scanner(System.in);

    public GamePlayerHuman(String playerName, String suit) {
        super(playerName, suit);

    }

    @Override
    public String makeInput() {
        String input;
        do {
            input = sc.nextLine();
        } while (!checkInput(input));
        return input;
    }
}