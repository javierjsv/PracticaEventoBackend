/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.eventos.jpa.sessions;

import static co.edu.sena.adsi.eventos.entities.DigitalDivice_.name;
import co.edu.sena.adsi.eventos.entities.Roles;
import co.edu.sena.adsi.eventos.entities.Roles_;
import co.edu.sena.adsi.eventos.entities.Usuarios;
import co.edu.sena.adsi.eventos.entities.Usuarios_;
import static co.edu.sena.adsi.eventos.entities.Usuarios_.idTipoDocumentos;
import static co.edu.sena.adsi.eventos.entities.Usuarios_.lastname;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author aprendiz
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "co.edu.sena.adsi_eventos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
     public List<Usuarios> findAllUsuariosByRol(String roles) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
        Root<Roles> rootRoles = cq.from(Roles.class);
        cq.where(cb.equal(rootRoles.get(Roles_.id), roles));
        ListJoin<Roles,Usuarios> joinRoles = rootRoles.join(Roles_.usuariosList);
        CriteriaQuery<Usuarios> cqq = cq.select(joinRoles);
        
        TypedQuery<Usuarios> q = getEntityManager().createQuery(cq);
        try {
            return  q.getResultList();
       
        } catch (NoResultException ex) {
            return null;
        }
    }

    //validaar existencia de un email        
    public Usuarios findByCorreos(String correos) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
        Root<Usuarios> tercero = cq.from(Usuarios.class);

        cq.where(cb.equal(tercero.get(Usuarios_.correos), correos));

        TypedQuery<Usuarios> tq = getEntityManager().createQuery(cq);

        try {
            return (Usuarios) tq.getSingleResult();
        } catch (NonUniqueResultException e) {
            throw e;
        } catch (NoResultException ex) {
            return null;

        }
    }
    
//    public List<Usuarios> findUsers(
//        String name, String lastname,
//        Integer idTipoDocumentos){
//        
//        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
//        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
//        Root<Usuarios> usuario = cq.from(Usuarios.class);
//        
//        Predicate data = cb.conjunction();
//        
//        if(name != null){
//            data = cb.and(data, cb.like(
//                    usuario.get(Usuarios_.name), 
//                    "%" + name + "%"));
//        }
//        
//        if(lastname != null){
//            data = cb.and(data, cb.like(
//                    usuario.get(Usuarios_.lastname), 
//                    "%" + lastname + "%"));
//        }
//        
//        
//        
//       if(idTipoDocumentos != null){
//            data = cb.and(data, cb.equal(
//                usuario.get(Usuarios_.idTipoDocumentos), 
//                    new TipoDocumentos(idTipoDocumentos)));
//        }
//        
//        
//   
//        
//        cq.where(data);
//        TypedQuery<Usuarios> tq = em.createQuery(cq);
//        try {
//            return tq.getResultList();
//        } catch (Exception e) {
//            return null;
//        }   
//    }
//    
}
