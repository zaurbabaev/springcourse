package az.babayev.springcourse.dao;

import az.babayev.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Person show(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id=?", new BeanPropertyRowMapper<>(Person.class), id);

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

    /*Тестируем производительность пакетной вставки*/

    public void testMultipleUpdate() {
        List<Person> people = create100People();
        long before = System.currentTimeMillis();
        for (Person person : people) {
            jdbcTemplate.update("INSERT INTO person (name, surname, age, email)  VALUES(?,?,?,?)",
                    person.getName(), person.getSurname(), person.getAge(), person.getEmail());

        }
        long after = System.currentTimeMillis();

        System.out.println("Time: " + (after - before));

    }

    public void testBatchUpdate() {
        List<Person> people = create100People();
        long before = System.currentTimeMillis();

        jdbcTemplate.batchUpdate("INSERT INTO person (name, surname, age, email)  VALUES(?,?,?,?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement statement, int i) throws SQLException {
                        statement.setString(1, people.get(i).getName());
                        statement.setString(2, people.get(i).getSurname());
                        statement.setInt(3, people.get(i).getAge());
                        statement.setString(4, people.get(i).getEmail());
                        statement.executeUpdate();
                    }

                    @Override
                    public int getBatchSize() {
                        return people.size();
                    }
                });

        long after = System.currentTimeMillis();

        System.out.println("Time: " + (after - before));

    }

    private List<Person> create100People() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            people.add(new Person(i,"Name" + i, "Surname" + i,
                    i + 5, "email" + i + "@mail.ru"));
        }
        return people;
    }
}
