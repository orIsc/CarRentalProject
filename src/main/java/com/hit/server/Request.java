package com.hit.server;

import java.util.ArrayList;
import java.util.List;

import com.hit.dm.Car;

public class Request {
    
    private Header header;
    private Body body;
    
    public Request() {
	
    }
    
    public Request(Header header,Body body) {
	super();
	this.header = header;
	this.body = body;
    }

     public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

 
    @Override
    public String toString() {
	return "Request [header=" + header + ", body=" + body + "]";
    }

    public static class Header {
	private String action;
	
	public Header() {
	    
	}
	
	public Header(String action) {
	    super();
	    this.action = action;
	}

	public String getAction() {
	    return action;
	}

	public void setAction(String action) {
	    this.action = action;
	}

	@Override
	public String toString() {
	    return "Header [action=" + action + "]";
	}
	
    }
    
    public static class Body {

    private List<Car> carList = new ArrayList<Car>();
    private String pat = "";
    
	public Body() {
	    
	}

	public Body(List<Car> carList, String pat) {
	    super();
	    this.carList = carList;
	    this.pat = pat;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public String getPat() {
		return pat;
	}

	public void setPat(String pat) {
		this.pat = pat;
	}

	@Override
	public String toString() {
		return "Body [carList=" + carList + ", pat=" + pat +"]";
	}

    }
}
