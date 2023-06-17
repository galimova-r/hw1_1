module com.example.exam {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.exam to javafx.fxml;
    exports com.example.exam;
}