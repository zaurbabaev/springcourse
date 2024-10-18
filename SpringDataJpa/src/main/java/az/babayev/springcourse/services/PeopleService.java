package az.babayev.springcourse.services;

import az.babayev.springcourse.models.Person;
import az.babayev.springcourse.repositories.PeopleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository repository;

    public PeopleService(PeopleRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findOne(int id) {
        return repository.findById(id)
                .orElse(null);
    }

    public Optional<Person> findEmail(String email) {
        return repository.findByEmail(email);
    }

    @Transactional
    public void save(Person person) {
        repository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        repository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
