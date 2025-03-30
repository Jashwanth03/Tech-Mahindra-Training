// Write a Java program to get specific files with extensions from a specified folder

import java.io.File;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the folder you would like to read: ");
        String directory = input.nextLine();
        System.out.println("Please enter extension: ");
        String extension = input.nextLine();
        fileExtensions(directory, extension);
    }

    public static void fileExtensions(String directory,  String ext) {
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        int counter = 0;

        for  (File file : listOfFiles) {
            if (file.isFile()) {
                String name = file.getName();
                String extension = name.substring(name.lastIndexOf('.')+1);

                if  (extension.equalsIgnoreCase(ext)) {
                    System.out.println("Folder "+name+" has extension "+extension);
                    found = true;
                    counter++;
                }
            }
            else if (file.isDirectory()) {
                fileExtensions(file.getAbsolutePath(), ext);
            }
        }

        if (!found) {
            System.out.println("No such extension '"+ext+"' in "+directory);
        }
        else{
            System.out.println("Number of files in "+directory+" is with extension '"+ext+"' is "+counter);
        }
    }
}
