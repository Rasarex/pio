/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package test;

public class App {

    public static void main(String[] args) {
        // PlayerComp player = null;

        // try {
        // player = new Player("Janek");
        // } catch (IllegalArgumentException e) {
        // System.out.println("Niepoprawne imię");
        // System.exit(-1);
        // }

        // Result<Player> resPlayer = Player.getPlayer("Janek");
        // if (!resPlayer.ok()) {
        // System.out.println("Niepoprawne imię");
        // System.exit(-1);
        // }
        // player = resPlayer.unwrap();
        Statistics stats = new Statistics();
        Game game = new Game(stats);
        game.addPlayer(PlayerComp.getPlayer("Janek").unwrap());
        game.addPlayer(PlayerComp.getPlayer("Janek").unwrap());
        game.addPlayer(PlayerComp.getPlayer("Janek").unwrap());
        // game.printPlayers();

        for (int i = 0; i < 10000; ++i) {
            game.play();
        }
        game.showStats();
        game.removePlayer("Janek");
    }
}
