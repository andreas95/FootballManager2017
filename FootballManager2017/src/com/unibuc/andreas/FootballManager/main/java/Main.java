package com.unibuc.andreas.FootballManager.main.java;

import com.unibuc.andreas.FootballManager.main.java.common.Shared;
import com.unibuc.andreas.FootballManager.main.java.common.StageManager;
import com.unibuc.andreas.FootballManager.main.java.database.ConnectToDatabase;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author andreas antone
 * Created by antoneandreas on 5/22/17.
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // set application version
        Shared.version="Football Manager 2017.1.0";

        //set application name
        primaryStage.setTitle("Football Manager 2017");

        //size properties
        primaryStage.setMinWidth(1430);
        primaryStage.setMinHeight(827);

        //connect to database
        new ConnectToDatabase();

        //set stage
        new StageManager(primaryStage);

        //set application icon
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/unibuc/andreas/FootballManager/main/resources/images/icons/app.png")));
    }

    public static void main(String[] args) {
        launch(args);
    }
}