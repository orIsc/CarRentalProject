package com.hit.comparator;

import java.util.Comparator;
import com.hit.dm.Car;

public class CarByCompany implements Comparator<Car> {
    
    @Override
    public int compare(Car o1, Car o2) {
    	return o1.getCompany().compareTo(o2.getCompany());
    }
    
}
