/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Bean.Customer;
import Interface.Handler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class CustomerHandler implements Handler {

    private static final CustomerHandler customerDAO = new CustomerHandler();

    private CustomerHandler() {
    }

    public static CustomerHandler getCustomerDAO() {
        return customerDAO;
    }

    //search
    @Override
    public List<Customer> searchQuery(String sql, String[] para) {
        List<Customer> customerList = new ArrayList<Customer>();
        PreparedStatement ps;
        try {
            Connection c = DriverManager.getConnection(DbConfig.connectionString,
                    DbConfig.dbUserName, DbConfig.dbPassword);
            ps = c.prepareStatement(sql);
            for (int i = 1; i <= para.length; i++) {
                ps.setString(i, para[i]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setAddress_id(rs.getInt("address_id"));
                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("last_name"));
                customerList.add(customer);
            }
            ps.close();
            c.close();
            return customerList;
        } catch (SQLException e) {
            System.out.println("CustomerHandler searchQuery error:" + e.getMessage());
            return null;
        }
    }

    //update
    @Override
    public int updateQuery(String sql, String[] para) {
        PreparedStatement ps;
        int res = -1; //return result
        try {
            Connection c = DriverManager.getConnection(DbConfig.connectionString,
                    DbConfig.dbUserName, DbConfig.dbPassword);
            ps = c.prepareStatement(sql);
            for (int i = 1; i <= para.length; i++) {
                ps.setString(i, para[i]);
            }
            int result = ps.executeUpdate();
            res = (result != 0) ? 1 : -1;
            return res;
        } catch (SQLException ex) {
            System.out.printf("CustomerHandler updateQuery error:" + ex.getMessage());
            return res;
        }
    }

    //delete
    @Override
    public int deleteQuery(String sql, String[] para) {
        PreparedStatement ps;
        int res = -1; //return result
        try {
            Connection c = DriverManager.getConnection(DbConfig.connectionString,
                    DbConfig.dbUserName, DbConfig.dbPassword);
            ps = c.prepareStatement(sql);
            for (int i = 1; i <= para.length; i++) {
                ps.setString(i, para[i]);
            }
            int result = ps.executeUpdate();
            res = (result != 0) ? 1 : -1;
            return res;
        } catch (SQLException ex) {
            System.out.printf("CustomerHandler updateQuery error:" + ex.getMessage());
            return res;
        }
    }

}
