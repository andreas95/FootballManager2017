package com.unibuc.andreas.FootballManager.main.java.common;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Created by antoneandreas on 5/22/17.
 */

public class StageManager {

    private static Stage stage;
    private static AnchorPane pane;

    public StageManager(Stage stage) throws IOException {
        StageManager.stage=stage;
        Parent root;
        root = FXMLLoader.load(ScreenController.class.getResource("/com/unibuc/andreas/FootballManager/main/java/view/ApplicationView.fxml"));
        Scene s=new Scene(root);
        s.setFill(Color.TRANSPARENT);
        stage.setScene(s);
        stage.show();
    }

    public static Stage getStage() {return stage;}
    public static void setRoot(Parent root) {StageManager.stage.getScene().setRoot(root);}
    public static void setPane(AnchorPane pane) {StageManager.pane=pane;}
    public static void setPaneFragment(Parent root) {
        StageManager.pane.getChildren().setAll(root);
    }
}
