package model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="AppUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;


    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String nickName;

    private String dateOfBirth;

    @OneToMany
    @JoinTable(name = "IsFriendTo")
    private List<User> friends = new LinkedList<>();

    @OneToMany(mappedBy = "user")
    private List<Ride> rides;

    public User() { }
    public User(String nickName) { this.nickName = nickName; }


    // boring getters and setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public List<User> getFriends() { return friends; }
    public void setFriends(List<User> friends) { this.friends = friends; }
}
