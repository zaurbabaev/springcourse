package com.example.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "passport", schema = "hibernate")
public class Passport implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person person;

    @Column(name = "passport_number")
    int passportNumber;

    public Passport(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "person=" + person +
                ", passportNumber=" + passportNumber +
                '}';
    }

}
