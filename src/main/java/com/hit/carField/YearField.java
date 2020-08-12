package com.hit.carField;

import com.hit.dm.Car;

public class YearField implements CarField {

    @Override
    public String getField(Car car) {
    	return Integer.toString(car.getYear());
    }

}
