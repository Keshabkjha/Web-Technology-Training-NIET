package car.drive;


public class Driver {
    private String dr_name;
    private String dr_lic;
    private Driver(String dr_name, String dr_lic) {
        super();
        this.dr_name = dr_name;
        this.dr_lic = dr_lic;

    }

    @Override
    public String toString() {
        return "Driver{" +
                "dr_name='" + dr_name + '\'' +
                ", dr_lic='" + dr_lic + '\'' +
                '}';
    }

    public String getDr_name() {
        return dr_name;
    }

    public void setDr_name(String dr_name) {
        this.dr_name = dr_name;
    }

    public String getDr_lic() {
        return dr_lic;
    }

    public void setDr_lic(String dr_lic) {
        this.dr_lic = dr_lic;
    }
}

