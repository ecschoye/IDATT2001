module Cardgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens edu.ntnu.idatt2001.cardgame to javafx.fxml;
    exports edu.ntnu.idatt2001.cardgame;
}