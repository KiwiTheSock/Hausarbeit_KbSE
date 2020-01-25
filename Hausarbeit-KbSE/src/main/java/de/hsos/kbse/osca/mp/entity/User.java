/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.osca.mp.entity;

import de.hsos.kbse.osca.mp.abstracts.AbstractEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.enterprise.context.Dependent;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Philipp Markmann
 */

@Entity
public class User extends AbstractEntity{
    
    @NotNull(message = "Firstname may not be empty")
    private String firstname;
    @NotNull(message = "Lastname may not be empty")
    private String lastname;
    
    @NotNull(message = "Email may not be empty")
    private String email;
    
    /**
     * Wird eine PLZ, Straße und Stadt benötigt? 
     * 
     * @NotNull(message = "PLZ may not be empty)
     * pirvate int plz;
     * 
     * @NotNull(message = "Street may not be empty)
     * private String street;
     * @NotNull(message = "City may not be empty)
     * private String city
     */
    
    @NotNull(message = "Username may not be empty")
    private String studentLogin;
    @NotNull(message = "Password may not be empty")
    private String studentPassword;
    
    private int accountType; // Admin, Student, Dozent
    
    //Relation zu Modul (OOAD, Mathe 2,...)
    @ManyToMany
    private List<Module> modules;

    public User() {
    }

    public User(String firstname, String lastname, String _email, String studentLogin, String studentPassword, int accountType, List<Module> modules) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.studentLogin = studentLogin;
        this.studentPassword = studentPassword;
        this.accountType = accountType;
        this.modules = modules;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentLogin() {
        return studentLogin;
    }

    public void setStudentLogin(String studentLogin) {
        this.studentLogin = studentLogin;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.firstname);
        hash = 37 * hash + Objects.hashCode(this.lastname);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.studentLogin);
        hash = 37 * hash + Objects.hashCode(this.studentPassword);
        hash = 37 * hash + this.accountType;
        hash = 37 * hash + Objects.hashCode(this.modules);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.accountType != other.accountType) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.studentLogin, other.studentLogin)) {
            return false;
        }
        if (!Objects.equals(this.studentPassword, other.studentPassword)) {
            return false;
        }
        if (!Objects.equals(this.modules, other.modules)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", studentLogin=" + studentLogin + ", studentPassword=" + studentPassword + ", accountType=" + accountType + ", modules=" + modules + '}';
    }

}
