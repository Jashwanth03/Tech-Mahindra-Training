import java.util.ArrayList;
import java.util.Scanner;

public class Collectiondemo {
    public static void main(String[] args) {
        String id;
        String name;
        String email;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<iddemo> list1 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of students:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            id = sc.next();
            name = sc.next();
            email = sc.next();
            list.add(id+" "+name+" "+email);
            list1.add(new iddemo(id,name,email));
        }
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        for(iddemo s:list1){
            s.display();
        }
        sc.close();
    }
}
class iddemo{
    String roll;
    String name;
    String email;
    public iddemo(String roll, String name, String email) {
        this.roll = roll;
        this.name = name;
        this.email = email;
    }
    public void display(){
        System.out.println(roll+" "+name+" "+email);
    }
}

