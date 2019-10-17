package  test;
import java.util.Random;
class Player{
    Player(){
        name = "Blank";
        offset = 1;
        range = 6;
        randMachine = new Random();
    }
    public int guess(){
        return randMachine.nextInt(range) + offset;
    }
    public void setName(String name){
        if(name == null )
            System.out.println("Wrong name set");
        if(name.length() == 0)
            System.out.println("Wrong name set");
        this.name = name;
    }
    public  String getName() {

        return name;
    }
    private Random randMachine;
    public int offset;
    public int range;
    public String name;
}