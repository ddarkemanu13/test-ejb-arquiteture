package br.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public AppXML getWithParam(@PathParam("description") String description) {
		return new AppXML(description);
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postApp(AppXML xml) {
		return Response.ok(xml).build();
	}

}
