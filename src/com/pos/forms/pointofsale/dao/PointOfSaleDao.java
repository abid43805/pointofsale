/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.pointofsale.dao;

import com.pos.beans.Products;
import java.util.List;

/**
 *
 * @author AbidAli
 */
public abstract class PointOfSaleDao {
public abstract List<Products> fetchProductsList();

public abstract Long calculateSaleId() ;
    
}
