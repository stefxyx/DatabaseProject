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
public class Region implements Serializable {
    
    
    @Column(name = "region_id")
    @Id
    private int region_id;
    
    @Column(name = "region_name")
    private String region_name;
    
    @Column(name = "region_manager")
    private int region_manager;

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public int getRegion_manager() {
        return region_manager;
    }

    public void setRegion_manager(int region_manager) {
        this.region_manager = region_manager;
    }
}
