/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.stocks.stocksservice;

import com.pos.beans.Customer;
import com.pos.beans.Supplier;
import com.pos.forms.stocks.stocksdao.StocksDao;
import com.pos.forms.stocks.stocksdao.StokcsDaoImpl;
import java.util.List;


/**
 *
 * @author AbidAli
 */
public class StocksService {
 public boolean insertCustomer(Customer customer)
    {
        
        StocksDao stocksDao = new StokcsDaoImpl();
        boolean customerInserted = false;
        if(null != customer)
        {
            customerInserted =  stocksDao.insertCustomer(customer);
        }
        else
        {
            System.out.println("customer object is null");
            customerInserted =  false;
        }
        return customerInserted;
    
    }
    public boolean insertSupplier(Supplier supplier)
    {
        
        StocksDao stocksDao = new StokcsDaoImpl();
        boolean supplierInserted = false;
        if(null != supplier)
        {
            supplierInserted =  stocksDao.insertSupplier(supplier);
        }
        else
        {
            System.out.println("supplier object is null");
            supplierInserted =  false;
        }
        return supplierInserted;
    
    }

    public List<Customer> fetchCustomersList() {
        StocksDao stocksDao = new StokcsDaoImpl();
        List<Customer> list =  stocksDao.fetchCustomer();
        return list;
    }
    public List<Supplier> fetchSupplierList() {
        StocksDao stocksDao = new StokcsDaoImpl();
        List<Supplier> list =  stocksDao.fetchSupplier();
        return list;
    }
    
    
    public boolean updateCustomer(Customer cust)
    {
        StocksDao stocksDao = new StokcsDaoImpl();
        boolean custUpdated =  stocksDao.updateCustomer(cust);
        return custUpdated;   
    }
    public boolean updateSupplier(Supplier supp)
    {
        StocksDao stocksDao = new StokcsDaoImpl();
        boolean suppUpdated =  stocksDao.updateSupplier(supp);
        return suppUpdated;   
    }
    
    public boolean deleteCustomer(Customer cust)
    {
        StocksDao stocksDao = new StokcsDaoImpl();
        boolean custDeleted =  stocksDao.deleteCustomer(cust);
        return custDeleted;   
    }

    public boolean deleteSupplier(Supplier supplier) {
        StocksDao stocksDao = new StokcsDaoImpl();
        boolean suppDeleted =  stocksDao.deleteSupplier(supplier);
        return suppDeleted; 
    }
   
    
    
}
