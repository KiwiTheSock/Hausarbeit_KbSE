/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.osca.mp.controller;

import de.hsos.kbse.osca.mp.entity.Customer;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Philipp
 */
@RequestScoped
public class UserRepository implements Serializable{


    @PersistenceContext(unitName = "de.hsos.kbse.oscar.mp_Hausarbeit-KbSE_war_1.0-SNAPSHOTPU")
    private EntityManager em;  
    
    
    public void create(Customer customer) {
        em.persist(customer);
    }
    
    @PostConstruct
    public void init(){
        Customer cus = new Customer("Homer", "Simson", "homer.s@web.de", "x", "x", 1);
        em.persist(cus);
    }
    
}
