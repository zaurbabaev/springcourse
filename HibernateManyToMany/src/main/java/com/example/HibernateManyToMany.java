package com.example;


import com.example.model.Actor;
import com.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class HibernateManyToMany {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Actor.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            saveMovieAndActors(session);
//            getMovieActors(session);

//            getActorMovies(session);

//            setMovieToActor(session);


            session.getTransaction().commit();
        }

    }

    private static void saveMovieAndActors(Session session) {
        Movie pulpFiction = new Movie("Pulp fiction", LocalDate.of(1994, Month.APRIL, 12));
        Actor harveyKetel = new Actor("Harvey Ketel", 81);
        Actor samuel = new Actor("Samuel L. Jackson", 72);

        pulpFiction.setActors(new ArrayList<>(List.of(harveyKetel, samuel)));

        harveyKetel.setMovies(new ArrayList<>(List.of(pulpFiction)));
        samuel.setMovies(new ArrayList<>(List.of(pulpFiction)));

        session.save(pulpFiction);
        session.save(harveyKetel);
        session.save(samuel);
    }

    public static void getMovieActors(Session session) {


        Movie movie = session.get(Movie.class, 4);
        movie.getActors()
                .forEach(actor -> System.out.println(actor.getName()));
    }

    public static void getActorMovies(Session session) {

        Actor actor = session.get(Actor.class, 2);
        actor.getMovies()
                .forEach(movie -> System.out.println(movie.getName()));
    }

    public static void setMovieToActor(Session session) {
        Movie fromDuskTillDawn = new Movie(
                "From Dusk till Dawn", LocalDate.of(1996, Month.JULY, 17));
        Movie findingGraceland = new Movie(
                "Finding Graceland", LocalDate.of(1998, Month.SEPTEMBER, 12));

        Actor harveyKetel = session.get(Actor.class, 2);

        harveyKetel.setMovies(new ArrayList<>(List.of(findingGraceland, fromDuskTillDawn)));

        findingGraceland.setActors(new ArrayList<>(List.of(harveyKetel)));
        fromDuskTillDawn.setActors(new ArrayList<>(List.of(harveyKetel)));


        session.save(findingGraceland);
        session.save(fromDuskTillDawn);

    }


}