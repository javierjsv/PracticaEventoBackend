/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.eventos.rest.services;


import co.edu.sena.adsi.eventos.entities.Roles;
import co.edu.sena.adsi.eventos.jpa.sessions.RolesFacade;
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

/**
 *
 * @author aprendiz
 */

@Path("roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RolesRest {
    
    
     @EJB
    private RolesFacade rolesEJB;
    
    @GET
    public List<Roles> findAll(){
    
    return rolesEJB.findAll();   
    }
    
    @GET
    @Path("{id}")
    public Roles findById(@PathParam("id") String id){
        return rolesEJB.find(id);
     
    }
     
    @POST
    public void create(Roles roles){
        rolesEJB.create(roles);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Roles roles){
        rolesEJB.edit(roles);
    }
    
}
