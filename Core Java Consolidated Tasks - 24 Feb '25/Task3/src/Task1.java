// Write a Java program to get a list of all file/directory names in the given directory

import java.io.File;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner in = new  Scanner(System.in);

        System.out.println("Enter directory of the folder: ");
        String directory = in.nextLine();

        fileRead(directory);
    }

    public static void fileRead(String directory){
        File folder = new File(directory);

        if (folder.isDirectory()) {
            System.out.println("\nInside main directory: "+folder.getName());
            File[] f = folder.listFiles();

            for (File file : f) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
                else if (file.isDirectory()) {
                    System.out.println("\nInside the directory " + file.getName());
                    fileRead(file.getAbsolutePath());
                }
            }
        }
        else if (folder.isFile()) {
            System.out.println("The file is "+folder.getName());
        }
    }
}

