package az.babayev.springcourse.dao;

import az.babayev.springcourse.models.Book;
import az.babayev.springcourse.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * from book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id=?", new BeanPropertyRowMapper<>(Book.class), id);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book (title, author, year) VALUES (?,?,?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE book SET title=?, author=?, year=? WHERE id=?",
                book.getTitle(), book.getAuthor(), book.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }


    // Book və Person cədvəllərini JOİN edirik və kitabın id-sinə əsasən avtorunu tapırıq
    public Optional<Person> getBookOwner(int id) {
        // Person cədvəlinin bütün sütnlarını seçirik
        return jdbcTemplate.query("SELECT person.* FROM book JOIN person ON book.person_id=person.id WHERE book.id=?",
                        new BeanPropertyRowMapper<>(Person.class), id)
                .stream().findAny();
    }

    // Kitabı azad edir, Person kitabı kitabxanaya qaytaran zaman bu metod çağrılır.
    public void release(int id) {
        jdbcTemplate.update("UPDATE book SET person_id=NULL WHERE id=?", id);
    }


    // Person kitabxanadan kitab götürərkən bu metod iş düşür. Persona kitabı mənimsədir.
    public void assign(int id, Person selectedPerson) {
        jdbcTemplate.update("UPDATE book SET person_id=? WHERE id=?", selectedPerson.getId(), id);
    }


}
