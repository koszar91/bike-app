package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Bike;
import scene.AppScene;
import scene.SceneManager;
import services.DBService;
import services.UserSessionService;

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
    }

    private void setupBikeInfo() {
        Bike bike = DBService.getBikeForUser(UserSessionService.getCurrentUser());
        this.nameLabel.setText(bike.getName());
        this.typeLabel.setText(bike.getType().getName());
        this.colorLabel.setText(bike.getColor().getName());
    }


}
