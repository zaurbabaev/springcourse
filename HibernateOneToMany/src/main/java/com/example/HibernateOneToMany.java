package com.example;


import com.example.model.Item;
import com.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HibernateOneToMany {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        getAllItemByPerson(sessionFactory);
//        getPersonByItem(sessionFactory);
//        addItemToPerson(sessionFactory);
//        createNewPersonAndNewItem(sessionFactory);
//        deleteItemByPerson(sessionFactory);

//        deletePerson(sessionFactory);

//        setItemOwner(sessionFactory);
        updateItemOwner(sessionFactory);
    }


    private static void getAllItemByPerson(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 5);

            System.out.println(person);

            List<Item> items = person.getItems();

            System.out.println(items);

            session.getTransaction().commit();
        }
    }

    private static void getPersonByItem(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Item item = session.get(Item.class, 13);
            System.out.println(item);
            Person owner = item.getOwner();
            System.out.println(owner.getName());

            session.getTransaction().commit();
        }
    }


    private static void addItemToPerson(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            Item newItem = new Item("Pen");
            newItem.setOwner(person);

            person.getItems().add(newItem);

            session.save(newItem);

            session.getTransaction().commit();
        }
    }

    private static void createNewPersonAndNewItem(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person newPerson = new Person("Elvin", 25);
            Item newItem = new Item("Bicycle", newPerson);

//            newPerson.getItems().add(newItem); olmaz çünki yeni personda olan items initialization olunmayıb NullPointer atır

//            newPerson.setItems(new ArrayList<>(List.of(newItem))); bu üsulda düzgündür
            newPerson.setItems(Collections.singletonList(newItem)); // hər 2 üsulla newItem əlavə edə bilərik
            session.save(newPerson);
            session.save(newItem);

            session.getTransaction().commit();
        }
    }

    private static void deleteItemByPerson(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 4);

            List<Item> items = person.getItems();

            //SQL
            items.forEach(session::remove);

            //SQL yaranmır lakin keşin düz işləməsi üçün lazımdır
            person.getItems().clear();

            session.getTransaction().commit();
        }
    }

    private static void deletePerson(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 3);

            //SQL
            session.remove(person);

            // keş üçün lazımdır
            person.getItems().forEach(p -> p.setOwner(null));

            session.getTransaction().commit();
        }
    }

    private static void setItemOwner(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Item item = session.get(Item.class, 3);
            Person person = session.get(Person.class, 1);
            item.setOwner(person);

            person.setItems(new ArrayList<>(List.of(item)));

            session.save(item);

            session.getTransaction().commit();
        }
    }

    private static void updateItemOwner(SessionFactory sessionFactory) {
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Item item = session.get(Item.class, 1);
            Person person = session.get(Person.class, 4);

            item.getOwner().getItems().remove(item);
            //SQL
            item.setOwner(person);

            person.setItems(new ArrayList<>(List.of(item)));

            session.getTransaction().commit();
        }
    }


}