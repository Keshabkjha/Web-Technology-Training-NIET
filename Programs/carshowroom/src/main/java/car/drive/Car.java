package car.drive;

public class Car {
    private Engine myengine;
    private Driver driver;
    private String brand;

    public Car(Engine myengine, Driver driver, String brand) {
        this.myengine = myengine;
        this.driver = driver;
        this.brand = brand;
    }
    @Override
    public String toString() {
        return "Car{" +
                "myengine=" + myengine +
                ", driver=" + driver +
                ", brand='" + brand + '\'' +
                '}';
    }

    public Engine getMyengine() {
        return myengine;

    }

    public void setMyengine(Engine myengine) {
        this.myengine = myengine;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void display(){
        System.out.println("Car details "+ brand);
        System.out.println("Engine details "+ myengine);
        System.out.println("Driver details "+ driver);
    }
}
