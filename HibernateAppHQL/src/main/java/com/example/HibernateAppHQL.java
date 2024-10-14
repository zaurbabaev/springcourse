package com.example;


import com.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateAppHQL {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        getAllPersonsWhereAgeBig30(sessionFactory).forEach(System.out::println);

//        getAllPersonsWhereNameStartWithK(sessionFactory).forEach(System.out::println);

//        updateName(sessionFactory);

//        delete(sessionFactory);

        Person person = new Person("Lamiye", 20);
        Person result = insert1(sessionFactory, person);
        System.out.println(result);
    }


    private static List<Person> getAll(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<Person> fromPerson = session.createQuery(
                            "FROM Person", Person.class)
                    .getResultList();
            session.getTransaction().commit();

            return fromPerson;
        }
    }

    private static List<Person> getAllPersonsWhereAgeBig30(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<Person> fromPerson = session.createQuery(
                            "FROM Person WHERE age > 30", Person.class)
                    .getResultList();
            session.getTransaction().commit();

            return fromPerson;
        }
    }

    private static List<Person> getAllPersonsWhereNameStartWithK(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<Person> resultList = session.createQuery("FROM Person WHERE name LIKE 'K%'", Person.class)
                    .getResultList();

            session.getTransaction().commit();
            return resultList;
        }
    }

    private static void updateName(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createMutationQuery(
                            "UPDATE Person SET age=25 WHERE name='Yusif'")
                    .executeUpdate();

            session.getTransaction().commit();
        }
    }

    private static void delete(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.createMutationQuery("DELETE FROM Person WHERE age=25")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    // buna ehtiyac yoxdur çünki HQL Obyektlərlə işləyir sadəcə save metoduna obyekti vermək kifayətdir
    private static Person insert(SessionFactory sessionFactory, Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.createMutationQuery("INSERT INTO Person (name, age) VALUES (name, age) ");
        session.save(person);

        session.getTransaction().commit();
        return person;
    }

    private static Person insert1(SessionFactory sessionFactory, Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(person);

        session.getTransaction().commit();
        return person;
    }

}
