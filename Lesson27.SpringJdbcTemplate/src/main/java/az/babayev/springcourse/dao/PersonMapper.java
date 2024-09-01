package az.babayev.springcourse.dao;


import az.babayev.springcourse.models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// biz new BeanPropertyRowMapper<>(Person.class) klasından istifadə etiyimizə görə bu klasa ehiyac olmadı
// nümunə kimi qalsın. cədvəldə sütun adı ilə Klasın dəyişənləri eyni adlı oladuğundan biz Springin təqdim etdiyi
// klası tətbiq etdik bu klas -> new BeanPropertyRowMapper<>(Person.class)
public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setSurname(rs.getString("surname"));
        person.setAge(rs.getInt("age"));
        person.setEmail(rs.getString("email"));
        return person;
    }
}
