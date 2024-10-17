package com.example;


import com.example.model.Item;
import com.example.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateOneToMany {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try (sessionFactory) {
//            getPersonLaterItems(session);

            Person person = session.get(Person.class, 1);
            System.out.println("Personu çağırırıq");

            Hibernate.initialize(person.getItems());

            session.getTransaction().commit();

//            System.out.println(person.getItems());
            System.out.println("Sessiyanin sonu");


            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("2ci tranzaksiyanin daxilinde");

//            person = session.merge(person);

//            Hibernate.initialize(person.getItems());

            List<Item> resultList = session.createQuery(
                    "SELECT i FROM Item i WHERE i.owner.id=:personId", Item.class)
                    .setParameter("personId",person.getId())
                    .getResultList();
            session.getTransaction().commit();

            System.out.println("2ci sessiyadan xaric");
            System.out.println(resultList);

        }


    }

    private static void getPersonLaterItems(Session session) {
        Person person = session.get(Person.class, 1);
        System.out.println("Personu aldiq");

        // Əlaqəli obyekti gətirək Lazy
        System.out.println(person.getItems());
    }


}