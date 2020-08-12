package com.hit.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.hit.algorithm.IAlgoStringMatching;
import com.hit.carField.CarField;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import com.hit.dm.Car;

public class CarService {
	private IAlgoStringMatching iAlgoStringMatching;
    private IDao iDao;
    private CarField carField;
    private Comparator<Car> comparator;
    private List<Car> matchCars = new ArrayList<>();
    private List<Car> carList = new ArrayList<>();
    
    public CarService(IAlgoStringMatching iAlgoStringMatching, 
	    CarField carField, Comparator<Car> comparator) {
    	super();
    	this.iAlgoStringMatching = iAlgoStringMatching;
    	this.carField = carField;
    	this.iDao = DaoFileImpl.getInstance("src/main/resources/DataModel.json");
    	this.comparator = comparator;
    }
    
    public List<Car> searchPatternInCarList(String pat) {
    	carList = iDao.getAll();
    	String txt;
    	for(Car car : carList) {
    	    txt = carField.getField(car);
    	    if(iAlgoStringMatching.searchStringMatching(pat, txt)) {
    		matchCars.add(car);
    	    }
    	}
    	return matchCars;   	
    }
    
    public List<Car> sortCarList() {
    	carList = iDao.getAll();
    	Collections.sort(carList, comparator);
    	return carList;
    }
        
    public void sortCurrentCarList(List<Car> carList) {
     	Collections.sort(carList, comparator);
    }
    
    public List<Car> getAll() {
		carList = iDao.getAll();
		return carList;
	}

    public void updateCar(Car car, Car updatedCar) {
    	iDao.update(car, updatedCar);
    }
    
    public void deleteCar(Car car) {
    	iDao.delete(car);
    }
    
    public void save(Car car) {
    	iDao.save(car);
    }
}
