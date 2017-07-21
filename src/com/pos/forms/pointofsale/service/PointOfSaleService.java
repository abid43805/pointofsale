/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.pointofsale.service;

import com.pos.beans.Products;
import com.pos.forms.pointofsale.dao.PointOfSaleDao;
import com.pos.forms.pointofsale.dao.PointOfSaleDaoImpl;
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
}
