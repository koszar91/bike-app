package model;

import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="AppUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;


    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;

    @Column(unique = true)
    private @Getter @Setter String nickName;

    private @Getter @Setter String dateOfBirth;

    @ManyToMany
    @JoinTable(name = "IsFriendTo")
    private @Getter @Setter List<User> friends = new LinkedList<>();

    @OneToMany(mappedBy = "user")
    private @Getter @Setter List<Ride> rides;

    @OneToOne
    @Nullable
    private @Getter @Setter Bike bike;

    public User(String nickName) { this.nickName = nickName; }

    public User(String firstName, String lastName, String nickName, String dateOfBirth, Bike bike) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.dateOfBirth = dateOfBirth;
        this.bike = bike;
    }
}
