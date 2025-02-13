abstract class AbstractDemo {
    abstract void abstractMethod();
}

class ConcreteDemo extends AbstractDemo{
    @Override
    void abstractMethod() {
        System.out.println("HI");
    }

    public static void main(String[] args) {
        AbstractDemo obj = new ConcreteDemo();
        obj.abstractMethod();
    }
}