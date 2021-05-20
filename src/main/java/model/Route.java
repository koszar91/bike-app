package model;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int routeID;

    @NotNull
    @Column(unique = true)
    private @Getter @Setter String name;

    private @Getter @Setter int length;

    @OneToMany(mappedBy = "route")
    private @Getter @Setter List<Ride> rides;


    public Route(int length, String name) {
        this.length = length;
        this.name = name;
    }
}
