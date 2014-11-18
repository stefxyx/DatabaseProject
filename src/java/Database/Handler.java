/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Wu
 */
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.apache.commons.beanutils.BeanUtils;

public class Handler<T> {

    private static final Handler handler = new Handler();

    private Handler() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Handler getHandler() {
        return handler;
    }

    //search
    public List<T> searchQuery(String sql, String[] para, Class outputClass) {
        List<T> list;
        PreparedStatement ps;
        try {
            Connection c = DriverManager.getConnection(DbConfig.connectionString,
                    DbConfig.dbUserName, DbConfig.dbPassword);
            ps = c.prepareStatement(sql);
            for (int i = 0; i <= para.length; i++) {
                ps.setString(i + 1, para[i]);
            }
            ResultSet rs = ps.executeQuery();
            list = mapRersultSetToObject(rs, outputClass);
            ps.close();
            c.close();
            return list;
        } catch (SQLException e) {
            System.out.println("Handler searchQuery error:" + e.getMessage());
            return null;
        }
    }
    
    //insert
    public int insertQuery(String sql, String[] para) {
        PreparedStatement ps;
        int res = -1; //return result
        try {
            Connection c = DriverManager.getConnection(DbConfig.connectionString,
                    DbConfig.dbUserName, DbConfig.dbPassword);
            ps = c.prepareStatement(sql);
            for (int i = 0; i <= para.length; i++) {
                ps.setString(i + 1, para[i]);
            }
            int result = ps.executeUpdate();
            res = (result != 0) ? 1 : -1;
            return res;
        } catch (SQLException ex) {
            System.out.printf("Handler updateQuery error:" + ex.getMessage());
            return res;
        }
    }

    //update
    public int updateQuery(String sql, String[] para) {
        PreparedStatement ps;
        int res = -1; //return result
        try {
            Connection c = DriverManager.getConnection(DbConfig.connectionString,
                    DbConfig.dbUserName, DbConfig.dbPassword);
            ps = c.prepareStatement(sql);
            for (int i = 0; i <= para.length; i++) {
                ps.setString(i + 1, para[i]);
            }
            int result = ps.executeUpdate();
            res = (result != 0) ? 1 : -1;
            return res;
        } catch (SQLException ex) {
            System.out.printf("Handler updateQuery error:" + ex.getMessage());
            return res;
        }
    }

    //delete
    public int deleteQuery(String sql, String[] para) {
        PreparedStatement ps;
        int res = -1; //return result
        try {
            Connection c = DriverManager.getConnection(DbConfig.connectionString,
                    DbConfig.dbUserName, DbConfig.dbPassword);
            ps = c.prepareStatement(sql);
            for (int i = 0; i <= para.length; i++) {
                ps.setString(i + 1, para[i]);
            }
            int result = ps.executeUpdate();
            res = (result != 0) ? 1 : -1;
            return res;
        } catch (SQLException ex) {
            System.out.printf("Handler updateQuery error:" + ex.getMessage());
            return res;
        }
    }

    @SuppressWarnings("unchecked")
    private List<T> mapRersultSetToObject(ResultSet rs, Class outputClass) {
        List<T> outputList = null;
        try {
            if (rs != null) {
                if (outputClass.isAnnotationPresent(Entity.class)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    Field[] fields = outputClass.getDeclaredFields();
                    System.out.println("rsmd=" + rsmd.getColumnCount());
                    while (rs.next()) {
                        T bean = (T) outputClass.newInstance();
                        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                            String columnName = rsmd.getColumnName(i);
                            Object columnValue = rs.getObject(i);

                            for (Field field : fields) {
                                if (field.isAnnotationPresent(Column.class)) {
                                    Column column = field.getAnnotation(Column.class);
                                    if (column.name().equalsIgnoreCase(columnName)
                                            && columnValue != null) {
                                        BeanUtils.setProperty(bean, field.getName(), columnValue);
                                        break;
                                    }
                                }
                            }
                        }
                        if (outputList == null) {
                            outputList = new ArrayList<T>();
                        }
                        outputList.add(bean);
                    }
                } else {
                    // throw some error
                    System.out.println("output class is not annotationPresented");
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return outputList;
    }
}
