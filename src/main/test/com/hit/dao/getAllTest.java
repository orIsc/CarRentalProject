package com.hit.dao;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.hit.dm.Car;

public class getAllTest {

    private IDao idao;
    private List<Car> carList; 
   
    @Before
    public void before() {
    	idao = DaoFileImpl.getInstance("src/main/resources/DataModel.json");
    	assertNotNull(idao);
    }
    
    @After
    public void after() {
    	for(Car car : carList) {
    		System.out.println(car);
    	}
    }
    
    @Test
    public void test() {
    	carList = idao.getAll();
    	assertNotNull(carList);
    }

}
