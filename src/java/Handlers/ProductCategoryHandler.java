/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Bean.ProductCategory;
import Database.Handler;
import java.util.List;

/**
 *
 * @author Wu
 */
public class ProductCategoryHandler {
    private static final ProductCategoryHandler 
            productCategoryHandler = new ProductCategoryHandler();
    
    private ProductCategoryHandler() {
        
    }
    
    public static ProductCategoryHandler getProductCategoryHandler() {
        return productCategoryHandler;
    }
    
    /**
     * get Product_Category only by id
     * @param id
     * @return Product Category
     */
    public ProductCategory getProductCategoryById(String id) {
        String sql = "select * from Product_Category where category_id = ?";
        String[] para = {id};
        List<ProductCategory> list = Handler.getHandler().searchQuery(sql, para, ProductCategory.class);
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }
    
    /**
     * update Product_Category by a given id
     * @param para
     * @return 
     */
    public int updateProductCategoryById(String [] para) {
        String sql = "update Product_Category set category_name = ? where category_id = ?";
        int ret = Handler.getHandler().updateQuery(sql, para);
        return ret;
    }
    
    /**
     * add new Product_Category
     * @param para
     * @return int
     */
    public int addProductCategory(String [] para){
        String sql = "intert into Product_Category (category_name) values (?)";
        int ret = Handler.getHandler().insertQuery(sql, para);
        return ret;
    }
    
    /**
     * delete Product_Category by a given id
     * @param id
     * @return int
     */
    public int deleteProductCategoryById(String id) {
        String sql = "delete from Product_Category where category_id = ?";
        String[] para = {id};
        int ret = Handler.getHandler().deleteQuery(sql, para);
        return ret;
    }
}

