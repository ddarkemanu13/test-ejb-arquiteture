package br.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/app")
public class WSApp {
	
	
	/*
	 * URL Test = http://localhost:8080/project-ws/rest/app/get
	 */
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public AppXML getApp() {
		return new AppXML("WS GET Test");
	}
	
	/*
	 * URL = http://localhost:8080/project-ws/rest/app/getDescription/yourDescription
	 */
	@GET
	@Path("/getDescription/{description}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppXML postApp(@PathParam("description") String description) {
		return new AppXML(description);
	}

}
