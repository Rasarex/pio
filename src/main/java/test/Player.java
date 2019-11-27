package  test;
import java.util.Random;
import java.lang.IllegalArgumentException;

class Player implements IPlayer{
    public Player(){
        name = "Blank";
        offset = 1;
        range = 6;
        randMachine = new Random();
    }
    public Player(String name) throws IllegalArgumentException{
        setNameThrows(name);
        offset  = 1;
        range = 6;
        randMachine = new Random();   
    }
    static Result<Player> getPlayer(String name){
            Player play = new Player();    
            if(1 == play.setName(name))
                return new Result<>(null,false);
            return new Result<>(play,true);
    }   
    public int guess(){
        return randMachine.nextInt(range) + offset;
    }
    public int setName(String name){
        if(null == name ||  !name.matches("^[\\w\\d~]{3,}$"))
            return 1;
        this.name = name;
        return 0;
    }
    public void setNameThrows(String name) throws IllegalArgumentException{
          if(null == name || name.matches("^[\\w\\d~]{3,}$"))
                throw new IllegalArgumentException();
          this.name = name;
    }
    public  String getName() {
        return name;
    }
    private Random randMachine;
    private int offset;
    private int range;
    private String name;
}