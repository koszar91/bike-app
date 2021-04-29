package database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


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
