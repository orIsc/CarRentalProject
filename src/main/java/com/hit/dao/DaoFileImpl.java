package com.hit.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hit.dm.Car;

public class DaoFileImpl implements IDao {
    
    private static String path;
    private static DaoFileImpl instance;
    
    private DaoFileImpl(String path) {
    	setPath(path);
    }
    
    public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		DaoFileImpl.path = path;
	}

	public static IDao getInstance(String path) {
    	if(instance == null) {
    		instance = new DaoFileImpl(path);
    	}
    	return instance;
    }
    
    @Override
    public void save(Car car) {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	 try (Reader reader = new FileReader(path)) {
		 	Type carListType = new TypeToken<ArrayList<Car>>(){}.getType();
	        List<Car> carList = gson.fromJson(reader, carListType);
	        carList.add(car);
	        try(Writer writer = new FileWriter(path)) {
	        	gson.toJson(carList, writer);
	        }catch(IOException e) {
	        	e.printStackTrace();
	        }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void delete(Car car) {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	 try (Reader reader = new FileReader(path)) {
	     Type carListType = new TypeToken<ArrayList<Car>>(){}.getType();
	     List<Car> carList = gson.fromJson(reader, carListType);
	     Iterator<Car> itr = carList.iterator();
	     while(itr.hasNext()) {
		 if(itr.next().isEqual(car))
		     itr.remove();
	    }
	    try(Writer writer = new FileWriter(path)) {
	        gson.toJson(carList, writer);
	    }catch(IOException e) {
	        	e.printStackTrace();
	    }
	 } catch (IOException e) {
	     e.printStackTrace();
	}
    }

    @Override
    public ArrayList<Car> getAll() {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	ArrayList<Car> carList = new ArrayList<>();
	 try (Reader reader = new FileReader(path)) {
	     	    Type carListType = new TypeToken<ArrayList<Car>>(){}.getType();
	            carList = gson.fromJson(reader, carListType);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return carList;
    }

    @Override
    public void update(Car car, Car updatedCar) {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	ArrayList<Car> carList = new ArrayList<>();
	 try (Reader reader = new FileReader(path)) {
	     Type carListType = new TypeToken<ArrayList<Car>>(){}.getType();
	     carList = gson.fromJson(reader, carListType);
	     for(Car c : carList) {
		 if(c.isEqual(car)) {
		     c.setCompany(updatedCar.getCompany());
		     c.setModel(updatedCar.getModel());
		     c.setYear(updatedCar.getYear());
		     c.setPrice(updatedCar.getPrice());
		 }
	     }
	    try(Writer writer = new FileWriter(path)) {
	        gson.toJson(carList, writer);
	    }catch(IOException e) {
	        	e.printStackTrace();
	    }
	 } catch (IOException e) {
	     e.printStackTrace();
	}
    }

}
