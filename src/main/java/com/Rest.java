package com;

import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
part 2/2 of the minimal server
 */

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


	//example: http://localhost:9999/home/googleAnalytics/2017-11-03/2017-11-09/

	@GET
	@Path("googleAnalytics/{startDate}/{endDate}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getGoogleAnalytics(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {
		GoogleAnalyticsHelper googleAnalyticsHelper = new GoogleAnalyticsHelper();
		JSONObject report = googleAnalyticsHelper.getReport(startDate, endDate);
		return report.toString();
	}
}


