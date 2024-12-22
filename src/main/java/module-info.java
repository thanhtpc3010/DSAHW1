module com.example.dsahw1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.dsahw1 to javafx.fxml;
    exports com.example.dsahw1;
}