package ru.lyskovets.util;

import ru.lyskovets.model.CardinfoEntity;

import org.hibernate.Session;
import java.sql.SQLException;

public class AtmDAOimpl implements AtmDAO {
    public void addCardinfoEntity(CardinfoEntity cardinfoEntity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cardinfoEntity);
            session.getTransaction().commit();
        } catch (Exception ex) {
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
            session = HibernateUtil.getSessionFactory().openSession();
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
            session = HibernateUtil.getSessionFactory().openSession();
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
