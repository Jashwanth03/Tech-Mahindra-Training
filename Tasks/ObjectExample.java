// Demonstrating Object class methods
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return age == user.age && name.equals(user.name);
    }
}

class SecondUser {
    private String name;
    private int age;

    public SecondUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ObjectExample {
    public static void main(String[] args) {
        User user1 = new User("Alice", 25);
        User user2 = new User("Alice", 25);
        SecondUser secondUser1 = new SecondUser("Alice", 25);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(secondUser1)); // Not the same class, will return false
    }
}
