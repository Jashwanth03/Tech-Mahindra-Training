import java.io.File;
import java.util.Scanner;

public class Task8 {
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
            // Get file size in bytes
            long fileSizeInBytes = file.length();

            // Convert file size to KB and MB
            double fileSizeInKB = fileSizeInBytes / 1024.0;
            double fileSizeInMB = fileSizeInKB / 1024.0;

            // Display file sizes
            System.out.println("File size: ");
            System.out.println(fileSizeInBytes + " Bytes");
            System.out.println(String.format("%.2f KB", fileSizeInKB));
            System.out.println(String.format("%.2f MB", fileSizeInMB));
        }

        scanner.close();
    }
}
