package com.javafee.java.lessons.lesson15.model.repository.jakartadb;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.reflections.Reflections;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HibernateConfig {
    private static final SessionFactory sessionFactory;
    private static final Session session;
    private static EntityManager entityManager;
    private static final StandardServiceRegistry registry;

    static {
        try {
            Properties prop = new Properties();
            try (InputStream resourceAsStream = HibernateConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
                prop.load(resourceAsStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

            Map<String, String> settings = new HashMap<>();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, prop.getProperty("db.url"));
            settings.put(Environment.USER, prop.getProperty("db.username"));
            settings.put(Environment.PASS, prop.getProperty("db.password"));
            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL82Dialect");
            settings.put(Environment.CACHE_PROVIDER_CONFIG, "org.hibernate.cache.internal.NoCacheProvider");
            settings.put(Environment.HBM2DDL_AUTO, "update");
            settings.put(Environment.NON_CONTEXTUAL_LOB_CREATION, "true");

            registryBuilder.applySettings(settings);
            registry = registryBuilder.build();

            Reflections reflections = new Reflections("com.javafee.java.lessons.lesson15.model.entity");
            Set<Class<?>> classes = reflections.getTypesAnnotatedWith(javax.persistence.Entity.class);

            MetadataSources sources = new MetadataSources(registry);
            classes.forEach(sources::addAnnotatedClass);

            Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
            session = sessionFactory.openSession();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession() {
        return session;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void beginTransaction() {
        if (!session.getTransaction().isActive())
            session.beginTransaction();
    }

    public static void commitTransaction() {
        session.getTransaction().commit();
    }

    public static void rollbackTransaction() {
        session.getTransaction().rollback();
    }

    public static void closeSession() {
        session.close();
    }

    public static EntityManager createAndGetEntityManager() {
        entityManager = getSessionFactory().createEntityManager();
        return entityManager;
    }

    public static void beginJpaTransaction() {
        createAndGetEntityManager();
        entityManager.getTransaction().begin();
    }

    public static void commitJpaTransaction() {
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
