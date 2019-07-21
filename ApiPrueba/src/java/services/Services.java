/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Consultas.Link;
import Models.Persona;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("services")
public class Services {

    Link link = new Link();
    Persona per = new Persona();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Services
     */
    public Services() {
    }

    /**
     * Retrieves representation of an instance of services.Services
     * @return an instance of java.lang.String
     */
    @Path("Person/instructions") 
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String instructions() {
        //TODO return proper representation object
        return "To look the information about a [ PERSON ] the following "
                + "format is used:\n"
                + ".../Person/{id}\n"
                + "Example: \n"
                + ".../Person/123\n\n\n"
                + "To look all PERSONS the following " 
                + "format is used:\n" 
                + ".../Persons/\n\n\n";
    }
    
    @Path("Persons")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getPersonas()
    {
        
        return link.listUser();
    }
    
    @Path("Person/insert/{name}/{id}/{cal}/{peso}")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getPersona(
            @PathParam("name") String name,
            @PathParam("id") String id,
            @PathParam("cal") String cal,
            @PathParam("peso") String peso)
    {
        int c = Integer.parseInt(cal);
        float p = Float.parseFloat(peso);
        
        per.setName(name);
        per.setCedula(id);
        per.setCalificacion(c);
        per.setPeso(p);
        return link.setUser(per);
    }
    

    //@Path("Person/insert")  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Persona setPerson(Persona persona){
        return link.setUser(persona); 
    }
    
    /*
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/post")
    public String postMessage(Message msg) throws Exception{
        
        System.out.println("First Name = "+msg.getFirstName());
        System.out.println("Last Name  = "+msg.getLastName());
        
        return "ok";
    }*/
    
}
