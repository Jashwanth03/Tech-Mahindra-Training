
public class Multi {

    public static void main(String[] args) {//Thread 1
        System.out.println("From Main thread!");
        System.out.println("From Main thread!");
        System.out.println("From Main thread!");
        Jtask1 t1 = new Jtask1();
        t1.start();//calls run method-Thread 2
        //t1.run();
        Jtask2 t2 = new Jtask2();
        Thread tt2 = new Thread(t2);
        new Thread(t2).start();//Thread 3
        tt2.start();//Thread 4
        t2.run();

        System.out.println(10 / 0);

    }
}

class Jtask1 extends Thread {

    public void run() {
        System.out.println("From Jtask1!" + this.getName());
        // System.out.println(10/0);
    }
}

class Jtask2 implements Runnable {

    public void run() {
        //System.out.println("From Thread2!");
        System.out.println(10 / 0);
    }
}
