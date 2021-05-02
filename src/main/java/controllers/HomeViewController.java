package controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import model.Ride;
import model.User;
import services.DBService;
import services.LogSessionService;


public class HomeViewController {

    private User currentUser;

    @FXML
    private Label welcomeLabel;

    @FXML
    private ListView<Ride> ridesListView;

    @FXML
    public void initialize() {
        this.currentUser = LogSessionService.getCurrentUser();

        this.setupWelcomeText(this.currentUser.getNickName() + "!");

        this.setupRidesList(FXCollections.observableArrayList(DBService.getEntities(Ride.class)));

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
                            setText(ride.getRoute().getName());
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
