// Write a Java program to create a method that takes an integer as a parameter and throws an exception if the number is odd

public class Task2 {

    public static void vals(int x){
        if (x%2 != 0){
            try {
                throw new Exception("This is an odd number lol!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Even number yay!");
        }
    }

    public static void main(String[] args) {
        vals(5);
        vals(8);
    }
}
