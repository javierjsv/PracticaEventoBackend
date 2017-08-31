/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.eventos.rest.services;

import co.edu.sena.adsi.eventos.entities.Assistances;
import co.edu.sena.adsi.eventos.jpa.sessions.AssistancesFacade;
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



@Path("Assistances")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AssistancesRest {
        
    @EJB
    private AssistancesFacade assistancesEJB;
    
    @GET
    public List<Assistances> findAll(){
    
    return assistancesEJB.findAll();   
    }
    
    @GET
    @Path("{id}")
    public Assistances findById(@PathParam("id") String id){
        return assistancesEJB.find(id);
     
    }
     
    @POST
    public void create(Assistances assistances){
        assistancesEJB.create(assistances);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Assistances assistances){
        assistancesEJB.edit(assistances);
    }
}
