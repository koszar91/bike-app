package model;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rideID;


    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private @Getter @Setter User user;

    @ManyToOne
    @JoinColumn(name = "routeID", referencedColumnName = "routeID")
    private @Getter @Setter Route route;

    private @Getter @Setter String rideDate;
    private @Getter @Setter double rideTime;

    public Ride(User user, Route route, String rideDate, double rideTime) {
        this.user = user;
        this.route = route;
        this.rideDate = rideDate;
        this.rideTime = rideTime;
    }
}
