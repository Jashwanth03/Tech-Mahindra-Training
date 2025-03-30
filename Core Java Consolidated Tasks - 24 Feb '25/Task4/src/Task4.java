// Write a Java program that reads a list of numbers from a file and throws an exception if any of the numbers are positive

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task4 {

    // Custom exception for positive numbers
    static class PositiveNumberException extends Exception {
        public PositiveNumberException(String message) {
            super(message);
        }
    }

    // Method to read numbers from a file and check for positives
    public static void readNumbersFromFile(String filePath) throws FileNotFoundException, PositiveNumberException {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundException("Error: File not found at path: " + filePath);
        }

        // Reading numbers from file
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Reading numbers from file:");

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    System.out.println(number);

                    // Throw an exception if a positive number is found
                    if (number > 0) {
                        throw new PositiveNumberException("Error: Found a positive number: " + number);
                    }
                } else {
                    scanner.next(); // Skip non-integer values
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file path from user
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        try {
            readNumbersFromFile(filePath);
            System.out.println("All numbers in the file are negative or zero.");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (PositiveNumberException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
