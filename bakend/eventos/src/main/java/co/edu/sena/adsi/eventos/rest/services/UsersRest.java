/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.eventos.rest.services;


import co.edu.sena.adsi.eventos.entities.Users;
import co.edu.sena.adsi.eventos.jpa.sessions.UsersFacade;
import co.edu.sena.adsi.rest.auth.DigestUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import javax.ws.rs.core.Response;

/**
 *
 * @author aprendiz
 */
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersRest {
     @EJB
    private UsersFacade usersEJB;
    
    @GET
    public List<Users> findAll(){
    
    return usersEJB.findAll();   
    }
    
    @GET
    @Path("{id}")
    public Users findById(@PathParam("id") String id){
        return usersEJB.find(id);
     
    }
     
    @POST
    public void create(Users users){
        usersEJB.create(users);
        
        
      

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        if (validarUsuarioByNumeroDocumento(users.getNumeroDocumento())) {
            if (validarUsuarioByCorreos(users.getCorreos())) {
                
                /**Esto es para cifrar la contraseña**/
                
                /**String passSinCifrar = usuario.getPassword();
                String passwordCifradra = DigestUtil.cifrarPassword(passSinCifrar);
                usuario.setPassword(DigestUtil.cifrarPassword(passSinCifrar));**/
                
                /**Forma rapida para cifrar la contraseña**/
                
                users.setPassword(DigestUtil.cifrarPassword(users.getPassword()));
                 // SendEmail email = new SendEmail();
                  //  email.emailRegistroUsers();
                

                usersEJB.create(users);
                return Response.status(Response.Status.OK)
                        .entity(gson.toJson("El usuario fue registrado satisfactoriamente."))
                        .build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(gson.toJson("El correo ya se encuenra registrado!."))
                        .build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("El numero de documento ya se encuenra registrado!."))
                    .build();
        }
    }
    private boolean validarUsuarioByCorreos(String correos) {
        return  usersEJB.findByCorreos(correos) == null;
    }
    private boolean validarUsuarioByNumeroDocumento(String numeroDocumento) {
        return  usersEJB.findAll(numeroDocumento) == null;
    }
        
        
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Users users){
        usersEJB.edit(users);
    }
}
