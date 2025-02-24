// Task 5 : You are required to create a string and captialize every alternative character. for

import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string: ");
        StringBuilder sb = new StringBuilder(input.nextLine());

        for (int i = 0; i < sb.length(); i+=2) {
            String ch = sb.charAt(i)+"";

            if (Character.isDigit(ch.charAt(0))){
                continue;
            }

            sb.setCharAt(i,ch.toUpperCase().charAt(0));
        }

        System.out.println(sb);
    }
}
