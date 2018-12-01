module cambeeler.view {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires cambeeler.controller;
    exports cambeeler.view to javafx.graphics;
    opens cambeeler.view to javafx.fxml;
}