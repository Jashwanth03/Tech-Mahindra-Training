// Task 4 : Use ArrayCopyRange() function to demonstrate and example such that you copy the range of values in an array.

import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) {

        // Original array
        int[] arr1 = {10, 20, 30, 40,};

        // Copy elements from index 1 to 3 (exclusive)
        int[] arr2 = Arrays.copyOfRange(arr1, 1, 3);

        System.out.println("Copied Array: " + Arrays.toString(arr2));
    }
}
