package com.evpa.mj.chs.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class EventTest {

    private SessionFactory sessionFactory;
    private StandardServiceRegistry registry;
    private Session session;

    @Before
    public void setUp() {
        registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @Test
    public void testSessionInsertSelect() {

        session.save(new Event("First event", new Date()));
        session.save(new Event("Second event", new Date()));

        List<Event> eventList = session.createQuery(" from Event ").list();

        Assert.assertTrue(eventList.size() > 0);

        for (Event e: eventList) {
            System.out.println(e.getDate() + " " + e.getTitle());
        }
    }



    @After
    public void tearDown() {
        session.getTransaction().commit();
        session.close();
        if (registry != null)
            StandardServiceRegistryBuilder.destroy(registry);
    }
}
