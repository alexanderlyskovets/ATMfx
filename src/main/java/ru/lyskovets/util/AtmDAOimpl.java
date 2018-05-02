/*
 * Copyright (c) 2018.
 * Written by Alexander Lyskovets
 *
 */

package ru.lyskovets.util;

import ru.lyskovets.model.CardinfoEntity;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import static ru.lyskovets.util.HibernateUtil.getSessionFactory;

public class AtmDAOimpl implements AtmDAO {
    public void addCardinfoEntity(CardinfoEntity cardinfoEntity) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(cardinfoEntity);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

    public void updateCardinfoEntity(String id, CardinfoEntity cardinfoEntity) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(cardinfoEntity);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public CardinfoEntity getCardinfoEntityById(String id) {
        CardinfoEntity cardinfoEntity = null;
        try (Session session = getSessionFactory().openSession()) {
            cardinfoEntity = session.load(CardinfoEntity.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cardinfoEntity;
    }
}
