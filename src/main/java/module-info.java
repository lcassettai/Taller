module Controlador {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens Controlador to javafx.fxml;
    exports Controlador;
}
