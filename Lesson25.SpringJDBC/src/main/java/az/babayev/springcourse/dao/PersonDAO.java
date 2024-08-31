package az.babayev.springcourse.dao;

import az.babayev.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PERSON_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection = null;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

//    public Person show(Integer id) {
//        return people.stream()
//                .filter(person -> person.getId().equals(id))
//                .findAny()
//                .orElse(null);
//    }


    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO person VALUES ('"
                    + 1 + "', '"
                    + person.getName() + "', '"
                    + person.getSurname() + "', '"
                    + person.getAge() + "', '"
                    + person.getEmail() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//    public void update(int id, Person person) {
//        Person personUpdated = show(id);
//        personUpdated.setName(person.getName());
//        personUpdated.setSurname(person.getSurname());
//        personUpdated.setAge(person.getAge());
//        personUpdated.setEmail(person.getEmail());
//    }
//
//    public void delete(int id) {
//        people.removeIf(person -> person.getId() == id);
//    }
}
