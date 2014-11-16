/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Wu
 */
public interface Handler {
    public Object searchQuery(String sql, String [] para);
    public int updateQuery(String sql, String [] para);
    public int deleteQuery(String sql, String [] para);
}
