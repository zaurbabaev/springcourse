package az.babayev.springcourse.util;

import az.babayev.springcourse.dao.PersonDAO;
import az.babayev.springcourse.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        Optional<Person> fullName = personDAO.getPersonByFullName(person.getFullName());
        if (fullName.isPresent())
            errors.rejectValue("fullName", "", "Человек с таким ФИО уже существует");
    }

}
