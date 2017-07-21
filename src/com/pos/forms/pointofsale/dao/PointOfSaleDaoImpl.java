/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.pointofsale.dao;

import com.pos.beans.Customer;
import com.pos.beans.Products;
import com.pos.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AbidAli
 */
public class PointOfSaleDaoImpl extends PointOfSaleDao {
    private static final String PRODUCTS_FETCH_QUERY = "select * from products";
    private static final String SALE_ID_FETCH_QUERY = "select max(sale_id) from sales";
    @Override
    public List<Products> fetchProductsList() {
        
      System.out.println("fetching product list.");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 1;
        Products product;
        List<Products> listOfProducts = null;
        try {
            listOfProducts = new ArrayList<Products>();
            con = DBUtils.getConnection();
            ps = con.prepareStatement(PRODUCTS_FETCH_QUERY);
            
            rs = ps.executeQuery();
            while (rs.next()) // found
            {
                product = new Products();
                
                product.setProductId(rs.getLong("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setPurchasePrice(rs.getDouble("purchase_price"));
                product.setQuantityAtHand(rs.getDouble("quantity_at_hand"));
                
                System.out.println(product);
               
                
                listOfProducts.add(product);
            }
        } catch (Exception ex) {
            System.out.println("Error in fetching products -->" + ex);
           } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            DBUtils.closeResultSet(rs);
        }
        return listOfProducts;
    
    }

    @Override
    public Long calculateSaleId() {
       System.out.println("calculating Sale ID.");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 1;
        Long saleId = 0L;
        
        try {
        
            
            con = DBUtils.getConnection();
            ps = con.prepareStatement(SALE_ID_FETCH_QUERY);
            
            rs = ps.executeQuery();
            if (rs.next()) // found
            {
               saleId = rs.getLong(1);
            }
        } catch (Exception ex) {
            System.out.println("Error in fetching products -->" + ex);
           } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            DBUtils.closeResultSet(rs);
        }
        return saleId;
    }
    
}
