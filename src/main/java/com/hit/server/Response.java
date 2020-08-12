package com.hit.server;

import com.hit.server.Request.Body;
import com.hit.server.Request.Header;

public class Response {
    private Header header;
    private Body body;
    
    public Response() {
	
    }
    
    public Response(Header header,Body body) {
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
	return "Response [header=" + header + ", body=" + body + "]";
    }

}
