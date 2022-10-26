module Wargames {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.ntnu.idatt2001.ecschoye.gui to javafx.fxml;
    exports edu.ntnu.idatt2001.ecschoye.gui;

    opens edu.ntnu.idatt2001.ecschoye.gui.controllers to javafx.fxml;
    opens edu.ntnu.idatt2001.ecschoye.gui.models to javafx.fxml;
    exports edu.ntnu.idatt2001.ecschoye.gui.models;
    exports edu.ntnu.idatt2001.ecschoye.battle;
    exports edu.ntnu.idatt2001.ecschoye.gui.application;
    exports edu.ntnu.idatt2001.ecschoye.terrain;
    exports edu.ntnu.idatt2001.ecschoye.units;
    opens edu.ntnu.idatt2001.ecschoye.gui.application to javafx.fxml;

}