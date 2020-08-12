package com.hit.server;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import com.hit.server.Request.Body;
import com.hit.server.Request.Header;
import com.google.gson.Gson;
import com.hit.dm.Car;
import com.hit.service.CarServerController;

public class HandleRequest implements PropertyChangeListener, Runnable {
   
    private String requestString;
    private Socket socket;
    private Request request;
    private CarServerController carServerController;
    private ObjectInputStream reader;
	private ObjectOutputStream writer;
    private List<Car> carList = new ArrayList<Car>();
    private Car car;
    private Response response;
    private String responseString;
    private String pat = "";
    private Body body;
    private Header header;
    
    public HandleRequest(Socket socket, CarServerController carServerController) {
    	super();
    	this.socket = socket;
    	this.carServerController = carServerController;
    	try {
    		writer = new ObjectOutputStream(this.socket.getOutputStream());
    		reader = new ObjectInputStream(this.socket.getInputStream());
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    	responseString = (String) evt.getNewValue();
		Thread t1 = new Thread(this);
		t1.start();
	}
    
    public Request readRequest(String requestString) {
    	Gson gson = new Gson();	
    	request = gson.fromJson(requestString, Request.class);   
    	return request;
    }
    
    public String writeResponse(Response response) {
    	Gson gson = new Gson();
    	responseString = gson.toJson(response);
    	return responseString;
    }
	
	@Override
	public void run() {
		header = new Header();
		body = new Body(new ArrayList<Car>(), new String());
		response = new Response(header, body);
		try {
			//messages that arrives from the client side.
			requestString = reader.readObject().toString();
			request = readRequest(requestString);
			System.out.println(request);
			
			//get the action from the client message
			String action = request.getHeader().getAction();
			
			switch (action) {

			case "Get-all" :
				carList = carServerController.getAllCars();
				body = new Body(carList, pat);
				response.setBody(body);
				System.out.println(response);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				writer.flush();
				break;

			case "Update-car":
				carList = request.getBody().getCarList();
				car = carList.get(0);
				Car updatedCar = carList.get(1);
				carServerController.updateCar(car, updatedCar);
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				writer.flush();
				break;

			case "Save-car":
				carList = request.getBody().getCarList();
				car = carList.get(0);
				carServerController.saveCar(car);
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				writer.flush();
				break;
				
			case "Delete-car": 
				carList = request.getBody().getCarList();
				car = carList.get(0);
				carServerController.deleteCar(car);
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				writer.flush();
				break;

			case "Search-carsByCompany":
				pat = request.getBody().getPat();
				carList = carServerController.searchPatternInCarListCompany(pat);
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
				
			case "Search-carsByModel":
				pat = request.getBody().getPat();
				carList = carServerController.searchPatternInCarListModel(pat);
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
				
			case "Search-carsByYear":
				pat = request.getBody().getPat();
				carList = carServerController.searchPatternInCarListYear(pat);
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
			
			case "Search-carsByPrice":
				pat = request.getBody().getPat();
				carList = carServerController.searchPatternInCarListPrice(pat);
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
				
			case "Sort-carByCompany":
				carList = carServerController.sortCarListByCompany();
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
				
			case "Sort-carByModel":
				carList = carServerController.sortCarListByModel();
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
				
			case "Sort-carByYear":
				carList = carServerController.sortCarListByYear();
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
			
			case "Sort-carByPrice":
				carList = carServerController.sortCarListByPrice();
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
				
			case "SortCurrent-carByCompany":
				carList = request.getBody().getCarList();
				carServerController.sortCurrentCarListByCompany(carList);
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
				
			case "SortCurrent-carByModel":
				carList = request.getBody().getCarList();
				carServerController.sortCurrentCarListByModel(carList);
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
				
			case "SortCurrent-carByYear":
				carList = request.getBody().getCarList();
				carServerController.sortCurrentCarListByYear(carList);
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
				
			case "SortCurrent-carByPrice":
				carList = request.getBody().getCarList();
				carServerController.sortCurrentCarListByPrice(carList);
				body = new Body(carList, pat);
				response.setBody(body);
				responseString = writeResponse(response);
				writer.writeObject(responseString);
				break;
			} 
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    

}