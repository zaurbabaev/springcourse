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
//        try (sessionFactory) {
//            Session session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Person person = session.get(Person.class, 1);
//            System.out.println(person);
//            session.getTransaction().commit();
//        }

        try (sessionFactory){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person1 = new Person("Test1", 30);
            Person person2 = new Person("Test2", 40);
            Person person3 = new Person("Test3", 50);

            session.save(person1);
            session.save(person2);
            session.save(person3);
            session.getTransaction().commit();
        }

    }
}
