// Write a Java program that sorts an array of integers using multiple threads

import java.util.Arrays;

class MergeSortMultiThreaded {
    private int[] array;

    public MergeSortMultiThreaded(int[] array) {
        this.array = array;
    }

    public void sort() {
        if (array.length > 1) {
            int mid = array.length / 2;

            // Split the array into two halves
            int[] leftArray = Arrays.copyOfRange(array, 0, mid);
            int[] rightArray = Arrays.copyOfRange(array, mid, array.length);

            // Create threads to sort each half
            Thread leftThread = new Thread(() -> new MergeSortMultiThreaded(leftArray).sort());
            Thread rightThread = new Thread(() -> new MergeSortMultiThreaded(rightArray).sort());

            leftThread.start();
            rightThread.start();

            try {
                leftThread.join();  // Wait for left half to finish
                rightThread.join(); // Wait for right half to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Merge the sorted halves
            merge(leftArray, rightArray);
        }
    }

    private void merge(int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    public int[] getSortedArray() {
        return array;
    }
}

public class Task3 {
    public static void main(String[] args) {
        int[] numbers = {12, 34, 5, 78, 23, 56, 1, 89, 17, 45};

        System.out.println("Original Array: " + Arrays.toString(numbers));

        MergeSortMultiThreaded sorter = new MergeSortMultiThreaded(numbers);
        sorter.sort();

        System.out.println("Sorted Array: " + Arrays.toString(sorter.getSortedArray()));
    }
}
