/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.eventos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aprendiz
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id"),
    @NamedQuery(name = "Usuarios.findByName", query = "SELECT u FROM Usuarios u WHERE u.name = :name"),
    @NamedQuery(name = "Usuarios.findByLastname", query = "SELECT u FROM Usuarios u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Usuarios.findByPhone", query = "SELECT u FROM Usuarios u WHERE u.phone = :phone"),
    @NamedQuery(name = "Usuarios.findByCorreos", query = "SELECT u FROM Usuarios u WHERE u.correos = :correos"),
    @NamedQuery(name = "Usuarios.findByContrasenas", query = "SELECT u FROM Usuarios u WHERE u.contrasenas = :contrasenas"),
    @NamedQuery(name = "Usuarios.findByNumeroDocumento", query = "SELECT u FROM Usuarios u WHERE u.numeroDocumento = :numeroDocumento")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phone")
    private Integer phone;
    @Size(max = 65)
    @Column(name = "correos")
    private String correos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasenas")
    private String contrasenas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @ManyToMany(mappedBy = "usuariosList")
    private List<Roles> rolesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<Assistances> assistancesList;
    @JoinColumn(name = "id_tipo_documentos", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposDocumentos idTipoDocumentos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<DigitalDivice> digitalDiviceList;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String contrasenas, String numeroDocumento) {
        this.id = id;
        this.contrasenas = contrasenas;
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }

    public String getContrasenas() {
        return contrasenas;
    }

    public void setContrasenas(String contrasenas) {
        this.contrasenas = contrasenas;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @XmlTransient
    public List<Assistances> getAssistancesList() {
        return assistancesList;
    }

    public void setAssistancesList(List<Assistances> assistancesList) {
        this.assistancesList = assistancesList;
    }

    public TiposDocumentos getIdTipoDocumentos() {
        return idTipoDocumentos;
    }

    public void setIdTipoDocumentos(TiposDocumentos idTipoDocumentos) {
        this.idTipoDocumentos = idTipoDocumentos;
    }

    @XmlTransient
    public List<DigitalDivice> getDigitalDiviceList() {
        return digitalDiviceList;
    }

    public void setDigitalDiviceList(List<DigitalDivice> digitalDiviceList) {
        this.digitalDiviceList = digitalDiviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.eventos.entities.Usuarios[ id=" + id + " ]";
    }
    
}
