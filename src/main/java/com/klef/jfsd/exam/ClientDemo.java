package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Insert records
        insertClients(sessionFactory);

        // Fetch all records
        fetchAllClients(sessionFactory);

        sessionFactory.close();
    }

    private static void insertClients(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client1 = new Client();
        client1.setName("Pidikiti Sathwik");
        client1.setGender("Male");
        client1.setAge(20);
        client1.setLocation("Mangalagiri");
        client1.setEmail("Sathwik0.pidikiti@gmail.com.com");
        client1.setMobile("8639982518");

       

        session.save(client1);
       

        transaction.commit();
        session.close();
        System.out.println("Clients inserted successfully.");
    }

    private static void fetchAllClients(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

        List<Client> clients = session.createQuery("from Client", Client.class).list();
        clients.forEach(System.out::println);

        session.close();
    }
}
