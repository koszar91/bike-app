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

import java.util.List;


public class HomeViewController {

    User currentUser = UserSessionService.getCurrentUser();

    // adding ride stuff
    @FXML
    private Button addRideButton;
    @FXML
    private void addRideButtonHandler() {
        String rideName = this.routesChoiceBox.getValue();
        String rideTime = this.rideTimeTextField.getText();
        String rideDate = this.rideDateTextField.getText();
        System.out.println("Route u chose: " + rideName);
        System.out.println("Time u get: " + rideTime);
        System.out.println("Date u choose: " + rideDate);

        Route route = DBService.getRouteWithName(rideName);
        Ride newRide = new Ride(this.currentUser, route, rideDate, Double.parseDouble(rideTime));
        DBService.addEntityToDB(newRide);

        this.setupRidesList();

        // clean text fields
        this.rideDateTextField.setText("");
        this.rideTimeTextField.setText("");
    }
    @FXML
    private ChoiceBox<String> routesChoiceBox;
    @FXML
    private TextField rideTimeTextField;
    @FXML
    private TextField rideDateTextField;

    //...
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
    private void routeClickedHandler() {
        ObservableList selectedIndices =
                this.ridesListView.getSelectionModel().getSelectedIndices();
        Integer selectedIdx = (Integer) selectedIndices.get(0);
        List<Ride> rides = DBService.getRidesOfUser(this.currentUser);
        UserSessionService.setSelectedRoute(rides.get(selectedIdx).getRoute());
        SceneManager.setScene(AppScene.ROUTE);
    }

    @FXML
    public void initialize() {
        this.setupWelcomeText(this.currentUser.getNickName());

        this.setupRidesList();

        this.setupRoutesChoiceBox();
    }

    private void setupRidesList() {
        ObservableList<Ride> rides = FXCollections.observableArrayList(DBService.getRidesOfUser(this.currentUser));
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

    private void setupWelcomeText(String name) {
        this.welcomeLabel.setText("Welcome " + name + "!");
    }

    private void setupRoutesChoiceBox() {
        List<Route> allRoutes = DBService.getAllEntitiesOfClass(Route.class);
        for (Route route : allRoutes) {
            this.routesChoiceBox.getItems().add(route.getName());
        }
    }

}
