/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.osca.mp.entity;

import de.hsos.kbse.osca.mp.abstracts.AbstractEntity;
import javax.enterprise.context.Dependent;
import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nordm
 */
@Entity
@Dependent
@Table(name = "CUSTOMER", catalog = "", schema = "X")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id"),
    @NamedQuery(name = "Customer.findByAccounttype", query = "SELECT c FROM Customer c WHERE c.accounttype = :accounttype"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
    @NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Customer.findByLastname", query = "SELECT c FROM Customer c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "Customer.findByStudentlogin", query = "SELECT c FROM Customer c WHERE c.studentlogin = :studentlogin"),
    @NamedQuery(name = "Customer.findByStudentpassword", query = "SELECT c FROM Customer c WHERE c.studentpassword = :studentpassword")})
public class Customer extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(name = "ACCOUNTTYPE")
    private Integer accounttype;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL", length = 255)
    private String email;
    @Size(max = 255)
    @Column(name = "FIRSTNAME", length = 255)
    private String firstname;
    @Size(max = 255)
    @Column(name = "LASTNAME", length = 255)
    private String lastname;
    @Size(max = 255)
    @Column(name = "STUDENTLOGIN", length = 255)
    private String studentlogin;
    @Size(max = 255)
    @Column(name = "STUDENTPASSWORD", length = 255)
    private String studentpassword;

    public Customer() {
    }

    public Customer( String email, String firstname, String lastname, String studentlogin, String studentpassword,Integer accounttype) {
        this.accounttype = accounttype;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentlogin = studentlogin;
        this.studentpassword = studentpassword;
    }

    public Customer(Long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Integer accounttype) {
        this.accounttype = accounttype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStudentlogin() {
        return studentlogin;
    }

    public void setStudentlogin(String studentlogin) {
        this.studentlogin = studentlogin;
    }

    public String getStudentpassword() {
        return studentpassword;
    }

    public void setStudentpassword(String studentpassword) {
        this.studentpassword = studentpassword;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.hsos.kbse.osca.mp.entity.Customer[ id=" + id + " ]";
    }
    
}
