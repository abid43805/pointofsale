/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.stocks.stocksdao;

import com.pos.beans.Customer;
import com.pos.beans.Products;
import com.pos.beans.Supplier;
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
    public abstract boolean insertSupplier(Supplier supplier);
    public abstract List<Customer> fetchCustomer();    
    public abstract boolean updateCustomer(Customer cust);    
    public abstract boolean deleteCustomer(Customer cust) ;
    public abstract boolean updateSupplier(Supplier supplier);    
    public abstract boolean deleteSupplier(Supplier supplier) ;
    public abstract boolean deleteProduct(Products product) ;

    public abstract List<Supplier> fetchSupplier();

    public abstract List<Products> fetchProducts();


    public abstract boolean insertProduct(Products product);

     /*updateProduct*/
    public abstract boolean updateProduct(Products product);
   
      
}
