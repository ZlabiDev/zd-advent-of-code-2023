package dev.zlabi.day.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Link: https://adventofcode.com/2023/day/1
 * The right Solution was 55002!
 */
public class DayOneFirstSolution {

    public static void main(String[] args) throws IOException {
        System.out.println("Start day one");

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/day/one/input.txt"))) {
            int count = 0;
            String line = br.readLine();

            while (line != null) {
                Matcher matcherForStartValue = Pattern.compile("\\d").matcher(line);
                Matcher matcherForEndValue = Pattern.compile("\\d").matcher(new StringBuilder(line).reverse().toString());
                matcherForStartValue.find();
                matcherForEndValue.find();

                int numberOfLine = Integer.parseInt(matcherForStartValue.group() + matcherForEndValue.group());

                count += numberOfLine;

                line = br.readLine();
            }

            System.out.println("The count of all numbers are: " + count);
        }

    }
}
