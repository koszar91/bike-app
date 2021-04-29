import database.SessionFactoryManager;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class MainApp {

    public static void main(String[] args) {
        System.out.println("\n----Start-----\n");

        // create one user
        User usr1 = new User("koszar91");

        // get session factory, create session and add usr (in transaction)
        SessionFactory sf = SessionFactoryManager.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        session.save(usr1);

        tr.commit();
        session.close();

        System.out.println("\n-----Exit-----\n");
    }
}
