package my.babincev.spring.dao;


import my.babincev.spring.models.Dog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DogMapper implements RowMapper<Dog> {
    @Override
    public Dog mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Dog dog = new Dog();
        dog.setId(resultSet.getInt("dog_id"));
        dog.setName(resultSet.getString("dog_name"));
        dog.setBreedId(resultSet.getInt("breed_id"));
        dog.setOwner(resultSet.getString("owner"));
        dog.setAddress(resultSet.getString("address"));
        dog.setAlive(resultSet.getBoolean("is_alive"));
        dog.setMentalTest(resultSet.getInt("mental_test"));
        return dog;
    }
}
