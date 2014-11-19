/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Bean.Privilege;
import Database.Handler;
import java.util.List;

/**
 *
 * @author Wu
 */
public class PrivilegeHandler {
    public static PrivilegeHandler privilegeHandler = new PrivilegeHandler();
    
    private PrivilegeHandler(){
        
    }
    
    public static PrivilegeHandler getPrivilegeHandler(){
        return privilegeHandler;
    }
    
    /**
     * get Privilege only by region_id
     * @param id
     * @return Privilege
     */
    public Privilege getPrivilegeById(String id) {
        String sql = "select * from Privilege where privilege_id = ?";
        String[] para = {id};
        List<Privilege> list = Handler.getHandler().searchQuery(sql, para, Privilege.class);
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }
    
    /**
     * update Privilege by a given id
     * @param para
     * @return 
     */
    public int updatePrivilegeById(String [] para) {
        String sql = "update Privilege set description = ? where privilege_id = ?";
        int ret = Handler.getHandler().updateQuery(sql, para);
        return ret;
    }
    
    /**
     * add new Privilege
     * @param para
     * @return int
     */
    public int addPrivilege(String [] para){
        String sql = "intert into Privilege (description) values (?)";
        int ret = Handler.getHandler().insertQuery(sql, para);
        return ret;
    }
    
    /**
     * delete Privilege by a given id
     * @param id
     * @return int
     */
    public int deletePrivilegeById(String id) {
        String sql = "delete from Privilege where privilege_id = ?";
        String[] para = {id};
        int ret = Handler.getHandler().deleteQuery(sql, para);
        return ret;
    }
}
