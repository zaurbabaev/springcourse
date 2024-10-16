package com.example;


import com.example.model.Passport;
import com.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateOneToOne {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

//        savePersonAndPassport(session);

//        getPassport(session);
//        setPassport(session);
        deletePerson(session);

        session.getTransaction().commit();

    }

    private static void savePersonAndPassport(Session session) {
        Person person = new Person("Conan", 20);
        Passport passport = new Passport(423456342);

        person.setPassport(passport);
        session.save(person);
    }

    private static void getPassport(Session session) {
        Passport passport = session.get(Passport.class, 12);
        System.out.println(passport);
        System.out.println(passport.getPerson().getName());
    }

    private static void setPassport(Session session) {
        Person person = session.get(Person.class, 10);
        person.getPassport().setPassportNumber(987654);
    }

    private static void deletePerson(Session session) {
        Person person = session.get(Person.class, 10);
        session.remove(person);
    }


}