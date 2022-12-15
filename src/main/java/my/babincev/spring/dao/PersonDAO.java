package my.babincev.spring.dao;

import my.babincev.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//класс общается с БД по CRUD
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 18, "tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 21, "bobi222@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 32, "michael@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 25, "katy2002002@gmail.com"));

    }

    public List<Person> getPeople(){
        return people;
    }

    public Person getPersonById(int id) throws Exception {
        for (Person person:
                people) {
            if (person.getId() == id){
                return person;
            }
        }
        throw new Exception("Person not found!");
    }

    public Person getPerson(int id) throws Exception {
        return getPersonById(id);
    }

    public void savePerson(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void updatePerson(int id, Person person){
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == id){
                person.setId(id);
                people.set(i, person);
                return;
            }
        }
    }

    public void deletePerson(int id) throws Exception {
        Person person = getPersonById(id);
        people.remove(person);
    }
}
