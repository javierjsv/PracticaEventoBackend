package co.edu.sena.adsi.eventos.entities;

import co.edu.sena.adsi.eventos.entities.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-31T11:59:20")
@StaticMetamodel(Assistances.class)
public class Assistances_ { 

    public static volatile SingularAttribute<Assistances, Boolean> attended;
    public static volatile SingularAttribute<Assistances, Date> date;
    public static volatile SingularAttribute<Assistances, Usuarios> idUser;
    public static volatile SingularAttribute<Assistances, Integer> id;

}