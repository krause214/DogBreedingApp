package my.babincev.spring.service;

import my.babincev.spring.dao.DogDAO;
import my.babincev.spring.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DogService {
    private final DogDAO dogDAO;

    @Autowired
    public DogService(DogDAO dogDAO) {
        this.dogDAO = dogDAO;
    }

    public Dog getDog(int id) throws Exception {
        return dogDAO.getDog(id);
    }

    public void addDog(Dog dog) {
        dogDAO.addDog(dog);
    }

    public void updateDog(int id, Dog dog) {
        dogDAO.updateDog(id, dog);
    }

    public void deleteDog(int id) {
        dogDAO.deleteDog(id);
    }

    public List<Dog> getDogs() {
        return dogDAO.getDogs();
    }
}
