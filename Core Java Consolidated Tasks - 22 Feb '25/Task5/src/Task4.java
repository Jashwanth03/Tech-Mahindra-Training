// Write a Java program that performs matrix multiplication using multiple threads

import java.util.Arrays;

class MatrixMultiplicationThread extends Thread {
    private final int[][] matrixA;
    private final int[][] matrixB;
    private final int[][] result;
    private final int row;

    public MatrixMultiplicationThread(int[][] matrixA, int[][] matrixB, int[][] result, int row) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.row = row;
    }

    @Override
    public void run() {
        int columnsB = matrixB[0].length;
        int columnsA = matrixA[0].length;

        for (int j = 0; j < columnsB; j++) {
            result[row][j] = 0;
            for (int k = 0; k < columnsA; k++) {
                result[row][j] += matrixA[row][k] * matrixB[k][j];
            }
        }
    }
}

public class Task4 {
    public static void main(String[] args) {
        // Define matrices
        int[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrixB = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        int rowsA = matrixA.length;
        int columnsB = matrixB[0].length;
        int[][] result = new int[rowsA][columnsB];

        // Create and start threads
        Thread[] threads = new Thread[rowsA];
        for (int i = 0; i < rowsA; i++) {
            threads[i] = new MatrixMultiplicationThread(matrixA, matrixB, result, i);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < rowsA; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the result matrix
        System.out.println("Resultant Matrix:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
