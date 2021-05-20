import model.Bike;
import model.Ride;
import model.Route;
import model.User;
import services.DBService;

import java.util.LinkedList;
import java.util.List;


public class DataAdder {
    public static void add() {
        // routes
        Route r1 = new Route(79, "Around the Czorsztyn lake");
        Route r2 = new Route(20, "Visiting seaside");
        Route r3 = new Route(56, "Tatra climb");
        Route r4 = new Route(54, "Gorce forest route");
        Route r5 = new Route(41, "Cracov city route");
        Route r6 = new Route(18, "Turbacz sprint climb");
        Route r7 = new Route(91, "Slovakia sightseeing route");
        Route r8 = new Route(620, "Warsaw-Cracov-Warsaw");
        Route r9 = new Route(14, "Bike-track sprint");
        Route r10 = new Route(111, "Through the German border");
        List<Route> routes = new LinkedList<>();
        routes.add(r1);routes.add(r2);routes.add(r3);routes.add(r4);
        routes.add(r5);routes.add(r6);routes.add(r7);routes.add(r8);
        routes.add(r9);routes.add(r10);
        DBService.addEntitiesToDB(routes);

        // users with bikes
        Bike b1 = new Bike("Merida Turbo", Bike.Color.BLACK, Bike.BikeType.ROAD);
        User u1 = new User("Bob", "Dylan", "bobby1", "01-02-1970", b1);
        b1.setUser(u1);
        Bike b2 = new Bike("Cannondale Slim", Bike.Color.YELLOW, Bike.BikeType.MOUNTAIN);
        User u2 = new User("Tom", "Ford", "tom90", "21-06-1995", b2);
        b2.setUser(u2);
        Bike b3 = new Bike("Specialized X200", Bike.Color.RED, Bike.BikeType.ROAD);
        User u3 = new User("Lucas", "Smith", "luke9", "01-12-1999", b3);
        b3.setUser(u3);
        Bike b4 = new Bike("Kross basic 200", Bike.Color.BLACK, Bike.BikeType.ELECTRIC);
        User u4 = new User("Bruce", "Willis", "willywonka", "22-08-2000", b4);
        b4.setUser(u4);
        Bike b5 = new Bike("Specialized Stumpjumper", Bike.Color.WHITE, Bike.BikeType.HYBRID);
        User u5 = new User("Dough", "West", "dest67", "17-11-2005", b5);
        b5.setUser(u5);


        // friends (u1 with all, u2 with all)
        u1.makeFriendsWith(u2);u1.makeFriendsWith(u3);u1.makeFriendsWith(u4);u1.makeFriendsWith(u5);
        u2.makeFriendsWith(u3);u2.makeFriendsWith(u4);u2.makeFriendsWith(u5);


        List<Bike> bikes = new LinkedList<>();
        bikes.add(b1);bikes.add(b2);bikes.add(b3);bikes.add(b4);bikes.add(b5);
        DBService.addEntitiesToDB(bikes);
        List<User> users = new LinkedList<>();
        users.add(u1);users.add(u2);users.add(u3);users.add(u4);users.add(u5);
        DBService.addEntitiesToDB(users);


        // rides
        Ride ri1 = new Ride(u1, r1, "03-05-2021", 2.5);
        Ride ri2 = new Ride(u1, r2, "03-04-2021", 0.3);
        Ride ri3 = new Ride(u1, r2, "13-04-2021", 0.32);
        Ride ri4 = new Ride(u1, r3, "01-05-2021", 1.13);
        Ride ri5 = new Ride(u1, r1, "22-04-2021", 2.23);
        Ride ri6 = new Ride(u1, r6, "03-05-2021", 0.5);
        List<Ride> rides = new LinkedList<>();
        rides.add(ri1);rides.add(ri2);rides.add(ri3);rides.add(ri4);rides.add(ri5);rides.add(ri6);
        DBService.addEntitiesToDB(rides);
    }
}
