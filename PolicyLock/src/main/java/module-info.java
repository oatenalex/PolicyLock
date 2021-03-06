module com.example.policylock {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires com.google.gson;
    requires org.json;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires xmlwise;

    opens com.example.policylock to javafx.fxml;
    exports com.example.policylock;
}