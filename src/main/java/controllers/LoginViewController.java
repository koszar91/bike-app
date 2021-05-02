package controllers;

import scene.AppScene;
import scene.SceneManager;
import services.DBService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.User;
import services.LogSessionService;

import java.util.List;


public class LoginViewController {

    // fxml controls
    @FXML
    private TextField textLogin;
    @FXML
    private Button buttonLogin;
    @FXML
    void loginHandler() {
        User usr = this.userExists(this.textLogin.getText());

        if (usr == null) {
            System.out.println("No such user. Register new account.");
            return;
        }

        System.out.printf("Successful login. Welcome %s\n", this.textLogin.getText());
        System.out.println("Redirecting to home view...");


        LogSessionService.setCurrentUser(usr);

        SceneManager.setScene(AppScene.HOME);
    }

    @FXML
    private TextField textRegister;
    @FXML
    private Button buttonRegister;
    @FXML
    void registerHandler() {
        User usr = this.userExists(this.textLogin.getText());

        if (usr != null) {
            System.out.println("User exists! Log in.");
            return;
        }

        usr = new User(this.textRegister.getText());
        DBService.addEntity(usr);

        System.out.println("Successful register. Log in.");
    }

    @FXML
    public void initialize() { }



    // private methods
    private User userExists(String nick) {
        List<User> users = DBService.getEntities(User.class);

        for (User usr : users)
            if (usr.getNickName().equals(nick))
                return usr;

        return null;
    }

}
