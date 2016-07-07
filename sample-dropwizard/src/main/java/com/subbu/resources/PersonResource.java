package com.subbu.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
	private final String template;
    private final String defaultName;
    private final AtomicLong counter;
	
  public PersonResource(String template, String defaultName){
	  this.template=template;
	  this.defaultName=defaultName;
	  this.counter= new AtomicLong();
	  
  }

}
