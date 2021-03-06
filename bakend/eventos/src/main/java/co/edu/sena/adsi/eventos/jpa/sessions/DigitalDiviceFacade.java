/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.eventos.jpa.sessions;

import co.edu.sena.adsi.eventos.entities.DigitalDivice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aprendiz
 */
@Stateless
public class DigitalDiviceFacade extends AbstractFacade<DigitalDivice> {

    @PersistenceContext(unitName = "co.edu.sena.adsi_eventos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DigitalDiviceFacade() {
        super(DigitalDivice.class);
    }
    
}
