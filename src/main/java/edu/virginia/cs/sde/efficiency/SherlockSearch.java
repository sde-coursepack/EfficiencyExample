package edu.virginia.cs.sde.efficiency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SherlockSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sherlock_holmes.txt"));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase you wish to search for: " );
        String target = "the";
        long startTime = System.currentTimeMillis();
        String message = "We are now searching for ";
        message += target;
        message += "\nPlease stand by while we search...";
        System.out.println(message);
        int currentLineNumber = 0;
        int count = 0;
        String results = "";
        for(String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            if (line.toLowerCase().contains(target)) {
                results += currentLineNumber + ", ";
                count++;
            }
            currentLineNumber++;
        }
        String endingMessage = "Thank you for waiting. Your query for: ";
        endingMessage += target;
        endingMessage += " returned ";
        endingMessage += count;
        endingMessage += " results:\n";
        endingMessage += "\t";
        endingMessage += results;
        endingMessage += "\n";
        System.out.println(endingMessage);

        long endingTime = System.currentTimeMillis();
        System.out.println("Your search took " + (endingTime - startTime) + " milliseconds");
    }
}
