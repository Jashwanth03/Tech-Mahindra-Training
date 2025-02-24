class Car{
    private String make;
    private String model;
    private int year;
    Car(String make,String model,int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }
    public void startEngine(){
        System.out.println("Car has been developed");
    }
}

class ElectricCar extends Car{
    private int battery;
    public ElectricCar(String make,String model,int year,int battery){
        super(make,model,year);
        this.battery = battery;
    }
    public void startEngine(){
        System.out.println("Electric Car has been developed");
    }
}
public class Oops {
    public static void main(String[] args) {

        Car[] car = {new Car("Mahindra", "Mahindra", 2024), new ElectricCar("Mahindra EV","Mahindra",2025,300)};
        for(Car c : car){
            c.startEngine();
        }

    }
}

