/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.osca.mp.boundary;

import de.hsos.kbse.osca.mp.abstracts.AbstractRepoAccesor;
import de.hsos.kbse.osca.mp.controller.CustomerRepository;
import de.hsos.kbse.osca.mp.entity.Customer;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Philipp
 */
public class LoginQuery extends AbstractRepoAccesor implements Serializable {

    @Inject
    private CustomerRepository repo;
    private String username;
    private Customer cust;

    public LoginQuery() {
    }

    /*    public void getCustomerById() {
    this.cust = (Customer) repo.findById(matnr);
    if (this.cust == null) {
    FacesContext.getCurrentInstance()
    .addMessage(null, new FacesMessage("Studen with " + this.matnr + "hat sich gerad eingeloggt!"));
    }
    }*/

}
