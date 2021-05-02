package scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class SceneManager {

    private static Stage stage;

    public static void setScene(AppScene sceneType) {

        String fxmlResourceName;

        switch (sceneType) {
            case HOME -> fxmlResourceName = "homeView.fxml";
            case LOGIN -> fxmlResourceName = "loginView.fxml";
            default -> {
                System.out.printf("Unrecognized scene: '%s'. Program exit\n", sceneType);
                return;
            }
        }
        try {
            BorderPane borderPane = FXMLLoader.load(SceneManager.class.getResource("/" + fxmlResourceName));
            Scene scene = new Scene(borderPane);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FXML template reading resulted in failure");
            System.exit(1);
        }

    }

    public static void setStage(Stage stage) {
        SceneManager.stage = stage;
    }
}
