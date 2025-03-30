// Write a Java program that calculates the sum of all prime numbers up to a given limit using multiple threads

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PrimeSumThread extends Thread {
    private final int start, end;
    private long sum = 0;

    public PrimeSumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
    }

    public long getSum() {
        return sum;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get upper limit from user
        System.out.print("Enter the upper limit: ");
        int limit = scanner.nextInt();

        int numThreads = 4; // Number of threads to use
        List<PrimeSumThread> threads = new ArrayList<>();
        int rangeSize = limit / numThreads;

        // Create and start threads
        for (int i = 0; i < numThreads; i++) {
            int start = i * rangeSize + 1;
            int end = (i == numThreads - 1) ? limit : (i + 1) * rangeSize;

            PrimeSumThread thread = new PrimeSumThread(start, end);
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to complete and sum up results
        long totalSum = 0;
        for (PrimeSumThread thread : threads) {
            try {
                thread.join();
                totalSum += thread.getSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum of all prime numbers up to " + limit + " is: " + totalSum);
        scanner.close();
    }
}

