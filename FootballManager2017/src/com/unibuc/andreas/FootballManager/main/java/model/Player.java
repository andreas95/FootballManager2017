package com.unibuc.andreas.FootballManager.main.java.model;

import com.unibuc.andreas.FootballManager.main.java.common.Shared;
import com.unibuc.andreas.FootballManager.main.java.database.PlayerDatabase;
import com.unibuc.andreas.FootballManager.main.java.ui.AlertMessage;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * @author andreas
 * Created by antoneandreas on 5/22/17.
 */
public class Player {

    private String name;
    private byte number;
    private String club;
    private String position;
    private byte age;
    private byte MP; //Matches played
    private byte GS; //Goals scored
    private byte YC; //Yellow cards
    private byte RC; //Red cards;

    public Player() {}

    public Player(String name, byte number, byte age, String club, String position, byte MP, byte GS, byte YC, byte RC) {
        this.name = name;
        this.number = number;
        this.club = club;
        this.position = position;
        this.age = age;
        this.MP = MP;
        this.GS = GS;
        this.YC = YC;
        this.RC = RC;
    }

    public byte getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getClub() {
        return club;
    }

    public String getPosition() {
        return position;
    }

    public byte getAge() {
        return age;
    }

    public byte getGS() {
        return GS;
    }

    public byte getMP() {
        return MP;
    }

    public byte getRC() {
        return RC;
    }

    public byte getYC() {
        return YC;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(byte number) {
        this.number = number;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setGS(byte GS) {
        this.GS = GS;
    }

    public void setMP(byte MP) {
        this.MP = MP;
    }

    public void setRC(byte RC) {
        this.RC = RC;
    }

    public void setYC(byte YC) {
        this.YC = YC;
    }

    public HBox getAction() {
        HBox box=new HBox(5);
        box.setAlignment(Pos.CENTER);

        Label delete=new Label("Delete");
        delete.getStyleClass().add("hyperlink");
        delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (AlertMessage.AlertMessageConfirmation("Delete "+getName(),"Do you want to delete this player?")) {
                    PlayerDatabase.deletePlayer(getNumber());
                    Shared.action_delete = true;
                }
            }
        });

        Label edit=new Label("Edit");
        edit.getStyleClass().add("hyperlink");
        edit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Shared.playerAge = getAge();
                Shared.playerClub = getClub();
                Shared.playerName = getName();
                Shared.playerNumber = getNumber();
                Shared.playerPosition = getPosition();
                Shared.playerMP = getMP();
                Shared.playerGS = getGS();
                Shared.playerYC = getYC();
                Shared.playerRC =getRC();
                Shared.action_edit = true;
            }
        });

        box.getChildren().addAll(delete,edit);
        return box;
    }
}
