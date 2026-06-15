package car.drive;

public class Engine {
    private String type;
    private String model;
    public Engine(String type, String model) {
        this.type = type;
        this.model = model;

    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
