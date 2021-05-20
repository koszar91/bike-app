package model;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Bike")
public class Bike {

    public enum BikeType {
        ROAD("Road"),
        MOUNTAIN("Mountain"),
        HYBRID("Hybrid"),
        ELECTRIC("Electric"),
        TOURING("Touring");

        BikeType(String name) { this.name = name; }

        @Getter
        private final String name;
    }

    public enum Color {
        RED("Red"),
        YELLOW("Yellow"),
        BLACK("Black"),
        WHITE("White");

        Color(String name) { this.name = name; }

        @Getter
        private final String name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bikeID;

    private @Getter @Setter Color color;

    private @Getter @Setter BikeType type;
    private @Getter @Setter String name;

    @OneToOne(mappedBy = "bike", optional = false)
    private @Getter @Setter User user;


    public Bike(String name, Color color, BikeType type) {
        this.name = name;
        this.color = color;
        this.type = type;
    }

}
