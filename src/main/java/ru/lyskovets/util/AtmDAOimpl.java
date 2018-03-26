package ru.lyskovets.util;

import org.hibernate.HibernateException;
import ru.lyskovets.model.CardinfoEntity;

import org.hibernate.Session;
import java.sql.SQLException;

import static ru.lyskovets.util.HibernateUtil.getSessionFactory;

public class AtmDAOimpl implements AtmDAO {
    public void addCardinfoEntity(CardinfoEntity cardinfoEntity) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cardinfoEntity);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateCardinfoEntity(String id, CardinfoEntity cardinfoEntity) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cardinfoEntity);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public CardinfoEntity getCardinfoEntityById(String id) {
        Session session = null;
        CardinfoEntity cardinfoEntity = null;
        try {
            session = getSessionFactory().openSession();
            cardinfoEntity = session.load(CardinfoEntity.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cardinfoEntity;
    }
}
