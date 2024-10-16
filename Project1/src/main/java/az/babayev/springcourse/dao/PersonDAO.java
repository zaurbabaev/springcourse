package az.babayev.springcourse.dao;

import az.babayev.springcourse.models.Book;
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


    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM person WHERE id=?", new BeanPropertyRowMapper<>(Person.class), id);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person (full_name, year_of_birth) VALUES (?,?)",
                person.getFullName(), person.getYearOfBirth());
    }


    public void update(int id, Person person) {
        String UPDATE_QUERY = "UPDATE person SET full_name=?,  year_of_birth=? WHERE id=?";
        jdbcTemplate.update(UPDATE_QUERY, person.getFullName(), person.getYearOfBirth(), id);
    }

    public void delete(int id) {
        String DELETE_QUERY = "DELETE FROM person WHERE id=?";
        jdbcTemplate.update(DELETE_QUERY, id);

    }

    // Full namenin unikallığını yoxlamaq üçün validasiya sorğusu
    public Optional<Person> getPersonByFullName(String fullName) {
        return jdbcTemplate.query("SELECT * FROM person WHERE full_name=?",
                        new BeanPropertyRowMapper<>(Person.class), fullName)
                .stream().findAny();

    }

    public List<Book> getBooksByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id=?", new BeanPropertyRowMapper<>(Book.class), id);
    }


}
