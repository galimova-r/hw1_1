module com.example.appex {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.appex to javafx.fxml;
    exports com.example.appex;
}