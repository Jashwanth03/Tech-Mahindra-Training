// Write a Java program that reads a file and throws an exception if the file is empty

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task5 {

    // Custom exception for an empty file
    static class EmptyFileException extends Exception {
        public EmptyFileException(String message) {
            super(message);
        }
    }

    // Method to read a file and check if it is empty
    public static void readFile(String filePath) throws FileNotFoundException, EmptyFileException {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundException("Error: File not found at path: " + filePath);
        }

        // Check if the file is empty
        if (file.length() == 0) {
            throw new EmptyFileException("Error: The file is empty!");
        }

        // Reading file content
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("File content:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file path from user
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        try {
            readFile(filePath);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyFileException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
