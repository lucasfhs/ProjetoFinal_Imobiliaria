module com.jotaproperties {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    exports com.jotaproperties.app;
    opens com.jotaproperties.controller to javafx.fxml;
}
