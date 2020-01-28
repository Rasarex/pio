package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class Game {

    public Game() {
        this(null);
    }

    public Game(Statistics stats) {
        players = new ArrayList<>();
        if (stats == null) {
            this.stats = new NullStatistics();
        }
        this.stats = stats;
    }

    public void showStats() {
        stats.showStats();
    }

    public void play() {
        if (null == players) {
            return;
        }
        int guess = 0;

        Random rand = new Random();
        boolean guessed = true;
        do {
            int number = rand.nextInt(6) + 1;
            for (Player player : players) {
                guess = player.guess();
                if (guess == number) {
                    guessed = false;
                    stats.increment(player);
                }
                System.out.printf("\nKostka: %d\nGracz %s: %d\n---------------", number, player.getName(), guess);
            }
        } while (guessed);

    }

    public void addPlayer(Player player) {
        addPlayer(player, "");
        stats.add(player);
    }

    private void addPlayer(Player player, String salt) {
        for (Player existing : players) {
            if (existing.getName().equals(player.getName() + salt)) {
                salt = getSalt();
                addPlayer(player, salt);
                return;
            }
        }
        player.setName(player.getName() + salt);
        players.add(player);
        return;
    }

    private String getSalt() {
        final Random rand = new Random();
        return "~" + Integer.toHexString(rand.nextInt());
    }

    public void printPlayers() {
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }

    public void removePlayer(String name) {

        for (Iterator<Player> it = players.iterator(); it.hasNext();) {
            if (it.next().getName().equals(name)) {
                it.remove();
                return;
            }
        }
        return;
    }

    private ArrayList<Player> players;
    private IStatistics stats;
}