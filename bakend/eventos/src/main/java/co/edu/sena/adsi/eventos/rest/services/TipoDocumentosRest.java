/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.eventos.rest.services;


import co.edu.sena.adsi.eventos.entities.TiposDocumentos;
import co.edu.sena.adsi.eventos.jpa.sessions.TiposDocumentosFacade;
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


@Path("TiposDocumentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoDocumentosRest {
    
    @EJB
    private TiposDocumentosFacade tiposDocumentosEJB;
    
    @GET
    public List<TiposDocumentos> findAll(){
    
    return tiposDocumentosEJB.findAll();   
    }
    
    @GET
    @Path("{id}")
    public TiposDocumentos findById(@PathParam("id") String id){
        return tiposDocumentosEJB.find(id);
     
    }
     
    @POST
    public void create(TiposDocumentos tiposDocumentos){
        tiposDocumentosEJB.create(tiposDocumentos);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, TiposDocumentos tiposDocumentos){
        tiposDocumentosEJB.edit(tiposDocumentos);
    }
}
