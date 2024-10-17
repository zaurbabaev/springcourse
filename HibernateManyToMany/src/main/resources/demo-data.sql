CREATE TABLE actor
(
    id   INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    age  INTEGER CHECK ( age > 0 )
);

CREATE TABLE movie
(
    id                 INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name               VARCHAR(200) NOT NULL,
    year_of_production DATE CHECK ( year_of_production > '1900-01-01' )
);


CREATE TABLE actor_movie
(
    actor_id INTEGER REFERENCES actor (id),
    movie_id INTEGER REFERENCES movie (id),
    PRIMARY KEY (actor_id, movie_id)
);



SELECT a.name, a.age, m.name, m.year_of_production
FROM movie m
         JOIN actor_movie a_m ON m.id = a_m.movie_id
         JOIN actor a ON a_m.actor_id = a.id;


