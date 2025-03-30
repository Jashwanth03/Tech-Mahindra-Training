
public class ThreadOne {

    public static void main(String[] args) {
        Jtask1 jt1 = new Jtask1();
        jt1.start();

        Thread tt1 = new Thread(jt1);
        tt1.start();
    }

}

class Jtask1 extends Thread {

    public void run() {
        System.out.println("From Thread One " + this.getName());
        System.out.println("From Thread One " + this.getName());
        System.out.println("From Thread One " + this.getName());
    }
}
