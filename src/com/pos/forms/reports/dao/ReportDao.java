/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.reports.dao;

import com.pos.beans.Sales;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author AbidAli
 */
public abstract class ReportDao {
    public abstract List<Sales> fetchSaleReport(Date startDate, Date endDate);
}
