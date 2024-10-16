package com.example;


import com.example.model.Item;
import com.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HibernateCascade {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Person person = new Person("Tima", 40);

        Item item = new Item("Laptop");

        person.addItemToPerson(item);

        session.save(person);

        session.getTransaction().commit();

    }




}