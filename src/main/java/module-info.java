module com.dema.demarzocalcolatrice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dema.demarzocalcolatrice to javafx.fxml;
    exports com.dema.demarzocalcolatrice;
}