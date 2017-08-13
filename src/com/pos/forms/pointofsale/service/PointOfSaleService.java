/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.pointofsale.service;

import com.pos.beans.Products;
import com.pos.beans.Sales;
import com.pos.forms.pointofsale.dao.PointOfSaleDao;
import com.pos.forms.pointofsale.dao.PointOfSaleDaoImpl;
import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.util.List;

/**
 *
 * @author AbidAli
 */
public class PointOfSaleService {
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
      saleResult =  posDao.performSale(sale);
      if(saleResult)
      {
        int[] resultOfSaleDetail= posDao.performSaleDetailInsert(sale, listOfSaleDetail);
        if(resultOfSaleDetail!= null && resultOfSaleDetail.length>0)
        {
                saleDetailResult = true;
        }
      }
     else
       {
           System.out.println("sale inserts failure inside service");
       }
      
     return saleDetailResult;
      
    }

  
}
