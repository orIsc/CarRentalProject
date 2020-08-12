package com.hit.dao;

import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.hit.dm.Car;

public class SaveTest {
    
    private IDao idao;
    private List<Car> carList;
    private Car car1;
    private Car car2;
    
    @Before
    public void before() {
    	idao = DaoFileImpl.getInstance("src/main/resources/DataModel.json");
    	assertNotNull(idao);
    	car1 = new Car("Citroen", "c5", 2018, 44000);
    	assertNotNull(car1);
    	car2 = new Car("shevrolet", "cruz", 2016, 26000);
    	assertNotNull(car2);
    }
    
    @After
    public void after() {
    	carList = idao.getAll();
    	for(Car car : carList)
    		System.out.println(car);
    }
    
    @Test
    public void test() {
    	idao.save(car1);
    	idao.save(car2);
    }

}
