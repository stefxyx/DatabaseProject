/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Bean.Region;
import Database.Handler;
import java.util.List;

/**
 *
 * @author yingxinxie
 */
public class RegionHandler {
   
    private static final RegionHandler regionHandler = new RegionHandler();
    
    private RegionHandler() {
        
    }
    
    public static RegionHandler getRegionHandler() {
        return regionHandler;
    }
    
    /**
     * get Region only by region_id
     * @param id
     * @return Region
     */
    public Region getRegionById(String id) {
        String sql = "select * from Region where region_id = ?";
        String[] para = {id};
        List<Region> list = Handler.getHandler().searchQuery(sql, para, Region.class);
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }
    
    /**
     * get Region only by region_name
     * @param name
     * @return Region
     */
    
    public Region getRegionByName(String name) {
        String sql = "select * from Region where region_name = ?";
        String[] para = {name};
        List<Region> list = Handler.getHandler().searchQuery(sql, para, Region.class);
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }
    
    /**
     * get Region only by region_manager
     * @param manager
     * @return List
     */
    public List<Region> getRegionByManager(String manager) {
        String sql = "select * from Region where region_manager = ?";
        String[] para = {manager};
        List<Region> list = Handler.getHandler().searchQuery(sql, para, Region.class);
        return list;
    }
    
    /**
     * update Region Name only by a given id
     * @param para
     * @return
     */
    public int updateRegionNameById(String [] para) {
        String sql = "update Region set region_name = ? where "
                + "region_id = ?";
        int ret = Handler.getHandler().updateQuery(sql, para);
        return ret;
    }
    
    /**
     * update Region Manager only by a given region id
     * @param para
     * @return
     */
    public int updateRegionManagerById(String [] para) {
        String sql = "update Region set region_manager = ? where "
                + "region_id = ?";
        int ret = Handler.getHandler().updateQuery(sql, para);
        return ret;
    }
    
    /**
     * update Region Manager only by a given region name
     * @param para
     * @return
     */
    public int updateRegionManagerByName(String [] para) {
        String sql = "update Region set region_manager = ? where "
                + "region_name = ?";
        int ret = Handler.getHandler().updateQuery(sql, para);
        return ret;
    }
    
    /**
     * add new Region
     * @param para
     * @return int
     */
    public int addRegion(String [] para) {
        String sql = "insert into Region (region_name, region_manager) values (?,?)";
        int ret = Handler.getHandler().insertQuery(sql, para);
        return ret;
    }
    
    /**
     * delete Region by a given id
     * @param id
     * @return int
     */
    public int deleteRegionById(String id) {
        String sql = "delete from Region where region_id = ?";
        String[] para = {id};
        int ret = Handler.getHandler().deleteQuery(sql, para);
        return ret;
    }
}
