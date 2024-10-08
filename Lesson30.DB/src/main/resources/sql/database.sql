create database first_db;

CREATE TABLE person
(
    id      INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name    VARCHAR NOT NULL,
    surname VARCHAR NOT NULL,
    age     INTEGER NOT NULL CHECK ( age > 0 ),
    email   VARCHAR NOT NULL UNIQUE
);

INSERT INTO person(name, surname, age, email)
VALUES ('Zaur', 'Babayev', 37, 'zaur@gmail.com'),
       ('Vusal', 'Kerimov', 30, 'vusal@gmail.com'),
       ('Nagi', 'Nagiyev', 23, 'nagi@gmail.com'),
       ('Kamil', 'Eliyev', 54, 'kamil@gmail.com');

SELECT *
FROM person;

DROP table public.person;

delete
from person
where id = 5