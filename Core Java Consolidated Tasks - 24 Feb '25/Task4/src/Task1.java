// Write a Java program that throws an exception and catch it using a try-catch block.

public class Task1 {
    public static void main(String[] args) {

        try {
            int x;
            x = 3/0;
        }
        catch (ArithmeticException e) {
            System.out.println("Division by zero is not invented in maths yet!");
        }
    }
}
