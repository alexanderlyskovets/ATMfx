/*
 * Copyright (c) 2018.
 * Written by Alexander Lyskovets
 *
 */

package ru.lyskovets.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private HibernateUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
