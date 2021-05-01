package database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


// singleton (don't want to have more than one session factory)
public class SessionFactoryManager {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration cfg = new Configuration();
            sessionFactory = cfg.configure().buildSessionFactory();
        }

        return sessionFactory;
    }
}
