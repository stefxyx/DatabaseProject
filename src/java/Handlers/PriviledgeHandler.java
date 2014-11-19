/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Bean.Priviledge;
import Database.Handler;
import java.util.List;

/**
 *
 * @author Wu
 */
public class PriviledgeHandler {
    public static PriviledgeHandler priviledgeHandler = new PriviledgeHandler();
    
    private PriviledgeHandler(){
        
    }
    
    public static PriviledgeHandler getPrivilegeHandler(){
        return priviledgeHandler;
    }
    
    /**
     * get Priviledge only by region_id
     * @param id
     * @return Priviledge
     */
    public Priviledge getPriviledgeById(String id) {
        String sql = "select * from Priviledge where priviledge_id = ?";
        String[] para = {id};
        List<Priviledge> list = Handler.getHandler().searchQuery(sql, para, Priviledge.class);
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }
    
    /**
     * update Priviledge by a given id
     * @param para
     * @return 
     */
    public int updatePriviledgeById(String [] para) {
        String sql = "update Priviledge set description = ? where priviledge_id = ?";
        int ret = Handler.getHandler().updateQuery(sql, para);
        return ret;
    }
    
    /**
     * add new Priviledge
     * @param para
     * @return int
     */
    public int addPriviledge(String [] para){
        String sql = "intert into Priviledge (description) values (?)";
        int ret = Handler.getHandler().insertQuery(sql, para);
        return ret;
    }
    
    /**
     * delete Priviledge by a given id
     * @param id
     * @return int
     */
    public int deletePriviledgeById(String id) {
        String sql = "delete from Priviledge where priviledge_id = ?";
        String[] para = {id};
        int ret = Handler.getHandler().deleteQuery(sql, para);
        return ret;
    }
}
