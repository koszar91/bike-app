import javafx.application.Application;
import javafx.stage.Stage;
import scene.AppScene;
import scene.SceneManager;

import java.io.IOException;


public class MainApp extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws IOException {
        // setup scene menager
        SceneManager.setStage(stage);

        // set up window and main scene
        SceneManager.setScene(AppScene.LOGIN);
        stage.setTitle("Cycling World");
        stage.setHeight(500);
        stage.setWidth(800);
        stage.show();
    }
}
