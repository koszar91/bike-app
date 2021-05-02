package controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.User;
import services.LogSessionService;



public class HomeViewController {

    private User currentUser;

    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        this.currentUser = LogSessionService.getCurrentUser();
        this.welcomeLabel.setText("Welcome " + this.currentUser.getNickName() + "!");
    }
}
