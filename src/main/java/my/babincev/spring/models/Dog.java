package my.babincev.spring.models;

public class Dog {
    private String name;
    private String owner;
    private int id;
    private int breedId;
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
