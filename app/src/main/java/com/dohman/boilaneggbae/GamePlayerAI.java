package com.dohman.boilaneggbae;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by David Öhman on 2018-01-31.
 */

public class GamePlayerAI extends GamePlayer {

    private final Game board;
    private ArrayList<String> aiInput;
    private static Random random;

    public GamePlayerAI(Game board) {
        super("BOT", "o");
        this.board = board;
        this.aiInput = new ArrayList<String>();
        random = new Random();
        initialize();
    }

    protected void initialize() {
        aiInput.add("a1");
        aiInput.add("a2");
        aiInput.add("a3");
        aiInput.add("b1");
        aiInput.add("b2");
        aiInput.add("b3");
        aiInput.add("c1");
        aiInput.add("c2");
        aiInput.add("c3");
    }

    public String makeInput() {
        String input;
        // Har inte kodat för alla möjliga drag, för då blir det helt omöjligt att slå boten
        if (board.getA1().getText().toString().equals("o") && board.getA2().getText().toString().equals("o") && board.getA3().getText().toString().equals(" ")
                || board.getB3().getText().toString().equals("o") && board.getC3().getText().toString().equals("o") && board.getA3().getText().toString().equals(" ")
                || board.getC1().getText().toString().equals("o") && board.getB2().getText().toString().equals("o") && board.getA3().getText().toString().equals(" ")
                || board.getA1().getText().toString().equals("x") && board.getA2().getText().toString().equals("x") && board.getA3().getText().toString().equals(" ")
                || board.getB3().getText().toString().equals("x") && board.getC3().getText().toString().equals("x") && board.getA3().getText().toString().equals(" ")
                || board.getC1().getText().toString().equals("x") && board.getB2().getText().toString().equals("x") && board.getA3().getText().toString().equals(" ")) {
            input = "a3";
        } else if (board.getB1().getText().toString().equals("o") && board.getB2().getText().toString().equals("o") && board.getB3().getText().toString().equals(" ")
                || board.getA3().getText().toString().equals("o") && board.getC3().getText().toString().equals("o") && board.getB3().getText().toString().equals(" ")
                || board.getB1().getText().toString().equals("x") && board.getB2().getText().toString().equals("x") && board.getB3().getText().toString().equals(" ")) {
            input = "b3";
        } else if (board.getC1().getText().toString().equals("o") && board.getC2().getText().toString().equals("o") && board.getC3().getText().toString().equals(" ")
                || board.getA1().getText().toString().equals("o") && board.getB2().getText().toString().equals("o") && board.getC3().getText().toString().equals(" ")
                || board.getA3().getText().toString().equals("o") && board.getB3().getText().toString().equals("o") && board.getC3().getText().toString().equals(" ")
                || board.getC1().getText().toString().equals("x") && board.getC2().getText().toString().equals("x") && board.getC3().getText().toString().equals(" ")
                || board.getA1().getText().toString().equals("x") && board.getB2().getText().toString().equals("x") && board.getC3().getText().toString().equals(" ")
                || board.getA3().getText().toString().equals("x") && board.getB3().getText().toString().equals("x") && board.getC3().getText().toString().equals(" ")
                ) {
            input = "c3";
        } else if (board.getB2().getText().toString().equals("o") && board.getC2().getText().toString().equals("o") && board.getA2().getText().toString().equals(" ")
                || board.getA1().getText().toString().equals("o") && board.getA3().getText().toString().equals("o") && board.getA2().getText().toString().equals(" ")
                || board.getB2().getText().toString().equals("x") && board.getC2().getText().toString().equals("x") && board.getA2().getText().toString().equals(" ")) {
            input = "a2";
        } else if (board.getA3().getText().toString().equals("o") && board.getC1().getText().toString().equals("o") && board.getB2().getText().toString().equals(" ")
                || board.getA1().getText().toString().equals("o") && board.getC3().getText().toString().equals("o") && board.getB2().getText().toString().equals(" ")
                || board.getA3().getText().toString().equals("x") && board.getC1().getText().toString().equals("x") && board.getB2().getText().toString().equals(" ")
                || board.getA1().getText().toString().equals("x") && board.getC3().getText().toString().equals("x") && board.getB2().getText().toString().equals(" ")) {
            input = "b2";
        } else if (board.getA2().getText().toString().equals("o") && board.getB2().getText().toString().equals("o") && board.getC2().getText().toString().equals(" ")
                || board.getC1().getText().toString().equals("o") && board.getC3().getText().toString().equals("o") && board.getC2().getText().toString().equals(" ")
                || board.getA2().getText().toString().equals("x") && board.getB2().getText().toString().equals("x") && board.getC2().getText().toString().equals(" ")) {
            input = "c2";
        } else if (board.getA2().getText().toString().equals("o") && board.getA3().getText().toString().equals("o") && board.getA1().getText().toString().equals(" ")
                || board.getB2().getText().toString().equals("o") && board.getC3().getText().toString().equals("o") && board.getA1().getText().toString().equals(" ")
                || board.getB1().getText().toString().equals("o") && board.getC1().getText().toString().equals("o") && board.getA1().getText().toString().equals(" ")
                || board.getA2().getText().toString().equals("x") && board.getA3().getText().toString().equals("x") && board.getA1().getText().toString().equals(" ")
                || board.getB2().getText().toString().equals("x") && board.getC3().getText().toString().equals("x") && board.getA1().getText().toString().equals(" ")
                || board.getB1().getText().toString().equals("x") && board.getC1().getText().toString().equals("x") && board.getA1().getText().toString().equals(" ")) {
            input = "a1";
        } else if (board.getB2().getText().toString().equals("o") && board.getB3().getText().toString().equals("o") && board.getB1().getText().toString().equals(" ")
                || board.getA1().getText().toString().equals("o") && board.getC1().getText().toString().equals("o") && board.getB1().getText().toString().equals(" ")
                || board.getB2().getText().toString().equals("x") && board.getB3().getText().toString().equals("x") && board.getB1().getText().toString().equals(" ")) {
            input = "b1";
        } else if (board.getC2().getText().toString().equals("o") && board.getC3().getText().toString().equals("o") && board.getC1().getText().toString().equals(" ")
                || board.getB2().getText().toString().equals("o") && board.getA3().getText().toString().equals("o") && board.getC1().getText().toString().equals(" ")
                || board.getA1().getText().toString().equals("o") && board.getB1().getText().toString().equals("o") && board.getC1().getText().toString().equals(" ")
                || board.getC2().getText().toString().equals("x") && board.getC3().getText().toString().equals("x") && board.getC1().getText().toString().equals(" ")
                || board.getB2().getText().toString().equals("x") && board.getA3().getText().toString().equals("x") && board.getC1().getText().toString().equals(" ")
                || board.getA1().getText().toString().equals("x") && board.getB1().getText().toString().equals("x") && board.getC1().getText().toString().equals(" ")) {
            input = "c1";
        } else {
            int index = random.nextInt(aiInput.size());
            input = aiInput.get(index);
        }
        return input;
    }
}

