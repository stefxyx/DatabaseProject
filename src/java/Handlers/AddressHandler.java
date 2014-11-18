/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Bean.Address;
import Database.Handler;


/**
 *
 * @author Wu
 */
public class AddressHandler {
    private static final AddressHandler addressHandler = new AddressHandler();
    
    private AddressHandler(){
    }
    
    public static AddressHandler getAddressHandler(){
        return addressHandler;
    }
    
    public Address getAddressById(int id){
        Address address = null;
        return address;
    }
}
