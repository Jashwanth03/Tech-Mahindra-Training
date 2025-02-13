
import java.io.*;

public class Serial {

    public static void main(String[] args) throws IOException {
        try {
            // Creating the object
            Student s1 = new Student(420, "madhan");
            // Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("f.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            // closing the stream
            out.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Student implements Serializable {

    int rno;
    String name;

    Student(int rno, String name) {
        this.rno = rno;
        this.name = name;
    }

}
