/*
 * Copyright (c) 2018.
 * Written by Alexander Lyskovets
 *
 */

package ru.lyskovets.util;

import org.hibernate.HibernateException;
import ru.lyskovets.model.CardinfoEntity;

public interface AtmDAO {
    public void addCardinfoEntity(CardinfoEntity cardinfoEntity) throws HibernateException;
    public void updateCardinfoEntity(String id, CardinfoEntity cardinfoEntity) throws HibernateException;
    public CardinfoEntity getCardinfoEntityById(String id) throws HibernateException;
}