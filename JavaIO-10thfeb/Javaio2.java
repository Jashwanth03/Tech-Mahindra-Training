public class Javaio2 {
    public static void sop(String s) {
        System.out.print(s);
    }
    public static void sopln(String s) {
        System.out.println(s);
    }
    public void soerr(String s) {
        System.err.print(s);
    }
    public static void main(String[] args) {
        Javaio2 j = new Javaio2();
        j.soerr("This is an error message using print().\n");
        j.soerr("This is another error message using println().\n");
        sop("Hello ");
        sop("Java");
        sopln("Hello");
        sopln("World");
        sopln("User");
    }
}
