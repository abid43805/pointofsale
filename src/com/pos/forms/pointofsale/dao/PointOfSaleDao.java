/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.pointofsale.dao;

import com.pos.beans.Products;
import com.pos.beans.SaleDetail;
import com.pos.beans.Sales;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AbidAli
 */
public abstract class PointOfSaleDao {
public abstract List<Products> fetchProductsList();

public abstract Long calculateSaleId() ;

public abstract boolean performSale(Sales sale, List<SaleDetail> listOfSaleDetail) throws SQLException;
public abstract int[] performSaleDetailInsert(Sales sale,List<SaleDetail> listOfSaleDetail);

public abstract Long fetchQuantityAtHand(Products product);

public abstract List<SaleDetail> fetchSaleDetails(String saleId) ;

public abstract boolean prcessSaleReturns(List<SaleDetail> listOfSaleDetail)  throws SQLException;
}
