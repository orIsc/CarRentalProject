package com.hit.dao;

import java.util.ArrayList;

import com.hit.dm.Car;

public interface IDao {
    public void update(Car car, Car updatedCar);
    public void save(Car car);
    public void delete(Car car);
    public ArrayList<Car> getAll();
    
}
