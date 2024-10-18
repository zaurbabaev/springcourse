create table person
(
    id    INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    age   INTEGER      NOT NULL,
    email VARCHAR(30)  NOT NULL UNIQUE
);

INSERT INTO person (name, age, email)
VALUES ('Bob1', 25, 'bob1@mail.ru'),
       ('Bob2', 40, 'bob2@mail.ru'),
       ('Toni1', 33, 'toni1@mail.ru');

CREATE TABLE item
(
    id        INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    person_id INTEGER      REFERENCES person (id) ON DELETE SET NULL,
    item_name VARCHAR(100) NOT NULL
);

INSERT INTO item (person_id, item_name)
VALUES ((select id from person where name='Bob'),'Airpods'),
       ((select id from person where name='Tom'),'Playstation'),
       ((select id from person where name='Toni'),'TV');

delete from person where email is NULL;

ALTER TABLE person ADD COLUMN date_of_birth DATE;

ALTER TABLE person ADD COLUMN create_at TIMESTAMP;

UPDATE person set date_of_birth=current_date;

UPDATE person set create_at=current_timestamp;

ALTER TABLE person ADD COLUMN mood VARCHAR(10);