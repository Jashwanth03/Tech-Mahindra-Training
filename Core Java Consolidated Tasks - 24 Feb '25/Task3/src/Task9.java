import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file path from user
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        // Create a File object
        File file = new File(filePath);

        // Check if the file exists
        if (!file.exists() || !file.isFile()) {
            System.out.println("The specified file does not exist or is not a valid file.");
        } else {
            try {
                // Read file into byte array
                byte[] fileBytes = readFileToByteArray(file);

                // Display byte array length
                System.out.println("File read successfully. Byte array length: " + fileBytes.length);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Method to read file contents into a byte array
    private static byte[] readFileToByteArray(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] byteArray = new byte[(int) file.length()];
        fis.read(byteArray);
        fis.close();
        return byteArray;
    }
}
