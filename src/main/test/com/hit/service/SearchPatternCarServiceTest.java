package com.hit.service;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.hit.algorithm.KmpAlgo;
import com.hit.algorithm.RabinKarpAlgo;
import com.hit.carField.CompanyField;
import com.hit.carField.ModelField;
import com.hit.carField.YearField;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import com.hit.dm.Car;

public class SearchPatternCarServiceTest {

    private List<Car> matchCars = new ArrayList<Car>();
    private KmpAlgo kmpAlgo;
    private CompanyField companyField;
    private IDao idao;
    private ModelField modelField;
    private RabinKarpAlgo rabinKarpAlgo;
    private SearchPatternCarService searchPatternCarService;
    private YearField yearField;
    
    @Before
    public void Before() {
    	kmpAlgo = new KmpAlgo();
    	assertNotNull(kmpAlgo);
	
    	companyField = new CompanyField();
    	assertNotNull(companyField);
	
    	idao = DaoFileImpl.getInstance("src/main/resources/DataModel.json");
    	assertNotNull(idao);
	
    	modelField = new ModelField();
    	assertNotNull(modelField);
	
    	rabinKarpAlgo = new RabinKarpAlgo();
    	assertNotNull(rabinKarpAlgo);
	
    	yearField = new YearField();
    	assertNotNull(yearField);
    }
    
    @After
    public void after() {
    	for(Car car : matchCars) {
    		System.out.println(car);
    	}
    }
    
    @Test
    public void test1() {
    	searchPatternCarService = new SearchPatternCarService(kmpAlgo, companyField, idao);
    	assertNotNull(searchPatternCarService);
    	matchCars = searchPatternCarService.searchPatternInCarList("a");
    	System.out.println("Company matches: ");
    }
    
    @Test
    public void test2() {
    	searchPatternCarService = new SearchPatternCarService(rabinKarpAlgo, modelField, idao);
    	assertNotNull(searchPatternCarService);
    	matchCars = searchPatternCarService.searchPatternInCarList("c");
    	System.out.println("Model matches: ");
    }

    @Test
    public void test3() {
    	searchPatternCarService = new SearchPatternCarService(rabinKarpAlgo, yearField, idao);
    	assertNotNull(searchPatternCarService);
    	matchCars = searchPatternCarService.searchPatternInCarList("2016");
    	System.out.println("Year matches: ");
    }
}
