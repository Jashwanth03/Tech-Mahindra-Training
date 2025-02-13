
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class CollectionThread {

    public static void main(String[] args) throws InterruptedException {
        CollectionArray ca = new CollectionArray();
        CollectionLinked cl = new CollectionLinked();
        CollectionVector cv = new CollectionVector();
        CollectionStack cs = new CollectionStack();

        ca.start();
        ca.join();

        cl.start();
        cl.join();

        cv.start();
        cv.join();

        cs.start();
        cs.join();

    }

}

class CollectionArray extends Thread {

    public void run() {
        List<Integer> l1 = new ArrayList<>();
        l1.add(69);
        l1.add(420);
        l1.add(03);
        l1.add(123);

        System.out.println("Number of elements in the list: " + l1.size());
        //Adding one element
        l1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :" + l1);
        System.out.println("The number of elements in the list: " + l1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:" + l1.contains(566));
        System.out.println("The given list before removing elements is :" + l1);

        l1.remove(2);//Removing element by its index
        l1.remove(3);//Removing element by its index
        System.out.println("After removing elements:");
        System.out.println("The given list is :" + l1);
    }
}

class CollectionLinked extends Thread {

    public void run() {
        List<Integer> l1 = new LinkedList<>();
        l1.add(6);
        l1.add(4);
        l1.add(5);
        l1.add(12);

        System.out.println("Number of elements in the list: " + l1.size());
        //Adding one element
        l1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :" + l1);
        System.out.println("The number of elements in the list: " + l1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:" + l1.contains(566));
        System.out.println("The given list before removing elements is :" + l1);

        l1.remove(2);//Removing element by its index
        l1.remove(3);//Removing element by its index
        System.out.println("After removing elements:");
        System.out.println("The given list is :" + l1);
    }
}

class CollectionVector extends Thread {

    public void run() {
        List<Integer> l1 = new Vector<>();
        l1.add(9);
        l1.add(42);
        l1.add(36);
        l1.add(13);

        System.out.println("Number of elements in the list: " + l1.size());
        //Adding one element
        l1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :" + l1);
        System.out.println("The number of elements in the list: " + l1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:" + l1.contains(566));
        System.out.println("The given list before removing elements is :" + l1);

        l1.remove(2);//Removing element by its index
        l1.remove(3);//Removing element by its index
        System.out.println("After removing elements:");
        System.out.println("The given list is :" + l1);
    }
}

class CollectionStack extends Thread {

    public void run() {
        List<Integer> l1 = new Stack<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);

        System.out.println("Number of elements in the list: " + l1.size());
        //Adding one element
        l1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :" + l1);
        System.out.println("The number of elements in the list: " + l1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:" + l1.contains(566));
        System.out.println("The given list before removing elements is :" + l1);

        l1.remove(2);//Removing element by its index
        l1.remove(3);//Removing element by its index
        System.out.println("After removing elements:");
        System.out.println("The given list is :" + l1);
    }
}
