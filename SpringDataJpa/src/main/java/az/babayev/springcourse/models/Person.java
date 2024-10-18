package az.babayev.springcourse.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    String name;

    @Min(value = 0, message = "Age should be greater than 0")
    int age;

    @Column(name = "email")
    @NotEmpty(message = "Email should be not empty")
    String email;


    public Person(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
