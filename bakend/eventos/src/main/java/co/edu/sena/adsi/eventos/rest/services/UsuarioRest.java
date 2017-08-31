package co.edu.sena.adsi.eventos.rest.services;




import co.edu.sena.adsi.eventos.entities.Usuarios;
import co.edu.sena.adsi.eventos.jpa.sessions.UsuariosFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRest {

    @EJB
    private UsuariosFacade usuarioEJB;

    @GET
   @RolesAllowed({"ADMIN"})
    public List<Usuarios> findAll() {

        return usuarioEJB.findAll();
    }
    
    @GET
   
 
    @Path("{id}")
    public Usuarios findById(@PathParam("id") Integer id) {

        return usuarioEJB.find(id);

    }

    @POST
    public Response create(Usuarios usuario) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        if (validarUsuarioByNumeroDocumento(usuario.getNumeroDocumento())) {
            if (validarUsuarioByCorreos(usuario.getCorreos())) {
                
              

                usuarioEJB.create(usuario);
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
        return usuarioEJB.findByCorreos(correos) == null;
    }
    private boolean validarUsuarioByNumeroDocumento(String numeroDocumento) {
        return usuarioEJB.findByCorreos(numeroDocumento) == null;
    }
    
    
   
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Usuarios usuario) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            usuarioEJB.edit(usuario);
            return Response.status(Response.Status.CREATED).entity(gson.toJson("El usuario se actualizó correctamente!")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error al actualizar el usuario!.")).build();
        }
    }
}
