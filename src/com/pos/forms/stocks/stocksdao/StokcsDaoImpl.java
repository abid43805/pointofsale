/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.stocks.stocksdao;

import com.pos.beans.Customer;
import com.pos.beans.Products;
import com.pos.beans.Supplier;
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
    private static final String SUPPLIER_INSERT_QUERY =  "INSERT INTO suppliers(sup_name, sup_contact_number, sup_address) values(?,?,?)";
    private static final String PRODUCT_INSERT_QUERY =   "INSERT INTO products(product_name, price, quantity_at_hand, purchase_price, supplier_id) values(?,?,?,?,?)";
    
    private static final String CUSTOMER_FETCH_QUERY = "select * from customers";
    private static final String SUPPLIERS_FETCH_QUERY = "select * from suppliers";
    private static final String PRODUCTS_FETCH_QUERY = "select * from products";
    private static final String CUSTOMER_UPDATE_QUERY = "update customers set customer_name = ?, customer_mobile_no = ?, customer_cnic = ?, customer_address = ? where customer_id = ?";
    private static final String SUPPLIER_UPDATE_QUERY = "update suppliers set sup_name=?, sup_contact_number=?, sup_address =? where sup_id = ?";
    private static final String PRODUCT_UPDATE_QUERY = "update products set product_name=?, price=?, quantity_at_hand=?, purchase_price=?, supplier_id=? where product_id = ?";
    private static final String CUSTOMER_DELETE_QUERY = "DELETE FROM customers WHERE customer_id = ?";
    private static final String SUPPLIER_DELETE_QUERY = "DELETE FROM suppliers WHERE sup_id = ?";
    private static final String PRODUCT_DELETE_QUERY = "DELETE FROM products WHERE product_id = ?";
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
    public boolean insertSupplier(Supplier supplier) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        int count = 1;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(SUPPLIER_INSERT_QUERY);
            ps.setString(count++, supplier.getSupplierName());
            ps.setString(count++, supplier.getSupplierContactNo());
            ps.setString(count++, supplier.getSupplierAddress());
  
            rs = ps.executeUpdate();
            if (rs > 0) // found
            {
                System.out.println("Supplier insert successfull : ");
                
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in inserting supplier -->" + ex.getMessage());
            ex.printStackTrace();
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
    public List<Supplier> fetchSupplier() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 1;
        Supplier supplier;
        List<Supplier> listOfSupplier = null;
        try {
            listOfSupplier = new ArrayList<Supplier>();
            con = DBUtils.getConnection();
            ps = con.prepareStatement(SUPPLIERS_FETCH_QUERY);
            
            rs = ps.executeQuery();
            while (rs.next()) // found
            {
                supplier = new Supplier();
                supplier.setSupplierId(rs.getLong("sup_id"));
                supplier.setSupplierName(rs.getString("sup_name"));
                supplier.setSupplierContactNo(rs.getString("sup_contact_number"));
                supplier.setSupplierAddress(rs.getString("sup_address"));
                
                       
                listOfSupplier.add(supplier);
            }
        } catch (Exception ex) {
            System.out.println("Error in fetching suppliers -->" + ex);
           } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            DBUtils.closeResultSet(rs);
        }
        return listOfSupplier;
    }
    @Override
    public List<Products> fetchProducts() {
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
                product.setQuantityAtHand(rs.getLong("quantity_at_hand"));
                product.setSupplierId(rs.getString("supplier_id"));
                product.setPurchasePrice(rs.getDouble("purchase_price"));
                
                
                       
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
    public boolean updateSupplier(Supplier supplier) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        int count = 1;
        
        boolean customerUpdated = false;
        
        try {
            
            con = DBUtils.getConnection();
            ps = con.prepareStatement(SUPPLIER_UPDATE_QUERY);
            ps.setString(count++, supplier.getSupplierName());
            ps.setString(count++, supplier.getSupplierContactNo());
            
            ps.setString(count++, supplier.getSupplierAddress());
            ps.setLong(count++, supplier.getSupplierId());
            rs = ps.executeUpdate();
            if (rs > 0) // updated
            {
                System.out.println("Supplier updated successfully");
                customerUpdated = true;      
            }
        } catch (Exception ex) {
            System.out.println("Error in updating supplier -->" + ex);
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
     @Override
    public boolean deleteSupplier(Supplier supplier) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        int count = 1;
        
        boolean supplierDeleted = false;
        
        try {
            
            con = DBUtils.getConnection();
            ps = con.prepareStatement(SUPPLIER_DELETE_QUERY);
            ps.setInt(count++, Integer.parseInt(supplier.getSupplierId()+""));
            rs = ps.executeUpdate();
            if (rs > 0) // updated
            {
                System.out.println("Supplier deleted successfully");
                supplierDeleted = true;      
            }
        } catch (Exception ex) {
            System.out.println("Error in deleting supplier -->" + ex);
           } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            }
        return supplierDeleted;
    }
     public boolean deleteProduct(Products product) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        int count = 1;
        
        boolean supplierDeleted = false;
        
        try {
            
            con = DBUtils.getConnection();
            ps = con.prepareStatement(PRODUCT_DELETE_QUERY);
            ps.setInt(count++, Integer.parseInt(product.getProductId()+""));
            rs = ps.executeUpdate();
            if (rs > 0) // updated
            {
                System.out.println("Product deleted successfully");
                supplierDeleted = true;      
            }
        } catch (Exception ex) {
            System.out.println("Error in deleting product -->" + ex);
           } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            }
        return supplierDeleted;
    }
    
    @Override
    public boolean insertProduct(Products product) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        int count = 1;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(PRODUCT_INSERT_QUERY);
            ps.setString(count++, product.getProductName());
            ps.setString(count++, ""+product.getPrice());
            ps.setString(count++, ""+product.getQuantityAtHand());
            ps.setString(count++, ""+product.getPurchasePrice());
            ps.setString(count++, product.getSupplierId());
  
            rs = ps.executeUpdate();
            if (rs > 0) // found
            {
                System.out.println("Product insert successfull : ");
                
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in inserting product -->" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            
        }
    }

    @Override
    public boolean updateProduct(Products product) {
    
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        int count = 1;
        
        boolean customerUpdated = false;
        
        try {
            
            con = DBUtils.getConnection();
            ps = con.prepareStatement(PRODUCT_UPDATE_QUERY);
            //"update products set product_name=?, price=?, quantity_at_hand=?, purchase_price=?, supplier_id=? where product_id = ?";
            ps.setString(count++, product.getProductName());
            ps.setDouble(count++, product.getPrice());
            
            ps.setLong(count++, product.getQuantityAtHand());
            ps.setDouble(count++, product.getPurchasePrice());
            ps.setString(count++, product.getSupplierId());
            ps.setLong(count++, product.getProductId());
            rs = ps.executeUpdate();
            if (rs > 0) // updated
            {
                System.out.println("Product updated successfully");
                customerUpdated = true;      
            }
        } catch (Exception ex) {
            System.out.println("Error in updating product -->" + ex);
           } finally {
            DBUtils.close(con);
            DBUtils.closePreparedStmnt(ps);
            }
        return customerUpdated;
    
    }
}
