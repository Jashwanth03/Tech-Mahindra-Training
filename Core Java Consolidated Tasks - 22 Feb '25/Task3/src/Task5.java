// Write a Java program to check if the given pathname is a directory or a file

import java.io.File;
import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the file / folder: ");
        File folder = new File(input.nextLine());

        if  (folder.exists()){
            if (folder.isDirectory()){
                System.out.println("It is a folder!");
            }
            else{
                System.out.println("It is a file!");
            }
        }
    }
}
