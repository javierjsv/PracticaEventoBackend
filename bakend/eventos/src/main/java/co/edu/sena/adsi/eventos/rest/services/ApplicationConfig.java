package co.edu.sena.adsi.eventos.rest.services;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;



/**
 *
 * @author luisOlave
 */
@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig{

 public ApplicationConfig() {
//       packages("co.edu.sena.adsi.eventos.rest.services;co.edu.sena.adsi.eventos.rest.auth");
//       register(RolesAllowedDynamicFeature.class); //es la que have que se implemente la seguridad
    }
    
    
}
