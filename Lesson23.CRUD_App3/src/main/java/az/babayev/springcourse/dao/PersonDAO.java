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
        people.add(new Person(++PERSON_COUNT, "Tom", "Tommi", "tom@xyz.az"));
        people.add(new Person(++PERSON_COUNT, "Bob", "Bobbi", "bob@xyz.az"));
        people.add(new Person(++PERSON_COUNT, "Mike", "Mikael", "mike@xyz.ru"));
        people.add(new Person(++PERSON_COUNT, "Katy", "Kataline", "katy@xyz.az"));
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


    public void save(Person person) {
        person.setId(++PERSON_COUNT); // formda id yoxdur ona görədə yeni person əlavə edildikdə id 1 vahid artacaq
        people.add(person);
    }


    public void update(int id, Person person) {
        Person personUpdated = show(id);
        personUpdated.setName(person.getName());
        personUpdated.setSurname(person.getSurname());
        personUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
