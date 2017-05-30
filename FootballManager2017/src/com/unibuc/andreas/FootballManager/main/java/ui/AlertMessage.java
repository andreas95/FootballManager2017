package com.unibuc.andreas.FootballManager.main.java.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

import java.util.Optional;

import static javafx.scene.control.Alert.AlertType;

/**
 * @author andreas antone
 * Created by Andreas on 6/14/16.
 */
public class AlertMessage {

    public AlertMessage(String title, String content, AlertType type) {
        Alert alert = new Alert(type,content);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle(title);
        alert.showAndWait();
    }

    public static boolean AlertMessageConfirmation(String title, String content) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            return true;
        } else {
            return false;
        }
    }
}
