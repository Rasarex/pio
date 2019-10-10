package  test;
import java.util.Random;
class Player{
    Player(){
        offset = 1;
        range = 6;
        randMachine = new Random();
    }
    public int guess(){
        return randMachine.nextInt(range) + offset;
    }
    private Random randMachine;
    public int offset;
    public int range;
}