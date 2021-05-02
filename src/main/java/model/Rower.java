package model;

import javax.persistence.*;


@Entity
public class Rower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rowerID;

    private String brand;
    private String color;
    private int numberOfGears;
    private int price;
    private TypeOfBike typeOfBike;

    @OneToOne
    private User owner;

    public Rower() {
    }

    public Rower(String color) {
        this.color = color;
    }


    public int getRowerID() {
        return rowerID;
    }

    public void setRowerID(int rowerID) {
        this.rowerID = rowerID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TypeOfBike getTypeOfBike() {
        return typeOfBike;
    }

    public void setTypeOfBike(TypeOfBike typeOfBike) {
        this.typeOfBike = typeOfBike;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
