// Write a Java program to create a method that reads a file and throws an exception if the file is not found

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task3 {

    // Method to read a file and throw an exception if not found
    public static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundException("Error: File not found at path: " + filePath);
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
        }

        scanner.close();
    }
}
