
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionSet {

    public static void main(String[] args) {

        HashSet<Integer> hs = new HashSet<>();
        hs.add(19);
        hs.add(76);
        hs.add(49);
        hs.add(69);
        hs.add(63);
        hs.add(84);
        hs.add(92);
        hs.add(119);
        setSample(hs);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Hello1");
        lhs.add("World");
        lhs.add("Java");
        lhs.add("madhan");
        lhs.add("TechM1");
        lhs.add("Karthick");
        lhs.add("Snoop Dawg");
        setSample(lhs);

        TreeSet<Float> ts = new TreeSet<>();
        ts.add(13.4f);
        ts.add(24.8f);
        ts.add(58.2f);
        ts.add(11.6f);
        ts.add(41.6f);
        ts.add(72.8f);
        ts.add(19.4f);
        ts.add(11.3f);
        setSample(ts);

    }

    public static void setSample(HashSet<Integer> hs) {
        hs.remove(119);
        for (Integer i : hs) {
            if (i % 7 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void setSample(LinkedHashSet<String> lhs) {
        lhs.remove("madhan");
        for (String i : lhs) {
            if (i.length() > 5) {
                System.out.println(i);
            }
        }
    }

    public static void setSample(TreeSet<Float> ts) {
        ts.remove(19.4f);
        for (Float i : ts) {
            if (i > 20) {
                System.out.println(i);
            }
        }
    }

}
