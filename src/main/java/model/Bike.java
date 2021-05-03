package model;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Bike {

    public enum BikeType {
        ROAD,
        MOUNTAIN,
        HYBRID,
        ELECTRIC,
        TOURING
    }

    public enum Color {
        Red,
        Yellow,
        Black,
        White
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bikeID;

    private @Getter @Setter Color color;
    private @Getter @Setter BikeType type;


    public Bike(Color color, BikeType type) { this.color = color; this.type = type; }

}
