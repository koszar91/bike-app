package model;

import javax.persistence.*;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rideID;


    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "routeID", referencedColumnName = "routeID")
    private Route route;


    public Ride() { }


    // boring setters and getters
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Route getRoute() {
        return route;
    }
    public void setRoute(Route route) {
        this.route = route;
    }
}
