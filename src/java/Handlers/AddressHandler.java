/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Bean.Address;
import Database.Handler;
import java.util.List;

/**
 *
 * @author Wu
 */
public class AddressHandler {

    private static final AddressHandler addressHandler = new AddressHandler();

    private AddressHandler() {
    }

    public static AddressHandler getAddressHandler() {
        return addressHandler;
    }
    
    /**
     * get Address only by address_id
     * @param id
     * @return Address
     */
    public Address getAddressById(String id) {
        String sql = "select * from Address where address_id = ?";
        String[] para = {id};
        List<Address> list = Handler.getHandler().searchQuery(sql, para, Address.class);
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }
    
    /**
     * update Address by a given id
     * @param para
     * @return 
     */
    public int updateAddressById(String [] para){
        String sql = "update Address set city = ?, state_ = ?,street = ?, zipCode = ? where "
                + "address_id = ?";
        int ret = Handler.getHandler().updateQuery(sql, para);
        return ret;
    }
    
    /**
     * add new Address
     * @param para
     * @return 
     */
    public int addAddress(String [] para){
        String sql = "insert into Address (city,street,state_,zipCode) values (?,?,?,?)";
        int ret = Handler.getHandler().insertQuery(sql, para);
        return ret;
    }
    
    /**
     * delete Address by given Id
     * @param id
     * @return 
     */
    public int deleteAddressById(String id){
        String sql = "delete from Address where address_id = ?";
        String[] para = {id};
        int ret = Handler.getHandler().deleteQuery(sql, para);
        return ret;
    }
}
