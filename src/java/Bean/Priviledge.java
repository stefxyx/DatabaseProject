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
public class Priviledge implements Serializable {
    @Column(name = "priviledge_id")
    @Id
    private int priviledge_id;
    @Column(name = "description")
    private String description;

    public int getPriviledge_id() {
        return priviledge_id;
    }

    public void setPriviledge_id(int priviledge_id) {
        this.priviledge_id = priviledge_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
