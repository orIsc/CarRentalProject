package com.hit.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.hit.dm.Car;

public class DeleteTest {

    private IDao idao;
    private List<Car> carList;
    private Car car;
    
    @Before
    public void before() {
    	idao = DaoFileImpl.getInstance("src/main/resources/DataModel.json");
    	assertNotNull(idao);
    	car = new Car("Jeep", "rubicon", 2018, 60000);
    	assertNotNull(car);
    }
    
    @After
    public void after() {
    	carList = idao.getAll();
    	for(Car car : carList)
    		System.out.println(car);
    }
    
    @Test
    public void test() {
    	idao.delete(car);
    }

}
