package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class MainViewController {

    @FXML
    private TextField textLogin;
    @FXML
    private Button buttonLogin;

    @FXML
    private TextField textRegister;
    @FXML
    private Button buttonRegister;


    public MainViewController() { }

    @FXML
    public void initialize() { }

    @FXML
    void loginHandler() {
        String nick = this.textLogin.getText();
        System.out.printf("login clicked, typed nick: '%s'\n", nick);
    }

    @FXML
    void registerHandler() {
        String nick = this.textRegister.getText();
        System.out.printf("register clicked, typed nick: '%s'\n", nick);
    }
}
