 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Wu
 */
@Entity
public class Address implements Serializable {

    @Column(name = "address_id")
    @Id
    private int address_id;
    
    @Column(name = "city")
    private String city;

    @Column(name = "state_")
    private String state_;
    
    @Column(name = "street")
    private String street;

    @Column(name = "zipCode")
    private String zipCode;

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState_() {
        return state_;
    }

    public void setState_(String state_) {
        this.state_ = state_;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
}
