package az.babayev.springcourse.config.util;

import az.babayev.springcourse.dao.PersonDAO;
import az.babayev.springcourse.models.Person;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Service
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        Optional<Person> email = personDAO.getEmail(person.getEmail());
        if (email.isPresent()) {
            errors.rejectValue("email", "", "This email is already token");
        }

    }
}
