package controllers;

import database.SessionFactoryManager;
import javafx.fxml.FXML;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class MainViewController {
    public MainViewController() { }


    @FXML
    public void initialize() {
        System.out.println("view initialized");

        User usr1 = new User("koszar91");

        SessionFactory sf = SessionFactoryManager.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        session.save(usr1);

        tr.commit();
        session.close();
    }

}
