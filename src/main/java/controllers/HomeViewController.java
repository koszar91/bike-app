package controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import model.Bike;
import model.Ride;
import model.User;
import scene.AppScene;
import scene.SceneManager;
import services.DBService;
import services.UserSessionService;


public class HomeViewController {

    @FXML
    private Button logOutButton;
    @FXML
    private void logOutButtonHandler(ActionEvent actionEvent) {
        UserSessionService.setCurrentUser(null);
        SceneManager.setScene(AppScene.LOGIN);
    }

    @FXML
    private Button friendsButton;
    @FXML
    private void friendsButtonHandler() {
        SceneManager.setScene(AppScene.FRIENDS);
    }

    @FXML
    private Button bikeButton;
    @FXML
    private void bikeButtonHandler() {
        SceneManager.setScene(AppScene.BIKE);
    }

    @FXML
    private Label welcomeLabel;

    @FXML
    private ListView<Ride> ridesListView;

    @FXML
    public void initialize() {
        this.setupWelcomeText(UserSessionService.getCurrentUser().getNickName() + "!");


        this.setupRidesList(FXCollections.observableArrayList(DBService.getEntitiesFromDB(Ride.class)));

        //setup

        //setup...


    }

    private void setupRidesList(ObservableList<Ride> rides) {
        this.ridesListView.setCellFactory((x) ->
                new ListCell<Ride>(){
                    @Override
                    protected void updateItem(Ride ride, boolean isEmpty) {
                        super.updateItem(ride, isEmpty);
                        if (isEmpty || ride == null) {
                            setText(null);
                        } else {
                            setText(ride.getRoute().getName()
                                    + ", time: "
                                    + ride.getRideDate());
                        }
                    }
                }
        );
        this.ridesListView.setItems(rides);
    }

    private void setupWelcomeText(String name) {
        this.welcomeLabel.setText("Welcome " + name);
    }



}
