package scene;

import lombok.Getter;

public enum AppScene {

    HOME("homeView.fxml"),
    LOGIN("loginView.fxml"),
    BIKE("bikeView.fxml"),
    FRIENDS("friendsView.fxml");

    AppScene(String resource) { this.resource = resource; }

    @Getter
    private final String resource;
}
