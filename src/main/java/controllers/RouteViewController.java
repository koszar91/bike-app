package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Ride;
import model.Route;
import model.User;
import scene.AppScene;
import scene.SceneManager;
import services.DBService;
import services.UserSessionService;

import java.util.Comparator;
import java.util.List;

public class RouteViewController {

    private Route selectedRoute;
    private List<Ride> rides;
    private User currentUser;

    @FXML
    public ListView<Ride> ridesListView;
    @FXML
    public TextField bestTimeTextField;
    @FXML
    public TextField yourTimeTextField;
    @FXML
    public TextField differenceTextField;
    @FXML
    public TextField youAreTextField;
    @FXML
    public Label routeNameLabel;
    @FXML
    public Button homeButton;
    @FXML
    public void homeButtonHandler() {
        UserSessionService.setSelectedRoute(null);
        SceneManager.setScene(AppScene.HOME);
    }

    @FXML
    public void initialize() {

        this.selectedRoute = UserSessionService.getSelectedRoute();
        this.rides = DBService.getRidesOnRoute(this.selectedRoute);
        this.currentUser = UserSessionService.getCurrentUser();
        this.rides.sort(Comparator.comparingDouble(Ride::getRideTime));
        if (this.selectedRoute == null) {
            System.out.println("NO SELECTED ROUTE - SHOULDN'T HAPPEN");
        }

        this.routeNameLabel.setText(this.selectedRoute.getName());

        this.setupRidesListView();

        this.setupTextFields();
    }

    private void setupTextFields() {
        double bestTime = 1e6;
        double yourTime = 1e6;
        double difference = 0;
        int yourPosition = -1;

        for (int i=0; i<this.rides.size(); i++) {
            Ride r = this.rides.get(i);
            bestTime = Math.min(bestTime, r.getRideTime());

            if ( r.getRideTime() <= yourTime &&
                    r.getUser().getNickName().equals(this.currentUser.getNickName())) {
                yourTime = r.getRideTime();
                difference = Math.abs(yourTime - bestTime);
                yourPosition = i + 1;
            }
        }

        this.bestTimeTextField.setText(String.valueOf(bestTime));
        this.yourTimeTextField.setText(String.valueOf(yourTime));
        this.differenceTextField.setText(String.valueOf(difference));
        this.youAreTextField.setText(String.valueOf(yourPosition));
    }

    private void setupRidesListView() {
        ObservableList<Ride> rides = FXCollections.observableArrayList(this.rides);
        this.ridesListView.setCellFactory((x) ->
                new ListCell<Ride>(){
                    @Override
                    protected void updateItem(Ride ride, boolean isEmpty) {
                        super.updateItem(ride, isEmpty);
                        if (isEmpty || ride == null) {
                            setText(null);
                        } else {
                            setText(ride.getRoute().getName()
                                    + ", date: "
                                    + ride.getRideDate()
                                    + ", time: "
                                    + String.valueOf(ride.getRideTime()));
                        }
                    }
                }
        );
        this.ridesListView.setItems(rides);
    }
}
