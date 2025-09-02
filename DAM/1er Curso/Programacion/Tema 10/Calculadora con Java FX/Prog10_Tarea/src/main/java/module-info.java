module com.mycompany.prog10_tarea {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.base;

    opens Prog10 to javafx.fxml;
    exports Prog10;
}
