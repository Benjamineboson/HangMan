package model;
public class HangMan {
    private int maxGuesses;
    private StringBuilder guessedLetters;
    private String wordToFind;
    private char[] wordToGuess;
    private int wrongGuessAmount;
    private StringBuilder letters;

    public HangMan(String wordToFind) {
        this.guessedLetters = new StringBuilder();
        this.wordToFind = wordToFind;
        this.wordToGuess = new char [0];
        this.letters = new StringBuilder();
        this.wrongGuessAmount = 1;
        this.maxGuesses = 8;
    }

    public int getMaxGuesses() {return maxGuesses;}

    public StringBuilder getGuessedLetters() {return guessedLetters;}

    public String getWordToFind() {return wordToFind;}

    public int getWrongGuessAmount() {return wrongGuessAmount;}

    public char[] getWordToGuess() {return wordToGuess;}

    public void newGame() {
     this.wordToGuess = new char[getWordToFind().length()];
        for (int i = 0; i < wordToGuess.length; i++) {
            wordToGuess[i] = '_';
        }
    }

    public boolean isWordFound() {return wordToFind.contentEquals(new String(wordToGuess));}

    public String wordToGuessContent() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordToGuess.length; i++) {
            sb.append(wordToGuess[i]);
           if (i < wordToGuess.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void enterUserLetter(String c) {
        if (!letters.toString().contains(c)) {
            if (wordToFind.contains(c)||wordToFind.equalsIgnoreCase(c)) {
                int index = wordToFind.indexOf(c);
                guessedLetters.append("[" + c + "]");
                while (index >= 0) {
                    wordToGuess[index] = c.charAt(0);
                    index = wordToFind.indexOf(c, index + 1);
                }
            } else {
                wrongGuessAmount++;
                guessedLetters.append("[" + c + "]");
            }
            letters.append(c);
        }
    }
}
