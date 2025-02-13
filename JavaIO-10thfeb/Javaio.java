public class Javaio {

    public void sop(String s) {
        System.out.print(s);
    }
public void sopln(String s) {
        System.out.println(s);
    }
    public void soerr(String s) {
        System.err.print(s);
    }
    public static void main(String[] args) {
        Javaio j = new Javaio();
        j.sop("Hello ");
        j.sop("Java");
        j.sopln("Hello");
        j.sopln("World");
        j.sopln("User");
        j.soerr("This is an error message using print().\n");
        j.soerr("This is another error message using println().");
    }
}
