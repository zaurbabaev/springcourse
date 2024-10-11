package az.babayev.springcourse.dao;

import az.babayev.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Optional<Person> show(String email) {
        return (jdbcTemplate.query(
                        "SELECT * FROM person WHERE email=?", new BeanPropertyRowMapper<>(Person.class), email)
                .stream()
                .findFirst());
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(Integer id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM person WHERE id=?", new BeanPropertyRowMapper<>(Person.class), id);

    }


    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person (name, surname, age, email) VALUES (?,?,?,?)",
                person.getName(), person.getSurname(), person.getAge(), person.getEmail());
    }


    public void update(int id, Person person) {
        String UPDATE_QUERY = "UPDATE person SET name=?, surname=?, age=?, email=? WHERE id=?";
        jdbcTemplate.update(UPDATE_QUERY, person.getName(), person.getSurname(), person.getAge(), person.getEmail(), id);
    }

    public void delete(int id) {
        String DELETE_QUERY = "DELETE FROM person WHERE ID=?";
        jdbcTemplate.update(DELETE_QUERY, id);

    }

}
