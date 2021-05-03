import javafx.application.Application;
import javafx.stage.Stage;
import scene.AppScene;
import scene.SceneManager;


public class MainApp extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) {
        // setup scene manager
        SceneManager.setStage(stage);
        SceneManager.setScene(AppScene.LOGIN);

        // set up window and main scene
        stage.setTitle("Cycling World");
        stage.setHeight(500);
        stage.setWidth(800);
        stage.show();

        DataAdder.add();
    }
}
