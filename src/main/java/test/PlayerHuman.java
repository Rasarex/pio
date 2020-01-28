package test;

import java.util.Scanner;

class PlayerHuman implements Player {
    static Scanner scanner = new Scanner(System.in);
    String name;

    @Override
    public int guess() {
        int retval = scanner.nextInt();
        return retval;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int setName(String name) {
        if (null == name || !name.matches("^[\\w\\d~]{3,}$"))
            return 1;
        this.name = name;
        return 0;
    }

}