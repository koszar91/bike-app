package services;

import model.Bike;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class DBService {
    private static final Configuration config = new Configuration();
    private static final SessionFactory sessFact = config.configure("hibernate.cfg.xml").buildSessionFactory();

    public static <T> List<T> getAllEntitiesOfClass(Class<T> tClass) {
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
            session.saveOrUpdate(entity);
        }
        tx.commit();
        session.close();
    }

    public static Bike getBikeForUser(User user) {
        Session session = sessFact.openSession();
        Transaction tx = session.beginTransaction();
        List<Bike> bikes = session
                .createQuery("FROM Bike where user = :owner")
                .setParameter("owner", user)
                .list();
        tx.commit();
        session.close();
        if (bikes.isEmpty()) {
            return null;
        }
        return bikes.get(0);
    }

    public static List<Ride> getRidesOfUser(User user) {
        Session session = sessFact.openSession();
        Transaction tx = session.beginTransaction();
        List<Ride> myList = session
                .createQuery("FROM Ride where user = :user")
                .setParameter("user", user)
                .getResultList();
        tx.commit();
        session.close();
        return myList;
    }

    public static List<User> getFriendsOfUser(User user) {
        List<User> result;
        Session session = sessFact.openSession();
        Transaction tx = session.beginTransaction();
        User copyUser = (User) session.createQuery("FROM User where nickName = :nickname")
                .setParameter("nickname", user.getNickName())
                .getResultList()
                .get(0);
        result = new LinkedList<>(copyUser.getFriends());
        tx.commit();
        session.close();
        return result.stream().filter(usr -> !usr
                            .getNickName()
                            .equals(user.getNickName()))
                            .collect(Collectors.toList());
    }

    public static List<Ride> getRidesOfFriendsOfUser(User user) {
        List<User> friendsList = getFriendsOfUser(user);
        Session session = sessFact.openSession();
        List<Ride> friendsRides = new LinkedList<>();
        Transaction tx = session.beginTransaction();
        for(User i : friendsList) {
            List<Ride> tmpList = session
                    .createQuery("FROM Ride where user = :user")
                    .setParameter("user", i)
                    .getResultList();
            friendsRides.addAll(tmpList);
        }
        tx.commit();
        session.close();
        return friendsRides;
    }

    public static Route getRouteWithName(String routeName) {
        Session session = sessFact.openSession();
        Transaction tx = session.beginTransaction();
        Route route = (Route) session
                .createQuery("from Route as route where route.name = :routeName")
                .setParameter("routeName", routeName)
                .getResultList()
                .get(0);
        tx.commit();
        session.close();
        return route;
    }

    public static List<Ride> getRidesOnRoute(Route route) {
        Session session = sessFact.openSession();
        Transaction tx = session.beginTransaction();
        List<Ride> rides = session
                .createQuery("FROM Ride where route = :route")
                .setParameter("route", route)
                .getResultList();
        tx.commit();
        session.close();
        return rides;
    }
}
