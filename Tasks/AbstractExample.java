abstract class Animal {
        abstract void makeSound();
    }

    class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Dog is barking");
        }
    }

    public class AbstractExample {
        public static void main(String[] args) {
            Dog dog = new Dog();
            dog.makeSound();
        }
}
