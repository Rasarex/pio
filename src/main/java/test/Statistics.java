package test;

import java.util.concurrent.ConcurrentHashMap;

class Statistics implements IStatistics {

  private final static ConcurrentHashMap<Player, Integer> stats = new ConcurrentHashMap<>();

  public synchronized void showStats() {
    System.out.println();
    stats.forEach((var player, var wins) -> {
      System.out.printf("%s won %d times\n", player.getName(), wins);
    });
  }

  public synchronized void increment(Player player) {
    stats.replace(player, stats.getOrDefault(player, 0) + 1);
  }

  public synchronized void add(Player player) {
    stats.put(player, 0);
  }

  public synchronized void clear() {
    stats.clear();
  }
}