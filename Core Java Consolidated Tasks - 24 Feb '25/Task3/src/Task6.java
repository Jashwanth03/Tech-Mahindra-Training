// Write a Java program to determine the last modified date of a file

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the file: ");
        String name = input.nextLine();

        File file = new File(name);
        if  (file.exists()) {
            long time = file.lastModified();
            DateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
            System.out.println("Date modified: " + sdf.format(time));
        }
    }
}
