package co.edu.sena.adsi.eventos.entities;

import co.edu.sena.adsi.eventos.entities.Assistances;
import co.edu.sena.adsi.eventos.entities.DigitalDivice;
import co.edu.sena.adsi.eventos.entities.Roles;
import co.edu.sena.adsi.eventos.entities.TypeDocuments;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-31T09:27:58")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, TypeDocuments> idTypeDocument;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile CollectionAttribute<Users, DigitalDivice> digitalDiviceCollection;
    public static volatile SingularAttribute<Users, Integer> phone;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile CollectionAttribute<Users, Roles> rolesCollection;
    public static volatile CollectionAttribute<Users, Assistances> assistancesCollection;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> numDocument;
    public static volatile SingularAttribute<Users, String> lastname;

}