package com.hit.service;

import java.util.ArrayList;
import java.util.List;
import com.hit.algorithm.IAlgoStringMatching;
import com.hit.carField.CarField;
import com.hit.dao.IDao;
import com.hit.dm.Car;

public class SearchPatternCarService {
    private IAlgoStringMatching iAlgoStringMatching;
    private IDao iDao;
    private CarField carField;
    private List<Car> matchCars = new ArrayList<>();
    private List<Car> carList = new ArrayList<>();
    
    public SearchPatternCarService(IAlgoStringMatching iAlgoStringMatching, 
	    CarField carField, IDao iDao) {
	super();
	this.iAlgoStringMatching = iAlgoStringMatching;
	this.carField = carField;
	this.iDao = iDao;
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
}
