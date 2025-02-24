class EvenNumbersThread extends Thread {
    public void run() {
        System.out.println("Even Numbers:");
        for (int i = 2; i <= 20; i += 2) {
            System.out.println("T1: "+i);
            try {
                Thread.sleep(500); // Pause to simulate processing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddNumbersThread extends Thread {
    public void run() {
        System.out.println("Odd Numbers:");
        for (int i = 1; i <= 20; i += 2) {
            System.out.println("T2: "+i);
            try {
                Thread.sleep(500); // Pause to simulate processing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        EvenNumbersThread evenThread = new EvenNumbersThread();
        OddNumbersThread oddThread = new OddNumbersThread();

        evenThread.start();
        oddThread.start();
    }
}
