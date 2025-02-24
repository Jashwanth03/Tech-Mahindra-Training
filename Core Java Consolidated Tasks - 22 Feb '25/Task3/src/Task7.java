import java.io.Console;

public class Task7 {
    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            System.out.println("No console available.");
            return;
        }

        // Read user input from console
        String input = console.readLine("Enter some text: ");
        System.out.println("You entered: " + input);
    }
}
