import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("Do you want to play a Game?");
        Methods game = new Methods();
        game.gameWrapper();
    }
}