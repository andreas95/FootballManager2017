package com.unibuc.andreas.FootballManager.main.java.model;

import com.unibuc.andreas.FootballManager.main.java.common.Shared;
import com.unibuc.andreas.FootballManager.main.java.database.ClubDatabase;
import com.unibuc.andreas.FootballManager.main.java.ui.AlertMessage;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;


/**
 * @author andreas antone
 * Created by antoneandreas on 5/22/17.
 */

public class Club {

    private String name;
    private String country;
    private byte MP; // Matches played
    private byte W; // Matches won
    private byte D; // Matches drawn
    private byte L; // Matches lose
    private byte GF; // Goals for or goals scored
    private byte GA; // Goals against or goals conceded
    private byte GD; // Goal difference
    private byte PTS; // Points

    public  Club() {}

    public Club(String name, String country, byte MP, byte W, byte D, byte L, byte GF, byte GA, byte GD, byte PTS) {
        this.name = name;
        this.country = country;
        this.MP = MP;
        this.W = W;
        this.D = D;
        this.L = L;
        this.GF = GF;
        this.GA = GA;
        this.GD = GD;
        this.PTS = PTS;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public byte getD() {
        return D;
    }

    public byte getGA() {
        return GA;
    }

    public byte getGD() {
        return GD;
    }

    public byte getGF() {
        return GF;
    }

    public byte getL() {
        return L;
    }

    public byte getMP() {
        return MP;
    }

    public byte getPTS() {
        return PTS;
    }

    public byte getW() {
        return W;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setD(byte d) {
        D = d;
    }

    public void setGA(byte GA) {
        this.GA = GA;
    }

    public void setGD(byte GD) {
        this.GD = GD;
    }

    public void setGF(byte GF) {
        this.GF = GF;
    }

    public void setL(byte l) {
        L = l;
    }

    public void setMP(byte MP) {
        this.MP = MP;
    }

    public void setPTS(byte PTS) {
        this.PTS = PTS;
    }

    public void setW(byte w) {
        W = w;
    }

    public HBox getAction() {
        HBox box=new HBox(5);
        box.setAlignment(Pos.CENTER);

        Label delete=new Label("Delete");
        delete.getStyleClass().add("hyperlink");
        delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (AlertMessage.AlertMessageConfirmation("Delete "+getName(),"Do you want to delete this club?")) {
                    ClubDatabase.deleteClub(getName());
                    Shared.action_delete2 = true;
                }
            }
        });

        Label edit=new Label("Edit");
        edit.getStyleClass().add("hyperlink");
        edit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Shared.clubName  = getName();
                Shared.clubCountry =  getCountry();
                Shared.clubMP = getMP();
                Shared.clubL = getL();
                Shared.clubW = getW();
                Shared.clubD = getD();
                Shared.clubGF = getGF();
                Shared.clubGD = getGD();
                Shared.clubGA = getGA();
                Shared.clubPTS = getPTS();
                Shared.action_edit2 = true;
            }
        });

        box.getChildren().addAll(delete,edit);
        return box;
    }

}
