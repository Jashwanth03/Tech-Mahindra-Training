// Write a Java program to check if a file or directory specified by pathname exists or not

import java.io.File;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the folder or file name: ");
        String name = input.nextLine();

        if (checkExists(name)) {
            System.out.println("It does exist in your computer!");
        }
        else {
            System.out.println("It does NOT exist in your computer!");
        }
    }

    public static boolean checkExists(String location){
        boolean found = false;
        File f = new File(location);

        if (f.exists()) {
            found = true;
        }

        return found;
    }
}
