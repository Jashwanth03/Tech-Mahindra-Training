// Write a Java program to check if a file or directory has read and write permissions

import java.io.File;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the file/folder :" );
        String name = input.nextLine();

        int val = checkPermission(name);

        if (val == -1){
            System.out.println("File not found!");
        }

        else if (val == 0) {
            System.out.println("No permissions for file!");
        }

        else if (val == 1) {
            System.out.println("Read only file");
        }

        else if (val == 2) {
            System.out.println("Read and write permissions");
        }

        else if (val == 3) {
            System.out.println("Read, write and execute permissions");
        }
    }

    public static int checkPermission(String location){
        int flag = 0;

        File f = new File(location);

        if (!f.exists()){
            return -1;
        }
        else{
            if (f.canRead()){
                flag = 1;

                if (f.canWrite()){
                    flag = 2;

                    if  (f.canExecute()){
                        flag = 3;
                    }
                }
            }
        }

        return  flag;
    }
}
