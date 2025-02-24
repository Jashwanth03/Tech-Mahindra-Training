import java.util.Scanner;

class NewDivide{
    public void divide(int dividend, int divisor){
        int quotient = 0;
        int remainder = dividend;
        while(remainder >= divisor){
            remainder = remainder - divisor;
            quotient++;
        }
        System.out.println("Quotient:" + quotient);
        System.out.println("Remainder:" + remainder);
    }
}

public class Divide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = sc.nextInt();
        System.out.println("Enter the second number");
        int b = sc.nextInt();
        NewDivide n = new NewDivide();
        n.divide(a, b);
    }
}
