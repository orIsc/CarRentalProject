package com.hit.carField;

import com.hit.dm.Car;

public class CompanyField implements CarField{

    @Override
    public String getField(Car car) {
    	return car.getCompany();	
    }

}
