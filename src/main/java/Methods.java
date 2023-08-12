import java.util.Random;
import java.util.Scanner;

public class Methods {
    private int round = 1;
    private int aNewTry = 0;
    private int tip; //Higher is 1. Lower is 0.
    private int guessedNumber;
    private int randomNumber;
    public void gameWrapper() {
        if (round == 1) {
            generateRandomNumber();
        }
        moderatingGame();
        compareNumbers(randomNumber, guessedNumber);
    }
    public void generateRandomNumber() {
        Random generatedNumber = new Random();
        randomNumber = generatedNumber.nextInt(11);
    }
    public void moderatingGame() {
        if (aNewTry == 1) {
            System.out.println("You know the drill:");
            aNewTry = 0;
        }
        switch (round) {
            case 1 -> {
                System.out.println("I will think of a Number from 0 to 10.");
                System.out.println("Can you guess what Number it is?");
                UserInput();
            }
            case 2 -> {
                System.out.println("I am sorry, you are wrong.");
                System.out.println("You can try again. I will even give you a tip.");
                tipDecisionBlock();
            }
            case 3 -> {
                System.out.println("Oh oh. This is your last try. You better make it count.");
                tipDecisionBlock();
            }
        }
    }
    public void UserInput() {
        Scanner scanner = new Scanner(System.in);
        guessedNumber = scanner.nextInt();
        //scanner.close();
    }
    public void tipDecisionBlock() {
        if (tip == 1) {
            System.out.println("My Number is higher than yours.");
        } else if (tip == 0) {
            System.out.println("My Number is lower than yours.");
        }
        UserInput();
    }
    public void compareNumbers(int generatedNumber, int guessedNumber) {
        if (generatedNumber == guessedNumber) {
            System.out.println("Congratulation! You have guessed correctly!");
            tryAgain();
        } else if (generatedNumber != guessedNumber && round != 3) {
            round++;
            if (generatedNumber > guessedNumber) {
                tip = 1;
            } else if (generatedNumber < guessedNumber) {
                tip = 0;
            }
            gameWrapper();
        } else {
            System.out.println("You were wrong. The Number I thought of was " + generatedNumber + ".");
            tryAgain();
        }
    }
    public void tryAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play again?");
        System.out.println("type in Yes, if you do want to go on.");
        String playAgain = scanner.nextLine().toLowerCase();
        if (playAgain.equals("yes")) {
            round = 1;
            aNewTry = 1;
            gameWrapper();
        } else {
            System.out.println("Thank you for playing!");
        }
    }
}
