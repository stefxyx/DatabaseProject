/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Wu
 */
@Entity
public class Store {
    
    @Column(name = "store_id")
    @Id
    private int store_id;
    
    @Column(name = "address_id")
    private int address_id;
    
    @Column(name = "store_manager")
    private int store_manager;
    
    @Column(name = "salesperson_number")
    private int salesperson_number;
    
    @Column(name = "region_id")
    private int region_id;

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getStore_manager() {
        return store_manager;
    }

    public void setStore_manager(int store_manager) {
        this.store_manager = store_manager;
    }

    public int getSalesperson_number() {
        return salesperson_number;
    }

    public void setSalesperson_number(int salesperson_number) {
        this.salesperson_number = salesperson_number;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }
    
    
}
