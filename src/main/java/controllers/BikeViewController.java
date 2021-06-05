package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Bike;
import model.Route;
import scene.AppScene;
import scene.SceneManager;
import services.DBService;
import services.UserSessionService;

import java.util.Arrays;
import java.util.List;

public class BikeViewController {

    @FXML
    private Button homeButton;
    @FXML
    private void homeButtonHandler() {
        SceneManager.setScene(AppScene.HOME);
    }
    @FXML
    private Label nameLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label colorLabel;

    @FXML
    private Label totalKilometersLabel;
    @FXML
    private Label bestRideLabel;

    @FXML
    public void initialize() {
        setupBikeInfo();
        setupColorChoiceBox();
        setupTypeChoiceBox();
    }

    private void setupColorChoiceBox() {
        List<Bike.Color> allColors = Arrays.asList(Bike.Color.values());
        for (Bike.Color color : allColors) {
            this.colourBikeChoiceBox.getItems().add(color.getName());
        }
    }

    private void setupTypeChoiceBox() {
        List<Bike.BikeType> allTypes = Arrays.asList(Bike.BikeType.values());
        for (Bike.BikeType type : allTypes) {
            this.typeBikeChoiceBox.getItems().add(type.getName());
        }
    }

    private void setupBikeInfo() {
        Bike bike = DBService.getBikeForUser(UserSessionService.getCurrentUser());
        if (bike == null) { return; }

        this.nameLabel.setText(bike.getName());
        this.typeLabel.setText(bike.getType().getName());
        this.colorLabel.setText(bike.getColor().getName());

    }


}
