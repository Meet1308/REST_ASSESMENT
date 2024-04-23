package com.rest.assesment;

import java.util.List;

import javax.websocket.server.PathParam;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("persons")
public class PersonResources {
	
	PersonDao dao = new PersonDao();
	
	@GET
	@Path("allperson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPerson(){
		return dao.getAllPerson();
	}
	
	@GET
	@Path("getpesonbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonById(@PathParam("id") int id) {
		return dao.getPersonById(id);
	}
	
	@POST
	@Path("addperson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> addPerson(Person p) {
		return dao.addPerson(p);
	}
	
	@DELETE
	@Path("deleteperson/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> deletePerson(@PathParam("id") int id) {
		return dao.deletePerson(id);
	}
	
	@PUT
	@Path("updateperson/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> updatePerson(@PathParam("id") int id, Person p) {
		return dao.updatePerson(id, p.getName());
	}
}
