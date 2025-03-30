import java.util.*;
import java.io.*;
public class Javaio3 {
    static void getInputUsingBufferedReaderClass() throws IOException
    {
        // Enter data using BufferReader
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter the input for Bufferreader:");
        // Reading data using readLine
        String s = r.readLine();

        // Printing the read line
        System.out.println("The given input:"+s);
    }
    static void getInputUsingScannerClass()
    {
        // Using Scanner for Getting Input from User
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the input as string :");
        String s1 = s.nextLine();
        System.out.println("You entered string " + s1);

        System.out.println("Enter the input as integer :");
        int a = s.nextInt();
        System.out.println("You entered integer " + a);

        System.out.println("Enter the input as float :");
        float b = s.nextFloat();
        System.out.println("You entered float " + b);
    }

    public static void main(String[] args) {
        try {
            getInputUsingBufferedReaderClass();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getInputUsingScannerClass();
    }
}
