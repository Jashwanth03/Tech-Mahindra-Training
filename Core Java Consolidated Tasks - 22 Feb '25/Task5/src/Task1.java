// Write a Java program to create a basic Java thread that prints "Hello, Java!" when executed

public class Task1 {
    public static void main(String[] args) {
        new T1().start();
    }
}

class T1 extends Thread{
    @Override
    public void run() {
        System.out.println("Hello, Java!");
    }
}