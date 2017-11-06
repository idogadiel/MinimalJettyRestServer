package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("home")
public class Rest {
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "Hello, world!";
	}


	@GET
	@Path("bye")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloBye() {
		return "Bye, world!";
	}

}


