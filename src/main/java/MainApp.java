import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainApp extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) {
        // set up window and main scene
        try {
            FXMLLoader loader = new FXMLLoader();
            BorderPane rootView = loader.load(getClass().getResource("loginView.fxml").openStream());
            stage.setScene(new Scene(rootView));
            stage.setTitle("Cycling World");
            stage.setHeight(500);
            stage.setWidth(800);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FXML template reading resulted in failure");
            System.exit(1);
        }
    }
}
