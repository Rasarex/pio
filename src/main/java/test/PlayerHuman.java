package test;

import java.util.Scanner;

class PlayerHuman implements IPlayer{
        static Scanner scanner = new Scanner(System.in);
        @Override
        public int guess(){
            int retval = scanner.nextInt();
            return retval;
        }

}