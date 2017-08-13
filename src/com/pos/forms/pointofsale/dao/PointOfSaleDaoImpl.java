/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.pointofsale.dao;

import com.pos.beans.Customer;
import com.pos.beans.Products;
import com.pos.beans.SaleDetail;
import com.pos.beans.Sales;
import com.pos.utils.DBUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AbidAli
 */
public class PointOfSaleDaoImpl extends PointOfSaleDao {
    private static final String PRODUCTS_FETCH_QUERY = "select * from products";
    private static final String SALE_ID_FETCH_QUERY = "select max(sale_id) from sales";
    private static final String SALE_INSERT_QUERY = "insert into sales (customer_id, transaction_date, amount_paid, paid_status, user_id) values (?,?,?,?,?)";
    private static final String SALE_DETAIL_INSERT_QUERY = "insert into sale_detail(sale_id, product_id, product_price, quantity, sub_total) values (?,?,?,?,?)";
            





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

    @Override
    public boolean performSale(Sales sale) {
        System.out.println("Commiting sale.");
        Connection con = null;
        boolean result = false;
        PreparedStatement ps = null;
        int count = 1;
        Long saleId = 0L;
        int rs ; 
        
        try {
           con = DBUtils.getConnection();
            ps = con.prepareStatement(SALE_INSERT_QUERY);
           //customer_id, transaction_date, amount_paid, paid_status, user_id, arrear_amount_to_be_paid
            ps.setLong(count++, sale.getCustomer().getCustomerId());
            Timestamp date = new Timestamp(new Date().getTime());
            ps.setTimestamp(count++, date);
            ps.setDouble(count++, sale.getAmountPaid());    
            ps.setInt(count++, 1);     // currently paid later on radio button
            ps.setLong(count++, sale.getUser().getId());
  
            rs = ps.executeUpdate();
            if (rs > 0)
            {
                System.out.println("sale insert successfull : now ready to insert saledetail");
                
                result = true;
            }
            else {
                
                System.out.println("sale insert failure...");
                result = false;

              
            }

        
        } catch (Exception ex) {
            Logger logger = Logger. getAnonymousLogger();
            try {
                logger.addHandler(new FileHandler("D:/posErrorFile.txt"));
                logger.log(Level.SEVERE, ex.getMessage());
                
            } catch (IOException ex1) {
                Logger.getLogger(PointOfSaleDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (SecurityException ex1) {
                Logger.getLogger(PointOfSaleDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
                  
            System.out.print("Error in inserting sale -->" );
            ex.printStackTrace();
           } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            
        }
        return result;
    }

    @Override
    public int[] performSaleDetailInsert(Sales sale, List<SaleDetail> listOfSaleDetail) {
        System.out.println("inserting sale detail...");
        Connection con = null;
        int[] batchResult = null;
        PreparedStatement ps = null;
        
        Long saleId = 0L;
        int rs ; 
        
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(SALE_DETAIL_INSERT_QUERY);
            //sale_id, product_id, product_price, quantity, sub_total
            
            
            for (SaleDetail saleDetail: listOfSaleDetail) {
                    int count = 1;
                    ps.setLong(count++, saleDetail.getSale());      // sale id will be generated on run time in future for multiusers
                    ps.setLong(count++, saleDetail.getProduct());
                    ps.setDouble(count++, saleDetail.getProductPrice());
                    ps.setLong(count++, saleDetail.getQuantity());
                    ps.setDouble(count++, saleDetail.getSubTotal());
                    
                    ps.addBatch();
            }
            
            batchResult = ps.executeBatch();
                 
         
            

        
        } catch (Exception ex) {
            System.out.println("Error in inserting sale detail-->" + ex);
           } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            
        }
        return batchResult;
            
    }
    
}
