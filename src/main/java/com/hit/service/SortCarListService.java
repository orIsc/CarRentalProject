package com.hit.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.hit.dao.IDao;
import com.hit.dm.Car;

public class SortCarListService {

    private Comparator<Car> comparator;
    private IDao iDao;
    private List<Car> carList;
    
    public SortCarListService(Comparator<Car> comparator, IDao iDao) {
	super();
	this.comparator = comparator;
	this.iDao = iDao;
    }
    
    public List<Car> sortCarList() {
	carList = iDao.getAll();
	Collections.sort(carList, comparator);
	return carList;
    }
    
    public void sortCurrentCarList(List<Car> carList) {
 	Collections.sort(carList, comparator);
     }
    
}
