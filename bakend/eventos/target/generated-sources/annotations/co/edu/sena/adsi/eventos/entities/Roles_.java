package co.edu.sena.adsi.eventos.entities;

import co.edu.sena.adsi.eventos.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-31T09:27:58")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, String> description;
    public static volatile SingularAttribute<Roles, String> id;
    public static volatile CollectionAttribute<Roles, Users> usersCollection;

}