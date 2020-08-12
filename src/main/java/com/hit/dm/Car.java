package com.hit.dm;

public class Car{
    
    private String company;
    private String model;
    private int year;
    private int price;
    
    public Car(String company, String model, int year, int price) {
	super();
	this.company = company;
	this.model = model;
	this.year = year;
	this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
    
    @Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", year=" + year + ", price=" + price + "]";
	}

	public boolean isEqual(Car car) {
	 if(this.getCompany().equals(car.getCompany()) && this.getModel().equals(car.getModel()) 
 		&& Integer.toString(this.getYear()).equals(Integer.toString(car.getYear())) 
 		&& Integer.toString(this.getPrice()).equals(Integer.toString(car.getPrice()))) {
 		return true;
 	}
	return false;
    }

}
