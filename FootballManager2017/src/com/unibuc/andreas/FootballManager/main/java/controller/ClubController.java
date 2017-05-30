package com.unibuc.andreas.FootballManager.main.java.controller;

import com.unibuc.andreas.FootballManager.main.java.common.Shared;
import com.unibuc.andreas.FootballManager.main.java.common.StageManager;
import com.unibuc.andreas.FootballManager.main.java.common.Utils;
import com.unibuc.andreas.FootballManager.main.java.database.ClubDatabase;
import com.unibuc.andreas.FootballManager.main.java.model.Club;
import com.unibuc.andreas.FootballManager.main.java.ui.AlertMessage;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import org.controlsfx.control.textfield.TextFields;


/**
 * @author andreas antone
 *  by antoneandreas on 5/22/17.
 */
public class ClubController {

    @FXML
    private TableView TableClubs;
    @FXML
    private TableColumn ColumnName;
    @FXML
    private TableColumn ColumnCountry;
    @FXML
    private TableColumn ColumnAction;
    @FXML
    private TableColumn ColumnMP;
    @FXML
    private TableColumn ColumnW;
    @FXML
    private TableColumn ColumnL;
    @FXML
    private TableColumn ColumnD;
    @FXML
    private TableColumn ColumnGA;
    @FXML
    private TableColumn ColumnGD;
    @FXML
    private TableColumn ColumnGF;
    @FXML
    private TableColumn ColumnPTS;
    @FXML
    private TextField ClubName;
    @FXML
    private TextField ClubCountry;
    @FXML
    private Button Save;
    @FXML
    private TextField Search;
    @FXML
    private TextField ClubGD;
    @FXML
    private TextField ClubGA;
    @FXML
    private TextField ClubD;
    @FXML
    private TextField ClubW;
    @FXML
    private TextField ClubL;
    @FXML
    private TextField ClubPTS;
    @FXML
    private Line LineTable;
    private ObservableList<Club> listClubs;


    public void initialize() {
        ColumnName.impl_setReorderable(false);
        ColumnCountry.impl_setReorderable(false);
        ColumnAction.impl_setReorderable(false);
        ColumnMP.impl_setReorderable(false);
        ColumnW.impl_setReorderable(false);
        ColumnD.impl_setReorderable(false);
        ColumnL.impl_setReorderable(false);
        ColumnGD.impl_setReorderable(false);
        ColumnGF.impl_setReorderable(false);
        ColumnGA.impl_setReorderable(false);
        ColumnPTS.impl_setReorderable(false);

        TableClubs.prefHeightProperty().bind(Bindings.size(TableClubs.getItems()).multiply(TableClubs.getFixedCellSize()).add(50));
        ColumnName.setCellValueFactory(new PropertyValueFactory<Club, String>("name"));
        ColumnCountry.setCellValueFactory(new PropertyValueFactory<Club, String>("country"));
        ColumnMP.setCellValueFactory(new PropertyValueFactory<Club, String>("MP"));
        ColumnW.setCellValueFactory(new PropertyValueFactory<Club, String>("W"));
        ColumnL.setCellValueFactory(new PropertyValueFactory<Club, String>("L"));
        ColumnD.setCellValueFactory(new PropertyValueFactory<Club, String>("D"));
        ColumnGF.setCellValueFactory(new PropertyValueFactory<Club, String>("GF"));
        ColumnGD.setCellValueFactory(new PropertyValueFactory<Club, String>("GD"));
        ColumnGA.setCellValueFactory(new PropertyValueFactory<Club, String>("GA"));
        ColumnPTS.setCellValueFactory(new PropertyValueFactory<Club, String>("PTS"));
        ColumnAction.setCellValueFactory(new PropertyValueFactory<Club, HBox>("action"));

        listClubs = FXCollections.observableArrayList(ClubDatabase.getClubs());
        TableClubs.setItems(listClubs);

        TextFields.bindAutoCompletion(ClubCountry,
                "Spain", "Romania", "France", "Germany", "United Kingdom", "Italy");


        Search.setOnKeyReleased(event -> search());

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                LineTable.setEndX(StageManager.getStage().getWidth()-320);
                                TableClubs.setMinHeight(StageManager.getStage().getHeight()-330);

                                if (Shared.action_delete2) {
                                    Shared.action_delete2 = false;
                                    refresh();
                                }

                                if (Shared.action_edit2) {
                                    Shared.action_edit2 = false;
                                    edit();
                                }
                            }
                        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void refresh() {
        ClubName.clear();
        ClubCountry.clear();
        ClubGD.clear();
        ClubGA.clear();
        ClubD.clear();
        ClubL.clear();
        ClubW.clear();
        ClubPTS.clear();
        listClubs = FXCollections.observableArrayList(ClubDatabase.getClubs());
        TableClubs.setItems(listClubs);
        Save.setOnAction(event -> save());
    }

    public void edit() {
        ClubName.setText(Shared.clubName);
        ClubCountry.setText(Shared.clubCountry);
        ClubPTS.setText(String.valueOf(Shared.clubPTS));
        ClubW.setText(String.valueOf(Shared.clubW));
        ClubL.setText(String.valueOf(Shared.clubL));
        ClubD.setText(String.valueOf(Shared.clubD));
        ClubGA.setText(String.valueOf(Shared.clubGA));
        ClubGD.setText(String.valueOf(Shared.clubGD));
        Save.setOnAction(event -> {
            if (ClubName.getText().isEmpty() || ClubCountry.getText().isEmpty() || ClubW.getText().isEmpty() ||
                    ClubL.getText().isEmpty() || ClubD.getText().isEmpty() || ClubGA.getText().isEmpty() ||
                    ClubGD.getText().isEmpty() || ClubPTS.getText().isEmpty()) {
                new AlertMessage("Error!", "Don't leave any fields blank!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(ClubW.getText())) {
                new AlertMessage("Error!", "Matches won is incorrect!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(ClubD.getText())) {
                new AlertMessage("Error!", "Matches drawn is incorrect!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(ClubL.getText())) {
                new AlertMessage("Error!", "Matches lose is incorrect!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(ClubGA.getText())) {
                new AlertMessage("Error!", "Goals against is incorrect!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(ClubGD.getText())) {
                new AlertMessage("Error!", "Goals difference is incorrect!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(ClubPTS.getText())) {
                new AlertMessage("Error!", "Points is incorrect!", Alert.AlertType.ERROR);
            } else if (ClubDatabase.existClub(ClubName.getText()) && !ClubName.getText().equals(Shared.clubName)) {
                new AlertMessage("Error!", "Club name already exists!", Alert.AlertType.ERROR);
            } else {
                ClubDatabase.editClub(Shared.clubName, new Club(ClubName.getText(), ClubCountry.getText(), (byte) (Byte.parseByte(ClubW.getText()) +
                        Byte.parseByte(ClubD.getText()) + Byte.parseByte(ClubL.getText())),
                        Byte.parseByte(ClubW.getText()), Byte.parseByte(ClubD.getText()), Byte.parseByte(ClubL.getText()),
                        (byte) (Byte.parseByte(ClubGA.getText()) + Byte.parseByte(ClubGD.getText())), Byte.parseByte(ClubGA.getText()), Byte.parseByte(ClubGD.getText()),
                        Byte.parseByte(ClubPTS.getText())));
                new AlertMessage("Success!", "The club was updated with success!", Alert.AlertType.INFORMATION);
                refresh();
            }
            });
    }

    public void search() {
        listClubs = FXCollections.observableArrayList(ClubDatabase.search(Search.getText()));
        TableClubs.setItems(listClubs);
    }

    @FXML
    public void save() {
        if (ClubName.getText().isEmpty() || ClubCountry.getText().isEmpty() || ClubW.getText().isEmpty() ||
                ClubL.getText().isEmpty() || ClubD.getText().isEmpty() || ClubGA.getText().isEmpty() ||
                ClubGD.getText().isEmpty() || ClubPTS.getText().isEmpty()) {
            new AlertMessage("Error!", "Don't leave any fields blank!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(ClubW.getText())) {
            new AlertMessage("Error!", "Matches won is incorrect!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(ClubD.getText())) {
            new AlertMessage("Error!", "Matches drawn is incorrect!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(ClubL.getText())) {
            new AlertMessage("Error!", "Matches lose is incorrect!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(ClubGA.getText())) {
            new AlertMessage("Error!", "Goals against is incorrect!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(ClubGD.getText())) {
            new AlertMessage("Error!", "Goals difference is incorrect!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(ClubPTS.getText())) {
            new AlertMessage("Error!", "Points is incorrect!", Alert.AlertType.ERROR);
        } else if (ClubDatabase.existClub(ClubName.getText())) {
            new AlertMessage("Error!", "Club name already exists!", Alert.AlertType.ERROR);
        } else {
            ClubDatabase.addClub(new Club(ClubName.getText(), ClubCountry.getText(), (byte) (Byte.parseByte(ClubW.getText()) +
                    Byte.parseByte(ClubD.getText()) + Byte.parseByte(ClubL.getText())),
                    Byte.parseByte(ClubW.getText()), Byte.parseByte(ClubD.getText()), Byte.parseByte(ClubL.getText()),
                    (byte) (Byte.parseByte(ClubGA.getText()) + Byte.parseByte(ClubGD.getText())), Byte.parseByte(ClubGA.getText()), Byte.parseByte(ClubGD.getText()),
                    Byte.parseByte(ClubPTS.getText())));
            new AlertMessage("Success!", "The club was added with success!", Alert.AlertType.INFORMATION);
            refresh();
        }
    }
}
