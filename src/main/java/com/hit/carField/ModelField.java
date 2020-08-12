package com.hit.carField;

import com.hit.dm.Car;

public class ModelField implements CarField {

    @Override
    public String getField(Car car) {
	return car.getModel();
    }

}
