package com.unibuc.andreas.FootballManager.main.java.controller;

import com.unibuc.andreas.FootballManager.main.java.common.Shared;
import com.unibuc.andreas.FootballManager.main.java.common.StageManager;
import com.unibuc.andreas.FootballManager.main.java.common.Utils;
import com.unibuc.andreas.FootballManager.main.java.database.ClubDatabase;
import com.unibuc.andreas.FootballManager.main.java.database.PlayerDatabase;
import com.unibuc.andreas.FootballManager.main.java.model.Club;
import com.unibuc.andreas.FootballManager.main.java.model.Player;
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
 * @author andreas
 * Created by antoneandreas on 5/22/17.
 */
public class PlayerController {

    @FXML
    private Button Save;
    @FXML
    private TextField Search;
    @FXML
    private TextField PlayerNumber;
    @FXML
    private TextField PlayerName;
    @FXML
    private TextField ClubName;
    @FXML
    private TextField PlayerPosition;
    @FXML
    private TextField PlayerAge;
    @FXML
    private TableView TablePlayers;
    @FXML
    private TextField ClubYC;
    @FXML
    private TextField ClubRC;
    @FXML
    private TextField ClubMP;
    @FXML
    private TextField ClubGS;
    @FXML
    private TableColumn ColumnAction;
    @FXML
    private TableColumn ColumnNumber;
    @FXML
    private TableColumn ColumnPlayerName;
    @FXML
    private TableColumn ColumnPlayerAge;
    @FXML
    private TableColumn ColumnPlayerPosition;
    @FXML
    private TableColumn ColumnClubName;
    @FXML
    private TableColumn ColumnPlayerGS;
    @FXML
    private TableColumn ColumnPlayerMP;
    @FXML
    private TableColumn ColumnPlayerRC;
    @FXML
    private TableColumn ColumnPlayerYC;
    @FXML
    private Line LineTable;
    private ObservableList<Player> listPlayers;

    public void initialize() {
        ColumnClubName.impl_setReorderable(false);
        ColumnNumber.impl_setReorderable(false);
        ColumnPlayerAge.impl_setReorderable(false);
        ColumnPlayerName.impl_setReorderable(false);
        ColumnPlayerPosition.impl_setReorderable(false);
        ColumnAction.impl_setReorderable(false);
        ColumnPlayerGS.impl_setReorderable(false);
        ColumnPlayerMP.impl_setReorderable(false);
        ColumnPlayerRC.impl_setReorderable(false);
        ColumnPlayerYC.impl_setReorderable(false);


        TablePlayers.prefHeightProperty().bind(Bindings.size(TablePlayers.getItems()).multiply(TablePlayers.getFixedCellSize()).add(50));
        ColumnNumber.setCellValueFactory(new PropertyValueFactory<Club, String>("number"));
        ColumnPlayerName.setCellValueFactory(new PropertyValueFactory<Club, String>("name"));
        ColumnPlayerPosition.setCellValueFactory(new PropertyValueFactory<Club, String>("position"));
        ColumnPlayerAge.setCellValueFactory(new PropertyValueFactory<Club, String>("age"));
        ColumnClubName.setCellValueFactory(new PropertyValueFactory<Club, String>("club"));
        ColumnPlayerYC.setCellValueFactory(new PropertyValueFactory<Club, String>("YC"));
        ColumnPlayerRC.setCellValueFactory(new PropertyValueFactory<Club, String>("RC"));
        ColumnPlayerGS.setCellValueFactory(new PropertyValueFactory<Club, String>("GS"));
        ColumnPlayerMP.setCellValueFactory(new PropertyValueFactory<Club, String>("MP"));
        ColumnAction.setCellValueFactory(new PropertyValueFactory<Club, HBox>("action"));

        listPlayers = FXCollections.observableArrayList(PlayerDatabase.getPlayers());
        TablePlayers.setItems(listPlayers);

        TextFields.bindAutoCompletion(PlayerPosition,
                "Goalkeeper", "Defender", "Midfielder", "Forward", "Coach");
        TextFields.bindAutoCompletion(ClubName, FXCollections.observableArrayList(ClubDatabase.getNameClubs()));



        Search.setOnKeyReleased(event -> search());

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                LineTable.setEndX(StageManager.getStage().getWidth()-320);
                                TablePlayers.setMinHeight(StageManager.getStage().getHeight()-330);

                                if (Shared.action_delete) {
                                    Shared.action_delete = false;
                                    refresh();
                                }

                                if (Shared.action_edit) {
                                    Shared.action_edit = false;
                                    edit();
                                }
                            }
                        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void refresh() {
        PlayerName.clear();
        PlayerAge.clear();
        PlayerNumber.clear();
        PlayerPosition.clear();
        ClubName.clear();
        ClubMP.clear();
        ClubGS.clear();
        ClubYC.clear();
        ClubRC.clear();
        listPlayers = FXCollections.observableArrayList(PlayerDatabase.getPlayers());
        TablePlayers.setItems(listPlayers);
        Save.setOnAction(event -> save());
    }

    @FXML
    public void save() {
        if (PlayerNumber.getText().isEmpty() || PlayerAge.getText().isEmpty() || PlayerName.getText().isEmpty()
                || ClubName.getText().isEmpty() || ClubMP.getText().isEmpty() || ClubGS.getText().isEmpty()
                || ClubYC.getText().isEmpty() || ClubRC.getText().isEmpty() || PlayerPosition.getText().isEmpty()) {
            new AlertMessage("Error!", "Don't leave any fields blank!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(PlayerNumber.getText())) {
            new AlertMessage("Error!", "Player number is incorrect!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(PlayerAge.getText())) {
            new AlertMessage("Error!", "Player age is incorrect!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(ClubMP.getText())) {
            new AlertMessage("Error!", "Matches played is incorrect!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(ClubGS.getText())) {
            new AlertMessage("Error!", "Goals scored is incorrect!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(ClubYC.getText())) {
            new AlertMessage("Error!", "Yellow cards is incorrect!", Alert.AlertType.ERROR);
        } else if (!Utils.isNumeric(ClubRC.getText())) {
            new AlertMessage("Error!", "Red cards is incorrect!", Alert.AlertType.ERROR);
        } else if (PlayerDatabase.existPlayer(PlayerName.getText())) {
            new AlertMessage("Error!", "Player name already exists!", Alert.AlertType.ERROR);
        } else {
            PlayerDatabase.addPlayer(new Player(PlayerName.getText(), Byte.parseByte(PlayerNumber.getText()),
                    Byte.parseByte(PlayerAge.getText()), ClubName.getText(), PlayerPosition.getText(),
                    Byte.parseByte(ClubMP.getText()), Byte.parseByte(ClubGS.getText()), Byte.parseByte(ClubYC.getText()), Byte.parseByte(ClubRC.getText())));
            new AlertMessage("Success!", "The player was added with success!", Alert.AlertType.INFORMATION);
            refresh();
        }
    }

    public void edit() {
        ClubName.setText(Shared.playerClub);
        PlayerPosition.setText(Shared.playerPosition);
        PlayerNumber.setText(String.valueOf(Shared.playerNumber));
        PlayerName.setText(Shared.playerName);
        PlayerAge.setText(String.valueOf(Shared.playerAge));
        ClubGS.setText(String.valueOf(Shared.playerGS));
        ClubMP.setText(String.valueOf(Shared.playerMP));
        ClubYC.setText(String.valueOf(Shared.playerYC));
        ClubRC.setText(String.valueOf(Shared.playerRC));
        Save.setOnAction(event -> {
            if (PlayerNumber.getText().isEmpty() || PlayerAge.getText().isEmpty() || PlayerName.getText().isEmpty()
                    || ClubName.getText().isEmpty() || ClubMP.getText().isEmpty() || ClubGS.getText().isEmpty()
                    || ClubYC.getText().isEmpty() || ClubRC.getText().isEmpty() || PlayerPosition.getText().isEmpty()) {
                new AlertMessage("Error!", "Don't leave any fields blank!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(PlayerNumber.getText())) {
                new AlertMessage("Error!", "Player number is incorrect!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(PlayerAge.getText())) {
                new AlertMessage("Error!", "Player age is incorrect!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(ClubMP.getText())) {
                new AlertMessage("Error!", "Matches played is incorrect!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(ClubGS.getText())) {
                new AlertMessage("Error!", "Goals scored is incorrect!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(ClubYC.getText())) {
                new AlertMessage("Error!", "Yellow cards is incorrect!", Alert.AlertType.ERROR);
            } else if (!Utils.isNumeric(ClubRC.getText())) {
                new AlertMessage("Error!", "Red cards is incorrect!", Alert.AlertType.ERROR);
            } else if (PlayerDatabase.existPlayer(PlayerName.getText()) && !PlayerName.getText().equals(Shared.playerName)) {
                new AlertMessage("Error!", "Player name already exists!", Alert.AlertType.ERROR);
            } else {
                PlayerDatabase.editPlayer(Shared.playerNumber, new Player(PlayerName.getText(), Byte.parseByte(PlayerNumber.getText()),
                        Byte.parseByte(PlayerAge.getText()), ClubName.getText(), PlayerPosition.getText(),
                        Byte.parseByte(ClubMP.getText()), Byte.parseByte(ClubGS.getText()), Byte.parseByte(ClubYC.getText()), Byte.parseByte(ClubRC.getText())));
                new AlertMessage("Success!", "The player was updated with success!", Alert.AlertType.INFORMATION);
                refresh();
            }
        });
    }

    public void search() {
        listPlayers = FXCollections.observableArrayList(PlayerDatabase.search(Search.getText()));
        TablePlayers.setItems(listPlayers);
    }
}
