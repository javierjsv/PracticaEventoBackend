/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.eventos.rest.services;

import co.edu.sena.adsi.eventos.entities.DigitalDivice;
import co.edu.sena.adsi.eventos.jpa.sessions.DigitalDiviceFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("DigitalDivice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DigitalDivideRest {
    
     @EJB
    private DigitalDiviceFacade digitalDiviceEJB;
    
    @GET
    public List<DigitalDivice> findAll(){
    
    return digitalDiviceEJB.findAll();   
    }
    
    @GET
    @Path("{id}")
    public DigitalDivice findById(@PathParam("id") String id){
        return digitalDiviceEJB.find(id);
     
    }
     
    @POST
    public void create(DigitalDivice assistances){
        digitalDiviceEJB.create(assistances);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, DigitalDivice digitalDivice){
        digitalDiviceEJB.edit(digitalDivice);
    }
    
}
