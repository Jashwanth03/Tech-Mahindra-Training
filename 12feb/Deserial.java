
import java.io.*;

public class Deserial {

    public static void main(String[] args) {
        try {
            // Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
            Student s = (Student) in.readObject();
            // printing the data of the serialized object
            System.out.println(s.rno + " " + s.name);
            // closing the stream
            in.close();
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
