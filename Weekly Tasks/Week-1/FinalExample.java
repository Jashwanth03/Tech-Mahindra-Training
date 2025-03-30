public class FinalExample {
    final int finalVariable = 10;

    final void finalMethod() {
        System.out.println("This is a final method.");
    }

    public void display() {
        System.out.println("Final variable value: " + finalVariable);
    }
}

class Main {
    public static void main(String[] args) {
        FinalExample example = new FinalExample();
        example.display();
        example.finalMethod();
    }
}
