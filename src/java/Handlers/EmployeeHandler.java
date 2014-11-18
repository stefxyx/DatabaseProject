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

    private EmployeeHandler() {

    }

    public static EmployeeHandler getEmployeeHandler() {
        return employeeHandler;
    }
    
    /**
     * employee login check
     * @param id
     * @param password
     * @return 
     */
    public Employee checkEmployee(String id, String password) {
        String sql = "select * from Employee where employee_id = ? and password = ?";
        String[] para = {id, password};
        List<Employee> list = Handler.getHandler().searchQuery(sql, para, Employee.class);
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * get Employee only by employee_id
     *
     * @param id
     * @return Employee
     */
    public Employee getEmployeeById(String id) {
        String sql = "select * from Employee where employee_id = ?";
        String[] para = {id};
        List<Employee> list = Handler.getHandler().searchQuery(sql, para, Employee.class);
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * get Employee only by employee_name
     *
     * @param name
     * @return List
     */
    public List<Employee> getEmployeeByEmployeeName(String name) {
        String sql = "select * from Employee where employee_name = ?";
        String[] para = {name};
        List<Employee> list = Handler.getHandler().searchQuery(sql, para, Employee.class);
        return list;
    }

    /**
     * update Employee Name by a given id
     *
     * @param para
     * @return
     */
    public int updateEmployeeNameById(String[] para) {
        String sql = "update Employee set employee_name = ?, where employee_id = ?";
        int ret = Handler.getHandler().updateQuery(sql, para);
        return ret;
    }

    /**
     * add new Employee
     *
     * @param para
     * @return int
     */
    public int addEmployee(String[] para) {
        String sql = "insert into Employee (city,street,state_,zipCode) values (?,?,?,?)";
        int ret = Handler.getHandler().insertQuery(sql, para);
        return ret;
    }

    /**
     * delete Employee by given Id
     *
     * @param id
     * @return int
     */
    public int deleteEmployeeById(String id) {
        String sql = "delete from Employee where id = ?";
        String[] para = {id};
        int ret = Handler.getHandler().deleteQuery(sql, para);
        return ret;
    }
}
