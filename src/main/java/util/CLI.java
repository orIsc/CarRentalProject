package util;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.hit.server.Request;

public class CLI implements Runnable {
    
	private PropertyChangeSupport propertyChangeHandler;
	private InputStream in;
	private OutputStream out;
	private String response;
	private int port;
	
	public CLI(int port) {
		this.port = port;
		propertyChangeHandler = new PropertyChangeSupport(this); 
	}


	public void addPropertyChangeListener(PropertyChangeListener pcl) {

		propertyChangeHandler.addPropertyChangeListener(pcl);

	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {

		propertyChangeHandler.removePropertyChangeListener(pcl);

	}

    
    @Override
    public void run() {
  	
	try {
		final Socket socket = new Socket("127.0.0.1", this.port);
		System.out.println("Task started");
		ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());   
		
		String message =  "{" + 
	    		"  \"header\": {" + 
	    		"    \"action\": \"Get-all\"" + 
	    		"  }," + 
	    		"  \"body\": {" + 
	    		"    \"carList\": [" + 
	    		"      {" + 
	    		"        \"company\": \"Honda\"," + 
	    		"        \"model\": \"civic\"," + 
	    		"        \"year\": 2015" + 
	    		"      }," + 
	    		"      {" + 
	    		"        \"company\": \"Mazda\"," + 
	    		"        \"model\": \"cx5\"," + 
	    		"        \"year\": 2016" + 
	    		"      }" + 
	    		"    ]" + 
	    		"  }" + 
	    		"}";
		writer.writeObject(message);
		writer.flush();
		

		response = reader.readObject().toString();
		System.out.println(response);
		
	    System.out.println("Task finished");
	    reader.close();
	    writer.close();
	} catch ( IOException | ClassNotFoundException  e) {
	    e.printStackTrace();
	}
    }

    public Request sendRequest(Request request) {
	
	return request;
    }
}
