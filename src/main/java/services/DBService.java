package services;

import model.Bike;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class DBService {
    private static final Configuration config = new Configuration();
    private static final SessionFactory sessFact = config.configure("hibernate.cfg.xml").buildSessionFactory();

    public static <T> List<T> getEntitiesFromDB(Class<T> tClass) {
        Session session = sessFact.openSession();
        Transaction tx = session.beginTransaction();
        List<T> res = session
                .createQuery("FROM " + tClass.getName(), tClass)
                .list();
        tx.commit();
        session.close();

        return res;
    }

    public static <T> void addEntityToDB(T entity) {
        Session session = sessFact.openSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
    }

    public static <T> void updateExistingEntityInDB(T entity) {
        Session session = sessFact.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(entity);
        tx.commit();
        session.close();
    }

    public static <T> void addEntitiesToDB(List<T> entities) {
        Session session = sessFact.openSession();
        Transaction tx = session.beginTransaction();
        for (T entity : entities) {
            session.save(entity);
        }
        tx.commit();
        session.close();
    }
}
