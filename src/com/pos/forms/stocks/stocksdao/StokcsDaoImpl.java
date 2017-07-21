/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.stocks.stocksdao;

import com.pos.beans.Customer;
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
public class StokcsDaoImpl extends StocksDao{

    private static final String CUSTOMER_INSERT_QUERY =  "INSERT INTO customers(customer_name, customer_mobile_no, customer_cnic, customer_address) values(?,?,?,?)";
    private static final String CUSTOMER_FETCH_QUERY = "select * from customers";
    private static final String CUSTOMER_UPDATE_QUERY = "update customers set customer_name = ?, customer_mobile_no = ?, customer_cnic = ?, customer_address = ? where customer_id = ?";
    private static final String CUSTOMER_DELETE_QUERY = "DELETE FROM customers WHERE customer_id = ?";
    @Override
    public boolean insertCustomer(Customer customer) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        int count = 1;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(CUSTOMER_INSERT_QUERY);
            ps.setString(count++, customer.getCustomerName());
            ps.setString(count++, customer.getMobileNo());
            ps.setString(count++, customer.getCnic());
            ps.setString(count++, customer.getAddress());
  
            rs = ps.executeUpdate();
            if (rs > 0) // found
            {
                System.out.println("Customer insert successfull : ");
                
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in inserting customer -->" + ex.getMessage());
            return false;
        } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
        }
    }

    @Override
    public List<Customer> fetchCustomer() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 1;
        Customer cust;
        List<Customer> listOfCustomer = null;
        try {
            listOfCustomer = new ArrayList<Customer>();
            con = DBUtils.getConnection();
            ps = con.prepareStatement(CUSTOMER_FETCH_QUERY);
            
            rs = ps.executeQuery();
            while (rs.next()) // found
            {
                cust = new Customer();
                cust.setCustomerId(rs.getLong("customer_id"));
                cust.setCustomerName(rs.getString("customer_name"));
                cust.setMobileNo(rs.getString("customer_mobile_no"));
                cust.setCnic(rs.getString("customer_cnic"));
                cust.setAddress(rs.getString("customer_address"));
                if(null!= rs.getString("total_amount"))
                {
                    cust.setTotalAmount(Long.parseLong(rs.getString("total_amount")));
                }
                
                listOfCustomer.add(cust);
            }
        } catch (Exception ex) {
            System.out.println("Error in fetching customers -->" + ex);
           } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            DBUtils.closeResultSet(rs);
        }
        return listOfCustomer;
    }

    @Override
    public boolean updateCustomer(Customer cust) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        int count = 1;
        
        boolean customerUpdated = false;
        
        try {
            
            con = DBUtils.getConnection();
            ps = con.prepareStatement(CUSTOMER_UPDATE_QUERY);
            ps.setString(count++, cust.getCustomerName());
            ps.setString(count++, cust.getMobileNo());
            ps.setString(count++, cust.getCnic());
            ps.setString(count++, cust.getAddress());
            ps.setLong(count++, cust.getCustomerId());
            rs = ps.executeUpdate();
            if (rs > 0) // updated
            {
                System.out.println("Customer updated successfully");
                customerUpdated = true;      
            }
        } catch (Exception ex) {
            System.out.println("Error in updating customers -->" + ex);
           } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            }
        return customerUpdated;
    }
    
    
     @Override
    public boolean deleteCustomer(Customer cust) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        int count = 1;
        
        boolean customerdeleted = false;
        
        try {
            
            con = DBUtils.getConnection();
            ps = con.prepareStatement(CUSTOMER_DELETE_QUERY);
            ps.setInt(count++, Integer.parseInt(cust.getCustomerId()+""));
            rs = ps.executeUpdate();
            if (rs > 0) // updated
            {
                System.out.println("Customer deleted successfully");
                customerdeleted = true;      
            }
        } catch (Exception ex) {
            System.out.println("Error in deleting customers -->" + ex);
           } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            }
        return customerdeleted;
    }
}
