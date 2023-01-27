package my.babincev.spring.utils;

import my.babincev.spring.dao.DogDAO;
import my.babincev.spring.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

/**
 * @author Andrey Babincev
 */
@Component
public class DogValidator implements Validator {

    private final DogDAO dogDAO;

    @Autowired
    public DogValidator(DogDAO dogDAO) {
        this.dogDAO = dogDAO;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Dog.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Dog dog = (Dog)target;

        Optional<Dog> optionalDog = dogDAO.getDog(dog.getName(), dog.getAddress());

        if (optionalDog.isPresent() && dog.getId() != optionalDog.get().getId()){
            errors.rejectValue("name", "", "This dog with the same address is already exists");
        }
    }
}
