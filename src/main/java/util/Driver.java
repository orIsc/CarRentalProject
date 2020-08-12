package util;

import com.hit.server.Server;

public class Driver {
    
    public static void main(String[] args) {
    	CLI cli = new CLI(12346); 
    	Server server = new Server(12346);
    	cli.addPropertyChangeListener(server); 

    }
}
