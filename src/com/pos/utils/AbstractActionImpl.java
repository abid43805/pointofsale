/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.utils;

import com.pos.beans.SaleDetail;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AbidAli
 */
public class AbstractActionImpl extends AbstractAction {
    List<SaleDetail> listOfSaleDetail;
    public AbstractActionImpl(List<SaleDetail> listOfSaleDetail) {
        this.listOfSaleDetail = listOfSaleDetail;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {

        JTable table = (JTable) e.getSource();
        int modelRow = Integer.valueOf(e.getActionCommand());
        ((DefaultTableModel) table.getModel()).removeRow(modelRow);   //for deleting row from table

        this.listOfSaleDetail.remove(modelRow);
        removeSaleDetailFromCart(modelRow);

    }
     private void removeSaleDetailFromCart(int index) {
        this.listOfSaleDetail.remove(index);   //remove from cart 
    }

}
