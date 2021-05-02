package controllers;

import services.DBService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.User;

import java.util.List;


public class MainViewController {

    // fxml controls
    @FXML
    private TextField textLogin;
    @FXML
    private Button buttonLogin;
    @FXML
    void loginHandler() {
        if (!this.userExists(this.textLogin.getText())) {
            System.out.println("No such user. Register new account.");
            return;
        }

        System.out.printf("Successful login. Welcome %s\n", this.textLogin.getText());
        System.out.println("Redirecting to home view...");
    }

    @FXML
    private TextField textRegister;
    @FXML
    private Button buttonRegister;
    @FXML
    void registerHandler() {
        if (this.userExists(this.textRegister.getText())) {
            System.out.println("User exists! Log in.");
            return;
        }

        System.out.println("Successful register. Log in.");
    }

    @FXML
    public void initialize() { }



    // private methods
    private boolean userExists(String nick) {
        List<User> users = DBService.getEntities(User.class);

        for (User usr : users)
            if (usr.getNickName().equals(nick))
                return true;

        return false;
    }

}
