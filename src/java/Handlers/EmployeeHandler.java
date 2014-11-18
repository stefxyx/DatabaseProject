/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;
import Bean.Employee;
import Database.Handler;
import java.util.List;

/**
 *
 * @author Wu
 */
public class EmployeeHandler {
    private static EmployeeHandler employeeHandler = new EmployeeHandler();
    private EmployeeHandler(){
        
    }
    
    public static EmployeeHandler getEmployeeHandler(){
        return employeeHandler;
    }
    
    public List<Employee> GetEmployeeByID(String [] array){
        String sql = "sejlr = ?";
        List<Employee> l = Handler.getCustomerHandler().searchQuery(sql, array, Employee.class);
        int ret = Handler.getCustomerHandler().updateQuery(sql, array);
        Handler.getCustomerHandler().insertQuery(sql, array);
        return l;
    }
}
