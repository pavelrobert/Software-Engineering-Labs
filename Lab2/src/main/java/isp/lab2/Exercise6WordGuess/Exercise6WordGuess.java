package isp.lab2.Exercise6WordGuess;
import java.util.Scanner;
import java.util.Random;

public class Exercise6WordGuess {

    /**
     * This method will return the number of occurrences of a character in a word
     * @param c
     * @param word
     * @return
     */
    public static int countOccurence(char c, char[] word) {
        int counter=0;
        for(int i=0;i<word.length;i++){
            if(word[i]==c)
                counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        String[] words ={"input", "kitchen", "entity","power", "analogy", "clouds", "mansion", "laptop", "screen","monitor","controller", "console", "mechanic"};
        int tries=0;
        Random r= new Random();
        String wordToGuess=words[r.nextInt(words.length)];
        String guessedWord="";
        for (int i = 0; i<wordToGuess.length(); i++) {
            guessedWord += "_";
        }
        String guessed_letters;
        Boolean guessed=false;
        Scanner scanner = new Scanner(System.in);
        while(!wordToGuess.equals(guessedWord)) {
            System.out.println("Enter a letter:");
            String input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("Please enter only one letter!");
                continue;
            }
            char guess = input.charAt(0);
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessed = true;
                    char[] guessedWordArray = guessedWord.toCharArray();
                    guessedWordArray[i] = guess;
                    guessedWord = String.valueOf(guessedWordArray);
                }
            }
            if (guessed) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }
            tries++;
            System.out.println("Guessed word: " + guessedWord);
        }
        System.out.println("Congratulations, you guessed the word \"" + wordToGuess + "\" in " + tries + " tries!");
    }
}





