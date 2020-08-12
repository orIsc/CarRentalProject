package com.hit.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hit.comparator.CarByCompany;
import com.hit.comparator.CarByModel;
import com.hit.comparator.CarByYear;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import com.hit.dm.Car;

public class SortCarListServiceTest {

    private List<Car> carList = new ArrayList<>();
    private CarByModel carByModel;
    private IDao idao;
    private SortCarListService sortCarListService;
    private CarByCompany carByCompany;
    private CarByYear carByYear;
    
    @Before
    public void before() {
	
    	carByModel = new CarByModel();
    	assertNotNull(carByModel);
	
    	idao = DaoFileImpl.getInstance("src/main/resources/DataModel.json");
    	assertNotNull(idao);
	
    	carByCompany = new CarByCompany();
    	assertNotNull(carByCompany);
	
    	carByYear = new CarByYear();
    	assertNotNull(carByYear);
    }
    
    @After
    public void after() {
    	for(Car car : carList) {
    		System.out.println(car);
    	}
    }
    
    @Test
    public void testModel() {
    	sortCarListService = new SortCarListService(carByModel, idao);
    	assertNotNull(sortCarListService);
    	carList = sortCarListService.sortCarList();
    	System.out.println("Sort by model: ");
    }

    @Test
    public void testCompany() {
    	sortCarListService = new SortCarListService(carByCompany, idao);
    	assertNotNull(sortCarListService);
    	carList = sortCarListService.sortCarList();
    	System.out.println("Sort by company: ");
    }

    @Test
    public void testYear() {
    	sortCarListService = new SortCarListService(carByYear, idao);
    	assertNotNull(sortCarListService);
    	carList = sortCarListService.sortCarList();
    	System.out.println("Sort by year: ");
    }

}
