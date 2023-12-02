package dev.zlabi.day.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Link: https://adventofcode.com/2023/day/1
 * The right Solution was 55093!
 */
public class DayOneSecondSolution {

    public static void main(String[] args) throws IOException {
        System.out.println("Start day one part two");

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/day/one/input.txt"))) {
            int count = 0;
            String line = br.readLine();

            while (line != null) {
                count += extractNumber(line);

                line = br.readLine();
            }

            System.out.println("The count of all numbers are: " + count);
        }
    }

    public static int extractNumber(String input) {
        Map<String, Integer> wordToNumber = createWordToNumberMap();

        StringBuilder digits = new StringBuilder();

        // Regex for matching Digits and Numbers
        Pattern pattern = Pattern.compile("(?:\\d+|oneight|twone|eightwo|one|two|three|four|five|six|seven|eight|nine)");
        Matcher matcher = pattern.matcher(input);

        // Appending Digit or String's corresponding Digit
        while (matcher.find()) {
            String match = matcher.group().toLowerCase();
            if (Character.isDigit(match.charAt(0))) {
                digits.append(match);
            } else {
                digits.append(wordToNumber.get(match));
            }
        }

        String number = "";
        number += digits.charAt(0);
        number += digits.charAt(digits.length() - 1);

        return Integer.parseInt(number);
    }

    private static Map<String, Integer> createWordToNumberMap() {
        Map<String, Integer> wordToNumber = new HashMap<>();

        wordToNumber.put("one", 1);
        wordToNumber.put("two", 2);
        wordToNumber.put("three", 3);
        wordToNumber.put("four", 4);
        wordToNumber.put("five", 5);
        wordToNumber.put("six", 6);
        wordToNumber.put("seven", 7);
        wordToNumber.put("eight", 8);
        wordToNumber.put("nine", 9);
        wordToNumber.put("oneight", 18);
        wordToNumber.put("twone", 21);
        wordToNumber.put("eightwo", 82);

        return wordToNumber;
    }
}
