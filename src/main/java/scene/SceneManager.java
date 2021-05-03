package scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class SceneManager {

    private static Stage stage;

    public static void setScene(AppScene sceneType) {
        try {
            BorderPane borderPane = FXMLLoader.load(SceneManager.class.getResource("/" + sceneType.getResource()));
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
