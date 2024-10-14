package com.example;


import com.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Person person = new Person("Kenan", 32);
        savePerson(sessionFactory,person);
        System.out.println(person.getId());

    }

    private static void deletePerson(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 1);

            session.remove(person);

            session.getTransaction().commit();
        }
    }

    private static void changePersonName(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 1);

            person.setName("Zaur");

            session.getTransaction().commit();
        }
    }

    private static void savePerson(SessionFactory sessionFactory, Person person) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.save(person);

            int idVahid = person.getId();

            session.getTransaction().commit();
            System.out.println(idVahid);
        }
    }
}
