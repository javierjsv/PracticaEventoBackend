package co.edu.sena.adsi.eventos.entities;

import co.edu.sena.adsi.eventos.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-31T09:27:58")
@StaticMetamodel(TypeDocuments.class)
public class TypeDocuments_ { 

    public static volatile SingularAttribute<TypeDocuments, String> name;
    public static volatile SingularAttribute<TypeDocuments, String> id;
    public static volatile CollectionAttribute<TypeDocuments, Users> usersCollection;

}