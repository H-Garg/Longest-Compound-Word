import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static Set<String> wordsSet = new HashSet<>();
    private static String longestCompoundedWord = "";
    private static String secondLongestCompoundedWord = "";

    public static void main(String[] args) {
        String inputFile = "Input_02.txt"; // Change this to "Input_01.txt" for the larger input file

        long startTime = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Assuming the words are alphabetically sorted and in lowercase
                wordsSet.add(line);
            }

            findLongestCompoundedWord();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to process file " + inputFile + ": " + (endTime - startTime) + " milliseconds");
    }

    private static void findLongestCompoundedWord() {
        for (String word : wordsSet) {
            if (isCompoundWord(word, true)) {
                if (word.length() > longestCompoundedWord.length()) {
                    secondLongestCompoundedWord = longestCompoundedWord;
                    longestCompoundedWord = word;
                } else if (word.length() > secondLongestCompoundedWord.length()) {
                    secondLongestCompoundedWord = word;
                }
            }
        }

        System.out.println("Longest Compound Word: " + longestCompoundedWord);
        System.out.println("Second Longest Compound Word: " + secondLongestCompoundedWord);
    }

    private static boolean isCompoundWord(String word, boolean original) {
        if (word.isEmpty()) {
            return !original;
        }

        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordsSet.contains(prefix) && isCompoundWord(suffix, false)) {
                return true;
            }
        }

        return false;
    }
}
