/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.eventos.rest.services;



import co.edu.sena.adsi.eventos.entities.TypeDocuments;
import co.edu.sena.adsi.eventos.jpa.sessions.TypeDocumentsFacade;
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

@Path("typeDocuments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TypeDocumentsRest {
    
     @EJB
    private TypeDocumentsFacade typeDocumentsEJB;
    
    @GET
    public List<TypeDocuments> findAll(){
    
    return typeDocumentsEJB.findAll();   
    }
    
    @GET
    @Path("{id}")
    public TypeDocuments findById(@PathParam("id") String id){
        return typeDocumentsEJB.find(id);
     
    }
     
    @POST
    public void create(TypeDocuments typeDocuments){
        typeDocumentsEJB.create(typeDocuments);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, TypeDocuments typeDocuments){
        typeDocumentsEJB.edit(typeDocuments);
    }
    
}
