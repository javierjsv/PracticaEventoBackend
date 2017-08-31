package co.edu.sena.adsi.eventos.entities;

import co.edu.sena.adsi.eventos.entities.Assistances;
import co.edu.sena.adsi.eventos.entities.DigitalDivice;
import co.edu.sena.adsi.eventos.entities.Roles;
import co.edu.sena.adsi.eventos.entities.TiposDocumentos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-31T11:59:20")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, TiposDocumentos> idTipoDocumentos;
    public static volatile ListAttribute<Usuarios, Assistances> assistancesList;
    public static volatile SingularAttribute<Usuarios, String> correos;
    public static volatile SingularAttribute<Usuarios, String> contrasenas;
    public static volatile ListAttribute<Usuarios, Roles> rolesList;
    public static volatile SingularAttribute<Usuarios, Integer> phone;
    public static volatile ListAttribute<Usuarios, DigitalDivice> digitalDiviceList;
    public static volatile SingularAttribute<Usuarios, String> name;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, String> numeroDocumento;
    public static volatile SingularAttribute<Usuarios, String> lastname;

}