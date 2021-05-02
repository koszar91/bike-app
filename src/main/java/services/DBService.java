package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DBService {
    private static final Configuration config = new Configuration();
    private static final SessionFactory sessFact = config.configure().buildSessionFactory();

    public static <T> List<T> getEntities(Class<T> entity) {
        Session session = sessFact.openSession();
        Transaction tx = session.beginTransaction();
        List<T> res = session
                .createQuery("FROM " + entity.getName(), entity)
                .list();
        tx.commit();
        session.close();

        return res;
    }

}
