/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.stocks.stocksservice;

import com.pos.beans.Customer;
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

    public List<Customer> fetchCustomersList() {
        StocksDao stocksDao = new StokcsDaoImpl();
        List<Customer> list =  stocksDao.fetchCustomer();
        return list;
    }
    
    
    public boolean updateCustomer(Customer cust)
    {
        StocksDao stocksDao = new StokcsDaoImpl();
        boolean custUpdated =  stocksDao.updateCustomer(cust);
        return custUpdated;   
    }
    
    public boolean deleteCustomer(Customer cust)
    {
        StocksDao stocksDao = new StokcsDaoImpl();
        boolean custDeleted =  stocksDao.deleteCustomer(cust);
        return custDeleted;   
    }
   
    
    
}
