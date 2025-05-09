/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author josepino
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Usuario.findByContrasennaUsuario", query = "SELECT u FROM Usuario u WHERE u.contrasennaUsuario = :contrasennaUsuario"),
    @NamedQuery(name = "Usuario.findBySalt", query = "SELECT u FROM Usuario u WHERE u.salt = :salt"),
    @NamedQuery(name = "Usuario.findByIntera", query = "SELECT u FROM Usuario u WHERE u.intera = :intera"),
    @NamedQuery(name = "Usuario.findByAlgorithm", query = "SELECT u FROM Usuario u WHERE u.algorithm = :algorithm")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "contrasenna_usuario")
    private String contrasennaUsuario;
    @Basic(optional = false)
    @Column(name = "salt")
    private String salt;
    @Basic(optional = false)
    @Column(name = "intera")
    private int intera;
    @Basic(optional = false)
    @Column(name = "algorithm")
    private String algorithm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Tarea> tareaList;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nombreUsuario, String contrasennaUsuario, String salt, int intera, String algorithm) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasennaUsuario = contrasennaUsuario;
        this.salt = salt;
        this.intera = intera;
        this.algorithm = algorithm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasennaUsuario() {
        return contrasennaUsuario;
    }

    public void setContrasennaUsuario(String contrasennaUsuario) {
        this.contrasennaUsuario = contrasennaUsuario;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getIntera() {
        return intera;
    }

    public void setIntera(int intera) {
        this.intera = intera;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public List<Tarea> getTareaList() {
        return tareaList;
    }

    public void setTareaList(List<Tarea> tareaList) {
        this.tareaList = tareaList;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Usuario[ id=" + id + " ]";
    }
    
}
