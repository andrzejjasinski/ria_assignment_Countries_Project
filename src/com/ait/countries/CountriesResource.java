package com.ait.countries;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
//import javax.ws.rs.QueryParam;

@Path("/countries")
public class CountriesResource 

{
	CountriesDAO dao = new CountriesDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Countries> findAll() {
		System.out.println("findAll");
		return dao.findAll();
	}
	
	@PUT @Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Countries update(Countries countries) 	
	{
		System.out.println("Updating_Country_Record: " + countries.getCountry());
		dao.update(countries);
		return countries;
	}
	
	@GET @Path("search/{query}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Countries> findByCountry(@PathParam("query") String query) {
		System.out.println("findByName: " + query);
		return dao.findByCountry(query);
	}
	
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Countries findById(@PathParam("id") String id) {
		System.out.println("findById " + id);
		return dao.findById(Integer.parseInt(id));
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Countries create(Countries countries)
	{
		System.out.println("creating new entry ...");
		return dao.create(countries);
	}
		
	@GET @Path("prefix/{query}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Countries> findByPrefix(@PathParam("query") String query) {
		System.out.println("findByPrefix: " + query);
		return dao.findByPrefix(query);		
	}
	
	@DELETE @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("id") int id) 
	{
		dao.remove(id);
	}

	
}