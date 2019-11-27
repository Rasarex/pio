package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class Game {

    Game() {
        players = new ArrayList<>();
    }

    void play() {
        if (null == players) {
            return;
        }
        int guess = 0;

        Random rand = new Random();
        boolean guessed = false;
        do {
            guessed = true;
            int number = rand.nextInt(6) + 1;
            for (Player player : players) {
                guess = player.guess();
                if (guess == number) {
                    guessed = false;
                }
                System.out.printf(" Kostka: %d\n Gracz %s: %d\n---------------", number, player.getName(), guess);
            }
        } while (guessed);

    }

    void addPlayer(Player player) {
        players.add(player);
    }

    private ArrayList<Player> players;
}