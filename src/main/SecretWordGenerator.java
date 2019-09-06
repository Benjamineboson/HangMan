package model;

import java.util.Random;

public class SecretWordGenerator {
    public static String chooseSecretWord(){
        Random random = new Random();
        String [] wordList = {"Jazz","Cough","Evil","Paris","Programming","Flower","Apple","Table","Display","Bear"};
        String secretWord = wordList[random.nextInt(wordList.length)].toUpperCase();
        return secretWord;
    }
}
