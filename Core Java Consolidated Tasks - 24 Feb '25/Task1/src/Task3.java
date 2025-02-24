//Task 3 : Demonstrate with an example with the difference between equals() vs deepEquals() method?

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {

        // three 2D integer arrays for comparison
        int[][] arr1 = { {1, 2}, {3, 4} };
        int[][] arr2 = { {1, 2}, {3, 4} };
        int[][] arr3 = { {5, 6}, {7, 8} };


        System.out.println("Deep equals comparison");
        // Compare arr1 and arr2
        System.out.println("arr1 equals with arr2: " + Arrays.deepEquals(arr1, arr2));

        // Compare arr2 and arr3
        System.out.println("arr2 equals with arr3: " + Arrays.deepEquals(arr2, arr3));

        System.out.println("Equals comparison");
        // Compare arr1 and arr2
        System.out.println("arr1 equals with arr2: " + Arrays.equals(arr1, arr2));

        // Compare arr2 and arr3
        System.out.println("arr2 equals with arr3: " + Arrays.equals(arr2, arr3));
    }

}
