package my.babincev.spring.dao;

import my.babincev.spring.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DogDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DogDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private static int DOG_COUNT;

    private ArrayList<Dog> dogs;

    public List<Dog> getDogs(){
        return jdbcTemplate.query("SELECT * FROM dog", new DogMapper());
    }

    public void addDog(Dog dog){
        jdbcTemplate.update("INSERT INTO dog VALUES(?,?,?,?,?,?,?)", dog.getId(), dog.getName(),
                dog.getBreedId(), dog.getOwner(), dog.getAddress(), dog.isAlive(),
                dog.getMentalTest());
    }

    public Dog getDog(int id) {
        return jdbcTemplate.query("SELECT * FROM dog WHERE dog_id =?", new Object[]{id}, new DogMapper())
                .stream().findAny().orElse(null);
    }

    public void updateDog(int id, Dog dog){
        jdbcTemplate.update("UPDATE dog SET dog_name=?, owner=?, address=?, mental_test=?," +
                "is_alive=? WHERE dog_id = ?", dog.getName(), dog.getOwner(), dog.getAddress(),
                dog.getMentalTest(), dog.isAlive(), id);
    }

    public void deleteDog(int id) {
        jdbcTemplate.update("DELETE FROM dog WHERE dog_id=?", id);
    }
}
