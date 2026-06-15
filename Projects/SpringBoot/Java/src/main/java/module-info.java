module com.adm.java {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.adm.java to javafx.fxml;
    exports com.adm.java;
}