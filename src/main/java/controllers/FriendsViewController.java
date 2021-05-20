package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import model.Ride;
import model.User;
import scene.AppScene;
import scene.SceneManager;
import services.DBService;

public class FriendsViewController {

    @FXML
    private Button homeButton;
    @FXML
    private void homeButtonHandler() {
        SceneManager.setScene(AppScene.HOME);
    }


    @FXML
    private ListView<User> friendsListView;

    @FXML
    private ListView<Ride> friendsRidesListView;

    @FXML
    public void initialize() {
        // TODO: BOTH TODOS HERE DEMAND WRITING DATABASE CODE. IN DB SERVICE CLASS.

        // TODO: pass this function list of users that are friends of current user (not all users)
        this.setupFriendsList(FXCollections.observableArrayList(DBService.getEntitiesFromDB(User.class)));

        // TODO: pass this function list of rides that are user friends' rides
        //  (not all rides)
        setupFriendsRidesList(FXCollections.observableArrayList(DBService.getEntitiesFromDB(Ride.class)));
    }

    private void setupFriendsList(ObservableList<User> users) {
        this.friendsListView.setCellFactory((x) ->
                new ListCell<User>(){
                    @Override
                    protected void updateItem(User user, boolean isEmpty) {
                        super.updateItem(user, isEmpty);
                        if (isEmpty || user == null) {
                            setText(null);
                        } else {
                            setText(user.getNickName());
                        }
                    }
                }
        );
        this.friendsListView.setItems(users);
    }

    private void setupFriendsRidesList(ObservableList<Ride> rides) {
        this.friendsRidesListView.setCellFactory((x) ->
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
        this.friendsRidesListView.setItems(rides);
    }
}
