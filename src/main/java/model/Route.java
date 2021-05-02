package model;


import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.List;


@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int routeID;

    @NotNull
    @Column(unique = true)
    private String name;

    private int length;

    @OneToMany(mappedBy = "route")
    private List<Ride> rides;

    public Route() { }


    // boring getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }
}
