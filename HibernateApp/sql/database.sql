CREATE TABLE person
(
    id   INTEGER PRIMARY KEY,
    name VARCHAR(100),
    age  INTEGER
);

drop table person;

select *
from person;

CREATE SEQUENCE person_id_seq start 1 increment 2;

drop sequence person_id_seq;
