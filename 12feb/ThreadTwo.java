
public class ThreadTwo {

    public static void main(String[] args) {
        JTask1 t1 = new JTask1();
        JTask1 t2 = new JTask1();

        t1.start();
        t2.start();
        t1.run();
    }
}

class JTask1 extends Thread {

    public void run() {
        System.out.println("From ThreadTwo!" + this.getName());
        System.out.println("From ThreadTwo!" + this.getName());
        System.out.println(10 / 0);
    }
}
