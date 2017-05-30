package com.unibuc.andreas.FootballManager.main.java.common;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by antoneandreas on 5/22/17.
 */
public class ScreenController {

    private static List<Screen> openedScreens = new ArrayList<Screen>();

    public static enum Screen {
        APPLICATION
    }

    public ScreenController() {}

    public static void onBack() {
        if (openedScreens.size() > 0) {
            openedScreens.remove(openedScreens.size() - 1);
            try {
                ScreenController.setScreen(ScreenController.openedScreens.get(openedScreens.size() - 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setScreen(Screen screen) throws IOException {
        switch (screen) {
            case APPLICATION:
                StageManager.setRoot(FXMLLoader.load(ScreenController.class.getResource("../layout/Application.fxml")));
                Shared.screen= Screen.APPLICATION;
                openedScreens.add(Screen.APPLICATION);
                break;
            default:
                break;
        }
    }
}
