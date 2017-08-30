/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.reports.reportservice;

import com.pos.beans.Sales;
import com.pos.forms.reports.dao.ReportDao;
import com.pos.forms.reports.dao.ReportDaoImpl;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author AbidAli
 */
public class ReportService {

    public List<Sales> reportfetchSalesReport(Date sqdStartDate, Date sqdEndDate) {
        ReportDao dao = new ReportDaoImpl();
        return dao.fetchSaleReport(sqdStartDate, sqdEndDate);
    }
    
}
