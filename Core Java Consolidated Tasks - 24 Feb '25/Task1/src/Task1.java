// Task 1 : Write a Java program to copy the alternative elements in the array.

public class Task1 {


    public static void altElArr(int[] x) {
        int[] a1;
        a1 = x;
        int newSize = (a1.length + 1) / 2;
        int[] a2= new int[newSize];
        int j = 0;
        for (int i = 0; i < a1.length; i+=2) {
            a2[j] = a1[i];
            j++;
        }

        System.out.println("Array elements are: ");
        for (int k : a2) {
            System.out.print(k + "-->");
        }
    }

    public static void main(String[] args) {
        altElArr(new int[]{25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 460});
    }
}
