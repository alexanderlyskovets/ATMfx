package ru.lyskovets.util;

import ru.lyskovets.model.CardinfoEntity;

import java.sql.SQLException;

public interface AtmDAO {
    public void addCardinfoEntity(CardinfoEntity cardinfoEntity) throws SQLException;
    public void updateCardinfoEntity(String id, CardinfoEntity cardinfoEntity) throws SQLException;
    public CardinfoEntity getCardinfoEntityById(String id) throws SQLException;
}