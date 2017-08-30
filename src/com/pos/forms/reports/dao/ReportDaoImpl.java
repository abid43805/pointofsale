/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.reports.dao;

import com.pos.beans.Customer;
import com.pos.beans.Sales;
import com.pos.beans.User;
import com.pos.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AbidAli
 */
public class ReportDaoImpl extends ReportDao{
    
    private static final String SALES_FETCH_QUERY = "select * from sales where transaction_date between ? and ?";
    private static final String USER_FETCH_QUERY = "select user_name from users where user_id = ?";
    private static final String CUSTOMER_FETCH_QUERY = "select customer_name from customers where customer_id = ?";
    
    @Override
    public List<Sales> fetchSaleReport(Date startDate, Date endDate) {
        List<Sales> listOfSales = new ArrayList<Sales>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 1;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(SALES_FETCH_QUERY);
            ps.setDate(count++, startDate);
            ps.setDate(count++, endDate);
  
            rs = ps.executeQuery();
            Sales sale;
            while (rs.next()) // found
            {
                sale = new Sales();
                sale.setSaleId(Long.parseLong(rs.getString("sale_id")));      // to use user_id it in sale insert
                User user = new User();
                if(rs.getString("user_id")!=null && !rs.getString("user_id").isEmpty())
                {
                    user.setId(Long.parseLong( rs.getString("user_id")));
                    user.setUserName(fetchUserName(user.getId()));
                    
                } 
                sale.setUser(user);
                Customer customer = new Customer();
                if(rs.getString("customer_id")!=null && !rs.getString("customer_id").isEmpty())
                {
                    
                    customer.setCustomerId(Long.parseLong( rs.getString("customer_id")));
                    customer.setCustomerName(fetchCustomerName(customer.getCustomerId()));
                    
                } 
                sale.setCustomer(customer);
                sale.setAmountPaid(rs.getDouble("amount_paid"));
                sale.setAmountToBePaid(rs.getDouble("arrear_amount_to_be_paid"));
                sale.setPaidStatus(rs.getInt("paid_status"));
                sale.setTransactionDate(rs.getDate("transaction_date"));
                listOfSales.add(sale);                
            }
            
        } catch (Exception ex) {
            System.out.println("Error in fetching sale() -->" + ex.getMessage());
            ex.printStackTrace();
            
        } finally {
            DBUtils.close(con);
            DBUtils.closeResultSet(rs);
            DBUtils.closePreparedStmnt(ps);
        }
        return listOfSales;
    }

    private String fetchUserName(Long id) {
        
        Connection con = null;
        PreparedStatement ps = null;
        String userName = null;
        ResultSet rs = null;
        int count = 1;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(USER_FETCH_QUERY);
            ps.setLong(count++, id);         
  
            rs = ps.executeQuery();
          
            if (rs.next()) // found
            {
                
                userName = rs.getString("user_name");
                
            }
            
        } catch (Exception ex) {
            System.out.println("Error in fetching user of sale -->" + ex.getMessage());
            ex.printStackTrace();
            
        } finally {
            DBUtils.close(con);
            DBUtils.closeResultSet(rs);
            DBUtils.closePreparedStmnt(ps);
        }
        
        return userName;
    }

    private String fetchCustomerName(Long customerId) {
        
        Connection con = null;
        PreparedStatement ps = null;
        String userName = null;
        ResultSet rs = null;
        int count = 1;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(CUSTOMER_FETCH_QUERY);
            ps.setLong(count++, customerId);         
  
            rs = ps.executeQuery();
          
            if (rs.next()) // found
            {
                
                userName = rs.getString("customer_name");
                
            }
            
        } catch (Exception ex) {
            System.out.println("Error in fetching user of sale -->" + ex.getMessage());
            ex.printStackTrace();
            
        } finally {
            DBUtils.close(con);
            DBUtils.closeResultSet(rs);
            DBUtils.closePreparedStmnt(ps);
        }
        
        return userName;
    }
    
    
}
