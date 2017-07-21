/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.stocks.stocksdao;

import com.pos.beans.Customer;
import java.util.List;


/**
 *
 * @author AbidAli
 */
public abstract class StocksDao {

    /**
     *
     * @param customer
     * @return
     */
    public abstract boolean insertCustomer(Customer customer);

    public abstract List<Customer> fetchCustomer();    
    public abstract boolean updateCustomer(Customer cust);    
    public abstract boolean deleteCustomer(Customer cust) ;
      
}
