import model.SecretWordGenerator;
import model.HangMan;
import java.util.Scanner;
public class App {
public static HangMan hangmanGame = new HangMan(SecretWordGenerator.chooseSecretWord());

    public static void main(String[] args) {
        System.out.println("Welcome to Hangman\nEnter a letter, or an entire word, with all letters separated by spaces (E X A M P L E): ");
        hangmanGame.newGame();
        App.play();
    }

    public static void play() {
        try (Scanner input = new Scanner(System.in)) {
            while (hangmanGame.getWrongGuessAmount() < hangmanGame.getMaxGuesses()) {
                System.out.println("Enter next guess: ");
                String str = input.next().toUpperCase();
                if (str.length() > 1) {
                    str = str.substring(0, 1);
                }
                hangmanGame.enterUserLetter(str);
                System.out.println("\n" + hangmanGame.wordToGuessContent());
                System.out.println("Already guessed letters: " + hangmanGame.getGuessedLetters().toString());
                if (hangmanGame.isWordFound()) {
                    System.out.println("\nYou win!");
                    break;
                } else {
                    System.out.println("\nTries remaining : " + (hangmanGame.getMaxGuesses() - hangmanGame.getWrongGuessAmount()));
                }
            }
            if (hangmanGame.getWrongGuessAmount() == hangmanGame.getMaxGuesses()) {
                System.out.println("\nYou lose!");
                System.out.println("The secret word was: " + hangmanGame.getWordToFind());
            }
        }
    }
}







