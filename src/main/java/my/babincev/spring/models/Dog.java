package my.babincev.spring.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Dog {
    @NotEmpty(message = "Empty name is not allowed!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;
    @NotEmpty(message = "Empty owner name is not allowed!")
    @Size(min = 2, max = 30, message = "Owner name should be between 2 and 30 characters")
    private String owner;

    private int id;
    private int breedId;

    //Country, City, index(6 digits)
    @NotEmpty(message = "Empty address name is not allowed!")
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Address should be in pattern: Country, City, index(6 digits)")
    private String address;
    private boolean alive;
    private int mentalTest;

    public int getBreedId() {
        return breedId;
    }

    public void setBreedId(int breedId) {
        this.breedId = breedId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Dog(String name, int id, int breedId,
               String owner, String address, boolean alive, int mentalTest) {
        this.name = name;
        this.id = id;
        this.breedId = breedId;
        this.owner = owner;
        this.address = address;
        this.alive = alive;
        this.mentalTest = mentalTest;
    }

    public int getMentalTest() {
        return mentalTest;
    }

    public void setMentalTest(int mentalTest) {
        this.mentalTest = mentalTest;
    }

    public Dog() {
    }

    public Dog(String name, String owner, int id) {
        this.name = name;
        this.owner = owner;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
