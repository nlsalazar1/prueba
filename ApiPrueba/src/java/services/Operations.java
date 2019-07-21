/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Consultas.LinkVehicle;
import Models.Persona;
import Models.Vehicle;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Cert-555
 */
@Path("operations")
public class Operations {

    LinkVehicle linkv = new LinkVehicle();
    Vehicle veh = new Vehicle();
     
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Operations
     */
    public Operations() {
    }

    /**
     * Retrieves representation of an instance of services.Operations
     * @return an instance of java.lang.String
     */
    
    
    @Path("Vehicles")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> getVehicles()
    {
        
        return linkv.listVehicles();
    }
    
    
    
    
    
    @Path("Vehicle/insert/{id}/{brand}/{model}/{color}/{country}")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle getVehicle(
            @PathParam("id") String id,
            @PathParam("brand") String brand,
            @PathParam("model") String model,
            @PathParam("color") String color,
            @PathParam("country") String country)
    {
        
        veh.setIdvehicle(id);
        veh.setBrand(brand);
        veh.setModel(model);
        veh.setColor(color);
        veh.setCountryorigin(country);
        
        return linkv.setVehicle(veh);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle setVehicle(Vehicle vehicle){
        return linkv.setVehicle(vehicle); 
    }

    /**
     * PUT method for updating or creating an instance of Operations
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
