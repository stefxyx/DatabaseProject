/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Bean.Customer;
import Database.Handler;
import java.util.List;


/**
 *
 * @author Wu
 */
public class CustomerHandler {

    private static final CustomerHandler customerHandler = new CustomerHandler();

    private CustomerHandler() {
    }

    public static CustomerHandler getCustomerHandler() {
        return customerHandler;
    }
    
    /**
     * get Customer only by customer_id
     * @param id
     * @return Customer
     */
    public Customer getCustomerById(String id) {
        String sql = "select * from Customer where customer_id = ?";
        String[] para = {id};
        List<Customer> list = Handler.getHandler().searchQuery(sql, para, Customer.class);
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }
    
    /**
     * get Customer only by customer_name
     * @param name
     * @return List
     */
    public List<Customer> getCustomerByCustomerName(String name) {
        String sql = "select * from Customer where customer_name = ?";
        String[] para = {name};
        List<Customer> list = Handler.getHandler().searchQuery(sql, para, Customer.class);
        return list;
    }
    
    /**
     * update Customer Name by a given id
     * @param para
     * @return 
     */
    public int updateCustomerNameById(String [] para){
        String sql = "update Customer set customer_name = ? where "
                + "customer_id = ?";
        int ret = Handler.getHandler().updateQuery(sql, para);
        return ret;
    }
    
    /**
     * add new Customer
     * @param para
     * @return int
     */
    public int addCustomer(String [] para){
        String sql = "insert into Customer (address_id, customer_name) values (?,?)";
        int ret = Handler.getHandler().insertQuery(sql, para);
        return ret;
    }
    
    /**
     * delete Customer by given Id
     * @param id
     * @return int
     */
    public int deleteCustomerById(String id){
        String sql = "delete from Customer where customer_id = ?";
        String[] para = {id};
        int ret = Handler.getHandler().deleteQuery(sql, para);
        return ret;
    }
}
