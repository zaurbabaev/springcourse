package az.babayev.springcourse.dao;

import az.babayev.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PERSON_COUNT;

    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PERSON_COUNT, "Tom"));
        people.add(new Person(++PERSON_COUNT, "Bob"));
        people.add(new Person(++PERSON_COUNT, "Mike"));
        people.add(new Person(++PERSON_COUNT, "Katy"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(Integer id) {
        return people.stream()
                .filter(person -> person.getId().equals(id))
                .findAny()
                .orElse(null);
    }






}
