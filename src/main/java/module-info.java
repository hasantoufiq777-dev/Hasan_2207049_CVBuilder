module com.example.cvbuilder {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.cvbuilder to javafx.fxml;
    exports com.example.cvbuilder;
}
