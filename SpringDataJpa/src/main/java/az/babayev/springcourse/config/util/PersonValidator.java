package az.babayev.springcourse.config.util;

import az.babayev.springcourse.models.Person;
import az.babayev.springcourse.repositories.PeopleRepository;
import az.babayev.springcourse.services.PeopleService;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Service
public class PersonValidator implements Validator {

    private final PeopleService peopleService;

    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        Optional<Person> email = peopleService.findEmail(person.getEmail());
        if (email.isPresent()) {
            errors.rejectValue("email", "", "This email is already token");
        }

    }
}
