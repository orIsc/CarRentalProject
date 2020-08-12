package com.hit.comparator;

import java.util.Comparator;
import com.hit.dm.Car;

public class CarByModel implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
    	return o1.getModel().compareTo(o2.getModel());
    }
}
