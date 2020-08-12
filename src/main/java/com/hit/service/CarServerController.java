package com.hit.service;

import java.util.ArrayList;
import java.util.List;

import com.hit.algorithm.KmpAlgo;
import com.hit.algorithm.RabinKarpAlgo;
import com.hit.carField.CompanyField;
import com.hit.carField.ModelField;
import com.hit.carField.PriceField;
import com.hit.carField.YearField;
import com.hit.comparator.CarByCompany;
import com.hit.comparator.CarByModel;
import com.hit.comparator.CarByPrice;
import com.hit.comparator.CarByYear;
import com.hit.dm.Car;

public class CarServerController {
	
	private List<Car> carList = new ArrayList<Car>();
	private CarService carService;
	
	public CarServerController(CarService carService) {
		this.carService = carService;
	}
	
	public CarServerController() {
		
	}
	
	public List<Car> searchPatternInCarListCompany(String pat) {
		carService = new CarService(new KmpAlgo(), new CompanyField(), new CarByCompany());
		carList = carService.searchPatternInCarList(pat);
		return carList;
	}
	
	public List<Car> searchPatternInCarListModel(String pat) {
		carService = new CarService(new KmpAlgo(), new ModelField(), new CarByModel());
		carList = carService.searchPatternInCarList(pat);
		return carList;
	}
	
	public List<Car> searchPatternInCarListYear(String pat) {
		carService = new CarService(new KmpAlgo(), new YearField(), new CarByYear());
		carList = carService.searchPatternInCarList(pat);
		return carList;
	}
	
	public List<Car> searchPatternInCarListPrice(String pat) {
		carService = new CarService(new KmpAlgo(), new PriceField(), new CarByPrice());
		carList = carService.searchPatternInCarList(pat);
		return carList;
	}
	
	public List<Car> sortCarListByCompany() {
		carService = new CarService(new RabinKarpAlgo(), new CompanyField(), new CarByCompany());
		carList = carService.sortCarList();
		return carList;
	}
	
	public List<Car> sortCarListByModel() {
		carService = new CarService(new KmpAlgo(), new ModelField(), new CarByModel());
		carList = carService.sortCarList();
		return carList;
	}
	
	public List<Car> sortCarListByYear() {
		carService = new CarService(new RabinKarpAlgo(), new YearField(), new CarByYear());
		carList = carService.sortCarList();
		return carList;
	}
	
	public List<Car> sortCarListByPrice() {
		carService = new CarService(new RabinKarpAlgo(), new PriceField(), new CarByPrice());
		carList = carService.sortCarList();
		return carList;
	}
	
	public void sortCurrentCarListByCompany(List<Car> carList) {
		carService = new CarService(new KmpAlgo(), new CompanyField(), new CarByCompany());
		carList = carService.sortCarList();
	}
	
	public void sortCurrentCarListByModel(List<Car> carList) {
		carService = new CarService(new RabinKarpAlgo(), new ModelField(), new CarByModel());
		carList = carService.sortCarList();
	}
	
	public void sortCurrentCarListByYear(List<Car> carList) {
		carService = new CarService(new KmpAlgo(), new YearField(), new CarByYear());
		carList = carService.sortCarList();
	}
	
	public void sortCurrentCarListByPrice(List<Car> carList) {
		carService = new CarService(new KmpAlgo(), new PriceField(), new CarByPrice());
		carList = carService.sortCarList();
	}
	
	public List<Car> getAllCars() {
		carService = new CarService(new RabinKarpAlgo(), new ModelField(), new CarByModel());
		carList = carService.getAll();
		return carList;
	}
	
	public void saveCar(Car car) {
		carService = new CarService(new KmpAlgo(), new CompanyField(), new CarByCompany());
		carService.save(car);
	}
	
	public void deleteCar(Car car) {
		carService = new CarService(new RabinKarpAlgo(), new YearField(), new CarByYear());
		carService.deleteCar(car);
	}
	
	public void updateCar(Car car, Car updatedCar) {
		carService = new CarService(new KmpAlgo(), new CompanyField(), new CarByCompany());
		carService.updateCar(car, updatedCar);
	}
}
