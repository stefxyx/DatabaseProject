/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;


/**
 *
 * @author Wu
 */
public class CustomerHandler {

    private static final CustomerHandler customerHandler = new CustomerHandler();

    private CustomerHandler() {
    }

    public static CustomerHandler getCustomerDAO() {
        return customerHandler;
    }
    
}
