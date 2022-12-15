package my.babincev.spring.service;

import my.babincev.spring.dao.PersonDAO;
import my.babincev.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleService {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    public List<Person> getPeople() {
        return personDAO.getPeople();
    }

    public Person getPerson(int id) throws Exception {
        return personDAO.getPerson(id);
    }

    public void savePerson(Person person) {
        personDAO.savePerson(person);
    }

    public void updatePerson(int id, Person person) {
        personDAO.updatePerson(id, person);
    }

    public void deletePerson(int id) throws Exception {
        personDAO.deletePerson(id);
    }
}
