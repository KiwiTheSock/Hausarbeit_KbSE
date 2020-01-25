/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.osca.mp.entity;

import de.hsos.kbse.osca.mp.abstracts.AbstractEntity;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Philipp
 */
@Entity
public class Module extends AbstractEntity {
    
    //ID wird in AbstractEntity erstellt
    @NotNull(message = "Modulename can't be empty")
    private String moduleName;
    @NotNull(message = "Semester can't be empty")
    private int semester;
    
    @ManyToMany
    private List<User> users;

    @OneToMany
    private List<Exam> exam;
    
    public Module() {
    }

    public Module(String moduleName, int semester, List<User> users) {
        this.moduleName = moduleName;
        this.semester = semester;
        this.users = users;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.moduleName);
        hash = 97 * hash + this.semester;
        hash = 97 * hash + Objects.hashCode(this.users);
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
        final Module other = (Module) obj;
        if (this.semester != other.semester) {
            return false;
        }
        if (!Objects.equals(this.moduleName, other.moduleName)) {
            return false;
        }
        if (!Objects.equals(this.users, other.users)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Module{" + "moduleName=" + moduleName + ", semester=" + semester + ", users=" + users + '}';
    }
    
}
