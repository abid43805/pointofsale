/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.pointofsale.service;

import com.pos.beans.Products;
import com.pos.beans.SaleDetail;
import com.pos.beans.Sales;
import com.pos.forms.pointofsale.dao.PointOfSaleDao;
import com.pos.forms.pointofsale.dao.PointOfSaleDaoImpl;
import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AbidAli
 */
public class PointOfSaleService {
    public Long fetchQuantityAtHand(Products product)
    {
        PointOfSaleDao posDao = new PointOfSaleDaoImpl();
        return posDao.fetchQuantityAtHand(product); 
    }
    public List<Products> fetchProductsList()
    {
        PointOfSaleDao posDao = new PointOfSaleDaoImpl();
        return posDao.fetchProductsList();
    }

    public Long calculateSaleId() {
      PointOfSaleDao posDao = new PointOfSaleDaoImpl();
      return posDao.calculateSaleId();
              
    }
    
    public boolean performSale(List listOfSaleDetail, Sales sale)
    {
      PointOfSaleDao posDao = new PointOfSaleDaoImpl();
      boolean saleResult;
      boolean saleDetailResult = false;
    try {
                saleResult =  posDao.performSale(sale, listOfSaleDetail);

                if(saleResult)
                {
          //        int[] resultOfSaleDetail= posDao.performSaleDetailInsert(sale, listOfSaleDetail);
          //        if(resultOfSaleDetail!= null && resultOfSaleDetail.length>0)
          //        {
                          saleDetailResult = true;
          //        }
                }
               else
                 {
                     System.out.println("sale inserts failure inside service");
                 }
       } catch (SQLException ex) {
            Logger.getLogger(PointOfSaleService.class.getName()).log(Level.SEVERE, null, ex);
       }
     return saleDetailResult;
      
    }

    public List<SaleDetail> fetchSaleDetails(String saleId) {

        PointOfSaleDao posDao = new PointOfSaleDaoImpl();
        return posDao.fetchSaleDetails(saleId);
    }
  public boolean updateSaleReturns(List<SaleDetail> listOfSaleDetail) {

        PointOfSaleDao posDao = new PointOfSaleDaoImpl();
        try {
            return posDao.prcessSaleReturns(listOfSaleDetail);
        } catch (SQLException ex) {
            Logger.getLogger(PointOfSaleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
  
}
